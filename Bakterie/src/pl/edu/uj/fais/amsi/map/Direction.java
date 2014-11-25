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
    
    public static int getDirNr(Direction i) {
        if(i == null){
            return 0;
        }
        switch (i) {
            case TOP_LEFT:
                return 0;
            case TOP:
                return 1;
            case TOP_RIGHT:
                return 2;
            case BOT_RIGHT:
                return 3;
            case BOT:
                return 4;
            case BOT_LEFT:
                return 5;
        }
        return 0;
    }
}