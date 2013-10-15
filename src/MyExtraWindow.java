import java.util.Iterator;

import processing.core.PApplet;
import toxi.color.ColorGradient;
import toxi.color.ColorList;
import toxi.color.TColor;

import com.hookedup.processing.ExtraWindow;

public class MyExtraWindow extends ExtraWindow {

	float counter = 0f;
	int randomCol = 0;
	int rectPos = 0;
	int slowAmt = 5;

	int displayWidth = 50;
	int currPos = 0;
	float speed = 1;
	TColor[] cols = new TColor[3];
	ColorGradient grad;

	public MyExtraWindow(PApplet theApplet, String theName, int theWidth,
			int theHeight) {
		super(theApplet, theName, theWidth, theHeight);
		// initWin();
	}

	public void setup() {
		size(350, 300);
		noStroke();
		initCols();
	}

	public void draw() {
		noStroke();
		fill(cols[0].toARGB());
		rect(200, 0, 50, 50);
		fill(cols[1].toARGB());
		rect(250, 0, 50, 50);
		fill(cols[2].toARGB());
		rect(300, 0, 50, 50);

		// ColorList l = grad.calcGradient(currPos, displayWidth+currPos);
		ColorList l = grad.calcGradient(0, displayWidth * 3);
		int x = 0;

		for (Iterator i = l.iterator(); i.hasNext();) {
			TColor c = (TColor) i.next();
			stroke(c.toARGB());
			line(x - (currPos), 0, x - currPos, height);
			x++;

		}
		if (currPos == displayWidth) {
			currPos = 0;
			addNewCol();
		} else {
			currPos++;
		}

	}

	public void addNewCol() {
		cols[0] = cols[1];
		cols[1] = cols[2];
		cols[2] = getRanCol();
		grad = new ColorGradient();
		grad.addColorAt(0, cols[0]);
		grad.addColorAt(displayWidth, cols[1]);
		grad.addColorAt(displayWidth * 2, cols[2]);
	}

	public void initCols() {

		cols[0] = getRanCol();
		cols[1] = getRanCol();
		cols[2] = getRanCol();

		grad = new ColorGradient();
		grad.addColorAt(0, cols[0]);
		grad.addColorAt(displayWidth, cols[1]);
		grad.addColorAt(displayWidth * 2, cols[2]);

	}

	TColor getRanCol() {
		TColor col = TColor.newRandom();
		
		return col;
	}
}
