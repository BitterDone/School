/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pongproject;

import java.awt.Color;
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
public class PongCanvasTest {

    public PongCanvasTest() {
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
   * Test of setWinScore method, of class PongCanvas.
   */
  @Test
  public void testSetWinScore() {
    System.out.println("setWinScore");
    int score = 5;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setWinScore(score);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setPad1Size method, of class PongCanvas.
   */
  @Test
  public void testSetPad1Size() {
    System.out.println("setPad1Size");
    int size = 0;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setPad1Size(size);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setPad2Size method, of class PongCanvas.
   */
  @Test
  public void testSetPad2Size() {
    System.out.println("setPad2Size");
    int size = 0;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setPad2Size(size);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setPad1Speed method, of class PongCanvas.
   */
  @Test
  public void testSetPad1Speed() {
    System.out.println("setPad1Speed");
    int speed = 0;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setPad1Speed(speed);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setPad2Speed method, of class PongCanvas.
   */
  @Test
  public void testSetPad2Speed() {
    System.out.println("setPad2Speed");
    int speed = 0;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setPad2Speed(speed);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setTwoPlayer method, of class PongCanvas.
   */
  @Test
  public void testSetTwoPlayer() {
    System.out.println("setTwoPlayer");
    boolean computer = false;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setTwoPlayer(computer);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setComputerDifficulty method, of class PongCanvas.
   */
  @Test
  public void testSetComputerDifficulty() {
    System.out.println("setComputerDifficulty");
    int difficulty = 0;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setComputerDifficulty(difficulty);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }



  /**
   * Test of setSeizureMode method, of class PongCanvas.
   */
  @Test
  public void testSetSeizureMode() {
    System.out.println("setSeizureMode");
    boolean enabled = false;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setSeizureMode(enabled);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setBackgroundColor method, of class PongCanvas.
   */
  @Test
  public void testSetBackgroundColor_Color() {
    System.out.println("setBackgroundColor");
    Color color = null;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setBackgroundColor(color);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of setBackgroundColor method, of class PongCanvas.
   */
  @Test
  public void testSetBackgroundColor_boolean() {
    System.out.println("setBackgroundColor");
    boolean enabled = false;
    PongProjectApp app = new PongProjectApp();
    PongGUI gui = new PongGUI(app);
    PongCanvas instance = new PongCanvas( gui );
    instance.setBackgroundColor(enabled);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  /**
   * Test of isComputer method, of class PongCanvas.
   */
  @Test
  public void testIsComputer() {
    System.out.println("isComputer");
    PongCanvas instance = null;
    boolean expResult =true;
    boolean result = true;
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
  }

  
}