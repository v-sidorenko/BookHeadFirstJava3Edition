package page545;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import page540.*;

public class QuizCardPlayer
{
    private ArrayList<QuizCard> cardList;
    private int currentCardIndex;
    private QuizCard currentCard;
    private JTextArea display;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args)
    {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go()
    {
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane scroller = new JScrollPane(display);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scroller);

        nextButton = new JButton("Show Question");
        nextButton.addActionListener(e -> nextCard());
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(e -> open());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 450);
        frame.setVisible(true);
    }

    private void nextCard()
    {
        if(cardList == null) {
            display.setText("Please, first load cards");
            return;
        }
        
        if(isShowAnswer) {
            display.setText(currentCard.getAnswer());
            nextButton.setText("Next Card");
            isShowAnswer = false;
        } else {
            if(currentCardIndex < cardList.size()) {
                showNextCard();
            } else {
                display.setText("That was the last card");
                nextButton.setEnabled(false);
            }
        }
    }

    private void open()
    {
        JFileChooser fileOpen = new JFileChooser("./resources");
        fileOpen.showOpenDialog(frame);
        File file = fileOpen.getSelectedFile();
        if(file != null) {
            loadFile(file);
        }
    }

    private void showNextCard()
    {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }

    private void loadFile(File file)
    {
        cardList = new ArrayList<>();
        currentCardIndex = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {                
                makeCard(line);
            }
            reader.close();
        } catch(Exception e) {
            System.out.println("Couldn't write the cardList out: " + e.getMessage());
        }
        showNextCard();
        nextButton.setEnabled(true);
    }

    private void makeCard(String lineToParse)
    {
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }
}
