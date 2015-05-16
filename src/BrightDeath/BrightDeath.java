package BrightDeath;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class BrightDeath
{

    public static void startGame(boolean city)
    {
        RunGame.gameStarter();
        
        System.out.println(GV.width+" "+GV.height);
        ClientConnector client = new ClientConnector();
        client.start();
        
        List<Dialogue> theDialogues = new ArrayList();
        List<Response> responseList = new ArrayList();
        List<Response> responseList2 = new ArrayList();
        Response r1 = new Response("How are you", 1, 0,null,false);
        responseList.add(r1);
        Response r2 = new Response("I'm bored", -1,0,null,false);
        responseList.add(r2);
        Dialogue d1 = new Dialogue("Ho Traveler", responseList, 0,null,false);
        Dialogue d2 = new Dialogue("I'm well", responseList2, 0,null,false);
        theDialogues.add(d1);
        theDialogues.add(d2);
        
        NPC volger = new NPC("Mr. Volger", 150, 500, theDialogues, 0);
        GV.npcList.add(volger);
        
        NPC tellers = new NPC("Mr. Tellers", 300, 500, theDialogues, 1);
        GV.npcList.add(tellers);
        
        KeyListener listen = new KeyListener()
        {
            public void keyTyped(KeyEvent ke)
            {
                if (ke.getKeyChar() == 'v' || ke.getKeyChar() == 'V')
                {
                    GV.moveA = false;
                    GV.moveD = false;
                    GV.moveS = false;
                    GV.moveW = false;
                    GV.checkForNPC();
                }
                if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A')
                {
                    GV.moveA = true;
                }
                if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S')
                {
                    GV.moveS = true;
                }
                if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D')
                {
                    GV.moveD = true;
                }
                if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W')
                {
                    GV.moveW = true;
                }
                if (ke.getKeyChar() == 'e' || ke.getKeyChar() == 'E') //for looting
                {
                    GV.checkLoot();
                }
//                if (ke.getKeyChar() == 27)
//                {
//                    if (GV.isPaused)
//                    {
//                        GV.p.setVisible(false);
//                    } else
//                    {
//                        GV.p.setVisible(true);
//                    }
//                }
                if (ke.getKeyChar() == 'b' || ke.getKeyChar() == 'B')
                {
                    if (GV.isBackPacked)
                    {
                        GV.b.setVisible(false);
                    } else
                    {
                        GV.b.setVisible(true);
                        
                    }
                }
                if (ke.getKeyChar() == 'r')
                {
                    System.out.println("MARKER MARKER MARKER MARKER MARKER MARKER MARKER MARKER MARKER MARKER MARKER");
                }
            }

            public void keyPressed(KeyEvent ke)
            {
                if (ke.getKeyCode() == 40)
                {
                    GV.attackDown = true;
                }
                if (ke.getKeyCode() == 39)
                {
                    GV.attackRight = true;
                }
                if (ke.getKeyCode() == 38)
                {
                    GV.attackUp = true;
                }
                if (ke.getKeyCode() == 37)
                {
                    GV.attackLeft = true;
                }

            }

            public void keyReleased(KeyEvent ke)
            {
                if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A')
                {
                    GV.moveA = false;
                }
                if (ke.getKeyChar() == 's' || ke.getKeyChar() == 'S')
                {
                    GV.moveS = false;
                }
                if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D')
                {
                    GV.moveD = false;
                }
                if (ke.getKeyChar() == 'w' || ke.getKeyChar() == 'W')
                {
                    GV.moveW = false;
                }
            }
        };
        GV.holder.addKeyListener(listen);
        
        GV.holder.setVisible(false);
        GV.holder.add(new Draw());
        GV.holder.setVisible(true);

        while (GV.run == true)
        {
            if (GV.moveA == true)
            {
                GV.xPos += GV.speed;
                if (GV.isWalled() == true)
                {
                    GV.xPos -= GV.speed;
                }
            }
            if (GV.moveS == true)
            {
                GV.yPos -= GV.speed;
                if (GV.isWalled() == true)
                {
                    GV.yPos += GV.speed;
                }
            }
            if (GV.moveD == true)
            {
                GV.xPos -= GV.speed;
                if (GV.isWalled() == true)
                {
                    GV.xPos += GV.speed;
                }
            }
            if (GV.moveW == true)
            {
                GV.yPos += GV.speed;
                if (GV.isWalled() == true)
                {
                    GV.yPos -= GV.speed;
                }
            }

            //this is where frame per second is determined
            try
            {
                Thread.sleep(30);
            } catch (InterruptedException ex)
            {

            }
        }
    }
}