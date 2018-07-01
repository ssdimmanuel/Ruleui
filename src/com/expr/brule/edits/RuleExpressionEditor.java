package com.expr.brule.edits;

import java.util.HashMap;

import com.expr.brule.core.BusinessRuleParser.CompopContext;
import com.expr.brule.core.BusinessRuleParser.StringExpressionContext;
import com.expr.brule.core.BusinessRuleParser.VariableExpressionContext;
import com.expr.brule.editing.RuleExpression;

public class RuleExpressionEditor extends RuleEditSupport {

	public RuleExpressionEditor(String rule, HashMap rmap) {
		super(rule, rmap);
	}
	
	private boolean replace=false;
	private RuleExpression save;

	@Override
	public void enterStringExpression(StringExpressionContext ctx) {
		
		if (ctx.compop() != null) {
			RuleExpression exp = new RuleExpression(ctx.lhs.getText(), ctx.rhs.getText(), ctx.compop().getText());

			System.out.println(exp + "" + this.replaceMap.get(exp));
			if (this.replaceMap.get(exp) instanceof RuleExpression) {
				save = (RuleExpression) this.replaceMap.get(exp);
				rw.replace(ctx.lhs, save.getBusinessVariable());
				//rw.replace(ctx.compop().start, ctx.compop().stop, save.getOperator());
				rw.replace(ctx.rhs, save.getComparedValue());
				replace=true;
			}
		}
	}


	@Override
	public void enterVariableExpression(VariableExpressionContext ctx) {
		
		if (ctx.compop() != null) {
			RuleExpression exp = new RuleExpression(ctx.lhs.getText(), ctx.rhs.getText(), ctx.compop().getText());

			System.out.println(exp + "" + this.replaceMap.get(exp));
			if (this.replaceMap.get(exp) instanceof RuleExpression) {
				save = (RuleExpression) this.replaceMap.get(exp);
				rw.replace(ctx.lhs, save.getBusinessVariable());
				//rw.replace(ctx.compop().start, ctx.compop().stop, save.getOperator());
				rw.replace(ctx.rhs, save.getComparedValue());
				replace=true;
			}
		}
	}




	@Override
	public void enterCompop(CompopContext ctx) {
		if(replace){
			rw.replace(ctx.start, " "+save.getOperator()+" ");
			replace=false;
		}else{
			super.enterCompop(ctx);
		}
	}

}
