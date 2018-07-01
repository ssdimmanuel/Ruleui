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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import com.ruleview.zest.MyContentProvider;
import com.ruleview.zest.MyLabelProvider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


public class RuleView {

	private Text txt;
	private TableViewer tv;
	//private GraphViewer viewer1;

	//ZestContentViewer viewer = null;

	@Inject
	private MDirtyable dirty;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		txt = new Text(parent, SWT.BORDER);
		txt.setMessage("Enter a rule");
		txt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				//dirty.setDirty(true);
			}
		});
		txt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txt.setSize(txt.getSize().x, 100);
		
		/*viewer = new ZestContentViewer(new ZestFxJFaceModule());
		viewer.createControl(parent, SWT.NONE);
		viewer.setContentProvider(new MyContentProvider());
		viewer.setLabelProvider(new MyLabelProvider());
		viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				System.out.println(
						"Selection changed: " + (event.getSelection()));
			}
		});
		viewer.setInput(new Object());*/
		
	}

	@Focus
	public void setFocus() {
		//tv.getTable().setFocus();
	}

	@Persist
	public void save() {
		dirty.setDirty(false);
	}
}