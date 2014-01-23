package pongproject;

import java.util.Random;

/**
 * Contains the methods that calculate where the paddles will move.
 * @author Mark
 */
public class PaddleMovement
{

    /** Speed of Player One's Paddle*/
    private int pad1Speed;
    /** Recognizes if Player One's up button is pushed or not*/
    private boolean p1UpPressed;
    /** Recognizes if Player One's down button is pushed or not*/
    private boolean p1DownPressed;
    /** Speed of Player Two's Paddle*/
    private int pad2Speed;
    /** Recognizes if Player Two's up button is pushed or not*/
    private boolean p2UpPressed;
    /** Recognizes if Player Two's down button is pushed or not*/
    private boolean p2DownPressed;
    /** Determines if the computer is playing*/
    private boolean computer;
    /** Determines the difficulty level of the computer*/
    private int compDifficulty;
    /** Boolean to check if difficulty has been checked*/
    private boolean diffCheck = true;

    /**
     * The Constructor
     * @param computer - determines if the computer is playing
     * @param pad1Speed - the speed of paddle one
     * @param pad2Speed - the speed of paddle two
     * @param compDifficulty  -the computer's difficulty
     */
    public PaddleMovement( boolean computer, int pad1Speed, int pad2Speed,
            int compDifficulty )
    {
        this.computer = computer;
        this.pad1Speed = pad1Speed;
        this.pad2Speed = pad2Speed;
        this.compDifficulty = compDifficulty;
    }

    // <editor-fold defaultstate="collapsed" desc="Paddle Movement">
    /**
     * Moves the appropriate paddle if and only if the key bound to the
     * direction is pressed.
     * @param ballY - ball's Y coordinate
     * @param ballD - ball's diameter
     * @param pad1Y - paddle one's Y coordinate
     * @param pad1H - paddle one's height
     * @param pad2Y - paddle two's Y coordinate
     * @param pad2H - paddle two's height
     * @return - the coordinates for the paddle
     */
    public int[] movePaddles( int ballY, int ballD, int pad1Y, int pad1H,
            int pad2Y, int pad2H )
    {
        int[] padMovement = new int[ 2 ];

        if( p1UpPressed && !p1DownPressed )
        {
            if( pad1Y + pad1H / 2 >= 0 )
                padMovement[0] = pad1Y - pad1Speed;
        }
        else if( !p1UpPressed && p1DownPressed )
        {
            if( ( pad1Y + pad1H / 3 ) <= 600 )
                padMovement[0] = pad1Y + pad1Speed;
        }
        else
            padMovement[0] = pad1Y;

        if( p2UpPressed && !p2DownPressed && !computer )
        {
            if( pad2Y + pad2H / 2 >= 0 )
                padMovement[1] = pad2Y - pad2Speed;
        }
        else if( !p2UpPressed && p2DownPressed && !computer )
        {
            if( ( pad2Y + pad2H / 3 ) <= 600 )
                padMovement[1] = pad2Y + pad2Speed;
        }
        else if( computer )
        {
            padMovement[1] = compAI( ballY, ballD, pad2Y, pad2H );
        }
        else
            padMovement[1] = pad2Y;

        return padMovement;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Computer AI">
    /**
     * The Computer AI
     * @param ballY - ball's Y coordinate
     * @param ballD - ball's diameter
     * @param pad2Y - paddle two's Y coordinate
     * @param pad2H - paddle two's height
     * @return - the coordinate for the computer's paddle
     */
    private int compAI( int ballY, int ballD, int pad2Y, int pad2H )
    {
        int distance;
        int direction;
        int newDir;

        if( diffCheck )
        {
            diffCheck = false;

            switch( compDifficulty )
            {
                case 1: //Easy
                {
                    pad2Speed = 1;
                    break;
                }
                case 2: //Moderate
                {
                    pad2Speed = 2;
                    break;
                }
                case 3: //Hard
                {
                    pad2Speed = 4;
                    break;
                }
                case 4: //Hardcore
                {
                    pad2Speed = 5;
                    break;
                }
                default: //Normal
                {
                    pad2Speed = 3;
                    break;
                }
            }
        }

        distance = ( pad2Y + pad2H / 2 ) - ( ballY + ballD / 2 );

//        if( ( ballX + ( ballD / 2 ) ) >= ( FWIDTH / 2 ) )
//            acrossHalf = true;
//        else
//            acrossHalf = false;

        if( distance > 5 )// && acrossHalf )
        {
            direction = -1;
        }
        else if( distance < -5 )// && acrossHalf )
        {
            direction = 1;
        }
        else
        {
            direction = 0;
        }

        Random rand = new Random();
        int x = rand.nextInt( 3 );

        if( x == 0 )
            newDir = pad2Speed * direction;
        else
            newDir = 0;

        return ( pad2Y + newDir );

    }
    // </editor-fold>

    /**
     * Sets if paddle one is going up
     * @param p1UpPressed - determines if paddle one is going up
     */
    public void setP1Up( boolean p1UpPressed )
    {
        this.p1UpPressed = p1UpPressed;
    }

    /**
     * Sets if paddle two is going up
     * @param p2UpPressed - determines if paddle two is going up
     */
    public void setP2Up( boolean p2UpPressed )
    {
        this.p2UpPressed = p2UpPressed;
    }

    /**
     * Sets if paddle one is going down
     * @param p1DownPressed - determines if paddle one is going down
     */
    public void setP1Down( boolean p1DownPressed )
    {
        this.p1DownPressed = p1DownPressed;
    }

    /**
     * Sets if paddle two is going down
     * @param p2DownPressed - determines if paddle two is going down
     */
    public void setP2Down( boolean p2DownPressed )
    {
        this.p2DownPressed = p2DownPressed;
    }

    /**
     * Sets the computer difficulty
     * @param difficulty - the difficulty of the computer
     */
    public void setComputerDiff( int difficulty )
    {
        this.compDifficulty = difficulty;
    }

    /**
     * Sets if the computer is playing
     * @param computer - determines if the computer is playing
     */
    public void setComputer( boolean computer )
    {
        this.computer = computer;
    }
}
