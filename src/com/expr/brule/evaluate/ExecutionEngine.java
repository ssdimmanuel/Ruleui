/**
 * 
 */
package com.expr.brule.evaluate;

import java.util.HashMap;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.expr.brule.core.BusinessRuleBaseVisitor;
import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.CompopContext;
import com.expr.brule.core.BusinessRuleParser.EnclosedExpressionContext;
import com.expr.brule.core.BusinessRuleParser.LogicalExpressionContext;
import com.expr.brule.core.BusinessRuleParser.NumberExpressionContext;
import com.expr.brule.core.BusinessRuleParser.ParseContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.core.BusinessRuleParser.VariableExpressionContext;

/**
 * Extends the class <code>BusinessRuleBaseVisitor</code> to visit all nodes to evaluate the expression
 * @author ssdImmanuel
 *
 */
public class ExecutionEngine extends BusinessRuleBaseVisitor<Object> {

	public ExecutionEngine(String rule, HashMap<String, Object> values) {
		this.rule = rule;
		this.values = values;
	}

	private String rule;
	private HashMap values;

	private Boolean result;

	/**
	 * Parses the rule String passed and calls the top level visit method
	 */
	public void evaluate() {
		BusinessRuleLexer lexer = new BusinessRuleLexer(CharStreams.fromString(rule));
		BusinessRuleParser parser = new BusinessRuleParser(new CommonTokenStream(lexer));
		this.result = (Boolean) this.visit(parser.parse());
		System.out.println("Final outcome : " + result);
	}

	@Override
	public Object visitParse(ParseContext ctx) {
		System.out.println("visit parse: " + ctx.getText());
		boolean res = false;

		res = (boolean) super.visit(ctx.expr());

		System.out.println("after parse");
		return res;
	}

	@Override
	public Object visitEnclosedExpression(EnclosedExpressionContext ctx) {
		// System.out.println("ee: "+ctx.expr().getClass());
		return super.visit(ctx.expr());
	}

	@Override
	public Object visitStringExpression(StringExpressionContext ctx) {
		System.out.println("inside String exp");
		String lhsvalue = ctx.lhs.getText();
		String rhsvalue = ctx.rhs.getText();
		String lhsRuntimeValue;
		String newrhsValue = rhsvalue.replaceAll("\"", "");

		lhsRuntimeValue = (String) this.values.get(lhsvalue);
		if (lhsRuntimeValue == null) {
			lhsRuntimeValue = lhsvalue;
		}

		System.out.println("lhs: " + lhsvalue);
		System.out.println("sbs: " + values.get(lhsvalue));
		System.out.println("rhs: " + newrhsValue);

		if (ctx.compop().EQUAL() != null) {
			//System.out.println("Outcome of expr " + ctx.getText() + " : " + lhsRuntimeValue.equals(rhsvalue));
			return lhsRuntimeValue.equals(newrhsValue);
		}

		if (ctx.compop().NE() != null) {
			return !(lhsRuntimeValue.equals(newrhsValue));
		}

		return lhsRuntimeValue.equals(rhsvalue);
	}

	@Override
	public Object visitNumberExpression(NumberExpressionContext ctx) {
		System.out.println("inside Number exp");
		String lhsvalue = ctx.lhs.getText();
		String rhsvalue = ctx.rhs.getText();
		double lhsnum = 0;
		double rhsnum;
		Object lhsRuntimeValue;
		Object newrhsValue = rhsvalue.replaceAll("\"", "");

		lhsRuntimeValue = this.values.get(lhsvalue);
		if (lhsRuntimeValue == null) {
			new RuntimeException("Value missing for Number expression");
		} else {
			lhsnum = Double.valueOf(lhsRuntimeValue.toString());
		}

		rhsnum = Double.parseDouble(newrhsValue.toString());

		System.out.println("lhs: " + lhsvalue);
		System.out.println("sbs: " + values.get(lhsvalue));
		System.out.println("rhs: " + ctx.rhs.getText());

		if (ctx.compop().EQUAL() != null) {
			return lhsnum == rhsnum;
		}

		if (ctx.compop().GT() != null) {
			return lhsnum > rhsnum;
		}
		if (ctx.compop().LT() != null) {
			return lhsnum < rhsnum;
		}
		if (ctx.compop().NE() != null) {
			return lhsnum != rhsnum;
		}
		if (ctx.compop().GTE() != null) {
			return lhsnum >= rhsnum;
		}
		if (ctx.compop().LTE() != null) {
			return lhsnum <= rhsnum;
		}

		return lhsRuntimeValue.equals(rhsvalue);
	}

	@Override
	public Object visitLogicalExpression(LogicalExpressionContext ctx) {

		System.out.println("Before Evaluation of LHS " + ctx.expr(0).getText() + " ");
		System.out.println("" + ctx.expr(0).getText());
		boolean leftoutcome = (boolean) this.visit(ctx.expr(0));

		System.out.println("Before Evaluation of RHS " + ctx.expr(1).getText() + " ");
		boolean rightoutcome = (boolean) this.visit(ctx.expr(1));

		System.out.println("Evaluation of " + ctx.expr(0).getText() + " " + leftoutcome);
		System.out.println("Evaluation of " + ctx.expr(1).getText() + " " + rightoutcome);

		if (ctx.binop().AND() != null) {
			return (leftoutcome && rightoutcome);
		}

		if (ctx.binop().OR() != null) {
			System.out.println("Evaluating OR " + rightoutcome);
			return (leftoutcome || rightoutcome);
		}

		return false;
	}

	@Override
	public Object visitVariableExpression(VariableExpressionContext ctx) {
		System.out.println("inside String exp");
		String lhsvalue = ctx.lhs.getText();
		String rhsvalue = ctx.rhs.getText();
		Object lhsRuntimeValue;
		Object rhsRuntimeValue;
		// Object newrhsValue = rhsvalue.replaceAll("\"", "");

		lhsRuntimeValue = this.values.get(lhsvalue);
		if (lhsRuntimeValue == null) {
			lhsRuntimeValue = lhsvalue;
		}

		rhsRuntimeValue = this.values.get(rhsvalue);
		if (rhsRuntimeValue == null) {
			rhsRuntimeValue = rhsvalue;
		}

		System.out.println("lhs: " + lhsvalue);
		System.out.println("sbs: " + values.get(lhsvalue));
		System.out.println("rhs: " + ctx.rhs.getText());

		if (ctx.compop().EQUAL() != null) {
			System.out.println("Outcome of expr " + ctx.getText() + " : " + lhsRuntimeValue.equals(rhsvalue));

			if (lhsRuntimeValue instanceof String) {

			} else if (lhsRuntimeValue instanceof Integer) {

			}
			return lhsRuntimeValue.equals(rhsRuntimeValue);
		}

		if (ctx.compop().GT() != null) {

		}

		return lhsRuntimeValue.equals(rhsvalue);
	}

	@Override
	public Object visitBinop(BinopContext ctx) {
		return super.visitBinop(ctx);
	}

	@Override
	public Object visitCompop(CompopContext ctx) {
		return super.visitCompop(ctx);
	}

}
