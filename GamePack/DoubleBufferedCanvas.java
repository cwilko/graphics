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


public class DoubleBufferedCanvas extends Canvas {
	
	
	Image im;
	Graphics buffer;

	
	public void InitCanvas() {
				
        Rectangle r = getBounds();
        
    	im = createImage(r.width,r.height);
    	
    	buffer = im.getGraphics();    	
   
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	


	public void paint(Graphics g) {
		
		if (im == null ) InitCanvas();
		redraw();
		g.drawImage(im, 0, 0, this);		
				
    }
    
    
	public void redraw() {
    
    }
    
}
