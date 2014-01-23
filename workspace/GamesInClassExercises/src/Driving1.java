import java.applet.*;
import java.awt.*;

/**
 * Simple animation example. Add double buffering for smooth transitions
 * 
 * @author mike slattery
 * @version Jan 2014
 */

public class Driving1 extends Applet implements Runnable {

	// Needed for code revision tracking
	private static final long serialVersionUID = 1L;

	//Creates a new empty thread?
	Thread anim = null; // animation thread

	Building[] bldgs = new Building[4];
	//Two new car instances to drive around
	Car c = new Car(210, 210, 30);
	Car c2 = new Car(10, 410, 30);

	//Offscreen buffer for bitwise copy, but what's it mean?
	Image offscreen = null;
	Graphics offgr;

	public void init() {
		System.out.println("init() called");
		//Populate the array of buildings & their size info
		bldgs[0] = new Building(50, 50, 150);
		bldgs[1] = new Building(250, 50, 150);
		bldgs[2] = new Building(50, 250, 150);
		bldgs[3] = new Building(250, 250, 150);

	}

	public void start() {
		System.out.println("start() called");
		//Thread asdf = new Thread();
		anim = new Thread(this);
		anim.start();
	}

	public void update(Graphics g) {
		// If the buffer doesn't exist, set it up
		if (offscreen == null) {
			offscreen = createImage(450, 450);
			offgr = offscreen.getGraphics();
		}
		// Call paint() to draw on the offscreen buffer
		paint(offgr);
		// And then copy that image to the screen
		g.drawImage(offscreen, 0, 0, null);
	}

	public void paint(Graphics g) {
		System.out.println("paint() called");

		// Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 450, 450);
		// Buildings paint themselves
		for (Building b : bldgs)
			b.paint(g);
		// car paints itself
		c.paint(g);
		c2.paint(g);

	}

	public void run() {

		System.out.println("run() called");

		while (anim != null) {
			c.update();
			c2.update();
		
		repaint();
		//Thread.yield();
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			}
		}//end while
	}

	public void stop() {

		System.out.println("stop() called");

		anim = null; // stop animation thread
	}
}