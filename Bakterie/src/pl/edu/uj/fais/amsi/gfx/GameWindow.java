/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uj.fais.amsi.gfx;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import pl.edu.uj.fais.amsi.bio.Bacteria;
import pl.edu.uj.fais.amsi.bio.MapObject;
import pl.edu.uj.fais.amsi.bio.Worm;
import pl.edu.uj.fais.amsi.main.Game;

/**
 *
 * @author student
 */
public class GameWindow {

    //constants and global variables
    final static Color COLOURBACK = Color.WHITE;
    final static Color COLOURCELL = Color.ORANGE;
    final static Color COLOURGRID = Color.BLACK;
    final static Color COLOURONE = new Color(255, 255, 255, 200);
    final static Color COLOURONETXT = Color.BLUE;
    final static Color COLOURTWO = new Color(0, 0, 0, 200);
    final static Color COLOURTWOTXT = new Color(255, 100, 255);
    final static int EMPTY = 0;
    final static int BSIZE = 15; //board size.
    final static int HEXSIZE = 60;	//hex size in pixels
    final static int BORDERS = 15;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).

    public static int[][] board = new int[BSIZE][BSIZE];
    private static DrawingPanel panel = new DrawingPanel();
    final static int WAITTIME = Game.rules.getTickIntervalInSeconds();

    public GameWindow() {

        initGame();
        createAndShowGUI();
    }

    void initGame() {

        HexOperations.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

        HexOperations.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
        HexOperations.setBorders(BORDERS);

        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                board[i][j] = EMPTY;
            }
        }

        //set up board here
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                MapObject temp = Game.getMapObject(i, j);
                if (temp instanceof Worm) {
                    board[i][j] = (int) 'W';
                }
                if (temp instanceof Bacteria) {
                    board[i][j] = (int) 'B';
                }
            }
        }

    }

    private void createAndShowGUI() {

        JFrame frame = new JFrame("Hex Game Of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.add(panel);
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        frame.setSize((int) (SCRSIZE / 1.23), SCRSIZE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void updateBoard() {
        Game.updateMap();
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE; j++) {
                MapObject temp = Game.getMapObject(i, j);
                if (temp instanceof Worm) {
                    board[i][j] = (int) 'W';
                }
                if (temp instanceof Bacteria) {
                    board[i][j] = (int) 'B';
                }

                if (temp == null) {
                    board[i][j] = EMPTY;
                }
            }
        }
        panel.repaint();
    }
}
