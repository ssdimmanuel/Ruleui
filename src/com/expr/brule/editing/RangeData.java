package com.expr.brule.editing;

/**
 * Hold reference to the token ranges with a given input
 * @author ssdImmanuel
 *
 */
public class RangeData {

	public RangeData() {
	}
	
	public int tokenStart;
	public int tokenLength;
	public int tokenType;
	@Override
	public String toString() {
		return "RangeData [tokenStart=" + tokenStart + ", tokenLength=" + tokenLength + ", tokenType=" + tokenType
				+ "]";
	}

	
}
