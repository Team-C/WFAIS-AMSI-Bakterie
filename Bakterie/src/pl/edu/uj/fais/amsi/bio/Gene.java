package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.main.Game;
import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Michał Szura
 */
public class Gene {

    private int[] directionProbabilities;

    public Gene() {
        directionProbabilities = new int[6];
        for (int i = 0; i < directionProbabilities.length; i++) {
            directionProbabilities[i] = Game.randomInt(Game.rules.getGeneMaxRandomRange());
        }
    }

    public Gene(int[] directionProbabilities) {
        System.arraycopy(directionProbabilities, 0, this.directionProbabilities, 0, directionProbabilities.length);
    }

    /**
     * Copy constructor.
     *
     * @param gene
     */
    public Gene(Gene gene) {
        this(gene.directionProbabilities);
        mutate();
    }

    public double getProbability(Direction dir) {
        switch (dir) {
            case TOP_LEFT:
                return calculateProbabilityFor(0);
            case TOP:
                return calculateProbabilityFor(1);
            case TOP_RIGHT:
                return calculateProbabilityFor(2);
            case BOT_RIGHT:
                return calculateProbabilityFor(3);
            case BOT:
                return calculateProbabilityFor(4);
            case BOT_LEFT:
                return calculateProbabilityFor(5);
            default:
                return 0;
        }
    }

    public void mutate() {
        directionProbabilities[Game.randomInt(6)] = Game.randomInt(Game.rules.getGeneMaxRandomRange());
    }

    private double calculateProbabilityFor(int postition) {
        double top = Math.exp(-directionProbabilities[postition]);
        double bottom = 0.0;
        for (int i = 0; i < directionProbabilities.length; i++) {
            bottom += Math.exp(-directionProbabilities[i]);
        }
        return top / bottom;
    }

}
