package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.main.Game;
import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Michał Szura
 */
public class Gene {

    private int[] directionProbabilities;
    private double[] calculatedProbabilites;

    public Gene() {
        directionProbabilities = new int[6];
        calculatedProbabilites = new double[6];

        for (int i = 0; i < directionProbabilities.length; i++) {
            directionProbabilities[i] = Game.rules.getGeneMaxRandomRange() / 6;
        }
        calculateProbabilities();
    }

    public Gene(int[] directionProbabilities) {
        this.directionProbabilities = directionProbabilities.clone();
        calculatedProbabilites = new double[6];
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
                return calculatedProbabilites[0];
            case TOP:
                return calculatedProbabilites[1];
            case TOP_RIGHT:
                return calculatedProbabilites[2];
            case BOT_RIGHT:
                return calculatedProbabilites[3];
            case BOT:
                return calculatedProbabilites[4];
            case BOT_LEFT:
                return calculatedProbabilites[5];
            default:
                return 0;
        }
    }

    public void mutate() {
        directionProbabilities[Game.randomInt(6)] = Game.randomInt(Game.rules.getGeneMaxRandomRange());
        calculateProbabilities();
    }

    private void calculateProbabilities() {
        for (int i = 0; i < 6; i++) {
            double top = Math.exp(-directionProbabilities[i]);
            double bottom = 0.0;
            for (int j = 0; j < directionProbabilities.length; j++) {
                bottom += Math.exp(-directionProbabilities[j]);
            }
            calculatedProbabilites[i] = top / bottom;
        }
    }

}
