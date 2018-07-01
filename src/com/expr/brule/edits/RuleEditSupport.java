package com.expr.brule.edits;

import java.util.HashMap;

import com.expr.brule.common.ParseWrapper;

public class RuleEditSupport extends ParseWrapper {

	protected HashMap<Object, Object> replaceMap = new HashMap();
	
	public RuleEditSupport(String rule,HashMap rmap) {
		super(rule);
		this.replaceMap = rmap;
	}
	public HashMap<Object, Object> getReplaceMap() {
		return replaceMap;
	}
	public void setReplaceMap(HashMap<Object, Object> replaceMap) {
		this.replaceMap = replaceMap;
	}
	
}
