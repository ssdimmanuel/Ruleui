// Generated from BusinessRule.g4 by ANTLR 4.7.1

package com.expr.brule.core;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BusinessRuleParser}.
 */
public interface BusinessRuleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(BusinessRuleParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(BusinessRuleParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(BusinessRuleParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(BusinessRuleParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpression(BusinessRuleParser.NumberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpression(BusinessRuleParser.NumberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanTrue}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanTrue(BusinessRuleParser.BooleanTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanTrue}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanTrue(BusinessRuleParser.BooleanTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enclosedExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEnclosedExpression(BusinessRuleParser.EnclosedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enclosedExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEnclosedExpression(BusinessRuleParser.EnclosedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanFalse}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanFalse(BusinessRuleParser.BooleanFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanFalse}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanFalse(BusinessRuleParser.BooleanFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanVariable}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanVariable(BusinessRuleParser.BooleanVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanVariable}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanVariable(BusinessRuleParser.BooleanVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(BusinessRuleParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(BusinessRuleParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpression(BusinessRuleParser.VariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpression(BusinessRuleParser.VariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(BusinessRuleParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(BusinessRuleParser.BinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link BusinessRuleParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(BusinessRuleParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BusinessRuleParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(BusinessRuleParser.CompopContext ctx);
}