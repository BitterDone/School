import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**	Github test
 * COSC 3550 Homework 1
 * @author Dan Bitter
 * Used code from Dr. Slattery's Driving1.java file
 * @version Jan 2014
 */

public class City extends Applet implements Runnable {
	// left
	int[] triX0 = { 25, 125, 75 };
	int[] triY0 = { 375, 375, 125 };
	// top
	int[] triX1 = { 175, 175, 425 };
	int[] triY1 = { 15, 115, 65 };
	// right
	int[] triX2 = { 475, 575, 525 };
	int[] triY2 = { 125, 125, 375 };
	// bottom
	int[] triX3 = { 175, 425, 425 };
	int[] triY3 = { 435, 485, 385 };
	// ----------------------------------------------------------
	//
	// Start seizure mode module
	//
	// ----------------------------------------------------------

	boolean seizure = true;
	// Offscreen buffer for bitwise copy, but what's it mean?
	Image offscreen = null;
	Graphics offgr;

	// Creates a new empty thread?
	Thread anim = null; // animation thread

	// Needed for code revision tracking
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------
	//
	// End seizure mode module
	//
	// ----------------------------------------------------------

	public void paint(Graphics g) {

		int x = 150;
		int y = 125;
		int spaceCir = 25;
		int spaceRect = 15;

		// Background
		g.setColor(randomColor());
		g.fillRect(0, 0, 600, 500);

		// Circles
		g.setColor(randomColor());
		for (int i = 0; i < 4; i++) {
			int tx = 0;
			int ty = 0;
			if (i == 0) {
				tx = x * i + spaceCir;
				ty = y * i + spaceCir;
			} else {
				tx = x * i + spaceCir / 2;
				ty = y * i + spaceCir / 2;
			}
			g.fillOval(tx, ty, 100, 100);
		}

		// Rectangles
		g.setColor(randomColor());
		for (int i = 0; i < 4; i++) {
			int tmpX = 0;
			int tmpY = 0;
			tmpX = 475 - (x * i);
			tmpY = y * i + spaceRect;

			g.fillRect(tmpX, tmpY, 100, 100);
		}

		g.setColor(randomColor());
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				g.fillPolygon(triX0, triY0, 3);
				break;
			case 1:
				g.fillPolygon(triX1, triY1, 3);
				break;
			case 2:
				g.fillPolygon(triX2, triY2, 3);
				break;
			case 3:
				g.fillPolygon(triX3, triY3, 3);
				break;
			}
		}

	}// end graphics

	public Color randomColor() {
		double x = Math.random();
		System.out.println("x: " + x);
		//Make it a number instead of a decimal
		x = x * 100000;
		//Double -> int
		int i = (int) x;
		System.out.println("i: " + i);
		//Initialize c
		Color c;
		if (i % 17 == 0) {
			c = Color.GRAY;
			System.out.println("GRAY");
		} else if (i % 23 == 0) {
			c = Color.BLUE;
			System.out.println("BLUE");
		} else if (i % 31 == 0) {
			c = Color.RED;
			System.out.println("RED");
		} else if (i % 11 == 0) {
			c = Color.YELLOW;
			System.out.println("YELLOW");
		} else if (i % 3 == 0) {
			c = Color.MAGENTA;
			System.out.println("MAGENTA");
		} else if (i % 2 == 0) {
			c = Color.GREEN;
			System.out.println("GREEN");
		} else {
			c = Color.BLACK;
			System.out.println("BLACK");
		}
		return c;
	}

	// }//end of class

	// ----------------------------------------------------------
	//
	// Start seizure mode module
	//
	// ----------------------------------------------------------
	public void start() {
		System.out.println("start() called");
		// Thread asdf = new Thread();
		anim = new Thread(this);
		anim.start();
	}

	public void update(Graphics g) {
		// If the buffer doesn't exist, set it up
		if (offscreen == null) {
			offscreen = createImage(600, 500);
			offgr = offscreen.getGraphics();
		}
		// Call paint() to draw on the offscreen buffer
		paint(offgr);
		// And then copy that image to the screen
		g.drawImage(offscreen, 0, 0, null);
	}

	@Override
	public void run() {
		System.out.println("run() called");
		while (anim != null) {
			if(seizure){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
				}
			}
		}// end while
	}
	// ----------------------------------------------------------
	//
	// End seizure mode module
	//
	// ----------------------------------------------------------
}