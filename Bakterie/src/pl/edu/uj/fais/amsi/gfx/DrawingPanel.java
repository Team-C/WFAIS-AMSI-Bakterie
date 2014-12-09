package pl.edu.uj.fais.amsi.gfx;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import static java.awt.SystemColor.text;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import static pl.edu.uj.fais.amsi.gfx.GameWindow.BSIZE;
import static pl.edu.uj.fais.amsi.gfx.GameWindow.COLOURBACK;
import static pl.edu.uj.fais.amsi.gfx.GameWindow.board;

/**
 *
 * @author Michal Szura & Bartosz Bereza
 */
class DrawingPanel extends JPanel {

    public DrawingPanel() {
        setBackground(COLOURBACK);

        MouseListener ml = new MouseListener(this);
        addMouseListener(ml);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        FontRenderContext frc = g2.getFontRenderContext();
        Font font = g.getFont();
        String hexText = " ";
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
                if (!board[i][j].equals("")) {
                    hexText = board[i][j];
                }
                TextLayout layout = new TextLayout(hexText, font, frc);
                Rectangle2D bounds = layout.getBounds();
                double w = bounds.getWidth();
                double h = bounds.getHeight();
                HexOperations.fillHex(i, j, w, h, board[i][j], i, j, g2);
            }
        }
    }

}
