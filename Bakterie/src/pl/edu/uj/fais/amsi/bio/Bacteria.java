package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.main.Game;

/**
 *
 * @author Michał Szura
 */
public class Bacteria extends MapObject {

    //Very Empty Class

    public Bacteria(int objectPosition) {
        super(Game.rules.getBacteriaStartingWeight(), objectPosition);
    }
}
