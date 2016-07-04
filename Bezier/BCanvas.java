/*
 * (c) Copyright 2001 MyCorporation.
 * All Rights Reserved.
 */
package Bezier;

/**
 * @version 	1.0
 * @author
 */

import Fractal.*;
import java.awt.*;

public class BCanvas extends DoubleBufferedCanvas {
	
	BCurve bc = new BCurve();
	BCurve bc2 = new BCurve();
	Fractal frac = new Fractal();
	
	static Vector3D p[] = new Vector3D [5];
	
	static Vector3D a = new Vector3D(0,400,0);
	static Vector3D b = new Vector3D(600,400,0);
		
	static Vector3D c = new Vector3D(300,100,0);
	static Vector3D d = new Vector3D(300,600,0);
	
	static {
		
		p[0] = new Vector3D(100,100,0);
		p[1] = new Vector3D(150,400,0);
		p[2] = new Vector3D(400,50,0);
		p[3] = new Vector3D(500,200,0);
		p[4] = new Vector3D(600,50,0);

	}
	
	int depth = 5;
	int activePoint = 0;
	
	public void redraw() {
		
		bc.setPoints(p[0],p[1],p[2],p[3]);
        bc2.setPoints(p[1],p[2],p[3],p[4]);
                       
		bc.drawCurve(buffer);
		bc2.drawCurve(buffer);
		bc.drawPoints(buffer);
		bc2.drawPoints(buffer);
		buffer.drawString("Active Point : " + activePoint,10,12);		
		buffer.drawString("x : " + (int)(p[activePoint].x) + " y : " + (int) (p[activePoint].y),10,25);
		
		frac.setPoints(a,b);
		frac.setDepth(depth);
		//frac.drawFractal(buffer);
    }
    
    public boolean keyDown (Event e, int key) {
		
	
		if(key == Event.UP) {
			depth += 1;
			activePoint +=1;
			if (activePoint > 4) activePoint = 4;
			repaint();
		}
		
		if(key == Event.DOWN) {
			depth -= 1;
			activePoint -=1;
			if (depth < 0) depth = 0;
			if (activePoint < 0) activePoint = 0;
			repaint();
		}

		return true;	
	}
	
	public boolean mouseDrag (Event e, int x, int y) {
		
		p[activePoint].x = x;
		p[activePoint].y = y;
		repaint();
		
		return true;
		
	}

}
