import processing.core.PApplet;

import com.hookedup.processing.ExtraWindow;


public class MyExtraWindow extends ExtraWindow {
	
	float counter = 0f;
	int randomCol = 0;
	int rectPos = 0;
	int slowAmt = 5;
	
	public MyExtraWindow(PApplet theApplet, String theName, int theWidth, int theHeight) {
		super( theApplet,  theName,  theWidth,  theHeight); 
		initWin();
	}
	

	private void initWin() {
		colorMode(HSB, 40, 1,1);
		fill(255,0,0);
		noStroke();
		rect(0, 0, 40, 25);
		
	}


	@Override
	public void draw() {
		
		moveRect();
	
	}
	
	private void moveRect() {
		
		//if (rectPos%slowAmt==0){
		stroke(rectPos/slowAmt, 1, 1);
		line(rectPos/slowAmt,0,rectPos/slowAmt,25);
	//	}
		rectPos ++;
		if (rectPos>40*slowAmt){
			rectPos = 0;
		}
		
		
	}


	public void logIt(String s){
		println(s);
	}

}
