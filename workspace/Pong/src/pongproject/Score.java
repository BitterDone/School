package pongproject;

import java.awt.*;

/**
 * The class that allows to draw the score upon the screen
 * @author Mark
 */
public class Score
{
    /** The X coordinate of the score*/
    private int Xo;
    /** The Y coordinate of the score*/
    private int Yo;

    /**
     * Initializes the origin of the ScoreBoard and the ScoreBoard itself
     * @param x - the X coordinate
     * @param y - the Y coordinate
     */
    public Score( int x, int y )
    {
        Xo = x;
        Yo = y;
    }

    /**
     * Draws the scoreboard onto the graphics
     * @param g - the graphics
     * @param p1 - player one's score
     * @param p2 - player two's score
     */
    public void DrawScore( Graphics g, int p1, int p2 )
    {
        Font font = new Font( "Forte", Font.BOLD, 30 );

        g.setFont( font );

        String score1 = "" + p1;
        String score2 = "" + p2;
        g.drawString( score1 + ":" + score2, Xo - 30, Yo );
    }

    /**
     * Redraws the score board
     * @param g - the graphics
     * @param p1 - player one's score
     * @param p2 - player two's score
     * @param newXCoord - the new X coordinate
     */
    public void DrawScore( Graphics g, int p1, int p2, int newXCoord )
    {
        Font font = new Font( "Forte", Font.BOLD, 30 );

        g.setFont( font );

        String score1 = "" + p1;
        String score2 = "" + p2;
        g.drawString( score1 + ":" + score2, newXCoord - 30, Yo );
    }
}
