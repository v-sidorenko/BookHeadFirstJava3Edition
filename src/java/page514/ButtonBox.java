package page514;

import javax.swing.*;

public class ButtonBox
        extends Box
{
    public ButtonBox(BeatBox beatBox)
    {
        super(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> beatBox.buildTrackAndStart());
        this.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> beatBox.stop());
        this.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e -> beatBox.changeTempo(1.03f));
        this.add(upTempo);

        JButton downTempo = new JButton("TempoDawn");
        downTempo.addActionListener(e -> beatBox.changeTempo(0.97f));
        this.add(downTempo);
    }

}
