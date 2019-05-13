package type_checker;

import type_checker.TypeErrorException;
import type_checker.Typechecker;
import type_checker_syntax.FunctionDefinition;
import type_checker_syntax.Exp;
import type_checker_syntax.FunctionName;
import type_checker_syntax.CharExp;
import type_checker_syntax.IntExp;
import type_checker_syntax.VariableDeclaration;
import type_checker_syntax.BoolExp;
import type_checker_syntax.IntType;
import type_checker_syntax.FunctionCallExp;
import type_checker_syntax.PointerType;
import type_checker_syntax.ContinueStmt;
import type_checker_syntax.ReturnVoidStmt;
import type_checker_syntax.PlusOp;
import type_checker_syntax.DereferenceLhs;
import type_checker_syntax.Stmt;
import type_checker_syntax.FreeStmt;
import type_checker_syntax.SequenceStmt;
import type_checker_syntax.DereferenceExp;
import type_checker_syntax.AddressOfExp;
import type_checker_syntax.Program;
import type_checker_syntax.IfStmt;
import type_checker_syntax.CharType;
import type_checker_syntax.VariableDeclarationInitializationStmt;
import type_checker_syntax.Variable;
import type_checker_syntax.VoidType;
import type_checker_syntax.BinopExp;
import type_checker_syntax.ReturnExpStmt;
import type_checker_syntax.ExpStmt;
import type_checker_syntax.Type;
import type_checker_syntax.VariableLhs;
import type_checker_syntax.BreakStmt;
import type_checker_syntax.WhileStmt;
import type_checker_syntax.AssignmentStmt;
import type_checker_syntax.VariableExp;

import org.junit.Test;
import type_checker.TypeErrorException;
import type_checker.Typechecker;

public class TypecheckerScopeTest {
    
    public static final FunctionDefinition[] EMPTY_FUNCTIONS =
        new FunctionDefinition[0];
    public static final VariableDeclaration[] EMPTY_VARDECS =
        new VariableDeclaration[0];
    
    public static Stmt stmts(final Stmt... input) {
        assert(input.length > 0);
        Stmt result = input[input.length - 1];
        for (int index = input.length - 2; index >= 0; index--) {
            result = new SequenceStmt(input[index], result);
        }
        return result;
    }

    public static VariableDeclarationInitializationStmt def(final Type type, final String name, final Exp exp) {
        return new VariableDeclarationInitializationStmt(new VariableDeclaration(type, new Variable(name)), exp);
    }

    // void foo() {
    //   body
    // }
    public static FunctionDefinition voidFunction(final Stmt body) {
        return new FunctionDefinition(new VoidType(),
                                      new FunctionName("foo"),
                                      EMPTY_VARDECS,
                                      body);
    }
    
    @Test
    public void testVariableDefinitionAndUse() throws TypeErrorException {
        // void foo() {
        //   int x = 0;
        //   int y = x;
        // }
        final Stmt body = stmts(def(new IntType(), "x", new IntExp(0)),
                                def(new IntType(), "y", new VariableExp(new Variable("x"))));
        final FunctionDefinition fdef = voidFunction(body);
        final Program prog = new Program(new FunctionDefinition[]{fdef});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testAccessUndeclaredVariable() throws TypeErrorException {
        // void foo() {
        //   int x = x;
        // }
        final Stmt body = stmts(def(new IntType(), "x", new VariableExp(new Variable("x"))));
        final FunctionDefinition fdef = voidFunction(body);
        final Program prog = new Program(new FunctionDefinition[]{fdef});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testPointerToVariable() throws TypeErrorException {
        // void foo() {
        //   int x = 0;
        //   int* y = &x;
        // }
        final Stmt body = stmts(def(new IntType(), "x", new IntExp(0)),
                                def(new PointerType(new IntType()),
                                    "y",
                                    new AddressOfExp(new VariableLhs(new Variable("x")))));
        final FunctionDefinition fdef = voidFunction(body);
        final Program prog = new Program(new FunctionDefinition[]{fdef});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testPointerDereferenceRhs() throws TypeErrorException {
        // void foo() {
        //   int x = 0;
        //   int* p = &x;
        //   int y = *p;
        // }

        final Stmt body = stmts(def(new IntType(), "x", new IntExp(0)),
                                def(new PointerType(new IntType()),
                                    "p",
                                    new AddressOfExp(new VariableLhs(new Variable("x")))),
                                def(new IntType(),
                                    "y",
                                    new DereferenceExp(new VariableExp(new Variable("p")))));
        final FunctionDefinition fdef = voidFunction(body);
        final Program prog = new Program(new FunctionDefinition[]{fdef});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testPointerDereferenceLhs() throws TypeErrorException {
        // void foo() {
        //   int x = 0;
        //   int* p = &x;
        //   *p = 7;
        // }

        final Stmt body = stmts(def(new IntType(), "x", new IntExp(0)),
                                def(new PointerType(new IntType()),
                                    "p",
                                    new AddressOfExp(new VariableLhs(new Variable("x")))),
                                new AssignmentStmt(new DereferenceLhs(new VariableLhs(new Variable("p"))),
                                                   new IntExp(7)));
        final FunctionDefinition fdef = voidFunction(body);
        final Program prog = new Program(new FunctionDefinition[]{fdef});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testAddPointer() throws TypeErrorException {
        // void foo() {
        //   int x = 0;
        //   int* y = &x;
        //   int* z = y + 3;
        // }
        final Stmt body = stmts(def(new IntType(), "x", new IntExp(0)),
                                def(new PointerType(new IntType()),
                                    "y",
                                    new AddressOfExp(new VariableLhs(new Variable("x")))),
                                def(new PointerType(new IntType()),
                                    "z",
                                    new BinopExp(new VariableExp(new Variable("y")),
                                                 new PlusOp(),
                                                 new IntExp(3))));
        final FunctionDefinition fdef = voidFunction(body);
        final Program prog = new Program(new FunctionDefinition[]{fdef});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testNormalFunctionCall() throws TypeErrorException {
        // int blah(int x, char y) {
        //   return 7;
        // }
        // void foo() {
        //   blah(7, 'a');
        // }

        final FunctionDefinition blah =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("blah"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new IntType(), new Variable("x")),
                                       new VariableDeclaration(new CharType(), new Variable("y"))
                                   },
                                   new ReturnExpStmt(new IntExp(7)));
        final FunctionDefinition foo =
            voidFunction(new ExpStmt(new FunctionCallExp(new FunctionName("blah"),
                                                         new Exp[]{
                                                             new IntExp(7),
                                                             new CharExp('a')
                                                         })));
        final Program prog = new Program(new FunctionDefinition[]{blah, foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testFunctionDefinitionVoidParam() throws TypeErrorException {
        // int blah(void x) {
        //   return 7;
        // }

        final FunctionDefinition blah =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("blah"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new VoidType(), new Variable("x"))
                                   },
                                   new ReturnExpStmt(new IntExp(7)));
        final Program prog = new Program(new FunctionDefinition[]{blah});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testFunctionDefinitionVoidPointerParam() throws TypeErrorException {
        // int blah(void* x) {
        //   return 7;
        // }

        final FunctionDefinition blah =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("blah"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new PointerType(new VoidType()),
                                                               new Variable("x"))
                                   },
                                   new ReturnExpStmt(new IntExp(7)));
        final Program prog = new Program(new FunctionDefinition[]{blah});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testFunctionDefinitionDuplicateFunctionNames() throws TypeErrorException {
        // void foo() { return; }
        // void foo() { return; }

        final FunctionDefinition foo =
            voidFunction(new ReturnVoidStmt());
        
        final Program prog = new Program(new FunctionDefinition[]{foo, foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testFunctionDefinitionDuplicateParameterNames() throws TypeErrorException {
        // void foo(int x, char x) { return; }

        final FunctionDefinition foo =
            new FunctionDefinition(new VoidType(),
                                   new FunctionName("foo"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new IntType(),
                                                               new Variable("x")),
                                       new VariableDeclaration(new CharType(),
                                                               new Variable("x"))
                                   },
                                   new ReturnVoidStmt());

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }
        
    @Test(expected = TypeErrorException.class)
    public void testFunctionCallNotEnoughParams() throws TypeErrorException {
        // int blah(int x, char y) {
        //   return 7;
        // }
        // void foo() {
        //   blah(7);
        // }
        final FunctionDefinition blah =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("blah"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new IntType(), new Variable("x")),
                                       new VariableDeclaration(new CharType(), new Variable("y"))
                                   },
                                   new ReturnExpStmt(new IntExp(7)));
        final FunctionDefinition foo =
            voidFunction(new ExpStmt(new FunctionCallExp(new FunctionName("blah"),
                                                         new Exp[]{
                                                             new IntExp(7)
                                                         })));
        final Program prog = new Program(new FunctionDefinition[]{blah, foo});
        Typechecker.typecheckProgram(prog);
    }
        
    @Test(expected = TypeErrorException.class)
    public void testFunctionCallTooManyParams() throws TypeErrorException {
        // int blah(int x, char y) {
        //   return 7;
        // }
        // void foo() {
        //   blah(7, 'a', true);
        // }

        final FunctionDefinition blah =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("blah"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new IntType(), new Variable("x")),
                                       new VariableDeclaration(new CharType(), new Variable("y"))
                                   },
                                   new ReturnExpStmt(new IntExp(7)));
        final FunctionDefinition foo =
            voidFunction(new ExpStmt(new FunctionCallExp(new FunctionName("blah"),
                                                         new Exp[]{
                                                             new IntExp(7),
                                                             new CharExp('a'),
                                                             new BoolExp(true)
                                                         })));
        final Program prog = new Program(new FunctionDefinition[]{blah, foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testFunctionCallWrongTypes() throws TypeErrorException {
        // int blah(int x, char y) {
        //   return 7;
        // }
        // void foo() {
        //   blah('a', y);
        // }

        final FunctionDefinition blah =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("blah"),
                                   new VariableDeclaration[]{
                                       new VariableDeclaration(new IntType(), new Variable("x")),
                                       new VariableDeclaration(new CharType(), new Variable("y"))
                                   },
                                   new ReturnExpStmt(new IntExp(7)));
        final FunctionDefinition foo =
            voidFunction(new ExpStmt(new FunctionCallExp(new FunctionName("blah"),
                                                         new Exp[]{
                                                             new CharExp('a'),
                                                             new IntExp(7)
                                                         })));
        final Program prog = new Program(new FunctionDefinition[]{blah, foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testFunctionCallNonexistent() throws TypeErrorException {
        // void foo() {
        //   blah(7, 'a');
        // }

        final FunctionDefinition foo =
            voidFunction(new ExpStmt(new FunctionCallExp(new FunctionName("blah"),
                                                         new Exp[]{
                                                             new IntExp(7),
                                                             new CharExp('a')
                                                         })));
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testIfNormal() throws TypeErrorException {
        // void foo() {
        //   if (true) {
        //     return;
        //   } else {
        //     return;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new IfStmt(new BoolExp(true),
                                    new ReturnVoidStmt(),
                                    new ReturnVoidStmt()));
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testIfErrorGuard() throws TypeErrorException {
        // void foo() {
        //   if (1) {
        //     return;
        //   } else {
        //     return;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new IfStmt(new IntExp(1),
                                    new ReturnVoidStmt(),
                                    new ReturnVoidStmt()));
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }
        
    @Test(expected = TypeErrorException.class)
    public void testIfErrorTrueBranch() throws TypeErrorException {
        // void foo() {
        //   if (true) {
        //     return 1;
        //   } else {
        //     return;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new IfStmt(new BoolExp(true),
                                    new ReturnExpStmt(new IntExp(1)),
                                    new ReturnVoidStmt()));
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testIfErrorFalseBranch() throws TypeErrorException {
        // void foo() {
        //   if (true) {
        //     return;
        //   } else {
        //     return 1;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new IfStmt(new BoolExp(true),
                                    new ReturnVoidStmt(),
                                    new ReturnExpStmt(new IntExp(1))));
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testWhileNormal() throws TypeErrorException {
        // void foo() {
        //   while (true) {
        //     return;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new WhileStmt(new BoolExp(true),
                                       new ReturnVoidStmt()));
        
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testWhileErrorGuard() throws TypeErrorException {
        // void foo() {
        //   while (1) {
        //     return;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new WhileStmt(new IntExp(1),
                                       new ReturnVoidStmt()));
        
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testWhileErrorBody() throws TypeErrorException {
        // void foo() {
        //   while (true) {
        //     return 1;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new WhileStmt(new BoolExp(true),
                                       new ReturnExpStmt(new IntExp(1))));
        
        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testBreakNormal() throws TypeErrorException {
        // void foo() {
        //   while (true) {
        //     break;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new WhileStmt(new BoolExp(true),
                                       new BreakStmt()));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testBreakOutOfWhile() throws TypeErrorException {
        // void foo() {
        //   break;
        // }

        final FunctionDefinition foo =
            voidFunction(new BreakStmt());

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testContinueNormal() throws TypeErrorException {
        // void foo() {
        //   while (true) {
        //     continue;
        //   }
        // }

        final FunctionDefinition foo =
            voidFunction(new WhileStmt(new BoolExp(true),
                                       new ContinueStmt()));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testContinueOutOfWhile() throws TypeErrorException {
        // void foo() {
        //   continue;
        // }

        final FunctionDefinition foo =
            voidFunction(new ContinueStmt());

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testCannotMakeVoidLocalVariable() throws TypeErrorException {
        // void foo() {
        //   void x = 1;
        // }

        final FunctionDefinition foo =
            voidFunction(def(new VoidType(), "x", new IntExp(1)));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }
        
   /* @Test
    public void testCanMakeVoidPointerLocalVariable() throws TypeErrorException {
        // void foo() {
        //   void* x = y;
        // }

        final FunctionDefinition foo =
            voidFunction(def(new PointerType(new VoidType()),
                             "x",
                             new IntExp(1)));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }        
*/
    @Test
    public void testAssignmentNormal() throws TypeErrorException {
        // void foo() {
        //   int x = 7;
        //   x = 8;
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(def(new IntType(), "x", new IntExp(7)),
                               new AssignmentStmt(new VariableLhs(new Variable("x")),
                                                  new IntExp(8))));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testAssignmentNoLhsVariable() throws TypeErrorException {
        // void foo() {
        //   int x = 7;
        //   y = 8;
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(def(new IntType(), "x", new IntExp(7)),
                               new AssignmentStmt(new VariableLhs(new Variable("y")),
                                                  new IntExp(8))));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testAssignmentNonPointerDereferenceLhs() throws TypeErrorException {
        // void foo() {
        //   int x = 7;
        //   *x = 8;
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(def(new IntType(), "x", new IntExp(7)),
                               new AssignmentStmt(new DereferenceLhs(new VariableLhs(new Variable("x"))),
                                                  new IntExp(8))));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testAssignmentErrorOnRight() throws TypeErrorException {
        // void foo() {
        //   int x = 7;
        //   x = true;
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(def(new IntType(), "x", new IntExp(7)),
                               new AssignmentStmt(new VariableLhs(new Variable("x")),
                                                  new BoolExp(true))));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testReturnNormal() throws TypeErrorException {
        // void foo() {
        //   return;
        // }

        final FunctionDefinition foo =
            voidFunction(new ReturnVoidStmt());

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testReturnDuplicate() throws TypeErrorException {
        // void foo() {
        //   return;
        //   return;
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(new ReturnVoidStmt(),
                               new ReturnVoidStmt()));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testReturnIfOnlyTrue() throws TypeErrorException {
        // int foo() {
        //   if (true) {
        //     return 1;
        //   } else {
        //     1;
        //   }
        // }

        final Stmt body =
            new IfStmt(new BoolExp(true),
                       new ReturnExpStmt(new IntExp(1)),
                       new ExpStmt(new IntExp(1)));
        
        final FunctionDefinition foo =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("foo"),
                                   EMPTY_VARDECS,
                                   body);

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test(expected = TypeErrorException.class)
    public void testReturnIfOnlyFalse() throws TypeErrorException {
        // int foo() {
        //   if (true) {
        //     1;
        //   } else {
        //     return 1;
        //   }
        // }

        final Stmt body =
            new IfStmt(new BoolExp(true),
                       new ExpStmt(new IntExp(1)),
                       new ReturnExpStmt(new IntExp(1)));
        
        final FunctionDefinition foo =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("foo"),
                                   EMPTY_VARDECS,
                                   body);

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

    @Test
    public void testReturnIfBothBranches() throws TypeErrorException {
        // int foo() {
        //   if (true) {
        //     return 1;
        //   } else {
        //     return 2;
        //   }
        // }

        final Stmt body =
            new IfStmt(new BoolExp(true),
                       new ReturnExpStmt(new IntExp(1)),
                       new ReturnExpStmt(new IntExp(2)));
        
        final FunctionDefinition foo =
            new FunctionDefinition(new IntType(),
                                   new FunctionName("foo"),
                                   EMPTY_VARDECS,
                                   body);

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }

   /* @Test
    public void testFreeNormal() throws TypeErrorException {
        // void foo() {
        //   void* p = 1;
        //   free(p);
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(def(new PointerType(new VoidType()),
                                   "p",
                                   new IntExp(1)),
                               new FreeStmt(new VariableExp(new Variable("p")))));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }
*/
    @Test(expected = TypeErrorException.class)
    public void testFreeNonVoidPointer() throws TypeErrorException {
        // void foo() {
        //   int p = 1;
        //   free(p);
        // }

        final FunctionDefinition foo =
            voidFunction(stmts(def(new IntType(),
                                   "p",
                                   new IntExp(1)),
                               new FreeStmt(new VariableExp(new Variable("p")))));

        final Program prog = new Program(new FunctionDefinition[]{foo});
        Typechecker.typecheckProgram(prog);
    }        
}
