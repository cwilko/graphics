/*
 * (c) Copyright 2001 MyCorporation.
 * All Rights Reserved.
 */
package Bezier;

/**
 * @version 	1.0
 * @author
 */
public class Vector3D {
	
	public double x,y,z;
	
	public Vector3D() {
		x = y = z = 0.0;
	}
	
	public Vector3D(int x, int y, int z) {

		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3D( Vector3D vec ) {
		
		x = vec.x;
		y = vec.y;
		z = vec.y;
		
	}
	
	public Vector3D add( Vector3D vec) {
		
		Vector3D ret = new Vector3D();
		
		ret.x = x + vec.x;
		ret.y = y + vec.y;
		ret.z = z + vec.z;
		
		return ret;
	}		
	
	public Vector3D sub( Vector3D vec) {
		
		Vector3D ret = new Vector3D();
		
		ret.x = x - vec.x;
		ret.y = y - vec.y;
		ret.z = z - vec.z;
		
		return ret;
	}	
	
	public Vector3D scale( double factor) {
		
		Vector3D ret = new Vector3D();
			
		ret.x = x * factor;
		ret.y = y * factor;
		ret.z = z * factor;
		
		return ret;
	}
	
	public Vector3D midPoint ( Vector3D pt2 ) {
		
		Vector3D ret = new Vector3D();
		
		ret.x = x + ((pt2.x - x) / 2.0);
		ret.y = y + ((pt2.y - y) / 2.0);
		ret.z = z + ((pt2.z - z) / 2.0);
		
		return ret;
	}
	
	public double magnitude () {
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	public Vector3D getNormal () {
		
		Vector3D ret = new Vector3D();
		double magnitude = this.magnitude();
		
	//	ret.x = x / magnitude;
	//	ret.y = y / magnitude;
		ret.z = z / magnitude;
		
		ret.x = 0.0 - y / magnitude;
		ret.y = x / magnitude;
		ret.z = 0.0;
		
		return ret;
	}

}
