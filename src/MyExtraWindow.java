import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;
import toxi.color.ColorGradient;
import toxi.color.ColorList;
import toxi.color.TColor;
import toxi.geom.Vec2D;

import com.hookedup.processing.ExtraWindow;

public class MyExtraWindow extends ExtraWindow {

	float counter = 0f;
	int randomCol = 0;
	int rectPos = 0;
	int slowAmt = 5;

	int displayWidth = 50;
	int currPos = 0;
	float speed = 1;
	TColor[] cols;
	ColorGradient grad;
	int trailLength = 20;
	ArrayList<Vec2D> trail;

	public MyExtraWindow(PApplet theApplet, String theName, int theWidth,
			int theHeight) {
		super(theApplet, theName, theWidth, theHeight);
		// initWin();
	}

	public void setup() {
		size(350, 300);
		trail = new ArrayList<Vec2D>();
		noStroke();
		initCols();
	}

	public void draw() {
		if (cols.length>0) {
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
			Vec2D mouseVec = new Vec2D(mouseX, mouseY);
			if (trail.size() < trailLength) {
				trail.add(0, mouseVec);
			} else {
				// remove last element
				trail.remove(trailLength - 1);
				trail.add(0, mouseVec);
			}
			drawTrail();
		}

	}

	private void drawTrail() {
		Vec2D mouse0 = trail.get(0);
		int oppCol = getOppCol(mouse0);		
		stroke(oppCol);
		ellipse(trail.get(0).x, trail.get(0).y, 3, 3);
		for (int i = 1; i < trail.size(); i++) {
			Vec2D vec = trail.get(i);
			oppCol = getOppCol(vec);
			stroke(oppCol);
			point(vec.x, vec.y);
		}

	}

	//returns opposite color for a given pixel pos
	private int getOppCol(Vec2D mouse0) {
		int currCol = get((int)mouse0.x,(int) mouse0.y);
		TColor oppCol = TColor.newARGB(currCol);
		oppCol = oppCol.getInverted();
		int retCol = oppCol.toARGB();
		return retCol;
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
		cols = new TColor[3];

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
