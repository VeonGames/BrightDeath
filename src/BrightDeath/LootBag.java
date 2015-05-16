/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BrightDeath;

import Items.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicno90
 */
public class LootBag 
{
    private List<Item> loot;
    public static final String name = "Loot";
    private int x, y;
    private boolean looted;
    private int size;
    public LootBag(int x, int y, int maxLoot)
    {
        
        loot = new ArrayList();
        looted = false;
        this.x = x;
        this.y = y;
        size = (int) (Math.random() * maxLoot) + 1;
        for (int k = 0; k < size; k++)
        {
            loot.add(GV.drops.get((int) (Math.random() * GV.drops.size())));
        }
    }

    public int getSize()
    {
        return size;
    }

    public List<Item> getLoot()
    {
        return loot;
    }

    public int getX()
    {
        return x;
    }

    public void setLooted(boolean looted)
    {
        this.looted = looted;
    }

    public void setLoot(List<Item> loot)
    {
        this.loot = loot;
    }

    public boolean isLooted()
    {
        return looted;
    }
    
    public int getY()
    {
        return y;
    }
    
}
