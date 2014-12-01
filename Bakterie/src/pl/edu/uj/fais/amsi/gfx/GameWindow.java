package pl.edu.uj.fais.amsi.gfx;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import pl.edu.uj.fais.amsi.bio.Bacteria;
import pl.edu.uj.fais.amsi.bio.MapObject;
import pl.edu.uj.fais.amsi.bio.Worm;
import pl.edu.uj.fais.amsi.main.Game;
import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Michal Szura & Bartosz Bereza
 */
public class GameWindow {

    //constants and global variables
    final static Color COLOURBACK = Color.WHITE;
    final static Color COLOURCELL = new Color(128, 128, 128, 255);//Color.ORANGE;
    final static Color COLOURGRID = Color.BLACK;
    final static Color COLOURONE = new Color(45, 136, 45, 255);
    final static Color COLOURONETXT = Color.WHITE;
    final static Color COLOURTWO = new Color(152, 219, 245, 255);
    final static Color COLOURTWOTXT = new Color(255, 88, 88);
    final static String EMPTY = "";
    final static int BSIZE = Game.rules.getBoardSize(); //board size.
    final static int HEXSIZE = 60;	//hex size in pixels
    final static int BORDERS = 15;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).

    public static String[][] board = new String[BSIZE][BSIZE];
    private static DrawingPanel panel = new DrawingPanel();

    public GameWindow() {

        initGame();
        createAndShowGUI();
    }

    void initGame() {

        HexOperations.setXYasVertex(false);

        HexOperations.setHeight(HEXSIZE);
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
                    board[i][j] = "W:" + temp.getWeight();
                }
                if (temp instanceof Bacteria) {
                    board[i][j] = "(B)";
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
                    Worm worm = (Worm) Game.getMapObject(i, j);
                    Direction wormDir = worm.getDirection();
                    if (wormDir == null) {
                        board[i][j] = "W:" + worm.getWeight() + ":";
                    } else {
                        board[i][j] = "W:" + worm.getWeight() + ":" + wormDir.toString();
                    }
                }
                if (temp instanceof Bacteria) {
                    board[i][j] = "(B)";
                }

                if (temp == null) {
                    board[i][j] = EMPTY;
                }
            }
        }
        panel.repaint();
    }
}
