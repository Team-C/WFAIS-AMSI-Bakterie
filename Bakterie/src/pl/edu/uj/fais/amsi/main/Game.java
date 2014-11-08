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
public class Game {

    private static Long x = System.nanoTime();
    private static int gene_min_random_range;
    private static int gene_max_random_range;
    private static int worm_starting_weight;
    private static int worm_weight_threshold;
    private static int worm_spawn_per_tick;
    private static int worm_spawning_number;
    private static int worm_weight_loss_per_tick;
    private static int bacteria_starting_weight;
    private static int bacteria_starting_number;
    private static int bacteria_spawn_per_tick;
    private static int tick_interval_in_seconds;
    
    /**************************************
    Methods:
    
    boolean RunGame()
    boolean LoadRules()
    int GetGeneMinRandomRange()
    int GetGeneMaxRandomRange()
    int GetWormStaringWeight()
    int GetWormWeightThreshold()
    int GetWormSpawnPerTick()
    int GetWormStartingNumber()
    int GetWormWeightLossPerTick()
    int GetBacteriaStartingWeight()
    int GetBacteriaStartingNumber()
    int GetBacteriaSpawnPerTick()
    int GetTickIntervalInSeconds()
    ******************************************/
    
    
    
    
    
    public static boolean RunGame(){
        return false;
    }
    
    public static boolean LoadRules(){
        
        Properties prop = new Properties();
	InputStream input = null;
 
	try {
 
		input = new FileInputStream("config.ini");
                // load a properties file
		prop.load(input);
                
                gene_min_random_range = Integer.parseInt(prop.getProperty("gene_min_random_range"));
                gene_max_random_range = Integer.parseInt(prop.getProperty("gene_max_random_range"));
                worm_starting_weight = Integer.parseInt(prop.getProperty("worm_starting_weight"));
                worm_weight_threshold = Integer.parseInt(prop.getProperty("worm_weight_threshold"));
                worm_spawn_per_tick = Integer.parseInt(prop.getProperty("worm_spawn_per_tick"));
                worm_spawning_number = Integer.parseInt(prop.getProperty("worm_spawning_number"));
                worm_weight_loss_per_tick = Integer.parseInt(prop.getProperty("worm_weight_loss_per_tick"));
                bacteria_starting_weight = Integer.parseInt(prop.getProperty("bacteria_starting_weight"));
                bacteria_starting_number = Integer.parseInt(prop.getProperty("bacteria_starting_number"));
                bacteria_spawn_per_tick = Integer.parseInt(prop.getProperty("bacteria_spawn_per_tick"));
                tick_interval_in_seconds = Integer.parseInt(prop.getProperty("tick_interval_in_seconds"));         
                
		
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
    
    public int GetGeneMinRandomRange(){
        return gene_min_random_range;
    }
    
    public int GetGeneMaxRandomRange(){
        return gene_max_random_range;
    }
    
    public int GetWormStaringWeight(){
        return worm_starting_weight;
    }
    
    public int GetWormWeightThreshold(){
        return worm_weight_threshold;
    }
    
    public int GetWormSpawnPerTick(){
        return worm_spawn_per_tick;
    }
    
    public int GetWormStartingNumber(){
        return worm_spawning_number;
    }
    
    public int GetWormWeightLossPerTick(){
        return worm_weight_loss_per_tick;
    }
    
    public int GetBacteriaStartingWeight(){
        return bacteria_starting_weight;
    }
    
    public int GetBacteriaStartingNumber(){
        return bacteria_starting_number;
    }
    
    public int GetBacteriaSpawnPerTick(){
        return bacteria_spawn_per_tick;
    }
    
    public int GetTickIntervalInSeconds(){
        return tick_interval_in_seconds;
    }
    

    public static void main(String[] args) {
        LoadRules();
        while(RunGame());
    }

    //Very Fast Random
    public static long randomLong() {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }

}
