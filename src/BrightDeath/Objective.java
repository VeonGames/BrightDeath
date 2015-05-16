package BrightDeath;

public class Objective
{
    private int type;
    private String instructions;
    private boolean active;
    private int numberOfActions;
    private String npcGoal;
    private int monsterType;
    private int itemType;
    
    
    public Objective(String instructions, String npcGoal)
    {
        this.instructions = instructions;
        this.npcGoal = npcGoal;
        type = 0;
    }
    
    public Objective(String instructions, int numberOfActions, int goalType, int objectiveType)
    {
        this.type = type;
        this.instructions = instructions;
        this.numberOfActions = numberOfActions;
        
        if (type==1)
        {
            monsterType = goalType;
        }
        if (type==2)
        {
            itemType = goalType;
        }
    }
    
    public int getMonsterType()
    {
        return monsterType;
    }
    
    public int getItemType()
    {
        return itemType;
    }
    
    public void completeAction()
    {
        numberOfActions--;
    }
    
    public int getNumberOfActions()
    {
        return numberOfActions;
    }
    
    public boolean getActive()
    {
        return active;
    }
    
    public  void setActive(boolean active)
    {
        this.active = active;
    }
    
    public int getType()
    {
        return type;
    }
    
    public String getInstructions()
    {
        return instructions;
    }
}
