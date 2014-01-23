package pongproject;

/**
 * Contains the Math to determine if the ball collides with anything
 * @author Mark
 */
public class CollisionDetection
{

    /**
     * The Constructor
     */
    public CollisionDetection()
    {
    }

    // <editor-fold defaultstate="collapsed" desc="Collision Detection">
    /**
     * Determines whether or not the ball has collided with the top or bottom
     * of the window or one of the paddles
     * @return - a boolean that is true if there has been a collision
     */
    public boolean[] hasCollided( int frameHeight, int ballX, int ballY, int ballD, int pad1X,
            int pad1Y, int pad1H, int pad1W, int pad2X, int pad2Y, int pad2H,
            int pad2W )
    {
        boolean[] collision = new boolean[3];

        int xBall = ballX;
        int y1Ball = ballY;
        int y2Ball = ballY + ballD;

        int xPad1 = pad1X + pad1W;
        int y1Pad1 = pad1Y;
        int y2Pad1 = pad1Y + pad1H;

        int xPad2 = pad2X;
        int y1Pad2 = pad2Y;
        int y2Pad2 = pad2Y + pad2H;

        if( xBall <= xPad1 )
        {
            if( ( y1Ball >= y1Pad1 && y1Ball <= y2Pad1 ) || ( y2Ball >= y1Pad1 && y2Ball <= y2Pad1 ) )
            {
                /* Used to test collision detection */
                //JOptionPane.showMessageDialog( this, "Collided");
                collision[0] = true;
                collision[1] = true;
                collision[2] = false;
            }
            else
                collision[0] = false;
        }
        else if( xBall + ballD >= xPad2 )
        {
            if( ( y1Ball >= y1Pad2 && y1Ball <= y2Pad2 ) || ( y2Ball >= y1Pad2 && y2Ball <= y2Pad2 ) )
            {
                /* Used to test collision detection */
                //JOptionPane.showMessageDialog( this, "Collided");
                collision[0] = true;
                collision[1] = false;
                collision[2] = true;
            }
            else
                collision[0] = false;
        }
        else if( y1Ball <= 0 || y2Ball >= frameHeight )
        {

            collision[0] = true;
            collision[1] = false;
            collision[2] = false;
        }
        else
        {
            collision[0] = false;
            collision[1] = false;
            collision[2] = false;
        }

        return collision;
    }
    // </editor-fold>
}
