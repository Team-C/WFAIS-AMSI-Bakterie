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

/**
 *
 * @author Konrad Welc
 */
public class GameRules {

    private final int BOARD_SIZE;
    private final int WORM_COMBAT_DAMAGE;
    private final int GENE_MAX_RANDOM_RANGE;
    private final int WORM_STARTING_WEIGHT;
    private final int WORM_WEIGHT_TRESHOLD;
    private final double WORM_SPAWN_PER_TICK;
    private final int WORM_STARTING_NUMBER;
    private final int WORM_WEIGHT_LOSS_PER_TICK;
    private final int BACTERIA_STARTING_WEIGHT;
    private final int BACTERIA_STARTING_NUMBER;
    private final double BACTERIA_SPAWN_PER_TICK;

    public GameRules() {
        BOARD_SIZE = Load("board_size");
        WORM_COMBAT_DAMAGE = Load("worm_combat_damage");
        GENE_MAX_RANDOM_RANGE = Load("gene_max_random_range");
        WORM_STARTING_WEIGHT = Load("worm_starting_weight");
        WORM_WEIGHT_TRESHOLD = Load("worm_weight_threshold");
        WORM_SPAWN_PER_TICK = LoadD("worm_spawn_per_tick");
        WORM_STARTING_NUMBER = Load("worm_starting_number");
        WORM_WEIGHT_LOSS_PER_TICK = Load("worm_weight_loss_per_tick");
        BACTERIA_STARTING_WEIGHT = Load("bacteria_starting_weight");
        BACTERIA_STARTING_NUMBER = Load("bacteria_starting_number");
        BACTERIA_SPAWN_PER_TICK = LoadD("bacteria_spawn_per_tick");
    }

    public int Load(String var) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/pl/edu/uj/fais/amsi/main/config.ini");
            // load a properties file
            prop.load(input);

            return Integer.parseInt(prop.getProperty(var));
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public double LoadD(String var) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/pl/edu/uj/fais/amsi/main/config.ini");
            // load a properties file
            prop.load(input);

            return Double.parseDouble(prop.getProperty(var));
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getWormCombatDamage() {
        return WORM_COMBAT_DAMAGE;
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public int getGeneMaxRandomRange() {
        return GENE_MAX_RANDOM_RANGE;
    }

    public int getWormStaringWeight() {
        return WORM_STARTING_WEIGHT;
    }

    public int getWormWeightThreshold() {
        return WORM_WEIGHT_TRESHOLD;
    }

    public double getWormSpawnPerTick() {
        return WORM_SPAWN_PER_TICK;
    }

    public int getWormStartingNumber() {
        return WORM_STARTING_NUMBER;
    }

    public int getWormWeightLossPerTick() {
        return WORM_WEIGHT_LOSS_PER_TICK;
    }

    public int getBacteriaStartingWeight() {
        return BACTERIA_STARTING_WEIGHT;
    }

    public int getBacteriaStartingNumber() {
        return BACTERIA_STARTING_NUMBER;
    }

    public double getBacteriaSpawnPerTick() {
        return BACTERIA_SPAWN_PER_TICK;
    }
}
