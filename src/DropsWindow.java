import java.util.ArrayList;

import processing.core.PApplet;
import toxi.geom.Vec2D;

import com.hookedup.processing.ExtraWindow;

public class DropsWindow extends ExtraWindow {

	public float yCount;
	public float totWidth = 25;
	public float speed = 10;
	public float totHeight = 8;
	public float inc;
	public float[] positions;
	public float[] directions;
	private boolean generated = false;
	private float modifier = 1;
	
	

	public DropsWindow(PApplet theApplet, String theName, int theWidth,
			int theHeight) {
		super(theApplet, theName, theWidth, theHeight);
		// initWin();
	}

	public void setup() {
		size(350, 300);
		stroke(255);
		generateDots();
		//colorMode(HSB, 25, 100, 100);
		background(0);
		inc = 1/speed;
		yCount = 0;
	}

	//set random positions and directions before starting
	private void generateDots() {
		directions = new float[8];
		positions = new float[8];
		int newRan;
		float dirRan;
		for (int i = 0; i < 8; i++) {
			newRan = (int) random(25);
			dirRan = random(1,5);
			dirRan /= 20;
			
			
			if (dirRan ==0) dirRan = .5f;
			
			positions[i] = 	newRan;
			directions[i] = dirRan;
						
		}
		generated = true;
		println(positions);
	}

	public void draw() {
	//	println("i");
	
		
		if (yCount%speed == 0){
			
			background(0);
			stroke(255);
			line(yCount/speed, 0, yCount/speed, 8);	
		}
		
		yCount+= modifier;
		
		if (yCount>=24*speed){
			modifier *= -1;
		}
		
		if (yCount<=0){
			modifier *= -1;
		}
		
		/*
		try {
			
			background(0);//,0,255);
			//fill(0, 255, 0);
		//	rect(0,0,10,10);
			stroke(255);
			
			//rect(0,0,5,5);
		//	point(0,0);
			float pos ;
			for (int i = 0; i < 8; i++) {
				pos = positions[i];
			//	rect(i, 1, 2, 2);
				
				point(pos, i);
			    println("pos:"+pos);
				//point(0, i);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		updateFirst();
		
//	
		*/
	}

	private void updateFirst() {
		float pos;
		float direction;
		for (int i = 0; i < totHeight; i++) {
			pos = positions[i];
			direction = directions[i];
			//going up 
			if (direction>0){
				//check if it is at the end
				if (pos >= totWidth){
					direction = direction*-1;
					directions[i] = direction;
				}
			}else{
				//going down
				if (pos<=0){
					//check if it is at the begining
					direction = direction*-1;
					directions[i] = direction;
				}
			}
			pos += directions[i];
			positions[i] = pos;
			
		}
		println(positions);
		
	}
}











