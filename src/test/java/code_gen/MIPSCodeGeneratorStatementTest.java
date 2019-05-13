package code_gen;

import code_gen_syntax.BreakStmt;
import code_gen_syntax.BoolExp;
import code_gen_syntax.VariableExp;
import code_gen_syntax.IntType;
import code_gen_syntax.Variable;
import code_gen_syntax.VariableDeclaration;
import code_gen_syntax.VariableLhs;
import code_gen_syntax.IntExp;
import code_gen_syntax.PrintStmt;
import code_gen_syntax.WhileStmt;
import code_gen_syntax.Lhs;
import code_gen_syntax.AddressOfExp;
import code_gen_syntax.Type;
import code_gen_syntax.StructureName;
import code_gen_syntax.StructureType;
import code_gen_syntax.VariableDeclarationInitializationStmt;
import code_gen_syntax.FunctionName;
import code_gen_syntax.IfStmt;
import code_gen_syntax.Stmt;
import code_gen_syntax.AssignmentStmt;
import code_gen_syntax.LessThanOp;
import code_gen_syntax.PointerType;
import code_gen_syntax.Exp;
import code_gen_syntax.DereferenceExp;
import code_gen_syntax.FieldName;
import code_gen_syntax.DereferenceLhs;
import code_gen_syntax.BinopExp;
import code_gen_syntax.PlusOp;
import code_gen_syntax.SequenceStmt;
import code_gen.MIPSCodeGenerator;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

public class MIPSCodeGeneratorStatementTest extends MIPSCodeGeneratorTestBase<Stmt> {
    // ---BEGIN CONSTANTS---
    public static final Map<StructureName, LinkedHashMap<FieldName, Type>> TWO_INTS =
        new HashMap<StructureName, LinkedHashMap<FieldName, Type>>() {{
            put(new StructureName("TwoInts"), new LinkedHashMap<FieldName, Type>() {{
                put(new FieldName("x"), new IntType());
                put(new FieldName("y"), new IntType());
            }});
        }};

    public static final Map<StructureName, LinkedHashMap<FieldName, Type>> DOUBLE_TWO_INTS =
        new HashMap<StructureName, LinkedHashMap<FieldName, Type>>() {{
            final StructureName twoInts = new StructureName("TwoInts");
            put(twoInts, TWO_INTS.get(twoInts));
            put(new StructureName("FourInts"), new LinkedHashMap<FieldName, Type>() {{
                put(new FieldName("first"), new StructureType(twoInts));
                put(new FieldName("second"), new StructureType(twoInts));
            }});
        }};
    // ---END CONSTANTS---
    
    protected void doCompile(final MIPSCodeGenerator gen, final Stmt stmt) {
        gen.setCurrentFunctionForTesting(new FunctionName("TEST"));
        gen.compileStatement(stmt);
    }

    public static VariableDeclarationInitializationStmt vardec(final String variableName,
                                                               final Type type,
                                                               final Exp exp) {
        return new VariableDeclarationInitializationStmt(new VariableDeclaration(type,
                                                                                 new Variable(variableName)),
                                                         exp);
    }

    public static Stmt stmts(final Stmt... stmts) {
        assert(stmts.length > 0);
        Stmt result = stmts[stmts.length - 1];

        for (int index = stmts.length - 2; index >= 0; index--) {
            result = new SequenceStmt(stmts[index], result);
        }
        return result;
    }

    public static PrintStmt printVar(final String varName) {
        return new PrintStmt(new VariableExp(new Variable(varName)));
    }

    public static AssignmentStmt assign(final Lhs lhs, final Exp exp) {
        return new AssignmentStmt(lhs, exp);
    }
    
    public static AssignmentStmt assign(final String varName, final Exp exp) {
        return assign(new VariableLhs(new Variable(varName)), exp);
    }

    @Test
    public void testSingleIntVariableDeclaration() throws IOException {
        File expected = new File("src//stmt//expected12.txt");
        assertResult(expected, stmts(vardec("x", new IntType(), new IntExp(1)),
                              printVar("x")));
    }

    @Test
    public void testDoubleIntVariableDeclarationGetFirst() throws IOException {
        File expected = new File("src//stmt//expected13.txt");
        assertResult(expected, stmts(vardec("x", new IntType(), new IntExp(1)),
                              vardec("y", new IntType(), new IntExp(2)),
                              printVar("x")));
    }

    @Test
    public void testDoubleIntVariableDeclarationGetSecond() throws IOException {
        File expected = new File("src//stmt//expected14.txt");
        assertResult(expected, stmts(vardec("x", new IntType(), new IntExp(1)),
                              vardec("y", new IntType(), new IntExp(2)),
                              printVar("y")));
    }

    @Test
    public void testSingleIntAssignment() throws IOException {
        File expected = new File("src//stmt//expected16.txt");
        assertResult(expected, stmts(vardec("x", new IntType(), new IntExp(1)),
                              assign("x", new IntExp(2)),
                              printVar("x")));
    }

    @Test
    public void testTwoIntsAssignFirst() throws IOException {
        File expected = new File("src//stmt//expected17.txt");
        assertResult(expected, stmts(vardec("x", new IntType(), new IntExp(1)),
                              vardec("y", new IntType(), new IntExp(2)),
                              assign("x", new IntExp(3)),
                              printVar("x")));
    }

    @Test
    public void testTwoIntsAssignSecond() throws IOException {
        File expected = new File("src//stmt//expected18.txt");
        assertResult(expected, stmts(vardec("x", new IntType(), new IntExp(1)),
                              vardec("y", new IntType(), new IntExp(2)),
                              assign("y", new IntExp(3)),
                              printVar("y")));
    }

    @Test
    public void testAssignIntThroughPointer() throws IOException {
        // int x = 5;
        // int* p = &x;
        // *p = 7;
        // print(x)

        final DereferenceLhs deref = new DereferenceLhs(new VariableLhs(new Variable("p")));
        deref.setTypeAfterDereference(new IntType());
        File expected = new File("src//stmt//expected15.txt");
        assertResult(expected,
                     stmts(vardec("x",
                                  new IntType(),
                                  new IntExp(5)),
                           vardec("p",
                                  new PointerType(new IntType()),
                                  new AddressOfExp(new VariableLhs(new Variable("x")))),
                           assign(deref,
                                  new IntExp(7)),
                           printVar("x")));
    }

    @Test
    public void testDereferenceInt() throws IOException {
        // x = 5;
        // p = &x;
        // print(*p);

        final DereferenceExp deref =
            new DereferenceExp(new VariableExp(new Variable("p")));
        deref.setTypeAfterDereference(new IntType());
        File expected = new File("src//stmt//expected19.txt");
        assertResult(expected,
                     stmts(vardec("x",
                                  new IntType(),
                                  new IntExp(5)),
                           vardec("p",
                                  new PointerType(new IntType()),
                                  new AddressOfExp(new VariableLhs(new Variable("x")))),
                           new PrintStmt(deref)));
    }

    @Test
    public void testIfTrue() throws IOException {
        // if (true) {
        //   print(1);
        // } else {
        //   print(2);
        // }
        File expected = new File("src//stmt//expected20.txt");
        assertResult(expected,
                     new IfStmt(new BoolExp(true),
                                new PrintStmt(new IntExp(1)),
                                new PrintStmt(new IntExp(2))));
    }

    @Test
    public void testIfFalse() throws IOException {
        // if (false) {
        //   print(1);
        // } else {
        //   print(2);
        // }
        File expected = new File("src//stmt//expected21.txt");
        assertResult(expected,
                     new IfStmt(new BoolExp(false),
                                new PrintStmt(new IntExp(1)),
                                new PrintStmt(new IntExp(2))));
    }

    @Test
    public void testWhileInitiallyFalse() throws IOException {
        // int x = 0;
        // while (x < 0) {
        //   x = x + 1;
        // }
        // print(x);

        final Variable x = new Variable("x");
        File expected = new File("src//stmt//expected22.txt");
        assertResult(expected,
                     stmts(vardec("x", new IntType(), new IntExp(0)),
                           new WhileStmt(new BinopExp(new VariableExp(x),
                                                      new LessThanOp(),
                                                      new IntExp(0)),
                                         assign("x", new BinopExp(new VariableExp(x),
                                                                  new PlusOp(),
                                                                  new IntExp(1)))),
                           printVar("x")));
    }

    @Test
    public void testWhileInitiallyTrue() throws IOException {
        // int x = 0;
        // while (x < 10) {
        //   x = x + 1;
        // }
        // print(x);

        final Variable x = new Variable("x");
        File expected = new File("src//stmt//expected23.txt");
        assertResult(expected,
                     stmts(vardec("x", new IntType(), new IntExp(0)),
                           new WhileStmt(new BinopExp(new VariableExp(x),
                                                      new LessThanOp(),
                                                      new IntExp(10)),
                                         assign("x", new BinopExp(new VariableExp(x),
                                                                  new PlusOp(),
                                                                  new IntExp(1)))),
                           printVar("x")));
    }

    @Test
    public void testIfScope() throws IOException {
        // int x = 0;
        // if (true) {
        //   int x = 1;
        // } else {
        //   int x = 2;
        // }
        // print(x);
        File expected = new File("src//stmt//expected24.txt");
        assertResult(expected,
                     stmts(vardec("x", new IntType(), new IntExp(0)),
                           new IfStmt(new BoolExp(true),
                                      vardec("x", new IntType(), new IntExp(1)),
                                      vardec("x", new IntType(), new IntExp(2))),
                           printVar("x")));
    }

    @Test
    public void testWhileScope() throws IOException {
        // int x = 0;
        // while (true) {
        //   int x = 1;
        //   break;
        // }
        // print(x);
        File expected = new File("src//stmt//expected25.txt");
        assertResult(expected,
                     stmts(vardec("x", new IntType(), new IntExp(0)),
                           new WhileStmt(new BoolExp(true),
                                         stmts(vardec("x", new IntType(), new IntExp(1)),
                                               new BreakStmt())),
                           printVar("x")));
    }
}
