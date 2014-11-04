package pl.edu.uj.fais.amsi.bio;

import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Michał Szura
 */
public class Gene{
    private int[] directionProbabilities;
    
    public Gene(){
        directionProbabilities = new int[6];
        //TODO random some genes.
    }
    
    public int getProbability(Direction dir){
        switch(dir){
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
    
    public void mutate(){
        //TODO
    }

    private int calculateProbabilityFor(int i) {
        //TODO
        return 0;
    }
}
