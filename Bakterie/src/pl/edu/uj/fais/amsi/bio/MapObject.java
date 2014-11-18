package pl.edu.uj.fais.amsi.bio;

/**
 *
 * @author Michał Szura
 */
public class MapObject {

    protected int objectPosition;
    protected int objectWeight;
    protected boolean objectIsAlive;
    
    public MapObject(){
        this.objectIsAlive = true;
    }
    
    public MapObject(int objectPosition){
        this.objectIsAlive = true;
        this.objectPosition = objectPosition;
    }

    /**
     * 
     */
    public void updateOnColision() {
        //TODO
    }

    /**
     * 
     */
    public void updateOnTick() {
        //TODO
    }

    /**
     * Returns Objects position.
     */
    public int getPosition() {
        return this.objectPosition;
    }

    /**
     * Returns Objects weight.
     */
    public int getWeight() {
        return this.objectWeight;
    }

    /**
     * Returns Objects alive status.
     */
    public boolean isAlive() {
        return this.objectIsAlive;
    }

}
