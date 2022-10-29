package page456;

import java.awt.event.*;
import javax.swing.*;

public class SimpleGui2
        implements ActionListener
{
    private JButton button;
    
    public static void main(String[] args)
    {
        SimpleGui2 gui = new SimpleGui2();
        gui.go();
    }
    
    public void go()
    {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        
        button.addActionListener(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(button);
        
        frame.setSize(300, 300);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        button.setText("I've been clicked!");
    }
    
}
