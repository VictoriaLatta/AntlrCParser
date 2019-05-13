package Antler_Lexer_Parser;
// Generated from Cminus.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CminusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CminusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CminusParser#startRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartRule(CminusParser.StartRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(CminusParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#progStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgStatements(CminusParser.ProgStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CminusParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#funcPointerDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncPointerDec(CminusParser.FuncPointerDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CminusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#funcCallParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallParam(CminusParser.FuncCallParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#funcPointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncPointer(CminusParser.FuncPointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#funcDecParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecParam(CminusParser.FuncDecParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(CminusParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(CminusParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#varAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(CminusParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(CminusParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(CminusParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#mathExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpr(CminusParser.MathExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(CminusParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(CminusParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#assignOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOp(CminusParser.AssignOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#loops}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoops(CminusParser.LoopsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#ifConditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfConditions(CminusParser.IfConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#forConditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForConditions(CminusParser.ForConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(CminusParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by {@link CminusParser#skip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(CminusParser.SkipContext ctx);
}