import java.awt.Color;
import java.awt.Graphics;

public class Car {
	int cx, cy, size;
	Color color = Color.red;
	public static final int Right = 1;
	public static final int Up = 2;
	public static final int Left = 3;
	public static final int Down = 4;
	int state = Right;

	int xlo, xhi, ylo, yhi;

	public Car(int x1, int y1, int s1) {
		cx = x1;
		cy = y1;
		size = s1;

		xlo = cx;
		yhi = cy;
		xhi = cx + 200;
		ylo = cy - 200;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(cx, cy, size, size);
	}

	public void update(){
	switch(state){
    	case Right: 	cx += 2;
    			if(cx>=410)
    				state = Up;
    			break;
    	case Up:
    		cy -=2;
    		if(cy <=10)
    			state = Left;
   		    	break;
    	case Left:
    		cx -= 2;
    		if (cx <=210)
    		state = Down;
   	    	break;
    	case Down:
    		cy += 2;
    		if(cy>=210)
    			state = Right;
   			break;
    }//end switch
	}//end update()
	
}//end public class Car