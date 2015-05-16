package BrightDeath;

public class OtherPlayer{
    
    private int xPos;
    private int yPos;
    private boolean[] attack = new boolean[4];
    private final boolean city;
    
    public OtherPlayer(int x, int y) 
    {
    
     xPos = x;
     yPos = y;
     for (int i=0;i<4;i++)
     {
      attack[i] = false;
     }
     city = false;
    }
    
    public void setAttacking(int direction, boolean isAttacking)
    {
     attack[direction] = isAttacking;
    }
    
    public boolean city()
    {
        return city;
    }
    
    public boolean isAttacking(int direction)
    {
     return attack[direction];
    }
    
    public void setXpos(int x)
    {
     xPos = x;
    }
    
    public void setYpos(int y)
    {
     yPos = y;
    }
    
    public int getXpos()
    {
     return xPos;
    }
    
    public int getYpos()
    {
     return yPos;
    }
}
