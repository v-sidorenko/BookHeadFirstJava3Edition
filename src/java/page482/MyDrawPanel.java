package page482;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MyDrawPanel
        extends JPanel
{

    @Override
    public void paintComponent(Graphics g)
    {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(this.getWidth() / 4, this.getHeight() / 4, this.getWidth() / 2, this.getHeight() / 2);

    }
}
