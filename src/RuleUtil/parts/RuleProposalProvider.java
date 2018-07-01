/**
 * 
 */
package RuleUtil.parts;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

import com.expr.autocomp.ProposalFinder;

/**
 * @author ssdImmanuel
 *
 */
public class RuleProposalProvider implements IContentProposalProvider {

	/**
	 * 
	 */
	public RuleProposalProvider() {
	}

	@Override
	public IContentProposal[] getProposals(String contents, int position) {
		
		ProposalFinder pf = new ProposalFinder(contents);
		try {
			pf.parseRule();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> next = pf.find();
		if(next.size()==0) {
			
		}
		
		ContentProposal []all = new ContentProposal[next.size()];
		int i=0;
		for(String s : next) {
			ContentProposal cp = new ContentProposal(contents+" "+s, null);
			
			all[i] = cp;
			i++;
		}
		
		return all;
	}

}
