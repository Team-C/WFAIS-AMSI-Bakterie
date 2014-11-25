package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.main.Game;
import pl.edu.uj.fais.amsi.map.Direction;
import pl.edu.uj.fais.amsi.map.Map;

/**
 *
 * @author Michał Szura
 */
public class Worm extends MapObject {

    private Direction wormDirection;
    private Gene gene;

    public Worm() {
        super(Game.rules.getWormStaringWeight());
        this.gene = new Gene();
    }

    public Worm(int objectPosition) {
        super(Game.rules.getWormStaringWeight(), objectPosition);
        this.gene = new Gene();
    }

    public Worm(Direction wormDirection, Gene gene, int objectPosition, int objectWeight) {
        super(objectWeight, objectPosition);
        this.wormDirection = wormDirection;
        this.gene = new Gene(gene);
    }

    /**
     *
     */
    @Override
    public void updateOnColision(MapObject object) {
        if (object instanceof Worm) {//Bite, Don't Move
            object.decreaseWeight(5);
            this.increaseWeight(5);
            Map.setMapObject(object);
            System.out.println("    FIGHT! FIGHT! FIGHT!");
        }
        if (object instanceof Bacteria) {
            this.increaseWeight(object.getWeight());
            if (canSplit()) {//Split
                System.out.println("    Split");
                Worm newWorm = new Worm(this.wormDirection, this.gene, object.getPosition(), this.getWeight() / 2);
                this.decreaseWeight(this.getWeight() / 2);
                this.gene.mutate();
                Map.setMapObject(this);
                Map.setMapObject(newWorm);
            } else {//Move
                int temp = this.getPosition();
                this.setPosition(object.getPosition());
                Map.setMapObject(this);
                Map.nullPosition(temp);
            }
        }
    }

    /**
     *
     */
    @Override
    public void updateOnTick() {
        //System.out.println("Update");
        this.decreaseWeight(Game.rules.getWormWeightLossPerTick());
    }

    public void move(int destination) {
        this.setPosition(destination);
    }

    public Direction getDirection() {
        return this.wormDirection;
    }

    public Direction calculateDirection() {
        double[] probabilites = new double[6];
        for (int i = 0; i < 6; i++) {
            probabilites[i] = gene.getProbability(Direction.getDir(i));
        }
        double sum = 0.0;
        int abstractNumber = 1000000;
        int temp = Game.randomInt(abstractNumber);
        double random = temp / (double) (abstractNumber - 1);// -1 because % will mean that there can be no 1.0 result
        for (int i = 0; i < 6; i++) {
            if ((sum + probabilites[i]) >= random) {
                Direction newDirection = Direction.getDir((i + Direction.getDirNr(wormDirection)) % 6);
                //System.out.println("Temp: " + temp + " Random: " + random + " AbstractNumber:" + abstractNumber);
                //gene.debugGene();
                //System.out.println("Worm: " + this.toString() + " Drirection: " + newDirection);
                wormDirection = newDirection;
                return newDirection;
            } else {
                sum += probabilites[i];
            }
        }
        return null;
    }

    /**
     * Call mutation of the gene.
     */
    public void mutateGene() {
        gene.mutate();
    }

    private boolean canSplit() {
        if (this.getWeight() >= Game.rules.getWormWeightThreshold()) {
            return true;
        } else {
            return false;
        }
    }
}
