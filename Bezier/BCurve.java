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

public class BCurve {
	
	private Vector3D p0, p1, p2, p3;
	
	public BCurve() {
		
		p0 = p1 = p2 = p3 = new Vector3D();
		
	}
	
	public BCurve(Vector3D p0, Vector3D p1, Vector3D p2, Vector3D p3) {
			
		this.p0 = p0; this.p1 = p1;
		this.p2 = p2; this.p3 = p3;
	}
	
	public void setPoints(Vector3D p0, Vector3D p1, Vector3D p2, Vector3D p3) {
			
		this.p0 = p0; this.p1 = p1;
		this.p2 = p2; this.p3 = p3;
	}
	
	private Vector3D Q(double u) {
		
		// Calculate point on the curve based on u	
		
		//if (u == 0) return p0;
		//if (u == 1) return p3;
		
		// Calculate blending functions based on u 
		// Based on Bernstein cubic polynomials
		
		double b0,b1,b2,b3;
		
		/*
		b0 = (1 - u) * (1 - u) * (1 - u);
		
		b1 = 3 * u * (1 - u) * (1 - u);
		
		b2 = 3 * u * u * (1 - u);
		
		b3 = u * u * u;
		*/
		
		b0 = B(0,3,u+3);
		b1 = B(1,3,u+3);
		b2 = B(2,3,u+3);
		b3 = B(3,3,u+3);
		
		return p0.scale(b0).add(p1.scale(b1).add(p2.scale(b2).add(p3.scale(b3))));		
		
	}
	
	private double B(int i, int order,double u) {
		
		if (order == 0) {
				if (i <= u && u < i+1) return 1;
				return 0;
		}
		
		double A = (u - i) / (i+order - i) * B(i,order-1,u);
		double B = (i+order+1 - u) / (i+order+1 - (i+1)) * B(i+1,order-1,u);
		
		return A+B;
		
	}
	
	public void drawCurve(Graphics buffer) {
		
		Vector3D firstXY,newXY;
		double x,y;
		x = p0.x; y = p0.y;
		firstXY = Q(0);
		x = firstXY.x; y = firstXY.y;
		for (double u = 0.01; u < 1; u += 0.01) {
			
			newXY = Q(u);
			buffer.drawLine((int) x,(int) y,(int) newXY.x,(int) newXY.y);
			x = newXY.x;
			y = newXY.y;
				
		}
		
	}
	
	public void drawPoints(Graphics buffer) {
		
		buffer.drawRect((int) p0.x - 1, (int) p0.y - 1, 3, 3);
		//buffer.drawString("p0", (int) p0.x, (int) p0.y - 3);
		
		buffer.drawRect((int) p1.x - 1, (int) p1.y - 1, 3, 3);
	//	buffer.drawString("p1", (int) p1.x, (int) p1.y - 3);
		
		buffer.drawRect((int) p2.x - 1, (int) p2.y - 1, 3, 3);
	//	buffer.drawString("p2", (int) p2.x, (int) p2.y - 3);
		
		buffer.drawRect((int) p3.x - 1, (int) p3.y - 1, 3, 3);
	//	buffer.drawString("p3", (int) p3.x, (int) p3.y - 3);
		
	}

	
}
