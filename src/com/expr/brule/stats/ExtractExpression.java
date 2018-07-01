package com.expr.brule.stats;

import java.util.ArrayList;

import com.expr.brule.common.ParseWrapper;
import com.expr.brule.core.BusinessRuleParser.ExprContext;
import com.expr.brule.core.BusinessRuleParser.NumberExpressionContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.core.BusinessRuleParser.VariableExpressionContext;

public class ExtractExpression extends ParseWrapper {

	
	private ArrayList<RuleExpression> expressions;
	
	public ExtractExpression(String rule) {
		super(rule);
		setExpressions(new ArrayList<RuleExpression>());
	}

	public ArrayList<RuleExpression> getExpressions() {
		return expressions;
	}

	public void setExpressions(ArrayList<RuleExpression> expressions) {
		this.expressions = expressions;
	}

	@Override
	public void enterStringExpression(StringExpressionContext ctx) {
		RuleExpression exp = new RuleExpression();
		exp.lhs = ctx.lhs.getText();
		exp.operator = ctx.compop().getText();
		exp.rhs = ctx.rhs.getText();
		expressions.add(exp);
	}

	@Override
	public void enterNumberExpression(NumberExpressionContext ctx) {
		RuleExpression exp = new RuleExpression();
		exp.lhs = ctx.lhs.getText();
		exp.operator = ctx.compop().getText();
		exp.rhs = ctx.rhs.getText();
		expressions.add(exp);
	}

	@Override
	public void enterVariableExpression(VariableExpressionContext ctx) {
		RuleExpression exp = new RuleExpression();
		exp.lhs = ctx.lhs.getText();
		exp.operator = ctx.compop().getText();
		exp.rhs = ctx.rhs.getText();
		expressions.add(exp);
	}

	
	
	
}
