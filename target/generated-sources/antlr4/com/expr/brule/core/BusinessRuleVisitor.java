// Generated from BusinessRule.g4 by ANTLR 4.7.1

package com.expr.brule.core;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BusinessRuleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BusinessRuleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(BusinessRuleParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(BusinessRuleParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpression(BusinessRuleParser.NumberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanTrue}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTrue(BusinessRuleParser.BooleanTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enclosedExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedExpression(BusinessRuleParser.EnclosedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanFalse}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanFalse(BusinessRuleParser.BooleanFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanVariable}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanVariable(BusinessRuleParser.BooleanVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(BusinessRuleParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpression}
	 * labeled alternative in {@link BusinessRuleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpression(BusinessRuleParser.VariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#binop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop(BusinessRuleParser.BinopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BusinessRuleParser#compop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompop(BusinessRuleParser.CompopContext ctx);
}