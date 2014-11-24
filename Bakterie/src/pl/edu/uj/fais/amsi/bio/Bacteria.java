package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.main.Game;

/**
 *
 * @author Michał Szura
 */
public class Bacteria extends MapObject{
    
    //Very Empty Class
    public Bacteria(){
        super();
        this.objectWeight = Game.rules.getBacteriaStartingWeight();
    }
    
    public Bacteria(int objectPosition){
        super();
        this.objectWeight = Game.rules.getBacteriaStartingWeight();
        this.objectPosition = objectPosition;
    }
}
