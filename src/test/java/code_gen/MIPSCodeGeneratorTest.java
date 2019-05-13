package code_gen;

import code_gen_syntax.SizeofExp;
import code_gen_syntax.PrintStmt;
import code_gen_syntax.BinopExp;
import code_gen_syntax.BoolExp;
import code_gen_syntax.PlusOp;
import code_gen_syntax.BoolType;
import code_gen_syntax.IntType;
import code_gen_syntax.EqualsOp;
import code_gen_syntax.PointerType;
import code_gen_syntax.IntExp;
import code_gen_syntax.Exp;
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

public class MIPSCodeGeneratorTest extends MIPSCodeGeneratorTestBase<Exp> {
    protected void doCompile(final MIPSCodeGenerator gen, final Exp exp) {
        gen.compilePrintStmt(new PrintStmt(exp));
    }

    @Test
    public void testIntLiteral() throws IOException {
        File expected = new File("src//exp//expected1.txt");
        assertResult(expected, new IntExp(1));
    }
    
    @Test
    public void testBoolLiteralTrue() throws IOException {
        File expected = new File("src//exp//expected2.txt");
        assertResult(expected, new BoolExp(true));
    }
     
    @Test
    public void testBoolLiteralFalse() throws IOException {
        File expected = new File("src//exp//expected3.txt");
        assertResult(expected, new BoolExp(false));
    }

    @Test
    public void testEqualsIntTrue() throws IOException {
        File expected = new File("src//exp//expected4.txt");
        assertResult(expected, new BinopExp(new IntExp(42),
                                     new EqualsOp(),
                                     new IntExp(42)));
    }

    @Test
    public void testEqualsIntFalse() throws IOException {
        File expected = new File("src//exp//expected11.txt");
        assertResult(expected, new BinopExp(new IntExp(42),
                                     new EqualsOp(),
                                     new IntExp(43)));
    }

    @Test
    public void testEqualsBoolTrue() throws IOException {
        File expected = new File("src//exp//expected5.txt");
        assertResult(expected, new BinopExp(new BoolExp(false),
                                     new EqualsOp(),
                                     new BoolExp(false)));
    }

    @Test
    public void testEqualsBoolFalse() throws IOException {
        File expected = new File("src//exp//expected6.txt");
        assertResult(expected, new BinopExp(new BoolExp(true),
                                     new EqualsOp(),
                                     new BoolExp(false)));
    }
    
    @Test
    public void testPlus() throws IOException {
        // 2 + 3 = 5
        File expected = new File("src//exp//expected7.txt");
        assertResult(expected, new BinopExp(new IntExp(2),
                                     new PlusOp(),
                                     new IntExp(3)));
    }
        
    @Test
    public void testSizeofInt() throws IOException {
        File expected = new File("src//exp//expected8.txt");
        assertResult(expected, new SizeofExp(new IntType()));
    }

    @Test
    public void testSizeofBool() throws IOException {
        File expected = new File("src//exp//expected9.txt");
        assertResult(expected, new SizeofExp(new BoolType()));
    }

    @Test
    public void testSizeofPointer() throws IOException {
        File expected = new File("src//exp//expected10.txt");
        assertResult(expected, new SizeofExp(new PointerType(new IntType())));
    }
       
} // MIPSCodeGeneratorTest

