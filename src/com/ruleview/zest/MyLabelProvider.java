package com.ruleview.zest;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class MyLabelProvider extends LabelProvider {
	public Image getImage(Object element) {
		return Display.getCurrent().getSystemImage(SWT.ICON_WARNING);
	}

	public String getText(Object element) {
		if (element instanceof String) {
			return element.toString();
		}
		return null;
	}
}