/**
 * 
 */
package com.expr.brule.edits;

import java.util.HashMap;

import com.expr.brule.core.BusinessRuleParser.NumberExpressionContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.core.BusinessRuleParser.VariableExpressionContext;

/**
 * @author ssdImmanuel
 *
 */
public class RuleVariableEditor extends RuleEditSupport {

	public RuleVariableEditor(String rule, String lhs, String replacelhs) {
		this(rule, new HashMap());
		this.replaceMap.put(lhs, replacelhs);
	}

	public RuleVariableEditor(String rule, HashMap map) {
		super(rule, map);
	}

	@Override
	public void enterStringExpression(StringExpressionContext ctx) {
		String lhs = ctx.lhs.getText();
		if (this.replaceMap.containsKey(lhs)) {
			this.rw.replace(ctx.lhs, " " + this.replaceMap.get(lhs) + " ");
		}
	}

	@Override
	public void enterNumberExpression(NumberExpressionContext ctx) {
		String lhs = ctx.lhs.getText();
		if (this.replaceMap.containsKey(lhs)) {
			this.rw.replace(ctx.lhs, " " + this.replaceMap.get(lhs) + " ");
		}
	}

	@Override
	public void enterVariableExpression(VariableExpressionContext ctx) {
		String lhs = ctx.lhs.getText();
		if (this.replaceMap.containsKey(lhs)) {
			this.rw.replace(ctx.lhs, " " + this.replaceMap.get(lhs) + " ");
		}
	}

}
