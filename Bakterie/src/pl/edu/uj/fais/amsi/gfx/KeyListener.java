/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uj.fais.amsi.gfx;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author K O M P U T E R
 */
public class KeyListener extends KeyAdapter {

    private final DrawingPanel outer;

    KeyListener(final DrawingPanel outer) {
        this.outer = outer;
    }

    public void keyTyped(KeyEvent ke) {
        int key = ke.getKeyCode();
        System.out.println("Click: " + ke.paramString());
        if (key == KeyEvent.VK_SPACE) {
            GameWindow.updateBoard();
        }
        if (key == KeyEvent.VK_RIGHT) {
            GameWindow.updateBoard();
            outer.repaint();
        }
    }
    

}
