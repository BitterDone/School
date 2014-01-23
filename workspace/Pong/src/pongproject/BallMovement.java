package pongproject;

/**
 * Contains the metthods that determine and place the next position of the ball
 * @author Mark
 */
public class BallMovement
{

    /** Controls whether the ball can speed up*/
    private boolean allowSpeedUp = false;
    /** Used to recognize the ball colliding with a paddle*/
    private boolean paddleCollision;
    /** Speed of the Ball*/
    private int ballSpeed = 1;
    /** Determines x-direction of the ball*/
    private int xpos = 1;
    /** Used to determine ball motion*/
    private int prevVelocity = 0;

    /**
     * Constructor
     */
    public BallMovement()
    {
    }

    // <editor-fold defaultstate="collapsed" desc="Direction of the Ball">
    /**
     * Determines the next position/direction of the ball depending on if it
     * has collided with specified locations. Redirects the ball according to
     * what it has hit.
     * @return - velocity of Y which determines the ball's direction
     */
    public int determineDirection( int frameHeight, int ballX, int ballY, int ballD, int pad1X,
            int pad1Y, int pad1H, int pad1W, int pad2X, int pad2Y, int pad2H,
            int pad2W )
    {
        CollisionDetection detect = new CollisionDetection();
        boolean[] collided = detect.hasCollided( frameHeight, ballX, ballY, ballD, pad1X,
                pad1Y, pad1H, pad1W, pad2X, pad2Y, pad2H,
                pad2W );

        int dist;
        int velocity = prevVelocity;

        if( collided[0] )
            if( collided[1] )
            {
                dist = ( ballY + ballD / 2 ) - ( pad1Y + pad1H / 2 );

                velocity = dist / 5;

                paddleCollision = true;
            }
            else if( collided[2] )
            {
                dist = ( ballY + ballD / 2 ) - ( pad2Y + pad2H / 2 );

                velocity = dist / 5;

                paddleCollision = true;
            }
            else
            {
                velocity *= -1;
                paddleCollision = false;
            }
        else
        {
            paddleCollision = false;
        }

        prevVelocity = velocity;

        return velocity;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ball Movement">
    /**
     * Sets the next position of the ball given an angle and a speed.
     * @param angle - the angle at which the ball is to move.
     * @param speed - the speed at which the ball is to move.
     */
    public int[] moveBall( int yVelocity )
    {
        int ypos = yVelocity;
        int[] position = new int[ 2 ];

        if( ypos > 4 )
            ypos = 4;
        else if( ypos < -4 )
            ypos = -4;
        else if( ypos == 0 && paddleCollision && allowSpeedUp )
            this.ballSpeed += 1;

        if( this.ballSpeed > 5 )
            this.ballSpeed = 5;

        if( paddleCollision )
        {
            xpos = -xpos;
        }

        position[0] = xpos * this.ballSpeed;
        position[1] = ypos;

        return position;
    }
    // </editor-fold>

    /**
     * Sets the previous Y velocity
     * @param prevVelocity - the previous Y velocity
     */
    public void setPrevV( int prevVelocity )
    {
        this.prevVelocity = prevVelocity;
    }

    /**
     * Sets the speed of the ball
     * @param speed - the speed of the ball
     */
    public void setBallSpeed( int speed )
    {
        this.ballSpeed = speed;
    }

    /**
     * Sets if the ball can speed up
     * @param allow - determines if the ball can speed up
     */
    public void setSpeedUp( boolean allow)
    {
        this.allowSpeedUp = allow;
    }

    /**
     * Sends if the ball can be sped up
     * @return - the determiner if the ball cans speed up
     */
    public boolean getSpeedUp()
    {
        return this.allowSpeedUp;
    }
}
