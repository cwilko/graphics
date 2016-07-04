/*
 * (c) Copyright 2001 MyCorporation.
 * All Rights Reserved.
 */
package Fractal;

/**
 * @version 	1.0
 * @author
 */

import Bezier.*;
import java.awt.*;

public class Fractal {
	
	Vector3D pt1, pt2;	
	Vector3D normal;

	int maxDepth = 0;
	
	Graphics buffer;
	
	public Fractal () {
		
		pt1 = pt2 = new Vector3D();
	}
	
	public Fractal (Vector3D pt1, Vector3D pt2) {
		
		this.pt1 = pt1;
		this.pt2 = pt2;
		setNormalVec();
	}
	
	public void setPoints (Vector3D pt1, Vector3D pt2 ) {
		
		this.pt1 = pt1;
		this.pt2 = pt2;
		setNormalVec();
	}
	
	public void setDepth (int depth) {
		maxDepth = depth;
	}
	
	public void setNormalVec() {
		
		// Obtain line vector between points
		Vector3D lineVec = pt2.sub(pt1);
		
		// Get normal vectore to the line vector
		normal = lineVec.getNormal();
	}
	
	public void drawFractal( Graphics buffer ) {
		
		this.buffer = buffer;
		
		drawFractal (pt1, pt2, 0);
		
		this.buffer = null;
		
	}
	
	private void drawFractal ( Vector3D pt1, Vector3D pt2, int depth) {
		
		if ( depth == maxDepth ) {
			buffer.drawLine((int) pt1.x, (int) pt1.y, (int) pt2.x, (int) pt2.y);
			return;
		}
		
		Vector3D mid = pt1.midPoint(pt2);
		
		// Adjust midpoint a random distance (max = horizontal diff)
		// Needs to be modified to allow none horizontal fractals
		
		double adjustment = Math.random() * pt2.sub(pt1).magnitude() - (pt2.sub(pt1).magnitude() / 2.0);
		
		mid = mid.add(normal.scale(adjustment));
		
		drawFractal (pt1, mid, depth + 1);
		drawFractal (mid, pt2, depth + 1);
			
	}
}
