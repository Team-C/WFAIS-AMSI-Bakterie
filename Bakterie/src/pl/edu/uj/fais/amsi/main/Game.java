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
import javax.swing.SwingUtilities;
import pl.edu.uj.fais.amsi.bio.Bacteria;
import pl.edu.uj.fais.amsi.bio.Gene;
import pl.edu.uj.fais.amsi.bio.MapObject;
import pl.edu.uj.fais.amsi.gfx.GameWindow;
import pl.edu.uj.fais.amsi.map.Direction;
import pl.edu.uj.fais.amsi.map.Map;

/**
 *
 * @author Konrad Welc
 */
public class Game {

    private static long x = System.nanoTime();
    private static Map map;
    public static GameRules rules;

    public static boolean runGame() {
        return false;
    }

    public static void main(String[] args) {
        rules = new GameRules();
        map = new Map();
        //while (runGame());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameWindow();
            }
        });
    }

    public static void updateMap() {
        map.updateOnTick();
    }

    public static MapObject getMapObject(int x, int y) {
        return map.getMapObject(x, y);
    }

    //Very Fast Random
    public static int randomInt() {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        int out = (int) x;
        return (out < 0) ? -out : out;
    }

    public static int randomInt(int max) {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        int out = (int) x % max;
        return (out < 0) ? -out : out;
    }

}
