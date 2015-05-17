package Quest;
import Items.Item;
import java.util.List;

public class Quest 
{
    final private String name;
    int x;
    int y;
    List<Item> loot;
    int money;
    int xp;
    final private int levelRequirement;
    
    public Quest(String name, int txtNum, int x, int y, List<Item> loot, int money, int xp, int levelRequirement)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.loot = loot;
        this.money = money;
        this.xp = xp;
        this.levelRequirement = levelRequirement;
    }
    
    
    
    public String getName()
    {
        return name;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public List<Item> getLoot()
    {
        return loot;
    }

    public int getMoney()
    {
        return money;
    }

    public int getXp()
    {
        return xp;
    }

    public int getLevelRequirement()
    {
        return levelRequirement;
    }
    
    
    public String name()
    {
        return name;
    }
    
    
}