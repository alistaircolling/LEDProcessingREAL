import processing.core.PApplet;

import com.hookedup.processing.ExtraWindow;


public class MyExtraWindow extends ExtraWindow {
	
	float counter = 0f;
	int randomCol = 0;
	
	public MyExtraWindow(PApplet theApplet, String theName, int theWidth, int theHeight) {
		super( theApplet,  theName,  theWidth,  theHeight); 
		initWin();
	}
	

	private void initWin() {
		fill(255,0,0);
		noStroke();
		rect(0, 0, 40, 25);
		
	}


	@Override
	public void draw() {
		
	
	}
	
	public void logIt(String s){
		println(s);
	}

}
