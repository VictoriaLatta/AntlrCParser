package Antler_Lexer_Parser;

// Generated from Cminus.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CminusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, VOID=2, RETURN=3, POINTDEC=4, POINT=5, LEFTPAREN=6, RIGHTPAREN=7, 
		Ifloop=8, Elseloop=9, Forloop=10, PRINT=11, MAIN=12, VAR=13, LEFTCURLY=14, 
		RIGHTCURLY=15, PLUS=16, MINUS=17, MULT=18, DIVIDE=19, PLUSEQUAL=20, MINUSEQUAL=21, 
		MULTEQUAL=22, DIVIDEQUAL=23, LESSTHAN=24, GREATERTHAN=25, LESSEQUAL=26, 
		GREATEREQUAL=27, ASSIGN=28, ID=29, INT=30, COMMENT=31, WS=32, STRING=33, 
		CHAR=34, NULLCHAR=35;
	public static final int
		RULE_startRule = 0, RULE_main = 1, RULE_progStatements = 2, RULE_statement = 3, 
		RULE_funcPointerDec = 4, RULE_type = 5, RULE_funcCallParam = 6, RULE_funcPointer = 7, 
		RULE_funcDecParam = 8, RULE_printStatement = 9, RULE_varDec = 10, RULE_varAssign = 11, 
		RULE_var = 12, RULE_assignment = 13, RULE_mathExpr = 14, RULE_op = 15, 
		RULE_exp = 16, RULE_assignOp = 17, RULE_loops = 18, RULE_ifConditions = 19, 
		RULE_forConditions = 20, RULE_compare = 21, RULE_skip = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"startRule", "main", "progStatements", "statement", "funcPointerDec", 
			"type", "funcCallParam", "funcPointer", "funcDecParam", "printStatement", 
			"varDec", "varAssign", "var", "assignment", "mathExpr", "op", "exp", 
			"assignOp", "loops", "ifConditions", "forConditions", "compare", "skip"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'void'", "'return'", "'&'", "'@'", "'('", "')'", "'if'", 
			"'else'", "'for'", "'printf'", "'main'", null, "'{'", "'}'", "'+'", "'-'", 
			"'*'", "'/'", "'+='", "'-='", "'*='", "'/='", "'<'", "'>'", "'<='", "'>='", 
			"'='", null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "VOID", "RETURN", "POINTDEC", "POINT", "LEFTPAREN", "RIGHTPAREN", 
			"Ifloop", "Elseloop", "Forloop", "PRINT", "MAIN", "VAR", "LEFTCURLY", 
			"RIGHTCURLY", "PLUS", "MINUS", "MULT", "DIVIDE", "PLUSEQUAL", "MINUSEQUAL", 
			"MULTEQUAL", "DIVIDEQUAL", "LESSTHAN", "GREATERTHAN", "LESSEQUAL", "GREATEREQUAL", 
			"ASSIGN", "ID", "INT", "COMMENT", "WS", "STRING", "CHAR", "NULLCHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cminus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CminusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartRuleContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode LEFTCURLY() { return getToken(CminusParser.LEFTCURLY, 0); }
		public ProgStatementsContext progStatements() {
			return getRuleContext(ProgStatementsContext.class,0);
		}
		public TerminalNode RIGHTCURLY() { return getToken(CminusParser.RIGHTCURLY, 0); }
		public TerminalNode EOF() { return getToken(CminusParser.EOF, 0); }
		public StartRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterStartRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitStartRule(this);
		}
	}

	public final StartRuleContext startRule() throws RecognitionException {
		StartRuleContext _localctx = new StartRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			type();
			setState(47);
			main();
			setState(48);
			match(LEFTCURLY);
			setState(49);
			progStatements();
			setState(50);
			match(RIGHTCURLY);
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(CminusParser.MAIN, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(MAIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgStatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ProgStatementsContext progStatements() {
			return getRuleContext(ProgStatementsContext.class,0);
		}
		public LoopsContext loops() {
			return getRuleContext(LoopsContext.class,0);
		}
		public ProgStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterProgStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitProgStatements(this);
		}
	}

	public final ProgStatementsContext progStatements() throws RecognitionException {
		ProgStatementsContext _localctx = new ProgStatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_progStatements);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				statement();
				setState(57);
				progStatements();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				loops();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				loops();
				setState(61);
				progStatements();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode NULLCHAR() { return getToken(CminusParser.NULLCHAR, 0); }
		public VarDecContext varDec() {
			return getRuleContext(VarDecContext.class,0);
		}
		public VarAssignContext varAssign() {
			return getRuleContext(VarAssignContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public FuncDecParamContext funcDecParam() {
			return getRuleContext(FuncDecParamContext.class,0);
		}
		public FuncCallParamContext funcCallParam() {
			return getRuleContext(FuncCallParamContext.class,0);
		}
		public FuncPointerDecContext funcPointerDec() {
			return getRuleContext(FuncPointerDecContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(65);
					varDec();
					}
					break;
				case VAR:
					{
					setState(66);
					varAssign();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(69);
				match(NULLCHAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				printStatement();
				setState(72);
				match(NULLCHAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				funcDecParam();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				funcCallParam();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				funcPointerDec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncPointerDecContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode LEFTPAREN() { return getToken(CminusParser.LEFTPAREN, 0); }
		public TerminalNode POINTDEC() { return getToken(CminusParser.POINTDEC, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode RIGHTPAREN() { return getToken(CminusParser.RIGHTPAREN, 0); }
		public TerminalNode ASSIGN() { return getToken(CminusParser.ASSIGN, 0); }
		public TerminalNode POINT() { return getToken(CminusParser.POINT, 0); }
		public FuncPointerDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcPointerDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterFuncPointerDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitFuncPointerDec(this);
		}
	}

	public final FuncPointerDecContext funcPointerDec() throws RecognitionException {
		FuncPointerDecContext _localctx = new FuncPointerDecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcPointerDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			type();
			setState(80);
			match(LEFTPAREN);
			setState(81);
			match(POINTDEC);
			setState(82);
			var();
			{
			setState(83);
			type();
			}
			setState(84);
			match(RIGHTPAREN);
			setState(85);
			match(ASSIGN);
			setState(86);
			match(POINT);
			setState(87);
			var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CminusParser.TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallParamContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode LEFTPAREN() { return getToken(CminusParser.LEFTPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RIGHTPAREN() { return getToken(CminusParser.RIGHTPAREN, 0); }
		public FuncPointerContext funcPointer() {
			return getRuleContext(FuncPointerContext.class,0);
		}
		public FuncCallParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterFuncCallParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitFuncCallParam(this);
		}
	}

	public final FuncCallParamContext funcCallParam() throws RecognitionException {
		FuncCallParamContext _localctx = new FuncCallParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcCallParam);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				var();
				setState(92);
				match(LEFTPAREN);
				setState(93);
				type();
				setState(94);
				var();
				setState(95);
				match(RIGHTPAREN);
				}
				break;
			case POINTDEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				funcPointer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncPointerContext extends ParserRuleContext {
		public TerminalNode POINTDEC() { return getToken(CminusParser.POINTDEC, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode LEFTPAREN() { return getToken(CminusParser.LEFTPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RIGHTPAREN() { return getToken(CminusParser.RIGHTPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FuncPointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcPointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterFuncPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitFuncPointer(this);
		}
	}

	public final FuncPointerContext funcPointer() throws RecognitionException {
		FuncPointerContext _localctx = new FuncPointerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcPointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(POINTDEC);
			setState(101);
			var();
			setState(102);
			match(LEFTPAREN);
			setState(103);
			type();
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(104);
				var();
				}
				break;
			case INT:
			case CHAR:
				{
				setState(105);
				exp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(108);
			match(RIGHTPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDecParamContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode LEFTPAREN() { return getToken(CminusParser.LEFTPAREN, 0); }
		public TerminalNode RIGHTPAREN() { return getToken(CminusParser.RIGHTPAREN, 0); }
		public TerminalNode LEFTCURLY() { return getToken(CminusParser.LEFTCURLY, 0); }
		public ProgStatementsContext progStatements() {
			return getRuleContext(ProgStatementsContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CminusParser.RETURN, 0); }
		public TerminalNode NULLCHAR() { return getToken(CminusParser.NULLCHAR, 0); }
		public TerminalNode RIGHTCURLY() { return getToken(CminusParser.RIGHTCURLY, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncPointerContext funcPointer() {
			return getRuleContext(FuncPointerContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CminusParser.VOID, 0); }
		public FuncDecParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterFuncDecParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitFuncDecParam(this);
		}
	}

	public final FuncDecParamContext funcDecParam() throws RecognitionException {
		FuncDecParamContext _localctx = new FuncDecParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcDecParam);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				type();
				setState(111);
				var();
				setState(112);
				match(LEFTPAREN);
				setState(113);
				type();
				setState(116);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(114);
					var();
					}
					break;
				case INT:
				case CHAR:
					{
					setState(115);
					exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(118);
				match(RIGHTPAREN);
				setState(119);
				match(LEFTCURLY);
				setState(120);
				progStatements();
				setState(121);
				match(RETURN);
				setState(125);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(122);
					var();
					}
					break;
				case INT:
				case CHAR:
					{
					setState(123);
					exp();
					}
					break;
				case POINTDEC:
					{
					setState(124);
					funcPointer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(127);
				match(NULLCHAR);
				setState(128);
				match(RIGHTCURLY);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(VOID);
				setState(131);
				var();
				setState(132);
				match(LEFTPAREN);
				setState(133);
				type();
				setState(136);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(134);
					var();
					}
					break;
				case INT:
				case CHAR:
					{
					setState(135);
					exp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(138);
				match(RIGHTPAREN);
				setState(139);
				match(LEFTCURLY);
				setState(140);
				progStatements();
				setState(141);
				match(RIGHTCURLY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(CminusParser.PRINT, 0); }
		public TerminalNode LEFTPAREN() { return getToken(CminusParser.LEFTPAREN, 0); }
		public TerminalNode STRING() { return getToken(CminusParser.STRING, 0); }
		public TerminalNode RIGHTPAREN() { return getToken(CminusParser.RIGHTPAREN, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitPrintStatement(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(PRINT);
			setState(146);
			match(LEFTPAREN);
			setState(147);
			match(STRING);
			setState(148);
			match(RIGHTPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitVarDec(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			type();
			setState(151);
			var();
			setState(152);
			assignment();
			setState(153);
			mathExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAssignContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MathExprContext mathExpr() {
			return getRuleContext(MathExprContext.class,0);
		}
		public VarAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterVarAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitVarAssign(this);
		}
	}

	public final VarAssignContext varAssign() throws RecognitionException {
		VarAssignContext _localctx = new VarAssignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			var();
			setState(156);
			assignment();
			setState(157);
			mathExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(CminusParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(CminusParser.ASSIGN, 0); }
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignment);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(ASSIGN);
				}
				break;
			case PLUSEQUAL:
			case MINUSEQUAL:
			case MULTEQUAL:
			case DIVIDEQUAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				assignOp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathExprContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public MathExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterMathExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitMathExpr(this);
		}
	}

	public final MathExprContext mathExpr() throws RecognitionException {
		MathExprContext _localctx = new MathExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mathExpr);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				exp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				exp();
				setState(167);
				op();
				setState(168);
				exp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				var();
				setState(171);
				op();
				setState(172);
				exp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				exp();
				setState(175);
				op();
				setState(176);
				var();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				var();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(CminusParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CminusParser.MINUS, 0); }
		public TerminalNode DIVIDE() { return getToken(CminusParser.DIVIDE, 0); }
		public TerminalNode MULT() { return getToken(CminusParser.MULT, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIVIDE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CminusParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(CminusParser.CHAR, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==CHAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignOpContext extends ParserRuleContext {
		public TerminalNode PLUSEQUAL() { return getToken(CminusParser.PLUSEQUAL, 0); }
		public TerminalNode MINUSEQUAL() { return getToken(CminusParser.MINUSEQUAL, 0); }
		public TerminalNode MULTEQUAL() { return getToken(CminusParser.MULTEQUAL, 0); }
		public TerminalNode DIVIDEQUAL() { return getToken(CminusParser.DIVIDEQUAL, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitAssignOp(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSEQUAL) | (1L << MINUSEQUAL) | (1L << MULTEQUAL) | (1L << DIVIDEQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopsContext extends ParserRuleContext {
		public TerminalNode Ifloop() { return getToken(CminusParser.Ifloop, 0); }
		public TerminalNode LEFTPAREN() { return getToken(CminusParser.LEFTPAREN, 0); }
		public IfConditionsContext ifConditions() {
			return getRuleContext(IfConditionsContext.class,0);
		}
		public TerminalNode RIGHTPAREN() { return getToken(CminusParser.RIGHTPAREN, 0); }
		public List<TerminalNode> LEFTCURLY() { return getTokens(CminusParser.LEFTCURLY); }
		public TerminalNode LEFTCURLY(int i) {
			return getToken(CminusParser.LEFTCURLY, i);
		}
		public List<ProgStatementsContext> progStatements() {
			return getRuleContexts(ProgStatementsContext.class);
		}
		public ProgStatementsContext progStatements(int i) {
			return getRuleContext(ProgStatementsContext.class,i);
		}
		public List<TerminalNode> RIGHTCURLY() { return getTokens(CminusParser.RIGHTCURLY); }
		public TerminalNode RIGHTCURLY(int i) {
			return getToken(CminusParser.RIGHTCURLY, i);
		}
		public TerminalNode Elseloop() { return getToken(CminusParser.Elseloop, 0); }
		public TerminalNode Forloop() { return getToken(CminusParser.Forloop, 0); }
		public ForConditionsContext forConditions() {
			return getRuleContext(ForConditionsContext.class,0);
		}
		public LoopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterLoops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitLoops(this);
		}
	}

	public final LoopsContext loops() throws RecognitionException {
		LoopsContext _localctx = new LoopsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_loops);
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(Ifloop);
				setState(188);
				match(LEFTPAREN);
				setState(189);
				ifConditions();
				setState(190);
				match(RIGHTPAREN);
				setState(191);
				match(LEFTCURLY);
				setState(192);
				progStatements();
				setState(193);
				match(RIGHTCURLY);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(Ifloop);
				setState(196);
				match(LEFTPAREN);
				setState(197);
				ifConditions();
				setState(198);
				match(RIGHTPAREN);
				setState(199);
				match(LEFTCURLY);
				setState(200);
				progStatements();
				setState(201);
				match(RIGHTCURLY);
				setState(202);
				match(Elseloop);
				setState(203);
				match(LEFTCURLY);
				setState(204);
				progStatements();
				setState(205);
				match(RIGHTCURLY);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(Forloop);
				setState(208);
				match(LEFTPAREN);
				setState(209);
				forConditions();
				setState(210);
				match(RIGHTPAREN);
				setState(211);
				match(LEFTCURLY);
				setState(212);
				progStatements();
				setState(213);
				match(RIGHTCURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfConditionsContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public IfConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifConditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterIfConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitIfConditions(this);
		}
	}

	public final IfConditionsContext ifConditions() throws RecognitionException {
		IfConditionsContext _localctx = new IfConditionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifConditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			var();
			setState(218);
			compare();
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
				{
				setState(219);
				exp();
				}
				break;
			case VAR:
				{
				setState(220);
				var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForConditionsContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ForConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forConditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterForConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitForConditions(this);
		}
	}

	public final ForConditionsContext forConditions() throws RecognitionException {
		ForConditionsContext _localctx = new ForConditionsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_forConditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			var();
			setState(224);
			compare();
			setState(225);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompareContext extends ParserRuleContext {
		public TerminalNode LESSTHAN() { return getToken(CminusParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHAN() { return getToken(CminusParser.GREATERTHAN, 0); }
		public TerminalNode LESSEQUAL() { return getToken(CminusParser.LESSEQUAL, 0); }
		public TerminalNode GREATEREQUAL() { return getToken(CminusParser.GREATEREQUAL, 0); }
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitCompare(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		CompareContext _localctx = new CompareContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESSTHAN) | (1L << GREATERTHAN) | (1L << LESSEQUAL) | (1L << GREATEREQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipContext extends ParserRuleContext {
		public SkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CminusListener ) ((CminusListener)listener).exitSkip(this);
		}
	}

	public final SkipContext skip() throws RecognitionException {
		SkipContext _localctx = new SkipContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_skip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00ea\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3"+
		"\5\3\5\5\5F\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tm\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5"+
		"\nw\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0080\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u008b\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0092\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\5\17\u00a6\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00b6\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u00da\n\24\3\25\3\25\3\25\3\25\5\25\u00e0\n\25\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\2\6\3\2\22\25\4\2  $$\3\2\26\31\3\2\32\35\2\u00e9\2\60\3\2\2"+
		"\2\4\67\3\2\2\2\6A\3\2\2\2\bO\3\2\2\2\nQ\3\2\2\2\f[\3\2\2\2\16d\3\2\2"+
		"\2\20f\3\2\2\2\22\u0091\3\2\2\2\24\u0093\3\2\2\2\26\u0098\3\2\2\2\30\u009d"+
		"\3\2\2\2\32\u00a1\3\2\2\2\34\u00a5\3\2\2\2\36\u00b5\3\2\2\2 \u00b7\3\2"+
		"\2\2\"\u00b9\3\2\2\2$\u00bb\3\2\2\2&\u00d9\3\2\2\2(\u00db\3\2\2\2*\u00e1"+
		"\3\2\2\2,\u00e5\3\2\2\2.\u00e7\3\2\2\2\60\61\5\f\7\2\61\62\5\4\3\2\62"+
		"\63\7\20\2\2\63\64\5\6\4\2\64\65\7\21\2\2\65\66\7\2\2\3\66\3\3\2\2\2\67"+
		"8\7\16\2\28\5\3\2\2\29B\5\b\5\2:;\5\b\5\2;<\5\6\4\2<B\3\2\2\2=B\5&\24"+
		"\2>?\5&\24\2?@\5\6\4\2@B\3\2\2\2A9\3\2\2\2A:\3\2\2\2A=\3\2\2\2A>\3\2\2"+
		"\2B\7\3\2\2\2CF\5\26\f\2DF\5\30\r\2EC\3\2\2\2ED\3\2\2\2FG\3\2\2\2GH\7"+
		"%\2\2HP\3\2\2\2IJ\5\24\13\2JK\7%\2\2KP\3\2\2\2LP\5\22\n\2MP\5\16\b\2N"+
		"P\5\n\6\2OE\3\2\2\2OI\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\t\3\2\2\2"+
		"QR\5\f\7\2RS\7\b\2\2ST\7\6\2\2TU\5\32\16\2UV\5\f\7\2VW\7\t\2\2WX\7\36"+
		"\2\2XY\7\7\2\2YZ\5\32\16\2Z\13\3\2\2\2[\\\7\3\2\2\\\r\3\2\2\2]^\5\32\16"+
		"\2^_\7\b\2\2_`\5\f\7\2`a\5\32\16\2ab\7\t\2\2be\3\2\2\2ce\5\20\t\2d]\3"+
		"\2\2\2dc\3\2\2\2e\17\3\2\2\2fg\7\6\2\2gh\5\32\16\2hi\7\b\2\2il\5\f\7\2"+
		"jm\5\32\16\2km\5\"\22\2lj\3\2\2\2lk\3\2\2\2mn\3\2\2\2no\7\t\2\2o\21\3"+
		"\2\2\2pq\5\f\7\2qr\5\32\16\2rs\7\b\2\2sv\5\f\7\2tw\5\32\16\2uw\5\"\22"+
		"\2vt\3\2\2\2vu\3\2\2\2wx\3\2\2\2xy\7\t\2\2yz\7\20\2\2z{\5\6\4\2{\177\7"+
		"\5\2\2|\u0080\5\32\16\2}\u0080\5\"\22\2~\u0080\5\20\t\2\177|\3\2\2\2\177"+
		"}\3\2\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7%\2\2\u0082\u0083"+
		"\7\21\2\2\u0083\u0092\3\2\2\2\u0084\u0085\7\4\2\2\u0085\u0086\5\32\16"+
		"\2\u0086\u0087\7\b\2\2\u0087\u008a\5\f\7\2\u0088\u008b\5\32\16\2\u0089"+
		"\u008b\5\"\22\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008d\7\t\2\2\u008d\u008e\7\20\2\2\u008e\u008f\5\6\4\2\u008f"+
		"\u0090\7\21\2\2\u0090\u0092\3\2\2\2\u0091p\3\2\2\2\u0091\u0084\3\2\2\2"+
		"\u0092\23\3\2\2\2\u0093\u0094\7\r\2\2\u0094\u0095\7\b\2\2\u0095\u0096"+
		"\7#\2\2\u0096\u0097\7\t\2\2\u0097\25\3\2\2\2\u0098\u0099\5\f\7\2\u0099"+
		"\u009a\5\32\16\2\u009a\u009b\5\34\17\2\u009b\u009c\5\36\20\2\u009c\27"+
		"\3\2\2\2\u009d\u009e\5\32\16\2\u009e\u009f\5\34\17\2\u009f\u00a0\5\36"+
		"\20\2\u00a0\31\3\2\2\2\u00a1\u00a2\7\17\2\2\u00a2\33\3\2\2\2\u00a3\u00a6"+
		"\7\36\2\2\u00a4\u00a6\5$\23\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a6\35\3\2\2\2\u00a7\u00b6\5\"\22\2\u00a8\u00a9\5\"\22\2\u00a9\u00aa"+
		"\5 \21\2\u00aa\u00ab\5\"\22\2\u00ab\u00b6\3\2\2\2\u00ac\u00ad\5\32\16"+
		"\2\u00ad\u00ae\5 \21\2\u00ae\u00af\5\"\22\2\u00af\u00b6\3\2\2\2\u00b0"+
		"\u00b1\5\"\22\2\u00b1\u00b2\5 \21\2\u00b2\u00b3\5\32\16\2\u00b3\u00b6"+
		"\3\2\2\2\u00b4\u00b6\5\32\16\2\u00b5\u00a7\3\2\2\2\u00b5\u00a8\3\2\2\2"+
		"\u00b5\u00ac\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\37"+
		"\3\2\2\2\u00b7\u00b8\t\2\2\2\u00b8!\3\2\2\2\u00b9\u00ba\t\3\2\2\u00ba"+
		"#\3\2\2\2\u00bb\u00bc\t\4\2\2\u00bc%\3\2\2\2\u00bd\u00be\7\n\2\2\u00be"+
		"\u00bf\7\b\2\2\u00bf\u00c0\5(\25\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\7\20"+
		"\2\2\u00c2\u00c3\5\6\4\2\u00c3\u00c4\7\21\2\2\u00c4\u00da\3\2\2\2\u00c5"+
		"\u00c6\7\n\2\2\u00c6\u00c7\7\b\2\2\u00c7\u00c8\5(\25\2\u00c8\u00c9\7\t"+
		"\2\2\u00c9\u00ca\7\20\2\2\u00ca\u00cb\5\6\4\2\u00cb\u00cc\7\21\2\2\u00cc"+
		"\u00cd\7\13\2\2\u00cd\u00ce\7\20\2\2\u00ce\u00cf\5\6\4\2\u00cf\u00d0\7"+
		"\21\2\2\u00d0\u00da\3\2\2\2\u00d1\u00d2\7\f\2\2\u00d2\u00d3\7\b\2\2\u00d3"+
		"\u00d4\5*\26\2\u00d4\u00d5\7\t\2\2\u00d5\u00d6\7\20\2\2\u00d6\u00d7\5"+
		"\6\4\2\u00d7\u00d8\7\21\2\2\u00d8\u00da\3\2\2\2\u00d9\u00bd\3\2\2\2\u00d9"+
		"\u00c5\3\2\2\2\u00d9\u00d1\3\2\2\2\u00da\'\3\2\2\2\u00db\u00dc\5\32\16"+
		"\2\u00dc\u00df\5,\27\2\u00dd\u00e0\5\"\22\2\u00de\u00e0\5\32\16\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0)\3\2\2\2\u00e1\u00e2\5\32\16"+
		"\2\u00e2\u00e3\5,\27\2\u00e3\u00e4\5\"\22\2\u00e4+\3\2\2\2\u00e5\u00e6"+
		"\t\5\2\2\u00e6-\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8/\3\2\2\2\17AEOdlv\177"+
		"\u008a\u0091\u00a5\u00b5\u00d9\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}