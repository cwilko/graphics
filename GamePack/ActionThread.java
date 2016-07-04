/*
 * (c) Copyright 2001 MyCorporation.
 * All Rights Reserved.
 */
package GamePack;

/**
 * @version 	1.0
 * @author
 */
public class ActionThread extends Thread {
	
	private static int FPS = 25;
	private static int SLEEP_INTERVAL = 100 / FPS;
	
	DoubleBufferedCanvas screen;
	
	ActionThread( GameScreen gS ) {
		screen = gS;
	}
	
	public void run() {
		
		while(true) {
			screen.repaint();
			try {
				sleep(SLEEP_INTERVAL);
			} catch (Exception e) {}
		
		}
		
	}

}
