package BrightDeath;

public class Wall {
    
    private int xcoord;
    private int ycoord;
    private String name;
    private final int type;
    
    public Wall(int x, int y, int t)
    {
        xcoord = x;//(int)((x*GV.sizeMod)+(GV.width*.5));
        ycoord = y;//(int)((y*GV.sizeMod)+(GV.height*.5));
        type = t;
        setType(t);
    }
    
    public int getXCoord()
    {
     return xcoord;
    }
    
    public int getYCoord()
    {
     return ycoord;
    }
    
    public void setXCoord(int xc)
    {
     xcoord = xc;
    }
        
    public void setYCoord(int yc)
    {
     ycoord = yc;
    }
    
    public int getType()
    {
        return type;
    }
    
    public void setType(int type)
    {
        if (type == 1)
        {
            name = "Rock";
        }
        else if (type == 2)
        {
            name = "greenTree";
        }
        else if (type == 3)
        {
            name = "Invisible";
        }
        else
        {
            name = "Wall";
        }
    }
    public String getName()
    {
        return name;
    }
}