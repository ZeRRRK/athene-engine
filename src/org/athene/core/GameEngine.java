package org.athene.core;

import org.athene.config.ConfigManager;
import org.athene.window.GameWindow;

/**
 * The game engine class.
 * @author Matt Yackel
 *
 */
public class GameEngine implements Runnable {
	
	/**
	 * JVM entry-point.
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		String title = (String) ConfigManager.getInstance().getValue("Engine.GameInfo", "GameName");
		int width = (Integer) ConfigManager.getInstance().getValue("Engine.Window", "GameWindow.Width");
		int height = (Integer) ConfigManager.getInstance().getValue("Engine.Window", "GameWindow.Height");
		GameWindow window = new GameWindow(title, width, height);
	}

	@Override
	public void run() {
		
	}

}
