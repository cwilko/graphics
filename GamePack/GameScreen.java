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
import java.awt.geom.*;

public class GameScreen extends DoubleBufferedCanvas {
	
	double rotVal = 0;
	
	static float shipPts[] = {-50,-25,50,0,-50,25,-25,0};
	
	private static final int MAX_PTS = 4;
	

	
	
	float newShipPts[] = new float[MAX_PTS*2];
	
	int shipXPts[] = new int[MAX_PTS];
	int shipYPts[] = new int[MAX_PTS];
	
	int xPos = 100;
	int yPos = 100;
	
	AffineTransform at = new AffineTransform();
	

	public void redraw() {
        xPos++;
        buffer.setColor(Color.blue);
        buffer.fillRect(0,0,size().width,size().height);
        
        buffer.setColor(Color.red);	
	
		at.setToTranslation(xPos, yPos);
		at.rotate(rotVal);
	
		
		at.transform(shipPts,0,newShipPts,0,MAX_PTS);

		int index = 0;
		
		for (int x = 0; x < MAX_PTS; x++) {
			shipXPts[x] = (int) newShipPts[index++];
			shipYPts[x] = (int) newShipPts[index++];			
		}

		buffer.fillPolygon(shipXPts, shipYPts, MAX_PTS);
				
		if (xPos <= -50) xPos = size().width + 50;
		if (xPos >= size().width + 50) xPos = -50;
		
    }
    
    public boolean keyDown (Event e, int key) {
		
		if(key == Event.RIGHT) {
			xPos += 2;	
		}
		
		if(key == Event.LEFT) {			
			xPos -= 2;
		}
		
		if(key == Event.UP) {
			rotVal += 0.1;
		}
		
		if(key == Event.DOWN) {
			rotVal -= 0.1;
		}
		return true;
			
	}
	
}
