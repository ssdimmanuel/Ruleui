package com.ruleview.zest;

import org.eclipse.gef.zest.fx.jface.IGraphContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MyContentProvider implements IGraphContentProvider {
	private Object input;
	
	private static String first() {
		return "First";
	}

	private static String second() {
		return "Second";
	}

	private static String third() {
		return "Third";
	}
	
	private static String fourth() {
		return "Fourth";
	}

	@Override
	public Object[] getNodes() {
		if (input == null) {
			return new Object[] {};
		}
		return new Object[] { first(), second(), third(), fourth()};
	}

	public Object[] getAdjacentNodes(Object entity) {
		if (entity.equals(first())) {
			return new Object[] { second() };
		}
		if (entity.equals(second())) {
			return new Object[] { third() };
		}
		if (entity.equals(third())) {
			return new Object[] { first() };
		}
		return null;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput,
			Object newInput) {
		input = newInput;
	}

	@Override
	public Object[] getNestedGraphNodes(Object node) {
		return null;
	}

	@Override
	public boolean hasNestedGraph(Object node) {
		return false;
	}
}
