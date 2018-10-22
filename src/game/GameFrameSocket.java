/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.WindowConstants;

/**
 *
 * @author OGUZHAN
 */

public class GameFrameSocket extends GameFrame{
    MainMenu mainMenu1;
    public GameFrameSocket(String title,MainMenu mainMenu) {
        super(title,mainMenu);  
    }

    @Override
    public void main() {
         GameFrame mainWindow = this;
        mainWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainWindow.setFocusable(true);
        mainWindow.setResizable(false);

        //mainWindow.setSize(320, 330);
        //game.requestFocus();
        game.addMouseListener(game);
        game.setFocusable(true);

        game.setEnabled(false);

        mainWindow.add(game);
        
        ((GamePanelSocket)game).main(null);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow.setVisible(true);
            }
        });
    }
    
    
    
}
