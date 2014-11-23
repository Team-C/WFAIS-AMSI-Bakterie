/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.edu.uj.fais.amsi.map;

import pl.edu.uj.fais.amsi.bio.Bacteria;
import pl.edu.uj.fais.amsi.bio.Gene;
import pl.edu.uj.fais.amsi.bio.MapObject;
import pl.edu.uj.fais.amsi.bio.Worm;

/**
 *
 * @author Wit
 */
public class Map
{
    private int size_x = 15;
    private int size_y = 15;
    
    MapObject tiles[] = new MapObject[size_x * size_y];
    
    public Map()
    {
       
    }
    
    
    
    public void debugPrint()
    {
         System.out.println("uszanowanko");
    }
    
}
