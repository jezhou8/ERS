import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*; 

public class UsingKeys extends Applet implements ActionListener,KeyListener
{
    public boolean debugging;
    private int xPos,yPos;
    private int xinc, yinc;
    private Timer timer;
    
    public void debug(int width, int height) {
        Applet applet = this;
        debugging = true;
        String windowTitle = applet.getClass().getName();
        JFrame frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height + 20);
        frame.setBackground(Color.BLACK);
        applet.setSize(width, height);                                                                                                                                                                                                                                                                                                                                                                                              
        frame.add(applet);
        applet.init();      // simulate browser call(1)
        applet.start();      // simulate browser call(2)
        frame.setVisible(true);
    }  

    public boolean debugging() {
        return debugging;
    }

    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }

    public void keyReleased(KeyEvent ke)
    {

    }

    public void keyPressed(KeyEvent ke)
    {
        int zzz=ke.getKeyCode();
        switch(zzz)
        {
            case(KeyEvent.VK_W):
            yinc=-5;
            xinc=0;
            break;

            case(KeyEvent.VK_S):
            yinc=5;
            xinc=0;
            break;

            case(KeyEvent.VK_D):
            xinc=5;
            yinc=0;
            break;

            case(KeyEvent.VK_A):
            xinc=-5;
            yinc=0;
            break;

            case(KeyEvent.VK_SPACE):
            timer.stop();
            break;
            
            case(KeyEvent.VK_R):
            timer.start();
            break;
        }
        repaint();
    }

    public void keyTyped(KeyEvent ke)
    {
    }

    public void init()
    { 
        setBackground(Color.BLACK);
        xPos=200;
        yPos=200;
        addKeyListener(this);
        requestFocus();
        timer=new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g)
    {
        xPos+=xinc;
        yPos+=yinc;
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos,yPos,50,50);
    }
}
/**
 *    int zzz=ke.getKeyCode();
switch(zzz)
{
case(KeyEvent.VK_UP):
yPos-=10;
break;

case(KeyEvent.VK_DOWN):
yPos+=10;
break;

case(KeyEvent.VK_RIGHT):
xPos+=10;
break;

case(KeyEvent.VK_LEFT):
xPos-=10;
break;

}
repaint();
 */




