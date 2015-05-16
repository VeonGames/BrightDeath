/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BrightDeath;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Draw extends JComponent
{

    public void paint(Graphics g)
    {
        Graphics2D graph = (Graphics2D) g;
        BufferedImage monsterPic = null;

        graph.setColor(Color.GREEN);
        Shape background = new Rectangle(GV.xPos - 5000, GV.yPos - 5000, 10000, 10000);
        graph.fill(background);

        graph.drawImage(GV.background.get(0), (int) ((GV.xPos)*GV.sizeMod + (GV.width * .5)), (int) ((GV.yPos)*GV.sizeMod + (GV.height * .5)), (int)(3000*GV.sizeMod), (int)(3000*GV.sizeMod),null);

        for (int i = 0; i < GV.otherPlayers.size(); i++)
        {
            OtherPlayer other = ((OtherPlayer) (GV.otherPlayers.get(i)));
            graph.drawImage(GV.playerPics[0][0], (int)((other.getXpos() + GV.xPos)*GV.sizeMod+GV.width*.5), (int) ((other.getYpos() + GV.yPos)*GV.sizeMod+GV.height*.5), (int) (50*GV.sizeMod), (int) (50*GV.sizeMod), null);
        }

        for (int i = 0; i < GV.walls.size(); i++)
        {
            Wall wall = (Wall) GV.walls.get(i);
            graph.drawImage(GV.wallPics.get(wall.getType()),(int) ((wall.getXCoord() + GV.xPos)*GV.sizeMod) +((int)(GV.width*.5)),(int) ((wall.getYCoord() + GV.yPos)*GV.sizeMod)+((int)(GV.height*.5)),(int)(50*GV.sizeMod),(int)(50*GV.sizeMod),null);
        }
        LootBag loot;
        for (int k = GV.lootBags.size() - 1; k  >= 0; k--)
        {
            loot = GV.lootBags.get(k);
            if (!loot.isLooted())
            {
                graph.drawImage(GV.lootPic, (int) ((GV.xPos + loot.getX())*GV.sizeMod)+((int)(GV.width*.5)), (int) ((GV.yPos + loot.getY())*GV.sizeMod)+((int)(GV.height*.5)), (int) (GV.sizeMod*50), (int) (GV.sizeMod*50), null);
            }
            else
            {
                GV.lootBags.remove(k);
            }
        }
        
        for (int i = 0; i < GV.monsters.size(); i++)
        {
            if (GV.monsters.get(i).isAlive())
            {
                Monster bill = GV.monsters.get(i);
                //System.out.println("Monster X: "+bill.getMonsterX()+", playerX: "+GV.xPos*-1);
                graph.drawImage(GV.monsterPics.get(bill.getType()), (int) ((bill.getMonsterX() + GV.xPos)*GV.sizeMod+GV.width*.5), (int) ((bill.getMonsterY() + GV.yPos)*GV.sizeMod+GV.height*.5), (int) (GV.sizeMod*50), (int) (GV.sizeMod*50), null);
            }
        }
        
        for (int i = 0; i < GV.npcList.size(); i++)
        {
            NPC theNPC = GV.npcList.get(i);
            graph.drawImage(GV.npcPics.get(theNPC.getPicPos()), (int) ((theNPC.getX()+GV.xPos)*GV.sizeMod+GV.width*.5), (int) ((theNPC.getY()+GV.yPos)*GV.sizeMod+GV.height*.5), (int) (GV.sizeMod*50), (int) (GV.sizeMod*50), null);
        }

        graph.drawImage(GV.playerPics[0][0], (int) (GV.width * .5), (int) (GV.height * .5), (int) (50*GV.sizeMod), (int) (GV.sizeMod*50), null);

        //Fix this for new attacks
        
//        for (int i = 0; i < GV.otherPlayers.size(); i++)
//        {
//            OtherPlayer other = (OtherPlayer) GV.otherPlayers.get(i);
//            ArrayList attack = null;
//            try
//            {
//                attack = GV.makeAttack(other.isAttacking(0), other.isAttacking(1), other.isAttacking(2), other.isAttacking(3), other.getXpos() + GV.xPos, other.getYpos() + GV.yPos);
//            }
//            catch (IOException ex)
//            {
//                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (attack != null)
//            {
//                graph.drawImage((BufferedImage) attack.get(0), (int) (((int)attack.get(1))*GV.sizeMod), (int) ((int)attack.get(2)*GV.sizeMod), (int) (GV.sizeMod*50), (int) (GV.sizeMod*50), null);
//            }
//        }
        
        if (GV.waitForAttack <= 2)
        {
            GV.down = GV.attackDown;
            GV.left = GV.attackLeft;
            GV.right = GV.attackRight;
            GV.up = GV.attackUp;
            GV.waitForAttack++;
        }
        else
        {
            GV.down = false;
            GV.left = false;
            GV.right = false;
            GV.up = false;
            GV.waitForAttack++;            
        }
        
        if (GV.up)
        {
             
        }
        
        //GUI   NOT FINNISHED
//        graph.drawImage(GV.GUI, 0, 0, GV.width, GV.height, null);
//        
//        graph.setColor(Color.GREEN);
//        graph.fillRect((int) (GV.width *.01), (int) (GV.height * .99), GV.health * 5, (int) (GV.height * .037));
//       
//        graph.setColor(Color.MAGENTA);
//        graph.fillRect(399 , 624, GV.xp * 5, 24);
//        
//        
//        graph.setColor(Color.BLACK);
//        graph.setFont(GV.healthFont);
//        graph.drawString(GV.health + "%", 400 + 225, 690);
//        graph.setFont(GV.xpFont);
//        graph.drawString(GV.xp + "%", 640, 640);
//        graph.setFont(GV.levelFont);
//        graph.drawString("Level " + GV.level, 40, 640);
    }
}