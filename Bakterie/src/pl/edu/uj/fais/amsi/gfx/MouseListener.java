/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uj.fais.amsi.gfx;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author K O M P U T E R
 */
class MouseListener extends MouseAdapter {

    private final DrawingPanel outer;

    MouseListener(final DrawingPanel outer) {
        this.outer = outer;
    }

    //inner class inside DrawingPanel
    public void mouseClicked(MouseEvent e) {
        GameWindow.updateBoard();
        outer.repaint();
//        int x = e.getX();
//        int y = e.getY();
//        Point p = new Point(HexOperations.pxtoHex(e.getX(), e.getY()));
//        if (p.x < 0 || p.y < 0 || p.x >= GameWindow.BSIZE || p.y >= GameWindow.BSIZE) {
//            return;
//        }
//        GameWindow.board[p.x][p.y] = (int) 'X';
//        outer.repaint();
    }

}
