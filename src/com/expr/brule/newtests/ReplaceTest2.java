package com.expr.brule.newtests;

import java.io.IOException;

import com.expr.brule.edits.RuleVariableEditor;

public class ReplaceTest2 {

	public static void main(String[] args) {
		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = Y ) )";
		
		System.out.println("Input rule: "+rule);
		
		/*HashMap rmap = new HashMap();
		rmap.put("AMOUNT", "CASH");*/
		
		RuleVariableEditor exp = new RuleVariableEditor(rule, "AMOUNT", "CASH");
		
		try {
			exp.parseRule();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Edited rule: "+exp.getLatestRule());

	}

}
