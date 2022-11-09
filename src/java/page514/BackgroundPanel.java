package page514;

import java.awt.*;
import javax.swing.*;

public class BackgroundPanel
        extends JPanel
{
    private int border = 10;

    public BackgroundPanel()
    {
        super(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(border, border, border, border));
        this.add(BorderLayout.EAST, new ButtonBox());
        
    }

}
