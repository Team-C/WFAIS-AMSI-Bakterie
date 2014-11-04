/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uj.fais.amsi.main;

/**
 *
 * @author Konrad Welc
 */
public class Game {

    private static Long x = System.nanoTime();

    public static void main(String[] args) {
    }

    //Very Fast Random
    public static long randomLong() {
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }

}
