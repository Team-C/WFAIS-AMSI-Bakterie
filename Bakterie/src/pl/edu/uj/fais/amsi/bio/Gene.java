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
            int temp = (int) Game.randomLong();
            directionProbabilities[i] = temp % Game.getGeneMaxRandomRange();
        }
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
        int temp = (int) Game.randomLong();
        int temp2 = (int) Game.randomLong();
        directionProbabilities[Math.abs(temp) % 6] = temp2 % Game.getGeneMaxRandomRange();
    }

    private double calculateProbabilityFor(int postition) {
        double top = Math.exp(-directionProbabilities[postition]);
        double bottom = 0.0;
        for (int i = 0; i < directionProbabilities.length; i++) {
            bottom += Math.exp(-directionProbabilities[i]);
        }
        return top/bottom;
    }
}
