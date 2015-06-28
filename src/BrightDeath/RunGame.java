package BrightDeath;

import Items.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class RunGame extends JComponent
{
    public static void gameStarter()
    {
        GV.holder.setBounds(0, 0, GV.width, GV.height);
        GV.holder.setVisible(true);
        for (int k = 0; k < 100; k++)
        {
            GV.drops.add(new Item(1));
        }
        for (int k = 0; k < 40; k++)
        {
            GV.drops.add(new Weapon());
        }
        for (int k = 0; k < 10; k++)
        {
            GV.drops.add(new Rune());
        }
        for (int k = 0; k < 50; k++)
        {
            GV.drops.add(new Food(1));
        }
        for (int k = 0; k< 25; k++)
        {
            GV.drops.add(new Armor());
        }
        GV.holder.addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent windowEvent)
            {
System.out.println("RunGame: 38: Window is shutting-down");
                GV.connect = false;
            }
        });

        try
        {
            GV.background.add(ImageIO.read(GV.class.getResource(GV.fileP + "BackGround.png")));
            GV.wallPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "Wall.png")));
            GV.wallPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "Rock.png")));
            GV.wallPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "greenTree.png")));
            GV.wallPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "Invisible.png")));
            GV.monsterPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "Monster.png")));
            GV.monsterPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "WhiteWolf.png")));
            GV.monsterPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "BaoBot.png")));
            GV.monsterPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "Goblin.png")));
            GV.monsterPics.add(ImageIO.read(GV.class.getResource(GV.fileP + "Ghastiel.png")));
            GV.playerPics[0][0] = ImageIO.read(GV.class.getResource(GV.fileP + "Player.png"));
            GV.lootPic = ImageIO.read(GV.class.getResource(GV.fileP + "Loot.png"));  
            GV.GUI = ImageIO.read(GV.class.getResource(GV.fileP +"GUI.png"));
            GV.npcPics.add(ImageIO.read(GV.class.getResource(GV.fileP+"MrVolger.png")));
            GV.npcPics.add(ImageIO.read(GV.class.getResource(GV.fileP+"MrTellers.png")));
            String attack = "/AttackPictures/";
            GV.attackPics.add(ImageIO.read(GV.class.getResource(attack +"FireBlast.png")));
        }
        catch (IOException e)
        {
            
        }
    }
}