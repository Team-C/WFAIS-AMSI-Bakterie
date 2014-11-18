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
    private static int GENE_MIN_RANDOM_RANGE;
    private static int GENE_MAX_RANDOM_RANGE;
    private static int WORM_STARTING_WEIGHT;
    private static int WORM_WEIGHT_TRESHOLD;
    private static int WORM_SPAWN_PER_TICK;
    private static int WORM_SPAWNING_NUMBER;
    private static int WORM_WEIGHT_LOSS_PER_TICK;
    private static int BACTERIA_STARTING_WEIGHT;
    private static int BACTERIA_STARTING_NUMBER;
    private static int BACTERIA_SPAWN_PER_TICK;
    private static int TICK_INTERVAL_IN_SECONDS;

    public static boolean runGame() {
        return false;
    }

    public static boolean loadRules() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.ini");
            // load a properties file
            prop.load(input);

            GENE_MIN_RANDOM_RANGE = Integer.parseInt(prop.getProperty("gene_min_random_range"));
            GENE_MAX_RANDOM_RANGE = Integer.parseInt(prop.getProperty("gene_max_random_range"));
            WORM_STARTING_WEIGHT = Integer.parseInt(prop.getProperty("worm_starting_weight"));
            WORM_WEIGHT_TRESHOLD = Integer.parseInt(prop.getProperty("worm_weight_threshold"));
            WORM_SPAWN_PER_TICK = Integer.parseInt(prop.getProperty("worm_spawn_per_tick"));
            WORM_SPAWNING_NUMBER = Integer.parseInt(prop.getProperty("worm_spawning_number"));
            WORM_WEIGHT_LOSS_PER_TICK = Integer.parseInt(prop.getProperty("worm_weight_loss_per_tick"));
            BACTERIA_STARTING_WEIGHT = Integer.parseInt(prop.getProperty("bacteria_starting_weight"));
            BACTERIA_STARTING_NUMBER = Integer.parseInt(prop.getProperty("bacteria_starting_number"));
            BACTERIA_SPAWN_PER_TICK = Integer.parseInt(prop.getProperty("bacteria_spawn_per_tick"));
            TICK_INTERVAL_IN_SECONDS = Integer.parseInt(prop.getProperty("tick_interval_in_seconds"));

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
        return GENE_MIN_RANDOM_RANGE;
    }

    public static int getGeneMaxRandomRange() {
        return GENE_MAX_RANDOM_RANGE;
    }

    public static int getWormStaringWeight() {
        return WORM_STARTING_WEIGHT;
    }

    public static int getWormWeightThreshold() {
        return WORM_WEIGHT_TRESHOLD;
    }

    public static int getWormSpawnPerTick() {
        return WORM_SPAWN_PER_TICK;
    }

    public static int getWormStartingNumber() {
        return WORM_SPAWNING_NUMBER;
    }

    public static int getWormWeightLossPerTick() {
        return WORM_WEIGHT_LOSS_PER_TICK;
    }

    public static int getBacteriaStartingWeight() {
        return BACTERIA_STARTING_WEIGHT;
    }

    public static int getBacteriaStartingNumber() {
        return BACTERIA_STARTING_NUMBER;
    }

    public static int getBacteriaSpawnPerTick() {
        return BACTERIA_SPAWN_PER_TICK;
    }

    public static int getTickIntervalInSeconds() {
        return TICK_INTERVAL_IN_SECONDS;
    }

    public static void main(String[] args) {
        loadRules();
        while (runGame());
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
