package BrightDeath;

import Items.Item;

public class Storage {
    
    private Item[] inv;
    
    
    public Storage()
    {
     inv = new Item[20];
    }
    
    public boolean add(Item i)
    {
        for (int k = 0; k < inv.length; k++)
        {
            if (inv[k] == null){
                inv[k] = i;
                
                return true;
            }
        }
        return false;
    }
    
    public void remove(int index)
    {
        inv[index] = null;
    }
    
}
