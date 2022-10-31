package page484;

import java.awt.*;
import java.util.concurrent.*;
import javax.swing.*;

public class SimpleAnimation
{
    private int xPos = 70;
    private int yPos = 70;
    private int xDir = 1;
    private int yDir = 1;
    private int ballDiametr = 20;
    private int sleepMs = 5;

    public static void main(String[] args)
    {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200, 200));

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        while(true)
        {
            if(xPos <= 0)
            {
                xDir = 1;
            } else if(xPos + ballDiametr >= drawPanel.getWidth())
            {
                xDir = -1;
            }
            if(yPos <= 0)
            {
                yDir = 1;
            } else if(yPos + ballDiametr >= drawPanel.getHeight())
            {
                yDir = -1;
            }

            xPos += xDir;
            yPos += yDir;

            drawPanel.repaint();

            try
            {
                TimeUnit.MILLISECONDS.sleep(sleepMs);
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    class MyDrawPanel
            extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.BLUE);
            g.fillOval(xPos, yPos, ballDiametr, ballDiametr);
        }
    }
}
