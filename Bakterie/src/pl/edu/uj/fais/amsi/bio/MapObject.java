package pl.edu.uj.fais.amsi.bio;

/**
 *
 * @author Michał Szura
 */
public class MapObject {

    private int objectPosition;
    private int objectWeight;
    private boolean objectIsAlive;

    public MapObject() {
        this.objectIsAlive = true;
    }

    public MapObject(int objectWeight) {
        this.objectIsAlive = true;
        this.objectWeight = objectWeight;
    }

    public MapObject(int objectWeight, int objectPosition) {
        this.objectIsAlive = true;
        this.objectWeight = objectWeight;
        this.objectPosition = objectPosition;
    }

    /**
     *
     */
    public void updateOnColision(MapObject incoming) {
        //Map Object Does Not Care For Your Collisions
    }

    /**
     *
     */
    public void updateOnTick() {
        if (objectWeight <= 0) {
            objectIsAlive = false;
        }
    }

    /**
     * @return Objects position
     */
    public int getPosition() {
        return this.objectPosition;
    }

    /**
     * @return Objects weight
     */
    public int getWeight() {
        return this.objectWeight;
    }

    /**
     * Sets Objects weight.
     *
     * @param objectWeight
     */
    public void setWeight(int objectWeight) {
        this.objectWeight = objectWeight;
    }

    public void decreaseWeight(int decrease) {
        this.objectWeight -= decrease;
        if (this.objectWeight <= 0) {
            this.objectIsAlive = false;
            System.out.println("   Worm Starved! " + this.toString());
        }
    }

    public void increaseWeight(int increase) {
        this.objectWeight += increase;
    }

    /**
     * Sets Objects position.
     *
     * @param objectPosition
     */
    public void setPosition(int objectPosition) {
        this.objectPosition = objectPosition;
    }

    /**
     * Returns Objects alive status.
     */
    public boolean isAlive() {
        return this.objectIsAlive;
    }

    public void setIsAlive(boolean objectIsAlive) {
        this.objectIsAlive = objectIsAlive;
    }

}
