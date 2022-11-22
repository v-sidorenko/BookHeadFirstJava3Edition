package page555;

import java.awt.*;
import javax.swing.*;

public class BackgroundPanel
        extends JPanel
{
    private int border = 10;

    public BackgroundPanel(BeatBox beatBox)
    {
        super(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(border, border, border, border));
        this.add(BorderLayout.EAST, new ButtonBox(beatBox));
        this.add(BorderLayout.WEST, new NameBox());

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        this.add(BorderLayout.CENTER, new MainPanel(grid, beatBox));
    }

}
