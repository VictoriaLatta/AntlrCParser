/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexerParser;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.apache.commons.io.*;
import Antler_Lexer_Parser.CminusLexer;
import Antler_Lexer_Parser.CminusLexer;
import Antler_Lexer_Parser.CminusParser;
import Antler_Lexer_Parser.CminusParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.*;
/**
 *
 * @author Quelyn
 */
public class LexerParserTest {
    
@Rule public TestName name = new TestName();

    public void assertResult(final String inputFile, String Expected) throws IOException{
    // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromFileName(inputFile);
// create a lexer that feeds off of input CharStream
        CminusLexer cminusLexer = new CminusLexer(input);
// create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(cminusLexer);
       
// create a parser that feeds off the tokens buffer
        CminusParser parser = new CminusParser(tokens);
        ParseTree tree = parser.startRule(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        assertEquals(tree.toStringTree(parser),Expected);
    }
@Test
    public void TestLexerandParser() throws IOException{
    String inputFile ="src//main//java//Antler_Lexer_Parser//test.c";
    String expected = "(startRule (type int) (main main) { (progStatements (statement (funcDecParam (type int) (var foo) ( (type int) (var x) ) { (progStatements (statement (varDec (type int) (var x) (assignment =) (mathExpr (exp 1))) ;) (progStatements (loops if ( (ifConditions (var x) (compare <) (exp 2)) ) { (progStatements (statement (varAssign (var x) (assignment =) (mathExpr (var y))) ;)) }))) return (var y) ; }))) } <EOF>)";
    assertResult(inputFile, expected);
    }    
}