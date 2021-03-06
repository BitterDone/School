package pongproject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PongGUI.java
 *
 * Created on May 3, 2010, 1:45:33 PM
 */
/**
 * The main frame of the program.
 * @author Mark
 */
public class PongGUI extends javax.swing.JFrame {

    /** The canvas of the program*/
    PongCanvas canvas;

    /**
     * The Constructor
     * @param aThis
     */
    public PongGUI(PongProjectApp aThis) {
        canvas = new PongCanvas(this);
        this.add(canvas);

        initComponents();

        canvas.Initialize();
    }

    /**
     * Starts the game loop/timer
     */
    private void Run() {
        canvas.Start();
        this.setResizable(true);
    }

    /**
     * Re-initializes the menu bar( brings it forward)
     */
    public void showMenuBar() {
        int x = this.getWidth();
        int y = this.getHeight();
        initComponents();
        this.setSize( x, y);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemPlayer = new javax.swing.JMenuItem();
        jMenuItemPaddle = new javax.swing.JMenuItem();
        jMenuItemBall = new javax.swing.JMenuItem();
        jMenuItemScore = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pongproject.PongProjectApp.class).getContext().getResourceMap(PongGUI.class);
        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N

        jMenuItemPlayer.setText(resourceMap.getString("jMenuItemPlayer.text")); // NOI18N
        jMenuItemPlayer.setName("jMenuItemPlayer"); // NOI18N
        jMenuItemPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPlayerActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPlayer);

        jMenuItemPaddle.setText(resourceMap.getString("jMenuItemPaddle.text")); // NOI18N
        jMenuItemPaddle.setName("jMenuItemPaddle"); // NOI18N
        jMenuItemPaddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPaddleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPaddle);

        jMenuItemBall.setText(resourceMap.getString("jMenuItemBall.text")); // NOI18N
        jMenuItemBall.setName("jMenuItemBall"); // NOI18N
        jMenuItemBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBallActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemBall);

        jMenuItemScore.setText(resourceMap.getString("jMenuItemScore.text")); // NOI18N
        jMenuItemScore.setName("jMenuItemScore"); // NOI18N
        jMenuItemScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemScoreActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemScore);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Starts the game loop
     * @param evt - the event
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem1ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        canvas.Start();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Closes the game
     * @param evt - the event
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem2ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Opens the player options
     * @param evt - the event
     */
    private void jMenuItemPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPlayerActionPerformed
        PlayOption play = new PlayOption( canvas);
        play.setVisible( true);
    }//GEN-LAST:event_jMenuItemPlayerActionPerformed

    /**
     * Opens the paddle options
     * @param evt - the event
     */
    private void jMenuItemPaddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPaddleActionPerformed
     PaddleOption paddle = new PaddleOption( canvas );
     paddle.setVisible(true);
    }//GEN-LAST:event_jMenuItemPaddleActionPerformed

    /**
     * Opens the ball options
     * @param evt - the event
     */
    private void jMenuItemBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBallActionPerformed
        BallOption ball = new BallOption( canvas );
        ball.setVisible(true);
    }//GEN-LAST:event_jMenuItemBallActionPerformed

    /**
     * Opens the score options
     * @param evt - the event
     */
    private void jMenuItemScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemScoreActionPerformed
        ScoreOption score = new ScoreOption( canvas );
        score.setVisible(true);
    }//GEN-LAST:event_jMenuItemScoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemBall;
    private javax.swing.JMenuItem jMenuItemPaddle;
    private javax.swing.JMenuItem jMenuItemPlayer;
    private javax.swing.JMenuItem jMenuItemScore;
    // End of variables declaration//GEN-END:variables
}
