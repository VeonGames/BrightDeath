package BrightDeath;
import java.util.List;

public class Quest 
{
    final private String name;
    final private List<Objective> theObjectives;
    final private int levelRequirement;
    
    public Quest(String name, List<Objective> theObjectives, int levelRequirement)
    {
        this.name = name;
        this.theObjectives = theObjectives;
        this.levelRequirement = levelRequirement;
    }
    
    public String name()
    {
        return name;
    }
    
    public List<Objective> getObjectives()
    {
        return theObjectives;
    }
}