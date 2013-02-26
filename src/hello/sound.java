package hello;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.midlet.*;

/**
 * @author shruthi
 */
public class sound extends MIDlet implements ItemCommandListener,CommandListener
{
    Form play_screen,wrong_screen,answer_screen,splash_screen;
    StringItem play_button,enter_button,retry,new_sound,play_previous;
    TextField enter;
    Display display;
    Command play,exit,ok,Retry,back,play_again;
    Player player;
    VolumeControl vc;
    Random generator;
    static int num;
    Image i,img,im;
    public void startApp()
    {
        display = Display.getDisplay(this);
        play_screen = new Form("INTRIGUING SOUNDS!!!!");
        splash_screen=new Form(null);
        try {
             im = Image.createImage("/splashscreen1.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        splash_screen.append(im);
        try {
            img = Image.createImage("/Wrongpg.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        wrong_screen=new Form(null);
        wrong_screen.append("SORRY! WRONG ANSWER");
        wrong_screen.append(img);
        //answer_screen=new Form(null);
        //answer_screen=new Form(null);
        //answer_screen.append("CORRECT ANSWER");
        back = new Command("BACK",Command.BACK,0);
        play_button = new StringItem("", "Play", Item.BUTTON);
        Retry=new Command("RETRY",Command.ITEM,0);
        retry=new StringItem(null, "RETRY", Item.BUTTON);
        retry.setDefaultCommand(Retry);
        retry.setItemCommandListener(this);
        wrong_screen.append(retry);
        play = new Command("Play", Command.ITEM, 0);
        play_button.setDefaultCommand(play);
        play_button.setItemCommandListener(this);
        play_previous = new StringItem("", "Play Previous", Item.BUTTON);
        play_again = new Command("Play again",Command.ITEM,0);
        play_previous.setDefaultCommand(play_again);
        play_previous.setItemCommandListener(this);
        ok = new Command("OK",Command.OK,1);
        enter_button = new StringItem("", "Enter", Item.BUTTON);
        enter_button.setDefaultCommand(ok);
        enter_button.setItemCommandListener(this);
        enter_button.setLayout(1);

        exit = new Command("EXIT",Command.EXIT,2);
        enter = new TextField("Try and guess the animal", null, 28, TextField.ANY);

        play_screen.append(play_button);
        play_screen.append(enter);
        play_screen.append(enter_button);
        play_screen.append(play_previous);
        //play_screen.addCommand(ok);
        play_screen.addCommand(exit);
        play_screen.setCommandListener(this);
        display.setCurrent(splash_screen);
        try
        {
            Thread.sleep(6000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        display.setCurrent(play_screen);


    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }

    public void commandAction(Command c, Item item)
    {
        boolean ans=false;
        answer_screen=new Form(null);
        if(c==play)
        {
            run();
        }
        else if (c == ok)
        {
            if(enter.getString()==null)
            {
                play_screen.append("Please Enter answer:");
            }
            else
            {
                String st=enter.getString();
                 if(st.equalsIgnoreCase("dog") && num==0)
                  ans=true;
                 else if(st.equalsIgnoreCase("cat") && num==1)
                  ans=true;
                 else if(st.equalsIgnoreCase("elephant")&& num==2)
                  ans=true;
                 else if(st.equalsIgnoreCase("cow")&& num==3)
                     ans=true;
                 else if(st.equalsIgnoreCase("chicken")&& num==4)
                     ans=true;
                 else if(st.equalsIgnoreCase("lion")&& num==5)
                     ans=true;
                 else if(st.equalsIgnoreCase("duck")&& num==6)
                     ans=true;
                 else if(st.equalsIgnoreCase("donkey")&& num==7)
                     ans=true;
                 else if(st.equalsIgnoreCase("horse") && num==8)
                     ans=true;
               if(ans)
               {
                   String s=null;


                  answer_screen.append("CORRECT ANSWER");
                  answer_screen.addCommand(back);
                  answer_screen.setCommandListener(this);
                  switch(num)
                  {
                      case 0:
                      {
                          s="DOG";
                        try {
                            i = Image.createImage("/Scrabby.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                      case 1:
                      {
                          s="CAT";
                        try {
                            i = Image.createImage("/cat.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                      case 2:
                      {
                          s="ELEPHANT";
                        try {
                            i = Image.createImage("/elephant.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                       case 3:
                      {
                          s="COW";
                        try {
                            i = Image.createImage("/cow.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                       case 4:
                      {
                          s="CHICKEN";
                        try {
                            i = Image.createImage("/chicken.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                       case 5:
                      {
                          s="LION";
                        try {
                            i = Image.createImage("/lion.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                       case 6:
                      {
                          s="DUCK";
                        try {
                            i = Image.createImage("/duck.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                       case 7:
                      {
                          s="DONKEY";
                        try {
                            i = Image.createImage("/donkey.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                        case 8:
                      {
                          s="HORSE";
                        try {
                            i = Image.createImage("/horse.png");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                          break;
                      }
                  }
                  answer_screen.append(s);
                    answer_screen.append(i);
                  display.setCurrent(answer_screen);

               }

               else
               {
                 display.setCurrent(wrong_screen);
                 wrong_screen.setCommandListener(this);
               }
            }
            }
        else if( c == play_again)
        {
            enter.setString(null);
            run1();
        }
       else if(c==Retry)
      {
        enter.setString(null);
        display.setCurrent(play_screen);
        play_screen.setCommandListener(this);
      }
    }
    public void run()
{
   String str=null;
   generator=new Random();
   num=generator.nextInt(9);
   switch(num)
   {
       case 0:
       {
           str="/dogsound.mp3";
           break;
       }
       case 1:
       {
           str="/catsound.mp3";
           break;
       }
       case 2:
       {
           str="/elephantsound.mp3";
           break;
       }
       case 3:
       {
           str="/cowsound.mp3";
           break;
       }
       case 4:
       {
           str="/chickensound.mp3";
           break;
       }
       case 5:
       {
           str="/lionsound.mp3";
           break;
       }
        case 6:
       {
           str="/ducksound.mp3";
           break;
       }
        case 7:
       {
           str="/donkeysound.mp3";
           break;
       }
         case 8:
       {
           str="/horsesound.mp3";
           break;
       }
   }
try
{
InputStream is = getClass().getResourceAsStream(str);
player = Manager.createPlayer(is,"audio/mpeg");

player.realize();
// get volume control for player and set volume to max
vc = (VolumeControl) player.getControl("VolumeControl");
if(vc != null)
{
vc.setLevel(100);
}
//player.prefetch();
player.start();
is.close();
is = null;
}
catch(Exception e)
{}
}
     public void run1()
{
   String str1=null;

   switch(num)
   {
       case 0:
       {
           str1="/dogsound.mp3";
           break;
       }
       case 1:
       {
           str1="/catsound.mp3";
           break;
       }
       case 2:
       {
           str1="/elephantsound.mp3";
           break;
       }
         case 3:
       {
           str1="/cowsound.mp3";
           break;
       }
       case 4:
       {
           str1="/chickensound.mp3";
           break;
       }
       case 5:
       {
           str1="/lionsound.mp3";
           break;
       }
         case 6:
       {
           str1="/ducksound.mp3";
           break;
       }
         case 7:
       {
           str1="/donkeysound.mp3";
           break;
       }
       case 8:
       {
           str1="/horsesound.mp3";
           break;
       }
   }
try
{
InputStream is = getClass().getResourceAsStream(str1);
player = Manager.createPlayer(is,"audio/mpeg");

player.realize();
// get volume control for player and set volume to max
vc = (VolumeControl) player.getControl("VolumeControl");
if(vc != null)
{
vc.setLevel(100);
}
//player.prefetch();
player.start();
is.close();
is = null;
}
catch(Exception e)
{}
}

    public void commandAction(Command c, Displayable d) {
        if(c == back)
        {
            enter.setString(null);
            display.setCurrent(play_screen);
            play_screen.setCommandListener(this);
        }
        if(c == exit)
        {
            destroyApp(true);
        }
    }
}
