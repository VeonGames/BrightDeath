/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BrightDeath;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class ClientConnector extends Thread
{

    private static Socket theClient;

    public void run()
    {
        OutputStream otpt;
        InputStream inpt;
        OtherPlayer catchem;

        try
        {

            //theClient = new Socket("76.167.196.16", 16030);
            theClient = new Socket(GV.serverName, 16030);
            inpt = theClient.getInputStream();
            otpt = theClient.getOutputStream();
            String s = InetAddress.getLocalHost().getHostAddress();
            System.out.println(s);

            s = s.substring(s.indexOf("/") + 1);
            writeInt(Integer.parseInt(s.substring(0, s.indexOf("."))), otpt);
            s = s.substring(s.indexOf(".") + 1);
            writeInt(Integer.parseInt(s.substring(0, s.indexOf("."))), otpt);
            s = s.substring(s.indexOf(".") + 1);
            writeInt(Integer.parseInt(s.substring(0, s.indexOf("."))), otpt);
            s = s.substring(s.indexOf(".") + 1);
            writeInt(Integer.parseInt(s), otpt);

            int num = readInt(inpt);
            for (int k = 0; k < num; k++)
            {
                GV.monsters.add(new Monster(readInt(inpt)));
            }
            num = readInt(inpt);
            for (int k = 0; k < num; k++)
            {
                GV.walls.add(new Wall(readInt(inpt), readInt(inpt), readInt(inpt)));

            }
            int temp;
            int numberOtherPlayers;
            int numRemoved;
            int tempx, tempy;

            while (GV.connect)
            {

                GV.holder.repaint();
                GV.connect = !readBoolean(inpt);
                tempx = GV.xPos;
                tempy = GV.yPos;
                writeInt(500 - tempx + GV.oldXPos, otpt);
                writeInt(500 - tempy + GV.oldYPos, otpt);
                GV.oldXPos = tempx;
                GV.oldYPos = tempy;
                GV.health = readInt(inpt);
                GV.xp = readInt(inpt);
                if (readBoolean(inpt))
                {
                    GV.level++;
                }

//                writeBoolean(GV.up, otpt);
//                writeBoolean(GV.down, otpt);
//                writeBoolean(GV.left, otpt);
//                writeBoolean(GV.right, otpt);
                writeBoolean(GV.up || GV.down || GV.left || GV.right, otpt);
                if (GV.up || GV.down || GV.left || GV.right)
                {
                    if (GV.up)
                    {
                        if (GV.right)
                        {
                            writeInt(1, otpt);
                        } else if (GV.left)
                        {
                            writeInt(7, otpt);
                        } else
                        {
                            writeInt(0, otpt);
                        }
                    } else if (GV.down)
                    {
                        if (GV.right)
                        {
                            writeInt(3, otpt);
                        } else if (GV.left)
                        {
                            writeInt(5, otpt);
                        } else
                        {
                            writeInt(4, otpt);
                        }
                    } else
                    {
                        if (GV.right)
                        {
                            writeInt(3, otpt);
                        } else if (GV.left)
                        {
                            writeInt(6, otpt);
                        } else
                        {
                            writeInt(8, otpt);
                        }
                    }
                }

                numRemoved = readInt(inpt);
                for (int i = 0; i < numRemoved; i++)
                {
                    GV.otherPlayers.remove(readInt(inpt));
                }

                numberOtherPlayers = readInt(inpt);
                for (int i = 0; i < numberOtherPlayers; i++)
                {
                    if (GV.otherPlayers.size() > i)
                    {
                        OtherPlayer p = GV.otherPlayers.get(i);
                        if (readBoolean(inpt))
                        {
                            p.setXpos(readInt(inpt));
                            p.setYpos(readInt(inpt));
                        }
                    } else
                    { //other players
                        if (readBoolean(inpt))
                        {
                            catchem = new OtherPlayer(readInt(inpt), readInt(inpt));
                            GV.otherPlayers.add(catchem);
                            catchem.setAttacking(0, readBoolean(inpt));
                            catchem.setAttacking(1, readBoolean(inpt));
                            catchem.setAttacking(2, readBoolean(inpt));
                            catchem.setAttacking(3, readBoolean(inpt));
                        } else
                        {
                            catchem = new OtherPlayer(-5000, -5000);
                            GV.otherPlayers.add(catchem);
                        }
                    }
                }

                for (Monster bill : GV.monsters)
                {
                    temp = readInt(inpt);
                    if (temp == 0)
                    {
                        //readInt(inpt);
                        //System.out.println("server: "+readInt(inpt)+" acual: "+GV.xPos+" Old: "+GV.oldXPos); //I think this part works
                        bill.setMonsterX(readInt(inpt) - GV.xPos - 2000);
                        //bill.setMonsterX(readInt(inpt));
                        bill.setMonsterY(readInt(inpt) - GV.yPos - 2000);
//                        bill.setMonsterY(readInt(inpt));
                    } else if (temp == 1)
                    {
                        bill.setAlive(false);
                    } else if (temp == 2)
                    {
                        bill.setAlive(false);
                        GV.lootBags.add(new LootBag(bill.getMonsterX(), bill.getMonsterY(), bill.getMaxLoot()));
                    }
                }

                if (GV.connect)
                {
                    //System.out.println("running");
                    writeBoolean(true, otpt);
                } else
                {
                    writeBoolean(false, otpt);
                    System.out.println("sucessful disconnect");
                    System.exit(0);
                    System.out.println("sucessful disconnect2");
                }
            }
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Connection Failed " + e);
            System.exit(0);
        }
    }

    public void writeBoolean(boolean boolToSend, OutputStream otpt)
    {
        try
        {
            if (boolToSend)
            {
                otpt.write(1);
            } else
            {
                otpt.write(0);
            }
        } catch (IOException e)
        {

        }
    }

    public boolean readBoolean(InputStream inpt) //change this back to orginal booleans
    {
        try
        {
            if (inpt.read() == 0)
            {
                return false;
            } else
            {
                return true;
            }
        } catch (IOException e)
        {
            return false;
        }
    }

    public static void writeInt(int intToSend, OutputStream otpt)
    {
        try
        {
            while (intToSend > 0)
            {
                if (intToSend <= 255)
                {
                    otpt.write(intToSend);
                    intToSend = 0;
                } else
                {
                    otpt.write(255);
                    intToSend -= 255;
                }
            }
            otpt.write(0);
        } catch (IOException e)
        {

        }
    }

    public static int readInt(InputStream inpt)
    {
        int intRead = -1;
        int intToUse = 0;
        try
        {
            while (intRead != 0)
            {
                intRead = inpt.read();
                if (intRead == 0)
                {
                    return intToUse;
                } else
                {
                    intToUse += intRead;
                }
            }
        } catch (IOException e)
        {

        }
        return intToUse;
    }
}
