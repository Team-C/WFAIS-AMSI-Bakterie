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

import pl.edu.uj.fais.amsi.main.Game;
import pl.edu.uj.fais.amsi.main.GameRules;

/**
 *
 * @author Wit
 */
public class Map
{
    private int size_x = 15;
    private int size_y = 15;
    
    private MapObject tiles[] = new MapObject[size_x * size_y];
    
    public Map()
    {
       for(int i=0; i<size_x*size_y; ++i)
           tiles[i] = null;
       
       // spawning starting entities
       spawnBacterias(Game.rules.getBacteriaStartingNumber());
       spawnWorms(Game.rules.getWormStartingNumber());
       
       
       
       
/*
        Mapa w UpdateOnTick() wywołuje swoje prywatne funkcje w takiej kolejności:
            MakeMove():
                W pętli dla każdego Worm na planszy wywoływana jest funkcja CalculateDirection(), która tylko i wyłącznie losuje kierunek według zadanego wzoru. Zmienia pole worm_direction.
                W pętli dla każdego Worm na planszy sprawdzana jest poprawność ruchu (kolizja, wyjście poza planszę itd) i zgodnie z narzuconą przez pętlę kolejnością, wykonywane są poprawne ruchy (wywoływane są funkcje Move() w klasie Worm które modyfikują pole object_position). Jeżeli nastąpiła kolizja Worm->Bacteria wywołana jest funkcja UpdateOnColision() w obiekcie Worm i Bacteria. W tej funkcji należy przenieść wagę z bakterii do robaka.
                W pętli dla każdego obiektu na planszy wywołana jest funkcja UpdateOnTick(), która powinna ustawć pole is_alive na false, jeżeli waga jest równa zero.
            RemoveDeadObjects() - funkcja usuwa z mapy martwe obiekty.
            CheckWeightThreshold() - funkcja iteruje po Worms na planszy i w razie przekroczenia wagi usuwa starego robaka i tworzy dwa nowe wywołując na każdym z nich MutateGene(), które wywołuje Mutate() w klasie Gene (losowy wybór jednej z 6 licz i przelosowanie jej).
            SpawnBacterias() - funckja dodaje nowe bakterie na mapie.
            SpawnWorms() - funckja dodaje nowe robaki na mapie.
        Mapa przygotowuje się do kolejnego ticku.
*/
    }
    
    private boolean isValidLocation(int tileId)
    {
        int x = tileId%size_x;
        int y = tileId/size_y;
                
        if(x < 0 || x >= size_x)
            return false;
        else if(y < 0 || y >= size_y)
            return false;
        else if(y == size_y-1 && x%2 == 1)
            return false;
        else if(tiles[tileId] != null)
            return false;
        else
            return true;
    }
    
    private void removeDeadObjects()
    {
        
    }
    
    private void spawnBacterias(int n)
    {
        int index = 0;
        while(n != 0)
        {
            index = ((int)Game.randomLong()) % (size_x*size_y);
            if(isValidLocation(index) == true)
            {
                --n;
                tiles[index] = new Bacteria();
            }
        }
    }
    
    private void spawnWorms(int n)
    {
        int index = 0;
        while(n != 0)
        {
            index = ((int)Game.randomLong()) % (size_x*size_y);
            if(isValidLocation(index) == true)
            {
                --n;
                tiles[index] = new Worm();
            } 
        }
    }
    
    private void checkWeightThresholds()
    {
        
    }
    
    private void makeMoves()
    {
        
    }
    
    public void updateOnTick()
    {
        
    }
    
    public MapObject getMapObject(int tileId)
    {
        return getMapObject(tileId%size_x, tileId/size_y);
    }
    
    public MapObject getMapObject(int x, int y)
    {
        if(x < 0 || x >= size_x)
            return null;
        else if(y < 0 || y >= size_y)
            return null;
        else if(y == size_y-1 && x%2 == 1)
            return null;
        else
            return tiles[x + y*size_x];
    }
    
    public void debugPrint()
    {
        System.out.println("---------- DEBUG PRINT ----------");
        System.out.println("W - Worm");
        System.out.println("b - Bacteria");
        System.out.println(". - Empty slot");
        System.out.println();
        
        for(int y=0; y<size_y; ++y)
        {
            for(int x=0; x<size_x; x+=2)
            {
                if(tiles[x + y*size_x] instanceof Worm)
                    System.out.print("W   ");
                else if(tiles[x + y*size_x] instanceof Bacteria)
                    System.out.print("b   ");
                else
                    System.out.print(".   ");
            }
            
            System.out.print("" + y + "\n  ");
            if(y == size_y-1) break;
            
            for(int x=1; x<size_x; x+=2)
            {
                if(tiles[x + y*size_x] instanceof Worm)
                    System.out.print("W   ");
                else if(tiles[x + y*size_x] instanceof Bacteria)
                    System.out.print("b   ");
                else
                    System.out.print(".   ");
            }
            
            System.out.print("\n");
        }
    }
    
}
