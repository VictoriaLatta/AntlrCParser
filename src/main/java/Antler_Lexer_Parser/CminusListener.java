package Antler_Lexer_Parser;

// Generated from Cminus.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CminusParser}.
 */
public interface CminusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CminusParser#startRule}.
	 * @param ctx the parse tree
	 */
	void enterStartRule(CminusParser.StartRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#startRule}.
	 * @param ctx the parse tree
	 */
	void exitStartRule(CminusParser.StartRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(CminusParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(CminusParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#progStatements}.
	 * @param ctx the parse tree
	 */
	void enterProgStatements(CminusParser.ProgStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#progStatements}.
	 * @param ctx the parse tree
	 */
	void exitProgStatements(CminusParser.ProgStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CminusParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CminusParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#funcPointerDec}.
	 * @param ctx the parse tree
	 */
	void enterFuncPointerDec(CminusParser.FuncPointerDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#funcPointerDec}.
	 * @param ctx the parse tree
	 */
	void exitFuncPointerDec(CminusParser.FuncPointerDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CminusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CminusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#funcCallParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallParam(CminusParser.FuncCallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#funcCallParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallParam(CminusParser.FuncCallParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#funcPointer}.
	 * @param ctx the parse tree
	 */
	void enterFuncPointer(CminusParser.FuncPointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#funcPointer}.
	 * @param ctx the parse tree
	 */
	void exitFuncPointer(CminusParser.FuncPointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#funcDecParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecParam(CminusParser.FuncDecParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#funcDecParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecParam(CminusParser.FuncDecParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(CminusParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(CminusParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(CminusParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(CminusParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(CminusParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(CminusParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(CminusParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(CminusParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(CminusParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(CminusParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void enterMathExpr(CminusParser.MathExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#mathExpr}.
	 * @param ctx the parse tree
	 */
	void exitMathExpr(CminusParser.MathExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(CminusParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(CminusParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(CminusParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(CminusParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(CminusParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(CminusParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#loops}.
	 * @param ctx the parse tree
	 */
	void enterLoops(CminusParser.LoopsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#loops}.
	 * @param ctx the parse tree
	 */
	void exitLoops(CminusParser.LoopsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#ifConditions}.
	 * @param ctx the parse tree
	 */
	void enterIfConditions(CminusParser.IfConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#ifConditions}.
	 * @param ctx the parse tree
	 */
	void exitIfConditions(CminusParser.IfConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#forConditions}.
	 * @param ctx the parse tree
	 */
	void enterForConditions(CminusParser.ForConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#forConditions}.
	 * @param ctx the parse tree
	 */
	void exitForConditions(CminusParser.ForConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#compare}.
	 * @param ctx the parse tree
	 */
	void enterCompare(CminusParser.CompareContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#compare}.
	 * @param ctx the parse tree
	 */
	void exitCompare(CminusParser.CompareContext ctx);
	/**
	 * Enter a parse tree produced by {@link CminusParser#skip}.
	 * @param ctx the parse tree
	 */
	void enterSkip(CminusParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by {@link CminusParser#skip}.
	 * @param ctx the parse tree
	 */
	void exitSkip(CminusParser.SkipContext ctx);
}