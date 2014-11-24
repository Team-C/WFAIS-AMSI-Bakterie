/*______________________________________________________________________________

Author:     Wit Szoniec

File:       Map.java
Version:    0.1

To do:
- wszystko :(

Optional:
- lepszy sposób znajdowania losowego pustego miejsca na planszy,
  dla prawie pełnej planszy może trwać wieki...
- osobny kontener dla obiektów, aby nie trzeba było przeszukiwać całej mapy
______________________________________________________________________________*/

package pl.edu.uj.fais.amsi.map;

import pl.edu.uj.fais.amsi.bio.Bacteria;
import pl.edu.uj.fais.amsi.bio.MapObject;
import pl.edu.uj.fais.amsi.bio.Worm;
import pl.edu.uj.fais.amsi.main.Game;

public class Map
{
    private final int size_x = 15;
    private final int size_y = 15;
    
    private final MapObject tiles[] = new MapObject[size_x * size_y];
    
    public Map()
    {
        for(int i=0; i<size_x*size_y; ++i)
            tiles[i] = null;
       
        // spawning starting entities
        spawnBacterias(Game.rules.getBacteriaStartingNumber());
        spawnWorms(Game.rules.getWormStartingNumber());

        debugPrint();
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
    
    private int getNeighbour(int tileId, Direction d)
    {
        int x = tileId%size_x;
        int y = tileId/size_y;
        int neighbourId = 0;
        
        if(x < 0 || x >= size_x)
            return -1;
        else if(y < 0 || y >= size_y)
            return -1;
        else if(y == size_y-1 && x%2 == 1)
            return -1;
        
        if(d == Direction.TOP)
        {
            if(y == 0) return -2;
            
            if(x%2 == 0)
            {
                neighbourId = tileId - size_x;
            }
            else
            {
                neighbourId = tileId - size_x;
            }
        }  
        else if(d == Direction.TOP_RIGHT)
        {
            if(x%2 == 0)
            {
                if(x == size_x-1) return -2;
                if(y == 0) return -2;
                neighbourId = tileId - size_x + 1;
            }
            else
            {
                neighbourId = tileId + 1;
            }
        }   
        else if(d == Direction.TOP_LEFT)
        {
            if(x%2 == 0)
            {
                if(y == 0) return -2;
                if(x == 0) return -2;
                neighbourId = tileId - size_x - 1;
            }
            else
            {
                neighbourId = tileId - 1;
            }
        }   
        else if(d == Direction.BOT)
        {
            if(y == size_y-1) return -2;
            
            if(x%2 == 0)
            {
                neighbourId = tileId + size_x;
            }
            else
            {
                if(y == size_y-2) return -2;
                neighbourId = tileId + size_x;
            }
        }   
        else if(d == Direction.BOT_RIGHT)
        {
            if(x%2 == 0)
            {
                if(x == size_x-1) return -2;
                if(y == size_y-1) return -2;
                neighbourId = tileId + 1;
            }
            else
            {
                neighbourId = tileId + size_x + 1;
            }
        }
        else if(d == Direction.BOT_LEFT)
        {
            if(x%2 == 0)
            {
                if(x == 0) return -2;
                if(y == size_y-1) return -2;
                neighbourId = tileId - 1;
            }
            else
            {
                neighbourId = tileId + size_x - 1;
            }
        }

        return neighbourId;
    }
    
    private void removeDeadObjects()
    {
        for(int i=0; i<size_x*size_y; ++i)
        {
            if(tiles[i].isAlive() == false)
                tiles[i] = null;
        }
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
    
    private void makeMoves()
    {
        /*
            W pętli dla każdego Worm na planszy wywoływana jest funkcja
            CalculateDirection(), która tylko i wyłącznie losuje kierunek według
            zadanego wzoru. Zmienia pole worm_direction.
            
            W pętli dla każdego Worm na planszy sprawdzana jest poprawność ruchu
            (kolizja, wyjście poza planszę itd) i zgodnie z narzuconą przez pętlę
            kolejnością, wykonywane są poprawne ruchy (wywoływane są funkcje Move()
            w klasie Worm które modyfikują pole object_position).
            Jeżeli nastąpiła kolizja Worm->Bacteria wywołana jest funkcja
            UpdateOnColision() w obiekcie Worm i Bacteria.
            W tej funkcji należy przenieść wagę z bakterii do robaka.
            
            W pętli dla każdego obiektu na planszy wywołana jest funkcja
            UpdateOnTick(), która powinna ustawć pole is_alive na false,
            jeżeli waga jest równa zero.
        */
    }
    
    public void updateOnTick()
    {
        // executing moves
        makeMoves();
        
        // removing dead objects
        removeDeadObjects();
        
        // spawning starting entities
        spawnBacterias(Game.rules.getBacteriaSpawnPerTick());
        spawnWorms(Game.rules.getWormSpawnPerTick());
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
        
        System.out.print("\n");
    }   
}
