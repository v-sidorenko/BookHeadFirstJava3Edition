package page514;

import java.util.*;
import javax.sound.midi.*;
import javax.swing.*;

import static javax.sound.midi.ShortMessage.CONTROL_CHANGE;
import static javax.sound.midi.ShortMessage.NOTE_OFF;
import static javax.sound.midi.ShortMessage.NOTE_ON;
import static javax.sound.midi.ShortMessage.PROGRAM_CHANGE;

public class BeatBox
{
    private ArrayList<JCheckBox> checkboxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47,
                         67, 63};

    public static void main(String[] args)
    {
        new BeatBox().buildGUI();
    }

    private void buildGUI()
    {
        MainFrame frame = new MainFrame("Cyber BeatBox");
        BackgroundPanel background = new BackgroundPanel(this);
        frame.getContentPane().add(background);

        setUpMidi();

        frame.go();
    }

    private void setUpMidi()
    {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changeTempo(float tempoMultiplier)
    {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

    public void stop()
    {
        sequencer.stop();
    }

    public void buildTrackAndStart()
    {
        int[] trackList;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for(int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];

            for(int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxList.get(j + i * 16);
                if(jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }

        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setCheckboxList(ArrayList<JCheckBox> checkboxList)
    {
        this.checkboxList = checkboxList;
    }

    private MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick)
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

    private void makeTracks(int[] list)
    {
        for(int i = 0; i < 16; i++) {
            int key = list[i];

            if(key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
            }
        }

    }
}
