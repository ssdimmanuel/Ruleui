/**
 * 
 */
package com.expr.brule.editing;

import java.util.ArrayList;

import com.expr.brule.common.ParseWrapper;
import com.expr.brule.core.BusinessRuleBaseListener;
import com.expr.brule.core.BusinessRuleParser.BinopContext;
import com.expr.brule.core.BusinessRuleParser.BooleanFalseContext;
import com.expr.brule.core.BusinessRuleParser.BooleanTrueContext;
import com.expr.brule.core.BusinessRuleParser.NumberExpressionContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.core.BusinessRuleParser.VariableExpressionContext;

/**
 * Collect all token ranges for a given input business rule
 * @author ssdImmanuel
 *
 */
public class RuleColoringData extends ParseWrapper {

	/**
	 * 
	 */
	private ArrayList<RangeData> tokenranges= new ArrayList<RangeData>();
	public RuleColoringData(String rule) {
		super(rule);
	}

	@Override
	public void enterBinop(BinopContext ctx) {
		
		RangeData data = new RangeData();
		data.tokenStart = ctx.start.getStartIndex();
		data.tokenLength= ctx.start.getText().length();
		
		data.tokenType = ctx.start.getType();
		this.tokenranges.add(data);
	}

	@Override
	public void enterStringExpression(StringExpressionContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.rhs.getStartIndex();
		data.tokenLength= ctx.rhs.getText().length();
		
		data.tokenType = ctx.rhs.getType();
		this.tokenranges.add(data);
	}

	@Override
	public void enterNumberExpression(NumberExpressionContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.rhs.getStartIndex();
		data.tokenLength= ctx.rhs.getText().length();
		
		data.tokenType = ctx.rhs.getType();
		this.tokenranges.add(data);
	}

	@Override
	public void enterVariableExpression(VariableExpressionContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.rhs.getStartIndex();
		data.tokenLength= ctx.rhs.getText().length();
		
		data.tokenType = ctx.rhs.getType();
		this.tokenranges.add(data);
	}

	@Override
	public void enterBooleanTrue(BooleanTrueContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.start.getStartIndex();
		data.tokenLength= ctx.getText().length();
		
		data.tokenType = ctx.TRUE().getSymbol().getType();
		this.tokenranges.add(data);
	}

	@Override
	public void enterBooleanFalse(BooleanFalseContext ctx) {
		RangeData data = new RangeData();
		data.tokenStart = ctx.start.getStartIndex();
		data.tokenLength= ctx.getText().length();
		
		data.tokenType = ctx.start.getType();
		this.tokenranges.add(data);
	}

	public ArrayList<RangeData> getTokenranges() {
		return tokenranges;
	}

	public void setTokenranges(ArrayList<RangeData> tokenranges) {
		this.tokenranges = tokenranges;
	}
	
}
