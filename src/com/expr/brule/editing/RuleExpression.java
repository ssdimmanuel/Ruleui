package com.expr.brule.editing;

public class RuleExpression {

	public RuleExpression() {
	}
	
	
	public RuleExpression(String businessVariable, String comparedValue, String operator) {
		this.businessVariable = businessVariable;
		this.comparedValue = comparedValue;
		this.operator = operator;
	}


	private String businessVariable;
	private String comparedValue;
	private String operator;
	public String getBusinessVariable() {
		return businessVariable;
	}
	public void setBusinessVariable(String businessVariable) {
		this.businessVariable = businessVariable;
	}
	public String getComparedValue() {
		return comparedValue;
	}
	public void setComparedValue(String comparedValue) {
		this.comparedValue = comparedValue;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessVariable == null) ? 0 : businessVariable.hashCode());
		result = prime * result + ((comparedValue == null) ? 0 : comparedValue.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}


	
	@Override
	public String toString() {
		return "RuleExpression [businessVariable=" + businessVariable + ", comparedValue=" + comparedValue
				+ ", operator=" + operator + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleExpression other = (RuleExpression) obj;
		if (businessVariable == null) {
			if (other.businessVariable != null)
				return false;
		} else if (!businessVariable.equals(other.businessVariable))
			return false;
		if (comparedValue == null) {
			if (other.comparedValue != null)
				return false;
		} else if (!comparedValue.equals(other.comparedValue))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		return true;
	}

	
}
