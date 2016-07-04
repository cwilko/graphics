/*
 * (c) Copyright 2001 MyCorporation.
 * All Rights Reserved.
 */
package Bezier;

/**
 * @version 	1.0
 * @author
 */

import java.awt.*;

public class Bezier extends Frame {
	
	static final int H_SIZE = 640;
	static final int V_SIZE = 800;

	public static void main(String[] args) {

		new Bezier();
	}
	
	public Bezier() {

		super("Bezier Curve Test");
    	setSize(H_SIZE, V_SIZE);
		add( new BCanvas());
		setVisible(true);
		
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
