/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Quest;

import Items.Item;
import java.util.List;

/**
 *
 * @author Nicno90
 */
public class CollectQuest extends Quest
{
    private int posses;
    private final int total;
    private Item coli;
    
    public CollectQuest(String name, int txtNum, int x, int y, List<Item> loot, int money, int xp, int levelRequirement, Item i, int amount)
    {
        super(name, txtNum, x, y, loot, money, xp, levelRequirement);
        coli = i;
        total = amount;
        
    }
    
}
