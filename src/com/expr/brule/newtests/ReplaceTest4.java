package com.expr.brule.newtests;

import java.io.IOException;

import com.expr.autocomp.ProposalFinder;

public class ReplaceTest4 {

	public static void main(String[] args) throws IOException {
		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = Y ) )";
		String rule1= "AMOUNT = 1010.00 OR true and amt";
		
		ProposalFinder pf = new ProposalFinder(rule1);
		pf.parseRule();
		pf.find();
	}

}
