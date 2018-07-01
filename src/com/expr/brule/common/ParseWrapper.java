/**
 * 
 */
package com.expr.brule.common;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.expr.brule.core.BusinessRuleBaseListener;
import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.core.BusinessRuleParser;
import com.expr.brule.core.BusinessRuleParser.ParseContext;

/**
 * Base class which provides parse and AST Walk feature for a business rule
 * 
 * @author ssdImmanuel
 *
 */
public class ParseWrapper extends BusinessRuleBaseListener {

	/**
	 * 
	 */
	protected TokenStreamRewriter rw;
	protected CommonTokenStream tokens;
	protected BusinessRuleLexer lexer;
	protected BusinessRuleParser parser;

	private String rule;

	public ParseWrapper(String rule) {
		this.rule = rule;
	}

	public void parseRule() throws IOException {
		this.parseRule(true);
	}

	/**
	 * Parse the rule and walk the tree
	 * @param walktree
	 * @throws IOException
	 */
	public void parseRule(boolean walktree) throws IOException {
		CharStream stream = CharStreams.fromString(rule);
		lexer = new BusinessRuleLexer(stream);
		tokens = new CommonTokenStream(lexer);
		parser = new BusinessRuleParser(tokens);

		rw = new TokenStreamRewriter(tokens);
		ParseContext ctx = parser.parse();
		if (walktree) {
			ParseTreeWalker.DEFAULT.walk(this, ctx);
		}
		
	}

	public String getLatestRule() {
		return rw.getText();
	}

}
