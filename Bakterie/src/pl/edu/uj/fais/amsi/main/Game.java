/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uj.fais.amsi.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import pl.edu.uj.fais.amsi.bio.Bacteria;
import pl.edu.uj.fais.amsi.bio.Gene;
import pl.edu.uj.fais.amsi.map.Direction;
import pl.edu.uj.fais.amsi.map.Map;

/**
 *
 * @author Konrad Welc
 */
public class Game {

    private static Long x = System.nanoTime();
    public static GameRules rules;

    public static boolean runGame() {
        return false;
    }

    public static void main(String[] args) {
        rules = new GameRules();
        while (runGame());
        Gene test = new Gene();
        
        /*
        for (int i = 0; i < 10; i++) {
            double x = 0;
            x += test.getProbability(Direction.BOT);
            x += test.getProbability(Direction.BOT_LEFT);
            x += test.getProbability(Direction.BOT_RIGHT);
            x += test.getProbability(Direction.TOP);
            x += test.getProbability(Direction.TOP_LEFT);
            x += test.getProbability(Direction.TOP_RIGHT);
            System.out.print(test.getProbability(Direction.TOP_LEFT) + "|");
            System.out.print(test.getProbability(Direction.TOP) + "|");
            System.out.print(test.getProbability(Direction.TOP_RIGHT) + "|");
            System.out.print(test.getProbability(Direction.BOT_RIGHT) + "|");
            System.out.print(test.getProbability(Direction.BOT) + "|");
            System.out.print(test.getProbability(Direction.BOT_LEFT) + "|");
            System.out.println("|SUM: " + x + "||");
            test.mutate();
        }
        */
        
        Map M = new Map();
        M.debugPrint();
    }

    //Very Fast Random
    public static long randomLong() {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }

}
