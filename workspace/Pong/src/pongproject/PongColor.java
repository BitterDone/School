package pongproject;

import java.awt.Color;
import java.util.Random;

/**
 * The Color generator's
 * @author Mark
 */
public class PongColor
{

    /** Initialization of the random*/
    private Random rand = new Random();

    /**
     * The Constructor
     */
    public PongColor()
    {
    }

    /**
     * Allows the colors to alternating
     * @param col1 - the first color
     * @param col2 - the second color
     * @return - the color to be used at the moment
     */
    public Color altColors( Color col1, Color col2 )
    {
        Color color;
        int num = rand.nextInt( 2 );

        if( num == 0 )
            color = col1;
        else
            color = col2;

        return color;
    }

    public Color invertColor( Color color )
    {
        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();

        R = 255 - R;
        G = 255 - G;
        B = 255 - B;

        return new Color( R,G,B);
    }

    // <editor-fold defaultstate="collapsed" desc="Random Color Generator">
    /**
     * Generates a random RGB color
     * @return - aa random RGB color
     */
    public Color randCol()
    {
        int r, g, b;

        r = rand.nextInt( 255 );
        g = rand.nextInt( 255 );
        b = rand.nextInt( 255 );

        return new Color( r, g, b );
    }
    // </editor-fold>
}
