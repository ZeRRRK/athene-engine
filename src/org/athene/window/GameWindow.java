package org.athene.window;

import javax.swing.JFrame;

/**
 * A window in which game content may be rendered.
 * @author Matt Yackel
 *
 */
public class GameWindow extends JFrame {
	
	/**
	 * Creates a new game window.
	 * @param title The window title.
	 * @param width The window width.
	 * @param height The window height.
	 */
	public GameWindow(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		toFront();
	}

}
