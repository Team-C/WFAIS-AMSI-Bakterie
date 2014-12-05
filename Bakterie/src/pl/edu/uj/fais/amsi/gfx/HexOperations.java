package pl.edu.uj.fais.amsi.gfx;

import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author Michal Szura & Bartosz Bereza
 */
public class HexOperations {

    //Constants
    public final static boolean orFLAT = true;
    public final static boolean orPOINT = false;

    public static boolean XYVertex = true;
    //true: x,y are the co-ords of the first vertex.
    //false: x,y are the co-ords of the top left rect. co-ord.

    private static int BORDERS = 50;	//default number of pixels for the border.

    private static int s = 0;	// length of one side
    private static int t = 0;	// short side of 30o triangle outside of each hex
    private static int r = 0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h = 0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

    public static void setXYasVertex(boolean b) {
        XYVertex = b;
    }

    public static void setBorders(int b) {
        BORDERS = b;
    }

    public static void setHeight(int height) {
        h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
        r = h / 2;			// r = radius of inscribed circle
        s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
        t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
    }

    public static Polygon hex(int x0, int y0) {

        int y = y0 + BORDERS;
        int x = x0 + BORDERS;
        if (s == 0 || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }

        int[] cx, cy;

        if (XYVertex) {
            cx = new int[]{x, x + s, x + s + t, x + s, x, x - t};
        } else {
            cx = new int[]{x + t, x + s + t, x + s + t + t, x + s + t, x + t, x};
        }
        cy = new int[]{y, y, y + r, y + r + r, y + r + r, y + r};
        return new Polygon(cx, cy, 6);
    }

    public static void drawHex(int i, int j, Graphics2D g2) {
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        Polygon poly = hex(x, y);
        g2.setColor(GameWindow.COLOURCELL);
        g2.fillPolygon(poly);
        g2.setColor(GameWindow.COLOURGRID);
        g2.drawPolygon(poly);
    }

    public static void fillHex(int i, int j, double wi, double hi, String n, Graphics2D g2) {
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        if (n.contains("(B)")) {
            g2.setColor(GameWindow.COLOURONE);
            g2.fillPolygon(hex(x, y));
            g2.setColor(GameWindow.COLOURONETXT);
            g2.drawString(n, (int) (x + r + BORDERS - wi / 2), (int) (y + r + BORDERS + 4));
        }
        if (n.contains("W")) {
            g2.setColor(GameWindow.COLOURTWO);
            g2.fillPolygon(hex(x, y));
            g2.setColor(GameWindow.COLOURTWOTXT);
            g2.drawString(n, (int) (x + r + BORDERS - wi / 2), (int) (y + r + BORDERS + 4));
        }
    }
}
