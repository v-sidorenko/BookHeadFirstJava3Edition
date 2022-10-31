package page482;

import java.awt.*;
import javax.swing.*;

public class TwoButtons
{
    private JFrame frame;
    private JLabel label;
    private JButton colorButton;
    private JButton labelButton;
    private MyDrawPanel drawPanel;

    public static void main(String[] args)
    {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelButton = new JButton("Change label");
        labelButton.addActionListener(event -> label.setText("Ouch!"));

        colorButton = new JButton("Change color");
        colorButton.addActionListener(event -> drawPanel.repaint());

        label = new JLabel("I'm a label");

        drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
