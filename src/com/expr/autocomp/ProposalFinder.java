package com.expr.autocomp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.expr.brule.common.ParseWrapper;

public class ProposalFinder extends ParseWrapper {

	public ProposalFinder(String rule) {
		super(rule);
	}
	
	public ArrayList<String> find() {
		CodeCompletionCore core = new CodeCompletionCore(parser, null, null);
		int last = this.tokens.getNumberOfOnChannelTokens()-1;
		CodeCompletionCore.CandidatesCollection candidates = core.collectCandidates(last, null);
		System.out.println("tokens: "+candidates.tokens);
		System.out.println("rules: "+candidates.rules);
		
		Map<Integer, List<Integer>> vals = candidates.tokens;
		
		Iterator<Integer> it = vals.keySet().iterator();
		
		ArrayList<String> prop = new ArrayList();
		
		while(it.hasNext()) {
			int key = it.next();
			List<Integer> val = vals.get(key);
			System.out.println(">> "+this.lexer.getVocabulary().getDisplayName(key));
			String poss = this.lexer.getVocabulary().getDisplayName(key);
			poss=poss.replace("'", "");
			if(poss.equals("EOF")) {
				continue;
			}
			prop.add(poss);
			
			for(Integer tinx : val) {
				String p1 =poss+" "+this.lexer.getVocabulary().getDisplayName(tinx);
				System.out.println("\t"+this.lexer.getVocabulary().getDisplayName(tinx));
				prop.add(p1);
			}
		}
		return prop;
	}

}
