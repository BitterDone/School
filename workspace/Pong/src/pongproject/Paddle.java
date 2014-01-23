package pongproject;

import java.awt.*;

/**
 * Contains the information to draw the graphical representation of the paddles
 * @author Mark & Dan
 */
public class Paddle
{

    /** The X origin of the Paddle*/
    private int Xo;
    /** The Y origin of the Paddle*/
    private int Yo;
    /** The width of the Paddle*/
    private int PWIDTH;
    /** The height of the Paddle*/
    private int PHEIGHT;

    /**
     * The Constructor
     * @param size - the size of the paddle
     */
    public Paddle( int size )
    {
        PHEIGHT = size;
    }

    /**
     * Sets the origin of the paddle
     * @param xOrigin - the X coordinate
     * @param yOrigin - the Y coordinate
     */
    public void setOrigin( int xOrigin, int yOrigin )
    {
        Xo = xOrigin;
        Yo = yOrigin;
    }

    /**
     * Draws the paddle on the graphics
     * @param g - the graphics
     */
    public void DrawPaddle( Graphics g )
    {
        PWIDTH = 7;

        g.fillRect( Xo, Yo, PWIDTH, PHEIGHT );
    }

    /**
     * Draws the paddle on the graphics
     * @param g - the graphics
     */
    public void DrawPaddle( Graphics g, Color background )
    {
        PWIDTH = 7;

        PongColor color = new PongColor();

        g.fillRect( Xo, Yo, PWIDTH, PHEIGHT );
        g.setColor( color.invertColor( background ) );
        g.drawRect( Xo, Yo, PWIDTH, PHEIGHT );
    }

    /**
     * Sends the X coordinate
     * @return - the X origin
     */
    public int getX()
    {
        int x = Xo;

        return x;
    }

    /**
     * Sends the Y coordinate
     * @return - the Y origin
     */
    public int getY()
    {
        int y = Yo;

        return y;
    }

    /**
     * Sends the Height
     * @return - the height
     */
    public int getH()
    {
        int h = PHEIGHT;

        return h;
    }

    /**
     * Sends the width
     * @return - the width
     */
    public int getW()
    {
        int w = PWIDTH;

        return w;
    }
}
