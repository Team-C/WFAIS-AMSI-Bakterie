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
            directionProbabilities[i] = Game.rules.getGeneMaxRandomRange() / 6;
        }
    }

    public Gene(int[] directionProbabilities) {
        this.directionProbabilities = directionProbabilities.clone();
        //System.arraycopy(directionProbabilities, 0, this.directionProbabilities, 0, directionProbabilities.length);
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
    
    public void debugGene(){
        System.out.print(this.toString()+" => ");
        System.out.print(calculateProbabilityFor(0)+" + ");
        System.out.print(calculateProbabilityFor(1)+" + ");
        System.out.print(calculateProbabilityFor(2)+" + ");
        System.out.print(calculateProbabilityFor(3)+" + ");
        System.out.print(calculateProbabilityFor(4)+" + ");
        System.out.print(calculateProbabilityFor(5)+" = ");
        double bottom = 0.0;
        for (int i = 0; i < directionProbabilities.length; i++) {
            bottom += calculateProbabilityFor(i);
        }
        System.out.println(bottom);
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
