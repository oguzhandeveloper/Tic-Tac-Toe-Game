/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.Timer;

/**
 *
 * @author OGUZHAN
 */
public class GameFrame extends JFrame {

    /**
     * Creates new form MainWindow
     */
    GamePanel game;
    Object lock = new Object();
    MainMenu mainMenu;

    public GameFrame(String title, MainMenu mainMenu) {
        super(title);
        this.mainMenu = mainMenu;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        getContentPane().setBackground(SystemColor.controlHighlight);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.controlHighlight);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Player 1 : ");

        jLabel2.setText("Player 2 : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPlayer1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPlayer2))
                .addContainerGap(254, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        PanelEnable(true, "Are you sure you want to quit?");
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param b
     * @param Message
     */
    public void PanelEnable(boolean b, String Message) {

        game.timeForPlayers.stop();
        if (!b) //Eger oyuncu kazanmıs ya da berabere ise bu blog girer
        {
            int i = JOptionPane.showConfirmDialog(this, Message + "\n" + "\nDo you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);

            if (i == JOptionPane.NO_OPTION) {
                try {
                    mainMenu.gameSame.dispose();

                } catch (Exception e) {
                    //System.out.println(e);
                }

            } else {
                mainMenu.gameSame.dispose();
                mainMenu.CreateSameComputerGame();
            }
        } else //Eger oyuncu cikmak isterse bu bloga girer
        {
            int i = JOptionPane.showConfirmDialog(this, Message + "\n", "Game Over", JOptionPane.YES_NO_OPTION);

            if (i == JOptionPane.YES_OPTION) {
                try {
                    mainMenu.gameSame.dispose();
                } catch (Exception e) {
                    //System.out.println(e);
                }

            } else {
                mainMenu.gameSame.dispose();
                mainMenu.CreateSameComputerGame();
            }
        }
    }

    public void main() {

        GameFrame mainWindow = this;

        game = new GamePanel(mainWindow);

        mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainWindow.setFocusable(true);
        mainWindow.setResizable(false);

        //mainWindow.setSize(320, 330);
        //game.requestFocus();
        game.addMouseListener(game);
        game.setFocusable(true);

        game.setEnabled(false);

        mainWindow.add(game);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel lblPlayer1;
    public javax.swing.JLabel lblPlayer2;
    // End of variables declaration//GEN-END:variables
}