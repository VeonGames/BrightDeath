/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BrightDeath;

import Items.Item;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author nicno90
 */
public class Inventory
{

    private Item[] inv;
    
    private int next = 0;

    public Inventory()
    {
        inv = new Item[20];
    }

    public void addLootBag(LootBag lootb)
    {
//        if (next == 0)
//        {
//            for (int i = 0; i < lootb.getLoot().size(); i++)
//            {
//                if (next >= 20)
//                {
//                    return;
//                }
//                inv[next] = lootb.getLoot().get(i);
//                GV.b.getItemSquares().get(next).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/" + inv[next].getName() + ".png")));
////                      System.out.println(inv[next]);
//                next++;
//
//            }
//            return;
//        }
//        boolean carryOn = true;
//        for (int i = 0; i < lootb.getLoot().size(); i++)
//        {
//            for (int k = 0; k < next; k++)
//            {
//                if (carryOn && inv[k].getName().equals(lootb.getLoot().get(i).getName()))
//                {
//                    inv[k].setAmount(inv[k].getAmount() + lootb.getLoot().get(i).getAmount());
//                    carryOn = false;
//                } else
//                {
//                    if (next >= 20)
//                    {
//                        return;
//                    }
//                    inv[next] = lootb.getLoot().get(i);
//                    GV.b.getItemSquares().get(next).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/" + inv[next].getName() + ".png")));
////                  System.out.println(inv[next]);
//                    next++;
//
//                }
//                if (carryOn)
//                    break;
//            }
//
//        }
        boolean go = true;
        for (Item i : lootb.getLoot())
        {
            for (Item j : inv)
            {
                if (j != null && j.getName().equals(i.getName()))
                {
                    go = false;
                    j.setAmount(j.getAmount() + i.getAmount());
                    break;
                }
                go = true;
            }
            if (go && next < 20)
            {
                inv[next] = i;
                GV.b.getItemSquares().get(next).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/" + inv[next].getName() + ".png")));
//                      System.out.println(inv[next]);
                next++;
                break;
            } 
            else if (next > 20)
            {
                return;
            }
        }
    }

//    public boolean add(Item i)
//    {
//
//        if (next != -1)
//        {
//            inv[next] = i;
//            GV.b.setItemText(next, inv[next].getName());
//            return true;
//        }
//        return false;
//    }
    public void remove(int index)
    {
        if (0 < index && index < 20)
        {
            return;
        }
        inv[index] = null;
        GV.b.getItemSquares().get(next).setIcon(null);
    }

    public Item get(int index)
    {
//        System.out.println(inv[index]);
//        System.out.println("here");
        return inv[index];
    }

    public int getColSize()
    {
        return inv.length;
    }

    public int getRowSize()
    {
        return inv.length;
    }

    public Item[] getInv()
    {
        return inv;
    }

}
