package BrightDeath;

import Items.Item;
import Items.Weapon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GV
{
    static String serverName;
    static boolean city;
    static boolean run = true, connect = true;
    static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    static JFrame holder = new JFrame("Bright Death");
    static int xPos = 0;
    static int yPos = 0;
    static char aHit;
    static char wHit;
    static char sHit;
    static char dHit;
    static boolean moveA = false, moveS = false, moveD = false, moveW = false;
    static boolean attackUp = false, attackDown = false, attackRight = false, attackLeft = false;
    static boolean down = false, up = false, right = false, left = false;
    static int speed = 3;
    static boolean attacking = false;
    static int waitForAttack = 0;
    static List<Monster> monsters = new ArrayList();
    static List<Wall> walls = new ArrayList();
    static List<OtherPlayer> otherPlayers = new ArrayList();
    static boolean isPaused = false;
//    static PauseMenu p = new PauseMenu();
    public static Inventory inventory = new Inventory();
    static BackPack b = new BackPack();
    static boolean isBackPacked = false;
    static List<Item> drops = new ArrayList();
    public final static String fileP = "/Images/";
    static List<BufferedImage> monsterPics = new ArrayList();
    static List<BufferedImage> attackPics = new ArrayList();
    static List<BufferedImage> wallPics = new ArrayList();
    static List<BufferedImage> npcPics = new ArrayList();
    static List<BufferedImage> background = new ArrayList();
    static List<Item> loot = new ArrayList();
    static BufferedImage[][] playerPics = new BufferedImage[1][1];
    static BufferedImage lootPic;
    static BufferedImage GUI;
    static List<LootBag> lootBags = new ArrayList();
    static int health = 50;
    static int xp = 10;
    static Font healthFont = new Font("txt", Font.BOLD, 30);
    static Font xpFont = new Font("txt", Font.BOLD, 10);
    static Font levelFont = new Font("txt", Font.BOLD, 40);
    static int level = 1;
    static int money = 0;
    static final double sizeMod = ((double)GV.width)/1024;
    static JFrame hold = new JFrame();
    static List<NPC> npcList = new ArrayList();
    static int oldXPos = 0;
    static int oldYPos = 0;
    static Weapon current = new Weapon();
    
    /*public static ArrayList makeAttack(boolean up, boolean right, boolean down, boolean left, int xPos, int yPos) throws IOException
    {
        ArrayList out = new ArrayList();
        int boxSize = (int) (50*sizeMod);

        //System.out.println("here");
        if (down || left || right || up)
        {
            if (attackType == 0)
            {
                if (down && !left && !right)
                {
                    yPos += boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordD.png")));
                }
                else if (up && !left && !right)
                {
                    yPos -= boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordU.png")));
                }
                else if (left && !up && !down)
                {
                    xPos -= boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordL.png")));
                }
                else if (right && !up && !down)
                {
                    xPos += boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordR.png")));
                }
                else if (right && up)
                {
                    xPos += boxSize;
                    yPos -= boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordNE.png")));
                }
                else if (right && down)
                {
                    xPos += boxSize;
                    yPos += boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordSE.png")));
                }
                else if (left && up)
                {
                    xPos -= boxSize;
                    yPos -= boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordNW.png")));
                }
                else if (left && down)
                {
                    xPos -= boxSize;
                    yPos += boxSize;
                    out.add(ImageIO.read(GV.class.getResourceAsStream(GV.fileP + "SwordSW.png")));
                }
                else
                {
                    out.add(null);
                }
                //return new Rectangle(xPos,yPos,50,50);
            }
            out.add(xPos);
            out.add(yPos);
            return out;
        }
        return null;
    }*/

    public static void checkLoot() //playerPos
    {
        int x = -GV.xPos;
        int y = -GV.yPos;
//        System.out.println("x " + x + " y " + y);
        List<LootBag> collected = new ArrayList();
        LootBag lootbag;
//        System.out.println(lootBags.size());
        
        for (int k = GV.lootBags.size() - 1; k >= 0; k--)
        {
            lootbag = lootBags.get(k);
            if ((x - 100 <= lootbag.getX()&& lootbag.getX()<= x + 100) && (y - 100 <= lootbag.getY()&& lootbag.getY() <= y + 100))
            {
                GV.inventory.addLootBag(lootbag);
                lootBags.remove(k);
                return;
            }
        }
//        System.out.println("GV 155 amount of bags:" + collected.size());
    }

    public static boolean isWalled()
    {
        boolean isWall = false;
        if (isWall == true)
        {
            return true;
        } else
        {
            for (int m = 0; m < GV.walls.size(); m++)
            {
                Wall stopper = (Wall) GV.walls.get(m);
                int XCenter = stopper.getXCoord();
                int YCenter = stopper.getYCoord();
                int XLocation = (GV.xPos * -1);
                int YLocation = (GV.yPos * -1);

                if (Math.abs((XLocation) - XCenter) < 50)
                {
                    if (Math.abs((YLocation) - YCenter) < 50)
                    {
                        isWall = true;
                        break;
                    }
                } else
                {
                    isWall = false;
                }
            }
            return isWall;
        }
    }

    public static boolean checkAgro(int x, int y, boolean a, int agro, int chase)
    {
        if (!a)
        {
            if (Math.abs(x + GV.xPos) <= agro)
            {
                if (Math.abs(y + GV.yPos) <= agro)
                {
                    a = true;
                }
            }
        } else
        {
            if (Math.abs(y + GV.yPos) > chase || Math.abs(x + GV.xPos) > chase)//(Math.abs(y-((int) (gV.height*.5)-50)+attackRadius+gV.yPos-(.5*agro))>=(chase*.5)||Math.abs(x-((int) (gV.width*.5)-50)+attackRadius+gV.xPos-(.5*agro))>=(chase*.5))
            {
                a = false;
            }
        }
        return a;
    }                     

    public static void addTheLoot()
    {
        int num1 = 0;
    }
    
    public static void checkForNPC()
    {
        NPC tempNPC;
        for (int i = 0; i < GV.npcList.size(); i++)
        {
            tempNPC = GV.npcList.get(i);
            if (Math.abs(tempNPC.getX()+GV.xPos)<=100&&Math.abs(tempNPC.getY()+GV.yPos)<=100)
            {
                createNPCDialogue(i, 0);
                return;
            }
        }
    }
    
    public static void createNPCDialogue(final int npcSpot, int dialogueNumber)
    {
        NPC theNPC = GV.npcList.get(npcSpot);
        hold = new JFrame(theNPC.getName());
        JPanel panel = new JPanel();
        hold.add(panel);
        JLabel dialogue = new JLabel(theNPC.getDialogue(dialogueNumber).getSpeach());
        panel.add(dialogue);
        hold.setBounds(0,0,500,500);
        
        JButton responses;
        for (int i = 0; i < theNPC.getDialogue(dialogueNumber).getNumberResponses(); i++)
        {
            responses = new JButton();
            final int dialogueNumberTemp = theNPC.getDialogue(dialogueNumber).getResponse(i).getSpeech();
            responses.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae)
                {
                    hold.setVisible(false);
                    if (dialogueNumberTemp != -1)
                    {
                        createNPCDialogue(npcSpot, dialogueNumberTemp);
                    }
                }
            });
            responses.setText(theNPC.getDialogue(dialogueNumber).getResponse(i).getAnswer());
            panel.add(responses);
        }
        hold.setVisible(true);
    }
}