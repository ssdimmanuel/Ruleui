package com.expr.brule.newtests;

import java.io.IOException;
import java.util.HashMap;

import com.expr.brule.editing.RuleExpression;
import com.expr.brule.edits.RuleExpressionEditor;

public class ReplaceTest1 {

	public static void main(String[] args) {
		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = Y ) )";
		
		System.out.println("Input rule: "+rule);
		
		RuleExpression orig = new RuleExpression("AMOUNT","200000.00",">");
		RuleExpression repl = new RuleExpression("AMOUNT-1","400000.00","<");
		
		RuleExpression o1 = new RuleExpression("IND1","Y","=");
		RuleExpression r1 = new RuleExpression("IND22","Z","=");
		
		HashMap rmap = new HashMap();
		rmap.put(orig, repl);
		rmap.put(o1, r1);
		
		RuleExpressionEditor exp = new RuleExpressionEditor(rule, rmap);
		
		try {
			exp.parseRule();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Edited rule: "+exp.getLatestRule());

	}

}
