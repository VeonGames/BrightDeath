package BrightDeath;

public class Monster {
    
    private final int type;
    private int monsterX;
    private int monsterY;
    private boolean alive = true;
    private final int[] dropRates;
    private String name;
    private final int id;
    private static int nextMonsterNum = 0;
    private int maxLoot;
    
    public Monster(int t)
    {
        dropRates = new int[GV.drops.size()];
        id = nextMonsterNum;
        nextMonsterNum++;
        name = "Monster";
        type = t;
        
        setType(t);
    }

    public int getType()
    {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isAlive()
    {
     return alive;
    }
    public void setAlive(boolean living)
    {
        alive = living;
    }
    
    public void setID()
    {
        
    }
    public int getMonsterX()
    {
        return monsterX;//(monsterX+((int) (GV.width*.5)));
    }
    
    public int getMonsterY()
    {
        return monsterY;//(monsterY+((int) (GV.height*.5)));
    }
    
    public void setMonsterX(int a)
    {
        monsterX = a;
    }
    
    public void setMonsterY(int a)
    {
        monsterY = a;
    }
    public boolean wasHit()
    {
        return true;
    }
    
    

    public void setType(int t) 
    {
        maxLoot = 10;
        if (t == 100)
        {
            name = "Bill";
        }
        else if (t == 0)
        {
            name = "Monster";
        }
        else if (t == 1)
        {
            name = "WhiteWolf";
        }
        else if (t == 2)
        {
            name = "BaoBot";
        }
        else if (t == 3)
        {
            name = "Goblin";
            maxLoot = 12;
        }
        else if (t == 6)
        {
            name = "Ghastiel";
        }
    }

    public int getMaxLoot()
    {
        return maxLoot;
    }
    
}