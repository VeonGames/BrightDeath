package BrightDeath;

public class AttackBox
{
    private int xPosition;
    private int yPosition;
    private final int type;
    
    public AttackBox(int xPosition, int yPosition, int type)
    {
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.type=type;
    }
    
    public int getType()
    {
        return type;
    }
    
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    public void setXPosition(int x)
    {
        xPosition = x;
    }
    
    public void setYPosition(int y)
    {
        yPosition = y;
    }
}