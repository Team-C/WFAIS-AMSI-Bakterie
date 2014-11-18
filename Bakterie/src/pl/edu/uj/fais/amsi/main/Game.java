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
import pl.edu.uj.fais.amsi.bio.Gene;
import pl.edu.uj.fais.amsi.map.Direction;

/**
 *
 * @author Konrad Welc
 */
public class Game {

    private static Long x = System.nanoTime();
    private static int geneMinRandomRange;
    private static int geneMaxRandomRange;
    private static int wormStartingWeight;
    private static int wormWeightThreshold;
    private static int wormSpawnPerTick;
    private static int wormSpawningNumber;
    private static int wormWeightLossPerTick;
    private static int bacteriaStartingWeight;
    private static int bacteriaStartingNumber;
    private static int bacteriaSpawnPerTick;
    private static int tickIntervalInSeconds;

    public static boolean RunGame() {
        return false;
    }

    public static boolean LoadRules() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.ini");
            // load a properties file
            prop.load(input);

            geneMinRandomRange = Integer.parseInt(prop.getProperty("gene_min_random_range"));
            geneMaxRandomRange = Integer.parseInt(prop.getProperty("gene_max_random_range"));
            wormStartingWeight = Integer.parseInt(prop.getProperty("worm_starting_weight"));
            wormWeightThreshold = Integer.parseInt(prop.getProperty("worm_weight_threshold"));
            wormSpawnPerTick = Integer.parseInt(prop.getProperty("worm_spawn_per_tick"));
            wormSpawningNumber = Integer.parseInt(prop.getProperty("worm_spawning_number"));
            wormWeightLossPerTick = Integer.parseInt(prop.getProperty("worm_weight_loss_per_tick"));
            bacteriaStartingWeight = Integer.parseInt(prop.getProperty("bacteria_starting_weight"));
            bacteriaStartingNumber = Integer.parseInt(prop.getProperty("bacteria_starting_number"));
            bacteriaSpawnPerTick = Integer.parseInt(prop.getProperty("bacteria_spawn_per_tick"));
            tickIntervalInSeconds = Integer.parseInt(prop.getProperty("tick_interval_in_seconds"));

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

    public static int getGeneMinRandomRange() {
        return geneMinRandomRange;
    }

    public static int getGeneMaxRandomRange() {
        return geneMaxRandomRange;
    }

    public static int getWormStaringWeight() {
        return wormStartingWeight;
    }

    public static int getWormWeightThreshold() {
        return wormWeightThreshold;
    }

    public static int getWormSpawnPerTick() {
        return wormSpawnPerTick;
    }

    public static int getWormStartingNumber() {
        return wormSpawningNumber;
    }

    public static int getWormWeightLossPerTick() {
        return wormWeightLossPerTick;
    }

    public static int getBacteriaStartingWeight() {
        return bacteriaStartingWeight;
    }

    public static int getBacteriaStartingNumber() {
        return bacteriaStartingNumber;
    }

    public static int getBacteriaSpawnPerTick() {
        return bacteriaSpawnPerTick;
    }

    public static int getTickIntervalInSeconds() {
        return tickIntervalInSeconds;
    }

    public static void main(String[] args) {
        LoadRules();
        while (RunGame());
        Gene test = new Gene();
        for (int i = 0; i < 10; i++) {
            double x=0;
            x += test.getProbability(Direction.BOT);
            x += test.getProbability(Direction.BOT_LEFT);
            x += test.getProbability(Direction.BOT_RIGHT);
            x += test.getProbability(Direction.TOP);
            x += test.getProbability(Direction.TOP_LEFT);
            x += test.getProbability(Direction.TOP_RIGHT);
            System.out.print(test.getProbability(Direction.TOP_LEFT)+"|");
            System.out.print(test.getProbability(Direction.TOP)+"|");
            System.out.print(test.getProbability(Direction.TOP_RIGHT)+"|");
            System.out.print(test.getProbability(Direction.BOT_RIGHT)+"|");
            System.out.print(test.getProbability(Direction.BOT)+"|");
            System.out.print(test.getProbability(Direction.BOT_LEFT)+"|");
            System.out.println("|SUM: "+x+"||");
            test.mutate();
        }
    }

    //Very Fast Random
    public static long randomLong() {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }

}
