package pl.edu.uj.fais.amsi.gfx;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import pl.edu.uj.fais.amsi.main.Game;

/**
 *
 * @author Michal Szura & Bartosz Bereza
 */
class MouseListener extends MouseAdapter {

    private final DrawingPanel outer;

    MouseListener(final DrawingPanel outer) {
        this.outer = outer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Game.runGame();
        outer.repaint();
    }

}
