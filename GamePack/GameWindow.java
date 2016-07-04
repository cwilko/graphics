/*
 * (c) Copyright 2001 MyCorporation.
 * All Rights Reserved.
 */
package GamePack;

/**
 * @version 	1.0
 * @author
 */

import java.awt.*;

public class GameWindow extends Frame {
	
	static final int H_SIZE = 640;
	static final int V_SIZE = 480;
	
	GameScreen canvas;
	
	GameWindow() { 
		
		super("Bandits at 3'o'clock");

    	setSize(H_SIZE, V_SIZE);
    	
    	canvas = new GameScreen();    	   	
    	
    	add(canvas);    	
    	
		setVisible(true);
		
		ActionThread at = new ActionThread(canvas);
		at.start();
			
		    	
	}
	
	public boolean handleEvent(Event evt)
	{
	
		// Return false if we want the system to also process
		// the message, otherwise return true to say we're done
		// with the message
		switch(evt.id)
		{
			// Event.WINDOW_DESTROY documentation
			// can be found in the Event classes
			case Event.WINDOW_DESTROY:
			{
				System.exit(0);
				return true;
			}
			default:

		}			
		return super.handleEvent(evt);
	}
	
}
