package com.expr.brule.pattern;

import org.antlr.v4.runtime.tree.pattern.ParseTreeMatch;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;

import com.expr.brule.common.ParseWrapper;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.NumberExpressionContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.core.BusinessRuleParser.VariableExpressionContext;

public class RulePatternMatcher extends ParseWrapper {

	public RulePatternMatcher(String rule, String pattern) {
		super(rule);
		this.pattern = pattern;
	}

	private String pattern;

	@Override
	public void enterStringExpression(StringExpressionContext ctx) {
		ParseTreePattern p = parser.compileParseTreePattern(pattern, ctx.getRuleIndex());
		ParseTreeMatch m = p.match(ctx);
		if (m.succeeded()) {
			System.out.println("matched: " + m.getTree().getText());
		}
	}

	@Override
	public void enterNumberExpression(NumberExpressionContext ctx) {
		ParseTreePattern p = parser.compileParseTreePattern(pattern, ctx.getRuleIndex());
		ParseTreeMatch m = p.match(ctx);
		if (m.succeeded()) {
			System.out.println("matched: " + m.getTree().getText());
		}
	}

	@Override
	public void enterVariableExpression(VariableExpressionContext ctx) {
		ParseTreePattern p = parser.compileParseTreePattern(pattern, ctx.getRuleIndex());
		ParseTreeMatch m = p.match(ctx);
		if (m.succeeded()) {
			System.out.println("matched: " + m.getTree().getText());
		}
	}
	
	

}
