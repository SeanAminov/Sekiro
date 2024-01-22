import java.awt.Color;

import java.awt.event.*;

public class Listener {
	// have reference to Panel so you can interact with it
	private Panel contentPanel;

	// constructor for Listener
	public Listener(Panel panel) {
		// save reference to Panel object when you create Listener
		this.contentPanel = panel;

		// register Listener object; syntax:
		// objectGeneratingEvents.addMouseListener(objectListening)

	}

	@Override
	public void mouseClicked(MouseEvent ev) {

		contentPanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
	}

	@Override
	public void mouseExited(MouseEvent ev) {
	}

	@Override
	public void mousePressed(MouseEvent ev) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
