package page489;

import java.awt.*;
import java.util.*;
import static javax.sound.midi.ShortMessage.CONTROL_CHANGE;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer3
{
    private MyDrawPanel panel;
    private Random random = new Random();

    public static void main(String[] args)
    {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void setUpGUI()
    {
        JFrame frame = new JFrame("My First Music Video");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyDrawPanel();
        frame.setContentPane(panel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void go()
    {
        setUpGUI();

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(panel, new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int note;
            for(int i = 0; i < 60; i += 4) {
                note = random.nextInt(50) + 1;
                track.add(makeEvent(NOTE_ON, 1, note, 100, i));
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    class MyDrawPanel
            extends JPanel
            implements ControllerEventListener
    {
        private boolean msg = false;

        @Override
        public void controlChange(ShortMessage event)
        {
            msg = true;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g)
        {
            if(msg) {
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                g.setColor(new Color(r, gr, b));

                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;

                int xPos = random.nextInt(40) + 10;
                int yPos = random.nextInt(40) + 10;

                g.fillRect(xPos, yPos, height, width);
                msg = false;
            }
        }
    }
}
