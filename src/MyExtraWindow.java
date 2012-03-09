import processing.core.PApplet;

import com.hookedup.processing.ExtraWindow;


public class MyExtraWindow extends ExtraWindow {
	
	public MyExtraWindow(PApplet theApplet, String theName, int theWidth, int theHeight) {
		super( theApplet,  theName,  theWidth,  theHeight); 
		// TODO Auto-generated constructor stub
	}
	float counter = 0f;
	int randomCol = 0;

	@Override
	public void draw() {
		
	//	fill(random(255, 255, 0);
		background(randomCol);
		fill(counter);
		noStroke();
		int size = (int) map(counter, 0.0f, 255.0f, 0.0f, 21.0f);
		rect(0, 0, size, size);
		
		super.draw();
		counter++;
		if (counter==255){
			counter = 0;
			randomCol = color(random(255), random(255), random(255));
		}
	}
	
	public void logIt(String s){
		println(s);
	}

}
