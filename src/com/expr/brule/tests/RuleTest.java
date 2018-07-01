package com.expr.brule.tests;

import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.RuleExpCounter;
import com.expr.brule.core.BusinessRuleParser.ParseContext;

public class RuleTest {

	public static void main(String[] args) throws Exception {

		String rule = "( ( ( AMOUNT > 200000.00) AND ( IND1 = Y) ) or ( ind1 = Y ) )";
		CharStream stream = new ANTLRInputStream(new StringReader(rule));
		BusinessRuleLexer lexer = new BusinessRuleLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		BusinessRuleParser parser = new BusinessRuleParser(tokens);
		
		ParseContext ctx = parser.parse();
		
		System.out.println("Input rule: "+ctx.getText());

		RuleExpCounter cnt = new RuleExpCounter();
		ParseTreeWalker.DEFAULT.walk(cnt, ctx);
		System.out.println("**** Expression Count : "+cnt.getExpressionCounter());
		int ecnt = cnt.getExpressionCounter();
		double pow2 = Math.pow(2, ecnt);
		
		System.out.println("Truth table has "+pow2+" entries" );
		
	}

}
