package page514;

import javax.swing.*;

class MainFrame
        extends JFrame
{
    private int x, y = 50;
    private int width, height = 300;
    
    
    public MainFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void go(){
        this.setBounds(x, y, width, height);
        this.pack();
        this.setVisible(true);
    }
}
