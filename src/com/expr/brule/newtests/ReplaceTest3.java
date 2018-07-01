package com.expr.brule.newtests;

import java.io.IOException;
import java.util.ArrayList;

import com.expr.brule.edits.MultiRuleEditor;

public class ReplaceTest3 {

	public static void main(String[] args) {
		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = Y ) )";
		String rule1= "AMOUNT = 1010.00";
		
		ArrayList rules = new ArrayList<String>();
		rules.add(rule);
		rules.add(rule1);
		
		MultiRuleEditor multi = new MultiRuleEditor(rules, "AMOUNT", "CASH");
		try {
			multi.run();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
