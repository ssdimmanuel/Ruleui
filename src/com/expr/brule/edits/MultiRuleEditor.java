package com.expr.brule.edits;

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.TokenStreamRewriter;

public class MultiRuleEditor {

	public MultiRuleEditor(ArrayList<String> rules,String lhs, String newlhs) {
		this.rules = rules;
		this.lhs = lhs;
		this.newlhs = newlhs;
	}
	
	private ArrayList<String> rules; 
	protected TokenStreamRewriter rw;
	private String lhs;
	private String newlhs;
	
	public void run() throws IOException {
		
		for(String rule : rules) {
			RuleVariableEditor editor = new RuleVariableEditor(rule, lhs, newlhs);
			editor.parseRule();
			System.out.println("old rule:    "+rule);
			System.out.println("edited rule: "+editor.getLatestRule());
		}
		
	}

}
