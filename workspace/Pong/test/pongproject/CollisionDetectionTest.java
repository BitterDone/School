/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pongproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author povinellir
 */
public class CollisionDetectionTest {

    public CollisionDetectionTest() {
    }

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  /**
   * Test of hasCollided method, of class CollisionDetection.
   */
  @Test
  public void testHasCollided() {
    System.out.println("hasCollided");
    int frameHeight = 100;
    int ballX = 0;
    int ballY = 2;
    int ballD = 1;
    int pad1X = 0;
    int pad1Y = 1;
    int pad1H = 3;
    int pad1W = 0;
    int pad2X = 0;
    int pad2Y = 0;
    int pad2H = 0;
    int pad2W = 0;
    CollisionDetection instance = new CollisionDetection();
    boolean[] expResult = {true,true,false};
    boolean[] result = instance.hasCollided(frameHeight, ballX, ballY, ballD, pad1X, pad1Y, pad1H, pad1W, pad2X, pad2Y, pad2H, pad2W);
    for (int i = 0; i < 3; i++){
    assertEquals(expResult[i], result[i]);
    }

    // TODO review the generated test code and remove the default call to fail.
    //("The test case is a prototype.");
  }

}