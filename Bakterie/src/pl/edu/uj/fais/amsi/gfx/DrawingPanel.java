/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uj.fais.amsi.gfx;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static pl.edu.uj.fais.amsi.gfx.GameWindow.BSIZE;
import static pl.edu.uj.fais.amsi.gfx.GameWindow.COLOURBACK;
import static pl.edu.uj.fais.amsi.gfx.GameWindow.board;

/**
 *
 * @author K O M P U T E R
 */
class DrawingPanel extends JPanel {

    public DrawingPanel() {
        setBackground(COLOURBACK);

        MouseListener ml = new MouseListener(this);
        addMouseListener(ml);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        super.paintComponent(g2);
        //draw grid
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                HexOperations.drawHex(i, j, g2);
            }
        }
        //fill in hexes
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                HexOperations.fillHex(i, j, board[i][j], g2);
            }
        }
    }


}
