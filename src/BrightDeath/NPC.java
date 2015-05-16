package BrightDeath;

import java.util.List;

public class NPC {

    private int x;
    private int y;
    private String name;
    private final List<Dialogue> talk;
    private final int picPos;

    public NPC(String name, int x, int y, List<Dialogue> talk, int picPos) {
        this.name = name;
        this.x = x + (int) (GV.width*.5);
        this.y = y + (int) (GV.height*.5);
        this.talk = talk;
        this.picPos = picPos;
        GV.walls.add(new Wall(x,y,3));
    }

    public NPC()
    {
        this.talk = null;
        this.picPos = 0;
    }
    
   
    public Dialogue getDialogue(int a)
    {
        return talk.get(a);
    }
    
    public int getPicPos()
    {
        return picPos;
    }
    
    public void setX(int x) {
        this.x = x + (int) (GV.width*.5);
    }

    public void setY(int y) {
        this.y = y + (int) (GV.height*.5);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x - (int) (GV.width*.5);
    }

    public int getY() {
        return y - (int) (GV.height*.5);
    }

    public String getName() {
        return name;
    }
}