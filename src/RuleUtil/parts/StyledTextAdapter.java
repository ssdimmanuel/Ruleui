package RuleUtil.parts;

import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.IControlContentAdapter2;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * An {@link IControlContentAdapter} for SWT Text controls. This is a
 * convenience class for easily creating a {@link ContentProposalAdapter} for
 * text fields.
 *
 * @since 3.2
 */
public class StyledTextAdapter implements IControlContentAdapter,
		IControlContentAdapter2 {

	StyledText txt;
	@Override
	public String getControlContents(Control control) {
		return ((StyledText) control).getText();
	}

	@Override
	public void setControlContents(Control control, String text,
			int cursorPosition) {
		((StyledText) control).setText(text);
		((StyledText) control).setSelection(cursorPosition, cursorPosition);
	}

	@Override
	public void insertControlContents(Control control, String text,
			int cursorPosition) {
		Point selection = ((StyledText) control).getSelection();
		((StyledText) control).insert(text);
		// Insert will leave the cursor at the end of the inserted text. If this
		// is not what we wanted, reset the selection.
		if (cursorPosition < text.length()) {
			((StyledText) control).setSelection(selection.x + cursorPosition,
					selection.x + cursorPosition);
		}
	}

	@Override
	public int getCursorPosition(Control control) {
		return ((StyledText) control).getCaretOffset();
	}

	@Override
	public Rectangle getInsertionBounds(Control control) {
		StyledText text = (StyledText) control;
		Point caretOrigin = text.getLocation();
		// We fudge the y pixels due to problems with getCaretLocation
		// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=52520
		return new Rectangle(caretOrigin.x + text.getClientArea().x,
				caretOrigin.y + text.getClientArea().y + 3, 1, text.getLineHeight());
	}

	@Override
	public void setCursorPosition(Control control, int position) {
		((StyledText) control).setSelection(new Point(position, position));
	}

	/**
	 * @see org.eclipse.jface.fieldassist.IControlContentAdapter2#getSelection(org.eclipse.swt.widgets.Control)
	 *
	 * @since 3.4
	 */
	@Override
	public Point getSelection(Control control) {
		return ((StyledText) control).getSelection();
	}

	/**
	 * @see org.eclipse.jface.fieldassist.IControlContentAdapter2#setSelection(org.eclipse.swt.widgets.Control,
	 *      org.eclipse.swt.graphics.Point)
	 *
	 * @since 3.4
	 */
	@Override
	public void setSelection(Control control, Point range) {
		((StyledText) control).setSelection(range);
	}
}
