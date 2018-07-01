/*******************************************************************************
 * Copyright (c) 2010 - 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package RuleUtil.parts;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.expr.brule.core.BusinessRuleLexer;
import com.expr.brule.editing.RangeData;
import com.expr.brule.editing.RuleColoringData;
import com.expr.brule.edits.RuleBalancer;

public class RuleSyntaxView {

	private StyledText txt;
	private TableViewer viewer;

	private Color red = Display.getDefault().getSystemColor(SWT.COLOR_RED);
	private Color green = Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
	private Color black = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
	private Color yellow = Display.getDefault().getSystemColor(SWT.COLOR_YELLOW);
	private Color blue = Display.getDefault().getSystemColor(SWT.COLOR_CYAN);
	private ContentProposalAdapter assist;

	@Inject
	private MDirtyable dirty;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		txt = new StyledText(parent, SWT.BORDER);
		txt.setBackground(black);
		txt.setForeground(green);
		Font boldFont = new Font(txt.getDisplay(), new FontData("Arial", 12, SWT.BOLD));
		txt.setFont(boldFont);
		txt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {

				String rule = txt.getText();

				System.out.println("Input rule: " + rule);
				System.out.println("rule length: " + rule.length());

				RuleColoringData edit = new RuleColoringData(rule);
				
				try {
					edit.parseRule();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//ParseTreeWalker.DEFAULT.walk(edit, ctx);
				ArrayList<RangeData> cd = edit.getTokenranges();
				// StyleRange[] ranges = new StyleRange[cd.size()];
				ArrayList<StyleRange> srange = new ArrayList<StyleRange>();
				System.out.println(cd);
				int i = 0;
				for (RangeData rd : cd) {
					/*if (rd.tokenStart <= 0) {
						continue;
					}*/
					if (rd.tokenStart + rd.tokenLength > rule.length()) {
						continue;
					}
					System.out.println("rdata: " + rd.tokenStart + " : " + rd.tokenLength);
					StyleRange sr = new StyleRange();
					sr.start = rd.tokenStart;
					sr.length = rd.tokenLength;
					if (rd.tokenType == BusinessRuleLexer.AND || rd.tokenType == BusinessRuleLexer.OR) {
						sr.foreground = red;
					} else if (rd.tokenType == BusinessRuleLexer.LEFTPAREN
							|| rd.tokenType == BusinessRuleLexer.RIGHTPAREN) {
						sr.foreground = red;
					} else if (rd.tokenType == BusinessRuleLexer.STRING) {
						sr.foreground = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
					}else if(rd.tokenType == BusinessRuleLexer.EQUAL || rd.tokenType==BusinessRuleLexer.GT
							|| rd.tokenType==BusinessRuleLexer.LT) {
						sr.foreground = red;
					}else if(rd.tokenType==BusinessRuleLexer.NUMBER) {
						sr.foreground=blue;
					}else if(rd.tokenType==BusinessRuleLexer.TRUE || rd.tokenType==BusinessRuleLexer.FALSE) {
						System.out.println("attempting to color true");
						sr.foreground = blue;
					}

					srange.add(sr);
					i++;
				}
				txt.setStyleRanges(srange.toArray(new StyleRange[srange.size()]));
			}
		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL|GridData.FILL_VERTICAL);
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessHorizontalSpace = true;
		txt.setLayoutData(gd);
		
		assist = new ContentProposalAdapter(txt, new StyledTextAdapter(), new RuleProposalProvider(), null, null);
		assist.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		assist.addContentProposalListener(new IContentProposalListener() {

			@Override
			public void proposalAccepted(IContentProposal proposal) {
				System.out.println("Accepted proposal: "+proposal.getContent());
				//int len = txt.getText().length();
				//txt.setCaretOffset(len-1);
			}
			
		});
		createButtonBar(parent);
		this.createViewer(parent);
	}

	private void createButtonBar(Composite parent) {
		Composite bcomp = new Composite(parent, SWT.NONE);
		bcomp.setLayout(new GridLayout(6, false));
		
		Button balance = new Button(bcomp, SWT.PUSH);
		balance.setText("Balance");
		balance.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txt.getText().trim().equals("")) {
					return;
				}
				
				RuleBalancer bal = new RuleBalancer(txt.getText());
				try {
					bal.parseRule();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(bal.getOpenInsertCount()==0 && bal.getCloseInsertCount()==0) {
					MessageDialog.openInformation(parent.getShell(), "Warning", "Rule is already balanced !!");
				}else {
					txt.setText(bal.getLatestRule());
				}
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void createViewer(Composite parent) {
        viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        createColumns(parent, viewer);
        final Table table = viewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        System.out.println("Table viewer created");

        viewer.setContentProvider(new ArrayContentProvider());
        // get the content for the viewer, setInput will call getElements in the
        // contentProvider
        viewer.setInput(new ArrayList());
        // make the selection available to other views
        //getSite().setSelectionProvider(viewer);
        // set the sorter for the table

        // define layout for the viewer
        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 1;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        viewer.getControl().setLayoutData(gridData);
    }

    public TableViewer getViewer() {
        return viewer;
    }
	
	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "LHS", "OP", "RHS", "Married" };
		int[] bounds = { 100, 100, 100, 100 };

		// first column is for the LHS Variable	
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0]);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return "";
			}
		});

		// second column is for the last name
		col = createTableViewerColumn(titles[1], bounds[1]);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return "";
			}
		});

	}

	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	@Focus
	public void setFocus() {
		this.txt.setFocus();
	}

	@Persist
	public void save() {
		dirty.setDirty(false);
	}
}