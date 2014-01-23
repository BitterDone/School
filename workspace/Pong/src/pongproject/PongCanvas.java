/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongproject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.Timer;

/**
 * The Canvas that enables the games to be drawn within the frame.
 * Contains the methods to call and set the graphical information to draw
 * the paddles, ball, and scoreboard.
 * Also, gets, calls, and sets the game settings.
 * @author Mark
 */
public class PongCanvas extends Canvas implements KeyListener
{

    // <editor-fold defaultstate="collapsed" desc="Player One Initializations">
    /** Playe One's Paddle Size */
    private int pad1Size = 0;
    /** Initialization of Player One's Paddle*/
    private Paddle pad1;
    /** Speed of Player One's Paddle*/
    private int pad1Speed = 0;
    /** Paddle Movement intialization */
    PaddleMovement pMove;
    /** Paddle One's Color*/
    Color pad1Color = Color.BLUE;
    /** Determines if the paddle's color is random*/
    boolean pad1Random;
    /** Key Code for Paddle One's Up Button*/
    private int p1Up = KeyEvent.VK_W;
    /** Key Code for Paddle One's Down Button*/
    private int p1Down = KeyEvent.VK_S;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Computer/Player Two Initializations">
    /** Playe Two's Paddle Size */
    private int pad2Size = 0;
    /** Initialization of Player Two's Paddle*/
    private Paddle pad2;
    /** Speed of Player Two's Paddle*/
    private int pad2Speed = 0;
    /** Determines if the computer is playing*/
    private boolean computer = false;
    /** Determines the difficulty level of the computer*/
    private int compDifficulty = 0;
    /** Paddle Two's Color*/
    Color pad2Color = Color.BLUE;
    /** Determines if the paddle's color is random*/
    boolean pad2Random;
    /** Key Code for Paddle Two's Up Button*/
    private int p2Up = KeyEvent.VK_H;
    /** Key Code for Paddle Two's Down Button*/
    private int p2Down = KeyEvent.VK_N;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Ball Initializations">
    /** Size of the Ball*/
    private int ballSize = 0;
    /** Initialization ofF the ball*/
    private Ball ball;
    /** Initialization of the ball's speed*/
    private int ballSpeed = 1;
    /** Initialization of the Ball Movement */
    BallMovement bMove;
    /** Ball's Color*/
    Color ballColor = Color.WHITE;
    /** Determines if the ball's color is random*/
    boolean ballRandom;
    /** Determines if the ball can speed up*/
    boolean speedUp = true;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Score Properties and Initialization">
    /** Player One's Score*/
    private int p1Score;
    /** Player Two's Score*/
    private int p2Score;
    /** Score to win*/
    private int win = 0;
    /** Initialization of the Score*/
    private Score score;
    /** Helps display who won*/
    private boolean p1Won;
    /** Initialization of the timer*/
    public Timer gameTimer;
    /** Initiailization of the buffer strategy*/
    private BufferStrategy buff;
    /** Used to get the information of the frames settings*/
    PongGUI frame;
    /** Boolean that determines if someone has scored*/
    private boolean scored;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Game Options">
    /** Allows the game to be completely halted.*/
    private boolean running;
    /** Allows for the pausing of the game*/
    private static boolean paused;
    /** Allows the player to quit*/
    private boolean cont;
    /** Initializes the Color Methods*/
    PongColor color;
    /** Allows for Seizure Mode*/
    private boolean seizureMode = false;
    /** Background Color for thr Canvas*/
    private Color backgroundColor = Color.BLACK;
    /** Allows for a random background color*/
    private boolean backgroundRandom = false;
    // </editor-fold>

    /** Constructor for the Canvas*/
    public PongCanvas( PongGUI frame )
    {
        this.frame = frame;
        this.setVisible( true );
        this.setBackground( Color.BLACK );
        this.setLocation( frame.getX(), frame.getY() );
        gameTimer = new Timer( 5, new ActionListener()
        {

            public void actionPerformed( ActionEvent e )
            {
                Run();
            }
        } );
    }

    /** Allows for to start the game*/
    public void Start()
    {
        scored = true;
        this.Initialize();
        gameTimer.start();
    }

    // <editor-fold defaultstate="collapsed" desc="Initialize">
    /**
     * Initializes the many settings of the game. Also, creates the buffer
     * strategy and the key listener.
     */
    public void Initialize()
    {
        // Generic Settings
        this.createBufferStrategy( 2 );
        this.addKeyListener( this );
        this.setFocusable( true );
        this.requestFocus();
        this.setSize( frame.getWidth() - 16, frame.getHeight() - 58 );

        color = new PongColor();
        bMove = new BallMovement();
        buff = this.getBufferStrategy();
        running = true;
        cont = true;
        p1Score = 0;
        p2Score = 0;

        this.Settings();

        pad1 = new Paddle( pad1Size );
        pad2 = new Paddle( pad2Size );
        pMove = new PaddleMovement( computer, pad1Speed, pad2Speed,
                compDifficulty );
        ball = new Ball( ballSize );
        bMove.setSpeedUp( speedUp );
        score = new Score( this.getWidth() / 2, 60 );

        try
        {
            Thread.sleep( 200 );
        }
        catch( Exception e )
        {
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Run Method">
    /**
     * Contains the semi-infinite loop that calls the games logic.
     * Calls the function drawStuffto display the game.
     */
    public void Run()
    {
        if( this.hasFocus() )
        {
            if( ( p1Score < win && p2Score < win ) && cont )
            {
                if( scored )
                {
                    int p1Or = this.getHeight() / 2 - ( pad1.getH() / 2 );
                    int p2Or = this.getHeight() / 2 - ( pad2.getH() / 2 );

                    cont = true;

                    paused = true;
                    running = true;

                    bMove.setPrevV( 0 );
                    bMove.setBallSpeed( ballSpeed ); //Debug

                    pMove.setComputerDiff( compDifficulty );
                    pMove.setComputer( computer );

                    pad1.setOrigin( 10, p1Or );
                    pad2.setOrigin( this.getWidth() - 10, p2Or );
                    ball.setOrigin( this.getWidth() / 2 - ball.getD(), this.getHeight() / 2 - ball.getD() );

                    drawStuff();

                    scored = false;
                }
                if( running )
                {
                    gameLoop();
                }

                drawStuff();
            }
            else
            {

                cont = false;

                if( p1Score == win )
                    p1Won = true;
                else
                    p1Won = false;

                frame.showMenuBar();
                drawStuff();

                gameTimer.stop();
            }
        }
        else
        {
            frame.showMenuBar();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Game Loop">
    /**
     * The Game Loop that checks if the game is paused, if not the
     * next drawing of the game is done.
     */
    private void gameLoop()
    {

        this.setSize( frame.getWidth() - 15, frame.getHeight() - 50 );
        if( !paused )
        {
            if( ball.getX() > ( pad2.getX() + pad2.getW() ) )
            {
                p1Score += 1;
                running = false;
                scored = true;
            }
            else if( ball.getX() + ball.getD() < pad1.getX() )
            {
                p2Score += 1;
                running = false;
                scored = true;
            }

            try
            {
                Thread.sleep( 5 );
            }
            catch( Exception e )
            {
            }

            drawStuff();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Drawing Method">
    /**
     * Uses triple buffering to draw and then  display the ball movement as
     * well as the paddles' movement.
     */
    private void drawStuff()
    {
        Graphics g = null;
        int yVelocity;
        int[] bDirection;
        int[] pDirection;

        try
        {
            g = buff.getDrawGraphics();

            if( !cont )
            {
                Font font = new Font( "Forte", Font.BOLD, 30 );

                g.setFont( font );

                g.clearRect( 0, 0, this.getWidth(), this.getHeight() );

                g.setColor( color.invertColor( this.backgroundColor) );

                if( p1Won )
                {
                    g.drawString( "Player 1 Won!", this.getWidth() / 2 - 110, this.getHeight() / 2 );
                }
                else if( !p1Won && !computer )
                {
                    g.drawString( "Player 2 Won!", this.getWidth() / 2 - 110, this.getHeight() / 2 );
                }
                else
                {
                    g.drawString( "Computer Won!", this.getWidth() / 2 - 110, this.getHeight() / 2 );
                }
            }
            else if( paused )
            {
                Font font = new Font( "Forte", Font.BOLD, 30 );

                g.setFont( font );

                g.setColor( color.invertColor( this.backgroundColor) );

                g.drawString( "Paused", this.getWidth() / 2 - 55, this.getHeight() / 2 );
            }
            else
            {
                g.clearRect( 0, 0, this.getWidth(), this.getHeight() );

                yVelocity = bMove.determineDirection( this.getHeight(), ball.getX(),
                        ball.getY(), ball.getD(), pad1.getX(), pad1.getY(),
                        pad1.getH(), pad1.getW(), pad2.getX(), pad2.getY(),
                        pad2.getH(), pad2.getW() );

                bDirection = bMove.moveBall( yVelocity );

                ball.setOrigin( ball.getX() + bDirection[0], ball.getY() +
                        bDirection[1] );

                pDirection = pMove.movePaddles( ball.getY(), ball.getD(),
                        pad1.getY(), pad1.getH(), pad2.getY(), pad2.getH() );

                pad1.setOrigin( pad1.getX(), pDirection[0] );

                pad2.setOrigin( this.getWidth() - 16, pDirection[1] );

                if( seizureMode )
                {
                    g.setColor( color.randCol() );
                    this.setBackground( color.randCol() );
                }
                else
                {
                    if( backgroundRandom)
                        backgroundColor = color.randCol();

                    g.setColor( color.invertColor( backgroundColor) );
                    this.setBackground( backgroundColor );
                }
                
                score.DrawScore( g, p1Score, p2Score, this.getWidth() / 2 );

                if( ballRandom || seizureMode )
                    g.setColor( color.randCol() );
                else
                    g.setColor( ballColor );

                ball.DrawBall( g, backgroundColor );

                if( pad1Random || seizureMode )
                    g.setColor( color.randCol() );
                else
                    g.setColor( pad1Color );

                pad1.DrawPaddle( g, backgroundColor );

                if( pad2Random || seizureMode )
                    g.setColor( color.randCol() );
                else
                    g.setColor( pad2Color );

                pad2.DrawPaddle( g, backgroundColor );
            }
        }
        finally
        {
            g.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        buff.show();

        //Tell the System to do the Drawing now
        Toolkit.getDefaultToolkit().sync();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Key Listener">
    /**
     * Needed to use the Key Listener
     * @param e - the key event
     */
    public void keyTyped( KeyEvent e )
    {
    }

    /**
     * Checks if one of the game keys is pressed.
     * @param e - the key event
     */
    public void keyPressed( KeyEvent e )
    {
        if( e.getKeyCode() == KeyEvent.VK_P )
        {
            paused = true;
        }

        if( ( e.getKeyCode() == p2Up ) && !computer )
        {
            if( PongCanvas.paused )
                PongCanvas.paused = false;

            pMove.setP2Up( true );
        }
        else if( e.getKeyCode() == p2Down && !computer )
        {
            if( PongCanvas.paused )
                PongCanvas.paused = false;

            pMove.setP2Down( true );
        }

        if( e.getKeyCode() == p1Up )
        {
            if( PongCanvas.paused )
                PongCanvas.paused = false;

            pMove.setP1Up( true );
        }
        else if( e.getKeyCode() == p1Down )
        {
            if( PongCanvas.paused )
                PongCanvas.paused = false;

            pMove.setP1Down( true );
        }
    }

    /**
     * Checks if one of the game keys is released.
     * @param e - the key event
     */
    public void keyReleased( KeyEvent e )
    {
        char c = e.getKeyChar();

        if( e.getKeyCode() == p2Up && !computer )
            pMove.setP2Up( false );
        else if( e.getKeyCode() == p2Down && !computer )
            pMove.setP2Down( false );

        if( e.getKeyCode() == p1Up )
            pMove.setP1Up( false );
        else if( e.getKeyCode() == p1Down )
            pMove.setP1Down( false );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Settings">
    /**
     * The default Game Settings
     */
    public void Settings()
    {
        if( win <= 0 )
            win = 5;

        if( pad1Size < 15 )
            pad1Size = 35;
        if( pad1Speed < 1 )
            pad1Speed = 1;

        if( pad2Size < 15 )
            pad2Size = 35;
        if( pad2Speed < 1 )
            pad2Speed = 1;

        if( compDifficulty < 1 )
            compDifficulty = 5; //Normal Difficulty

        if( ballSize < 1 )
            ballSize = 10;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set Methods">
    /**
     * Sets the amoun to be played to
     * @param score - the amount played up to
     */
    public void setWinScore( int score )
    {
        this.win = score;
    }

    /**
     * Sets the size of paddle one
     * @param size - the size of paddle one
     */
    public void setPad1Size( int size )
    {
        this.pad1Size = size;
    }

    /**
     * Sets the size of the second paddle
     * @param size - the size of paddle two
     */
    public void setPad2Size( int size )
    {
        this.pad2Size = size;
    }

    /**
     * Sets the speed of paddle one
     * @param speed - the speed of paddle one
     */
    public void setPad1Speed( int speed )
    {
        this.pad1Speed = speed;
    }

    /**
     * Sets the speed of paddle two
     * @param speed - the speed of paddle two
     */
    public void setPad2Speed( int speed )
    {
        this.pad2Speed = speed;
    }

    /**
     * Sets if the computer is playing
     * @param computer - sets if the computer is playing
     */
    public void setTwoPlayer( boolean computer )
    {
        this.computer = computer;
    }

    /**
     * Sets the difficulty of the computer
     * @param difficulty - the difficulty of the computer
     */
    public void setComputerDifficulty( int difficulty )
    {
        this.compDifficulty = difficulty;
    }

    /**
     * Sets the size of the ball
     * @param size - the size of the ball
     */
    public void setBallSize( int size )
    {
        this.ballSize = size;
    }

    /**
     * Sets if the ball can speed up
     * @param allow - determines if the ball can speed up
     */
    public void setSpeedUp( boolean allow )
    {
        this.speedUp = allow;
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
     * Sets the color of paddle one
     * @param color - the color of paddle one
     */
    public void setPad1Color( Color color )
    {
        this.pad1Color = color;
        this.pad1Random = false;
    }

    /**
     * Sets the color of paddle one
     * @param color - the color of paddle one
     */
    public void setPad1Color( boolean color )
    {
        this.pad1Random = true;
    }

    /**
     * Sets the color of paddle two
     * @param color - the color of paddle two
     */
    public void setPad2Color( Color color )
    {
        this.pad2Color = color;
        this.pad2Random = false;
    }

    /**
     * Sets the color of paddle two
     * @param color - the color of paddle two
     */
    public void setPad2Color( boolean color )
    {
        this.pad2Random = true;
    }

    /**
     * Sets the color of the ball
     * @param color - the color of the ball
     */
    public void setBallColor( Color color )
    {
        this.ballColor = color;
        this.ballRandom = false;
    }

    /**
     * Sets the color of the ball
     * @param color - the color of the ball
     */
    public void setBallColor( boolean color )
    {
        this.ballRandom = true;
    }

    /**
     * Sets the key code for paddle one's up button
     * @param up - the key code for paddle one's up button
     */
    public void setP1Up( int up )
    {
        this.p1Up = up;
    }

    /**
     * Sets the key code for paddle one's down button
     * @param up - the key code for paddle one's down button
     */
    public void setP1Down( int down )
    {
        this.p1Down = down;
    }

    /**
     * Sets the key code for paddle two's up button
     * @param up - the key code for paddle two's up button
     */
    public void setP2Up( int up )
    {
        this.p2Up = up;
    }

    /**
     * Sets the key code for paddle two's down button
     * @param up - the key code for paddle two's down button
     */
    public void setP2Down( int down )
    {
        this.p2Down = down;
    }
    /**
     * Sets if seizure mode is enabled
     * @param enabled - determines if seizureMode is enabled
     */
    public void setSeizureMode( boolean enabled )
    {
        this.seizureMode = enabled;
    }
    /**
     * Sets the background color of the canvas
     * @param color - the new color
     */
    public void setBackgroundColor( Color color)
    {
        this.backgroundColor = color;
    }
        /**
     * Sets the background color of the canvas
     * @param color - the new color
     */
    public void setBackgroundColor( boolean enabled)
    {
        this.backgroundRandom = enabled;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get Methods">
    /**
     * Sends if the computer is active
     * @return - the activity of the computer
     */
    public boolean isComputer()
    {
        return computer;
    }

    /**
     * Sends the computer's difficulty
     * @return - the computer's difficulty
     */
    public int getCompDifficulty()
    {
        return this.compDifficulty;
    }

    /**
     * Sends paddle one's color
     * @return - paddle one's color
     */
    public Color getPad1Color()
    {
        return pad1Color;
    }

    /**
     * Sends paddle two's color
     * @return - paddle two's color
     */
    public Color getPad2Color()
    {
        return pad2Color;
    }

    /**
     * Sends the ball's color
     * @return - the ball's color
     */
    public Color getBallColor()
    {
        return ballColor;
    }

    /**
     * Sends if the ball can speed up
     * @return - determines if the ball can speed up
     */
    public boolean getSpeedUp()
    {
        return bMove.getSpeedUp();
    }

    /**
     * Sends the keycode for paddle one's up button
     * @return - paddle one's up button
     */
    public int getP1Up()
    {
        return this.p1Up;
    }

    /**
     * Sends the keycode for paddle one's down button
     * @return - paddle one's down button
     */
    public int getP1Down()
    {
        return this.p1Down;
    }

    /**
     * Sends the keycode for paddle two's up button
     * @return - paddle two's up button
     */
    public int getP2Up()
    {
        return this.p2Up;
    }

    /**
     * Sends the keycode for paddle two's down button
     * @return - paddle two's down button
     */
    public int getP2Down()
    {
        return this.p2Down;
    }

    /**
     * Sends if seizure mode is enabled or not
     * @return - the value representing if seizrue mode is enabled
     */
    public boolean getSeizureMode()
    {
        return this.seizureMode;
    }
    /**
     * Sends the current background color of the canvas
     * @return - the background color
     */
    public Color getBackgroundColor()
    {
        return this.backgroundColor;
    }
    // </editor-fold>
}
