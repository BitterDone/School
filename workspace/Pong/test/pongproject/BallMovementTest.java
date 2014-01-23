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
public class BallMovementTest {

    public BallMovementTest() {
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
   * Test of determineDirection method, of class BallMovement.
   */
  @Test
  public void testDetermineDirection() {
    System.out.println("determineDirection");
    int frameHeight = 0;
    int ballX = 0;
    int ballY = 0;
    int ballD = 0;
    int pad1X = 0;
    int pad1Y = 0;
    int pad1H = 0;
    int pad1W = 0;
    int pad2X = 0;
    int pad2Y = 0;
    int pad2H = 0;
    int pad2W = 0;
    BallMovement instance = new BallMovement();
    int expResult = 0;
    int result = instance.determineDirection(frameHeight, ballX, ballY, ballD, pad1X, pad1Y, pad1H, pad1W, pad2X, pad2Y, pad2H, pad2W);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of moveBall method, of class BallMovement.
   */
 


  /**
   * Test of setPrevV method, of class BallMovement.
   */
  @Test
  public void testSetPrevV() {
    System.out.println("setPrevV");
    int prevVelocity = 0;
    BallMovement instance = new BallMovement();
    instance.setPrevV(prevVelocity);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setBallSpeed method, of class BallMovement.
   */
  @Test
  public void testSetBallSpeed() {
    System.out.println("setBallSpeed");
    int speed = 0;
    BallMovement instance = new BallMovement();
    instance.setBallSpeed(speed);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setSpeedUp method, of class BallMovement.
   */
  @Test
  public void testSetSpeedUp() {
    System.out.println("setSpeedUp");
    boolean allow = false;
    BallMovement instance = new BallMovement();
    instance.setSpeedUp(allow);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of getSpeedUp method, of class BallMovement.
   */
  @Test
  public void testGetSpeedUp() {
    System.out.println("getSpeedUp");
    BallMovement instance = new BallMovement();
    boolean expResult = false;
    boolean result = instance.getSpeedUp();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
   // fail("The test case is a prototype.");
  }

}