package page514;

import javax.swing.*;

class MainFrame
        extends JFrame
{
    private final int x = 500, y = 500;
    private final int width = 300, height = 300;
    
    public MainFrame(String frameName)
    {
        super(frameName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void go(){
        this.setBounds(x, y, width, height);
        this.pack();
        this.setVisible(true);
    }
}
