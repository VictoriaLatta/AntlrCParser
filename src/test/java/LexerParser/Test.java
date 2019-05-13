package LexerParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Antler_Lexer_Parser.CminusLexer;
import Antler_Lexer_Parser.CminusLexer;
import Antler_Lexer_Parser.CminusParser;
import Antler_Lexer_Parser.CminusParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Quelyn
 */
public class Test {
     public static void main(String[] args) throws Exception {

// create a CharStream that reads from standard input
        CharStream input = CharStreams.fromFileName(".\\src\\main\\java\\comp430\\cminuscompiler\\Test.c");
// create a lexer that feeds off of input CharStream
        CminusLexer cminusLexer = new CminusLexer(input);
// create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(cminusLexer);
       
// create a parser that feeds off the tokens buffer
        CminusParser parser = new CminusParser(tokens);
        ParseTree tree = parser.startRule(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
     }   
}
