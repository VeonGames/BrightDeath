/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BrightDeath;

/**
 *
 * @author nicno90
 */
public class QuestNPC extends NPC
{
    private int x;
    private int y;
    private String name;
    private String talk;
    
    public QuestNPC(String name, int x, int y, String talk)
    {
        super();
        this.name = name;
        this.x = x;
        this.y = y;
        this.talk = talk;
    }
    
}
