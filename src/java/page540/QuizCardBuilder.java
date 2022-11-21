package page540;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizCardBuilder
{
    private JFrame frame;
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList = new ArrayList<>();
    
    public static void main(String[] args)
    {
        new QuizCardBuilder().go();
    }
    
    public void go()
    {
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        
        question = createTextArea(bigFont);
        JScrollPane qScroller = createScroller(question);
        answer = createTextArea(bigFont);
        JScrollPane aScroller = createScroller(answer);
        
        mainPanel.add(new JLabel("Question:"));
        mainPanel.add(qScroller);
        mainPanel.add(new JLabel("Answer:"));
        mainPanel.add(aScroller);
        
        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> nextCard());
        mainPanel.add(nextButton);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(e -> clearAll());
        
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> saveCard());
        
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
    
    private JTextArea createTextArea(Font font)
    {
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(font);
        return textArea;
    }
    
    private JScrollPane createScroller(JTextArea textArea)
    {
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }
    
    private void nextCard()
    {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);
        clearCard();
    }
    
    private void saveCard()
    {
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);
        
        JFileChooser fileSave = new JFileChooser("./resources");
        fileSave.showSaveDialog(frame);
        File file = fileSave.getSelectedFile();
        if(file != null) {
            saveFile(file);
        }
    }
    
    private void clearAll()
    {
        cardList.clear();
        clearCard();
    }
    
    private void clearCard()
    {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
    
    private void saveFile(File file)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
            clearCard();
        } catch(Exception e) {
            System.out.println("Couldn't write the cardList out: " + e.getMessage());
        }
    }
}
