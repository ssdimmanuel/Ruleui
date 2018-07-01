// Generated from BusinessRule.g4 by ANTLR 4.7.1

package com.expr.brule.core;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BusinessRuleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, STRING=3, LEFTPAREN=4, RIGHTPAREN=5, EQUAL=6, LT=7, GT=8, 
		LTE=9, GTE=10, NE=11, AND=12, OR=13, VARIABLE=14, NUMBER=15, SPACE=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TRUE", "FALSE", "STRING", "LEFTPAREN", "RIGHTPAREN", "EQUAL", "LT", "GT", 
		"LTE", "GTE", "NE", "AND", "OR", "VARIABLE", "NUMBER", "SPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TRUE", "FALSE", "STRING", "LEFTPAREN", "RIGHTPAREN", "EQUAL", "LT", 
		"GT", "LTE", "GTE", "NE", "AND", "OR", "VARIABLE", "NUMBER", "SPACE"
	};
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


	public BusinessRuleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BusinessRule.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2,\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\38\n\3\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\5\7J\n\7\3\b\3\b\3\b\5\bO\n\b\3\t\3\t\3\t\5\tT\n\t\3\n"+
		"\3\n\3\n\3\n\5\nZ\n\n\3\13\3\13\3\13\3\13\5\13`\n\13\3\f\3\f\3\f\3\f\5"+
		"\ff\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\ro\n\r\3\16\3\16\3\16\3\16\3\16"+
		"\5\16v\n\16\3\17\6\17y\n\17\r\17\16\17z\3\17\7\17~\n\17\f\17\16\17\u0081"+
		"\13\17\3\20\6\20\u0084\n\20\r\20\16\20\u0085\3\20\3\20\6\20\u008a\n\20"+
		"\r\20\16\20\u008b\5\20\u008e\n\20\3\21\3\21\3\21\3\21\2\2\22\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"\3\2\7\5\2\13\f\17\17$$\4\2C\\c|\7\2/\60\62;C\\aac|\3\2\62;\5\2\13\f\17"+
		"\17\"\"\2\u00a4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\3+\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rI\3"+
		"\2\2\2\17N\3\2\2\2\21S\3\2\2\2\23Y\3\2\2\2\25_\3\2\2\2\27e\3\2\2\2\31"+
		"n\3\2\2\2\33u\3\2\2\2\35x\3\2\2\2\37\u0083\3\2\2\2!\u008f\3\2\2\2#$\7"+
		"v\2\2$%\7t\2\2%&\7w\2\2&,\7g\2\2\'(\7V\2\2()\7T\2\2)*\7W\2\2*,\7G\2\2"+
		"+#\3\2\2\2+\'\3\2\2\2,\4\3\2\2\2-.\7h\2\2./\7c\2\2/\60\7n\2\2\60\61\7"+
		"u\2\2\618\7g\2\2\62\63\7H\2\2\63\64\7C\2\2\64\65\7N\2\2\65\66\7U\2\2\66"+
		"8\7G\2\2\67-\3\2\2\2\67\62\3\2\2\28\6\3\2\2\29=\7$\2\2:<\n\2\2\2;:\3\2"+
		"\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7$\2\2A\b\3\2"+
		"\2\2BC\7*\2\2C\n\3\2\2\2DE\7+\2\2E\f\3\2\2\2FJ\7?\2\2GH\7G\2\2HJ\7S\2"+
		"\2IF\3\2\2\2IG\3\2\2\2J\16\3\2\2\2KO\7>\2\2LM\7N\2\2MO\7V\2\2NK\3\2\2"+
		"\2NL\3\2\2\2O\20\3\2\2\2PT\7@\2\2QR\7I\2\2RT\7V\2\2SP\3\2\2\2SQ\3\2\2"+
		"\2T\22\3\2\2\2UV\7>\2\2VZ\7?\2\2WX\7N\2\2XZ\7G\2\2YU\3\2\2\2YW\3\2\2\2"+
		"Z\24\3\2\2\2[\\\7@\2\2\\`\7?\2\2]^\7I\2\2^`\7G\2\2_[\3\2\2\2_]\3\2\2\2"+
		"`\26\3\2\2\2ab\7#\2\2bf\7?\2\2cd\7P\2\2df\7G\2\2ea\3\2\2\2ec\3\2\2\2f"+
		"\30\3\2\2\2gh\7C\2\2hi\7P\2\2io\7F\2\2jo\7(\2\2kl\7c\2\2lm\7p\2\2mo\7"+
		"f\2\2ng\3\2\2\2nj\3\2\2\2nk\3\2\2\2o\32\3\2\2\2pq\7Q\2\2qv\7T\2\2rs\7"+
		"q\2\2sv\7t\2\2tv\7~\2\2up\3\2\2\2ur\3\2\2\2ut\3\2\2\2v\34\3\2\2\2wy\t"+
		"\3\2\2xw\3\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\177\3\2\2\2|~\t\4\2\2"+
		"}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\36\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0082\u0084\t\5\2\2\u0083\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008d\3\2\2\2\u0087"+
		"\u0089\7\60\2\2\u0088\u008a\t\5\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3"+
		"\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u0087\3\2\2\2\u008d\u008e\3\2\2\2\u008e \3\2\2\2\u008f\u0090\t\6\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\b\21\2\2\u0092\"\3\2\2\2\23\2+\67=IN"+
		"SY_enuz\177\u0085\u008b\u008d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}