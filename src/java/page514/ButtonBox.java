package page514;

import javax.swing.*;

public class ButtonBox
        extends Box
{
    public ButtonBox()
    {
        super(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> System.out.println("start button"));
        this.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> System.out.println("stop button"));
        this.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e -> System.out.println("upTempo button"));
        this.add(upTempo);

        JButton downTempo = new JButton("TempoDawn");
        downTempo.addActionListener(e -> System.out.println("dawnTempo button"));
        this.add(downTempo);
    }

}
