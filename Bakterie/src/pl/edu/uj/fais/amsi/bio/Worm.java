package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Michał Szura
 */
public class Worm extends MapObject{
    
    private Direction wormDirection;
    private Gene gene;
    
    public Worm(){
        super();
        this.gene = new Gene();
    }
    
    public void move(){
        //TODO
    }
    
    public Direction getDirection(){
        return this.wormDirection;
    }
    
    public Direction calculateDirection(){
        //TODO
        return Direction.BOT;
    }
}
