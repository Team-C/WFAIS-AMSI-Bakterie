package pl.edu.uj.fais.amsi.map;

/**
 *
 * @author Wit
 */
public enum Direction {
    TOP,TOP_LEFT,TOP_RIGHT,BOT,BOT_LEFT,BOT_RIGHT;
    
    public static Direction getDir(int i) {
        switch (i) {
            case 0:
                return TOP_LEFT;
            case 1:
                return TOP;
            case 2:
                return TOP_RIGHT;
            case 3:
                return BOT_RIGHT;
            case 4:
                return BOT;
            case 5:
                return BOT_LEFT;
        }
        return null;
    }
}