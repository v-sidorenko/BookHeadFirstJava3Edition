package page555;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainPanel
        extends JPanel
{
    public MainPanel(GridLayout grid, BeatBox beatBox)
    {
        super(grid);
        ArrayList<JCheckBox> checkboxList = new ArrayList<>();
        for(int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            this.add(c);
        }
        beatBox.setCheckboxList(checkboxList);
    }

}
