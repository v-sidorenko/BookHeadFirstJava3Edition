package page514;

import javax.swing.*;

public class NameBox
        extends Box
{

    private final String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
                                              "Open Hi-Hat",
                                              "Acoustic Snare", "Crash Cymbal",
                                              "Hand Clap",
                                              "High Tom", "Hi Bongo", "Maracas",
                                              "Whistle",
                                              "Low Conga", "Cowbell",
                                              "Vibraslap",
                                              "Low-mid Tom", "High Agogo",
                                              "Open Hi Conga"};

    public NameBox()
    {
        super(BoxLayout.Y_AXIS);
        for(String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            this.add(instrumentLabel);
        }
    }

}
