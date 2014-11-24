package pl.edu.uj.fais.amsi.bio;

import java.util.ArrayList;
import java.util.List;
import pl.edu.uj.fais.amsi.main.Game;
import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Michał Szura
 */
public class Worm extends MapObject {

    private Direction wormDirection;
    private Gene gene;

    public Worm() {
        super();
        this.objectWeight = Game.rules.getWormStaringWeight();
        this.gene = new Gene();
    }
    
    public Worm(int objectPosition) {
        super();
        this.objectWeight = Game.rules.getWormStaringWeight();
        this.gene = new Gene();
        this.objectPosition = objectPosition;
    }

    /**
     *
     */
    @Override
    public void updateOnColision(MapObject object) {
        //TODO
    }

    /**
     *
     */
    @Override
    public void updateOnTick() {
        //TODO
    }

    public void move(int destination) {
        //TODO
    }

    public Direction getDirection() {
        return this.wormDirection;
    }

    public Direction calculateDirection() {
        Direction ret = Direction.TOP;
        List<Double> probabilites = new ArrayList<>();
        for (Direction dir : Direction.values()) {
            probabilites.add(gene.getProbability(dir));
        }
        //TODO

        wormDirection = ret;
        return ret;
    }
}
