package pongproject;

import java.awt.*;

/**
 * The class that contains the graphical information for the ball
 * @author Mark & Dan
 */
public class Ball
{

    /** The width of the ball*/
    private int BWIDTH;
    /** The height of the ball*/
    private int BHEIGHT;
    /** The X origin of the ball*/
    private int Xo;
    /** The Y origin of the ball*/
    private int Yo;

    /**
     * Constructor
     * @param diameter - the diameter of the ball
     */
    public Ball( int diameter )
    {
        BWIDTH = diameter;
        BHEIGHT = diameter;
    }

    /**
     * Sets the origin of the ball
     * @param xOrigin - the X coordinate
     * @param yOrigin - the Y coordinate
     */
    public void setOrigin( int xOrigin, int yOrigin )
    {
        Xo = xOrigin;
        Yo = yOrigin;
    }

    /**
     * Draws the ball on the graphics
     * @param g - the graphics to be drawn on
     */
    public void DrawBall( Graphics g )
    {
        g.fillOval( Xo, Yo, BWIDTH, BHEIGHT );
    }

    /**
     * Draws the ball on the graphics
     * @param g - the graphics to be drawn on
     */
    public void DrawBall( Graphics g, Color background )
    {
        PongColor color = new PongColor();

        g.fillOval( Xo, Yo, BWIDTH, BHEIGHT );
        g.setColor( color.invertColor( background ) );
        g.drawOval( Xo, Yo, BWIDTH, BHEIGHT );
    }

    /**
     * Sends the X coordinate
     * @return - the X coordinate
     */
    public int getX()
    {
        return Xo;
    }

    /**
     * Sends the Y coordinate
     * @return - the Y coordinate
     */
    public int getY()
    {
        return Yo;
    }

    /**
     * Sends the diameter of the ball
     * @return - the diameter of the ball
     */
    public int getD()
    {
        return BWIDTH;
    }
}
