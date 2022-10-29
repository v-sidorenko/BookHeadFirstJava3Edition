package page471;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui3
        implements ActionListener
{
    private JFrame frame;
    private JButton button;

    public static void main(String[] args)
    {
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Change color");
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        frame.repaint();
    }

}
