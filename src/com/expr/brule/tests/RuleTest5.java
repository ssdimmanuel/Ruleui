package com.expr.brule.tests;


import java.util.HashMap;

import com.expr.brule.evaluate.ExecutionEngine;

public class RuleTest5 {

	public static void main(String[] args) throws Exception {

		String rule = "( ( IND1 = 1)  OR ( IND2 > 2 ) ) & TYPE = \"ABC\"";
		
		
		System.out.println("Input rule: "+rule);
		
		HashMap values = new HashMap();
		values.put("IND1", 1.0);
		values.put("IND2", 22.1);
		values.put("TYPE", "ABC");
		
		ExecutionEngine eng = new ExecutionEngine(rule, values);
		eng.evaluate();
		
	}

}
