package code_gen;

import code_gen_syntax.ReturnExpStmt;
import code_gen_syntax.FunctionName;
import code_gen_syntax.VariableExp;
import code_gen_syntax.IfStmt;
import code_gen_syntax.EqualsOp;
import code_gen_syntax.IntType;
import code_gen_syntax.Variable;
import code_gen_syntax.VariableDeclaration;
import code_gen_syntax.VoidType;
import code_gen_syntax.Stmt;
import code_gen_syntax.MinusOp;
import code_gen_syntax.IntExp;
import code_gen_syntax.Exp;
import code_gen_syntax.FieldName;
import code_gen_syntax.PrintStmt;
import code_gen_syntax.BinopExp;
import code_gen_syntax.PlusOp;
import code_gen_syntax.FunctionCallExp;
import code_gen_syntax.Type;
import code_gen_syntax.StructureName;
import code_gen_syntax.FunctionDefinition;
import code_gen.MIPSCodeGenerator;
import static code_gen.MIPSCodeGeneratorStatementTest.vardec;
import static code_gen.MIPSCodeGeneratorStatementTest.stmts;
import static code_gen.MIPSCodeGeneratorStatementTest.printVar;
import static code_gen.MIPSCodeGeneratorStatementTest.assign;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// last function is main, which is assumed a void return type
public class MIPSCodeGeneratorFunctionTest extends MIPSCodeGeneratorTestBase<FunctionDefinition[]> {
    protected void doCompile(final MIPSCodeGenerator gen, final FunctionDefinition[] functions) {
        assert(functions.length > 0);

        // main needs to be first so we fall into it
        final FunctionDefinition main = functions[functions.length - 1];
        gen.compileMainFunctionDefinition(main);
        for (int index = 0; index < functions.length - 1; index++) {
            gen.compileFunctionDefinition(functions[index]);
        }
    }

    public static Map<FunctionName, FunctionDefinition> functionMap(final FunctionDefinition[] functions) {
        final Map<FunctionName, FunctionDefinition> result = new HashMap<FunctionName, FunctionDefinition>();
        for (final FunctionDefinition def : functions) {
            assert(!result.containsKey(def.name));
            result.put(def.name, def);
        }
        return result;
    }
    
    public void assertResultF(final File expected,
                              final Map<StructureName, LinkedHashMap<FieldName, Type>> structDecs,
                              final FunctionDefinition... functions) throws IOException {
        assertResult(expected,
                     functions,
                     structDecs,
                     functionMap(functions));
    }

    public void assertResultF(final File expected,
                              final FunctionDefinition... functions) throws IOException {
        assertResultF(expected,
                      new HashMap<StructureName, LinkedHashMap<FieldName, Type>>(),
                      functions);
    }

    public static FunctionDefinition mkMain(final Stmt stmt) {
        return new FunctionDefinition(new VoidType(),
                                      new FunctionName("main"),
                                      new VariableDeclaration[0],
                                      stmt);
    }

    @Test
    public void testCallFunctionAddsParams() throws IOException {
        final FunctionName foo = new FunctionName("foo");
        final Variable x = new Variable("x");
        final Variable y = new Variable("y");
        File expected= new File("src//fun//expected26.txt");
        assertResultF(expected,
                      new FunctionDefinition(new IntType(),
                                             foo,
                                             new VariableDeclaration[] {
                                                 new VariableDeclaration(new IntType(), x),
                                                 new VariableDeclaration(new IntType(), y)
                                             },
                                             new ReturnExpStmt(new BinopExp(new VariableExp(x),
                                                                            new PlusOp(),
                                                                            new VariableExp(y)))),
                      mkMain(new PrintStmt(new FunctionCallExp(foo,
                                                               new Exp[] {
                                                                   new IntExp(1),
                                                                   new IntExp(2)
                                                               }))));
    }
    
    @Test
    public void testFibonacci() throws IOException {
        // int fib(int x) {
        //   if (x == 0) {
        //     return 0;
        //   } else if (x == 1) {
        //     return 1;
        //   } else {
        //     return fib(x - 1) + fib(x - 2);
        //   }
        // }
        // void main() {
        //   print(fib(7));
        // }

        final FunctionName fib = new FunctionName("fib");
        final Variable x = new Variable("x");
        final Exp recursiveCase = new BinopExp(new FunctionCallExp(fib,
                                                                   new Exp[] {
                                                                       new BinopExp(new VariableExp(x),
                                                                                    new MinusOp(),
                                                                                    new IntExp(1))
                                                                   }),
                                               new PlusOp(),
                                               new FunctionCallExp(fib,
                                                                   new Exp[] {
                                                                       new BinopExp(new VariableExp(x),
                                                                                    new MinusOp(),
                                                                                    new IntExp(2))
                                                                   }));
        File expected= new File("src//fun//expected27.txt");
        assertResultF(expected,
                      new FunctionDefinition(new IntType(),
                                             fib,
                                             new VariableDeclaration[] {
                                                 new VariableDeclaration(new IntType(), x)
                                             },
                                             new IfStmt(new BinopExp(new VariableExp(x),
                                                                     new EqualsOp(),
                                                                     new IntExp(0)),
                                                        new ReturnExpStmt(new IntExp(0)),
                                                        new IfStmt(new BinopExp(new VariableExp(x),
                                                                                new EqualsOp(),
                                                                                new IntExp(1)),
                                                                   new ReturnExpStmt(new IntExp(1)),
                                                                   new ReturnExpStmt(recursiveCase)))),
                      mkMain(new PrintStmt(new FunctionCallExp(fib,
                                                               new Exp[] {
                                                                   new IntExp(7)
                                                               }))));
    }
}

