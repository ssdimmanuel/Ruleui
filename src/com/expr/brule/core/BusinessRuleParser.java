// Generated from BusinessRule.g4 by ANTLR 4.7.1

package com.expr.brule.core;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BusinessRuleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, STRING=3, LEFTPAREN=4, RIGHTPAREN=5, EQUAL=6, LT=7, GT=8, 
		LTE=9, GTE=10, NE=11, AND=12, OR=13, VARIABLE=14, NUMBER=15, SPACE=16;
	public static final int
		RULE_parse = 0, RULE_expr = 1, RULE_binop = 2, RULE_compop = 3;
	public static final String[] ruleNames = {
		"parse", "expr", "binop", "compop"
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

	@Override
	public String getGrammarFileName() { return "BusinessRule.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BusinessRuleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BusinessRuleParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			expr(0);
			setState(9);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringExpressionContext extends ExprContext {
		public Token lhs;
		public Token rhs;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(BusinessRuleParser.VARIABLE, 0); }
		public TerminalNode STRING() { return getToken(BusinessRuleParser.STRING, 0); }
		public StringExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExpressionContext extends ExprContext {
		public Token lhs;
		public Token rhs;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public TerminalNode VARIABLE() { return getToken(BusinessRuleParser.VARIABLE, 0); }
		public TerminalNode NUMBER() { return getToken(BusinessRuleParser.NUMBER, 0); }
		public NumberExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitNumberExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanTrueContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(BusinessRuleParser.TRUE, 0); }
		public BooleanTrueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterBooleanTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitBooleanTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitBooleanTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnclosedExpressionContext extends ExprContext {
		public TerminalNode LEFTPAREN() { return getToken(BusinessRuleParser.LEFTPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHTPAREN() { return getToken(BusinessRuleParser.RIGHTPAREN, 0); }
		public EnclosedExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterEnclosedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitEnclosedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitEnclosedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanFalseContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(BusinessRuleParser.FALSE, 0); }
		public BooleanFalseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterBooleanFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitBooleanFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitBooleanFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanVariableContext extends ExprContext {
		public TerminalNode VARIABLE() { return getToken(BusinessRuleParser.VARIABLE, 0); }
		public BooleanVariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterBooleanVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitBooleanVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitBooleanVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExpressionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public LogicalExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpressionContext extends ExprContext {
		public Token lhs;
		public Token rhs;
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(BusinessRuleParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(BusinessRuleParser.VARIABLE, i);
		}
		public VariableExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new VariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(12);
				((VariableExpressionContext)_localctx).lhs = match(VARIABLE);
				setState(13);
				compop();
				setState(14);
				((VariableExpressionContext)_localctx).rhs = match(VARIABLE);
				}
				break;
			case 2:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				((StringExpressionContext)_localctx).lhs = match(VARIABLE);
				setState(17);
				compop();
				setState(18);
				((StringExpressionContext)_localctx).rhs = match(STRING);
				}
				break;
			case 3:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				((NumberExpressionContext)_localctx).lhs = match(VARIABLE);
				setState(21);
				compop();
				setState(22);
				((NumberExpressionContext)_localctx).rhs = match(NUMBER);
				}
				break;
			case 4:
				{
				_localctx = new BooleanTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(TRUE);
				}
				break;
			case 5:
				{
				_localctx = new BooleanFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(FALSE);
				}
				break;
			case 6:
				{
				_localctx = new BooleanVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(VARIABLE);
				}
				break;
			case 7:
				{
				_localctx = new EnclosedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(LEFTPAREN);
				setState(28);
				expr(0);
				setState(29);
				match(RIGHTPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalExpressionContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(33);
					if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
					setState(34);
					binop();
					setState(35);
					expr(9);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(BusinessRuleParser.AND, 0); }
		public TerminalNode OR() { return getToken(BusinessRuleParser.OR, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_binop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public static class CompopContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(BusinessRuleParser.EQUAL, 0); }
		public TerminalNode LT() { return getToken(BusinessRuleParser.LT, 0); }
		public TerminalNode GT() { return getToken(BusinessRuleParser.GT, 0); }
		public TerminalNode LTE() { return getToken(BusinessRuleParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(BusinessRuleParser.GTE, 0); }
		public TerminalNode NE() { return getToken(BusinessRuleParser.NE, 0); }
		public CompopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).enterCompop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BusinessRuleListener ) ((BusinessRuleListener)listener).exitCompop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BusinessRuleVisitor ) return ((BusinessRuleVisitor<? extends T>)visitor).visitCompop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompopContext compop() throws RecognitionException {
		CompopContext _localctx = new CompopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << LT) | (1L << GT) | (1L << LTE) | (1L << GTE) | (1L << NE))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3\3\3\3\3\3\7"+
		"\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\5\3\5\3\5\2\3\4\6\2\4\6\b\2\4\3\2\16"+
		"\17\3\2\b\r\2\63\2\n\3\2\2\2\4!\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n\13\5\4"+
		"\3\2\13\f\7\2\2\3\f\3\3\2\2\2\r\16\b\3\1\2\16\17\7\20\2\2\17\20\5\b\5"+
		"\2\20\21\7\20\2\2\21\"\3\2\2\2\22\23\7\20\2\2\23\24\5\b\5\2\24\25\7\5"+
		"\2\2\25\"\3\2\2\2\26\27\7\20\2\2\27\30\5\b\5\2\30\31\7\21\2\2\31\"\3\2"+
		"\2\2\32\"\7\3\2\2\33\"\7\4\2\2\34\"\7\20\2\2\35\36\7\6\2\2\36\37\5\4\3"+
		"\2\37 \7\7\2\2 \"\3\2\2\2!\r\3\2\2\2!\22\3\2\2\2!\26\3\2\2\2!\32\3\2\2"+
		"\2!\33\3\2\2\2!\34\3\2\2\2!\35\3\2\2\2\")\3\2\2\2#$\f\n\2\2$%\5\6\4\2"+
		"%&\5\4\3\13&(\3\2\2\2\'#\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2"+
		"\2\2+)\3\2\2\2,-\t\2\2\2-\7\3\2\2\2./\t\3\2\2/\t\3\2\2\2\4!)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}