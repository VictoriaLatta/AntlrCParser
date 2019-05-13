package Antler_Lexer_Parser;

// Generated from Cminus.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CminusLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TYPE", "VOID", "RETURN", "POINTDEC", "POINT", "LEFTPAREN", "RIGHTPAREN", 
			"Ifloop", "Elseloop", "Forloop", "PRINT", "MAIN", "VAR", "LEFTCURLY", 
			"RIGHTCURLY", "PLUS", "MINUS", "MULT", "DIVIDE", "PLUSEQUAL", "MINUSEQUAL", 
			"MULTEQUAL", "DIVIDEQUAL", "LESSTHAN", "GREATERTHAN", "LESSEQUAL", "GREATEREQUAL", 
			"ASSIGN", "ID", "INT", "COMMENT", "WS", "STRING", "CHAR", "HEX_DIGIT", 
			"ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC", "NULLCHAR"
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


	public CminusLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cminus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00fc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2Y\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\6\16\u0088"+
		"\n\16\r\16\16\16\u0089\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\7\36\u00b2\n\36\f\36\16\36\u00b5\13\36\3\37\6\37\u00b8\n\37\r\37\16"+
		"\37\u00b9\3 \3 \3 \3 \7 \u00c0\n \f \16 \u00c3\13 \3 \5 \u00c6\n \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\7\"\u00d3\n\"\f\"\16\"\u00d6\13\"\3\""+
		"\3\"\3#\3#\3#\5#\u00dd\n#\3#\3#\3$\3$\3%\3%\3%\3%\5%\u00e7\n%\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\5&\u00f2\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\2\2"+
		")\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G\2I\2K\2M\2O%\3\2\13\3\2c|\5\2C\\aac|\6\2\62;C\\aac|\4\2\f"+
		"\f\17\17\5\2\13\f\17\17\"\"\4\2$$^^\4\2))^^\5\2\62;CHch\t\2))^^ddhhpp"+
		"ttvv\2\u0104\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2O\3\2\2\2\3X\3\2\2\2\5Z\3\2\2\2\7_\3\2\2\2\tf\3\2\2\2\13h\3\2\2\2"+
		"\rj\3\2\2\2\17l\3\2\2\2\21n\3\2\2\2\23q\3\2\2\2\25v\3\2\2\2\27z\3\2\2"+
		"\2\31\u0081\3\2\2\2\33\u0087\3\2\2\2\35\u008b\3\2\2\2\37\u008d\3\2\2\2"+
		"!\u008f\3\2\2\2#\u0091\3\2\2\2%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u0097\3"+
		"\2\2\2+\u009a\3\2\2\2-\u009d\3\2\2\2/\u00a0\3\2\2\2\61\u00a3\3\2\2\2\63"+
		"\u00a5\3\2\2\2\65\u00a7\3\2\2\2\67\u00aa\3\2\2\29\u00ad\3\2\2\2;\u00af"+
		"\3\2\2\2=\u00b7\3\2\2\2?\u00bb\3\2\2\2A\u00cb\3\2\2\2C\u00cf\3\2\2\2E"+
		"\u00d9\3\2\2\2G\u00e0\3\2\2\2I\u00e6\3\2\2\2K\u00f1\3\2\2\2M\u00f3\3\2"+
		"\2\2O\u00fa\3\2\2\2QR\7k\2\2RS\7p\2\2SY\7v\2\2TU\7e\2\2UV\7j\2\2VW\7c"+
		"\2\2WY\7t\2\2XQ\3\2\2\2XT\3\2\2\2Y\4\3\2\2\2Z[\7x\2\2[\\\7q\2\2\\]\7k"+
		"\2\2]^\7f\2\2^\6\3\2\2\2_`\7t\2\2`a\7g\2\2ab\7v\2\2bc\7w\2\2cd\7t\2\2"+
		"de\7p\2\2e\b\3\2\2\2fg\7(\2\2g\n\3\2\2\2hi\7B\2\2i\f\3\2\2\2jk\7*\2\2"+
		"k\16\3\2\2\2lm\7+\2\2m\20\3\2\2\2no\7k\2\2op\7h\2\2p\22\3\2\2\2qr\7g\2"+
		"\2rs\7n\2\2st\7u\2\2tu\7g\2\2u\24\3\2\2\2vw\7h\2\2wx\7q\2\2xy\7t\2\2y"+
		"\26\3\2\2\2z{\7r\2\2{|\7t\2\2|}\7k\2\2}~\7p\2\2~\177\7v\2\2\177\u0080"+
		"\7h\2\2\u0080\30\3\2\2\2\u0081\u0082\7o\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7k\2\2\u0084\u0085\7p\2\2\u0085\32\3\2\2\2\u0086\u0088\t\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\34\3\2\2\2\u008b\u008c\7}\2\2\u008c\36\3\2\2\2\u008d\u008e"+
		"\7\177\2\2\u008e \3\2\2\2\u008f\u0090\7-\2\2\u0090\"\3\2\2\2\u0091\u0092"+
		"\7/\2\2\u0092$\3\2\2\2\u0093\u0094\7,\2\2\u0094&\3\2\2\2\u0095\u0096\7"+
		"\61\2\2\u0096(\3\2\2\2\u0097\u0098\7-\2\2\u0098\u0099\7?\2\2\u0099*\3"+
		"\2\2\2\u009a\u009b\7/\2\2\u009b\u009c\7?\2\2\u009c,\3\2\2\2\u009d\u009e"+
		"\7,\2\2\u009e\u009f\7?\2\2\u009f.\3\2\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2"+
		"\7?\2\2\u00a2\60\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4\62\3\2\2\2\u00a5\u00a6"+
		"\7@\2\2\u00a6\64\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\u00a9\7?\2\2\u00a9\66"+
		"\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab\u00ac\7?\2\2\u00ac8\3\2\2\2\u00ad\u00ae"+
		"\7?\2\2\u00ae:\3\2\2\2\u00af\u00b3\t\3\2\2\u00b0\u00b2\t\4\2\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"<\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\4\62;\2\u00b7\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba>\3"+
		"\2\2\2\u00bb\u00bc\7\61\2\2\u00bc\u00bd\7\61\2\2\u00bd\u00c1\3\2\2\2\u00be"+
		"\u00c0\n\5\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c6\7\17\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3"+
		"\2\2\2\u00c7\u00c8\7\f\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b \2\2\u00ca"+
		"@\3\2\2\2\u00cb\u00cc\t\6\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b!\2\2\u00ce"+
		"B\3\2\2\2\u00cf\u00d4\7$\2\2\u00d0\u00d3\5I%\2\u00d1\u00d3\n\7\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d8\7$\2\2\u00d8D\3\2\2\2\u00d9\u00dc\7)\2\2\u00da\u00dd\5I%\2\u00db"+
		"\u00dd\n\b\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00df\7)\2\2\u00dfF\3\2\2\2\u00e0\u00e1\t\t\2\2\u00e1H\3\2"+
		"\2\2\u00e2\u00e3\7^\2\2\u00e3\u00e7\t\n\2\2\u00e4\u00e7\5M\'\2\u00e5\u00e7"+
		"\5K&\2\u00e6\u00e2\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"J\3\2\2\2\u00e8\u00e9\7^\2\2\u00e9\u00ea\4\62\65\2\u00ea\u00eb\4\629\2"+
		"\u00eb\u00f2\4\629\2\u00ec\u00ed\7^\2\2\u00ed\u00ee\4\629\2\u00ee\u00f2"+
		"\4\629\2\u00ef\u00f0\7^\2\2\u00f0\u00f2\4\629\2\u00f1\u00e8\3\2\2\2\u00f1"+
		"\u00ec\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2L\3\2\2\2\u00f3\u00f4\7^\2\2\u00f4"+
		"\u00f5\7w\2\2\u00f5\u00f6\5G$\2\u00f6\u00f7\5G$\2\u00f7\u00f8\5G$\2\u00f8"+
		"\u00f9\5G$\2\u00f9N\3\2\2\2\u00fa\u00fb\7=\2\2\u00fbP\3\2\2\2\16\2X\u0089"+
		"\u00b3\u00b9\u00c1\u00c5\u00d2\u00d4\u00dc\u00e6\u00f1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}