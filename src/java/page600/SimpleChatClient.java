package page600;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.concurrent.*;
import javax.swing.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClient {
    
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;
    
    public static void main(String[] args)
    {
        new SimpleChatClient().go();
    }
    
    public void go(){
        setUpNetworking();
        
        JScrollPane scroller = createScrollableTextArea();
        
        outgoing = new JTextField(20);
        
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());
        
        JPanel maiPanel = new JPanel();
        maiPanel.add(scroller);
        maiPanel.add(outgoing);
        maiPanel.add(sendButton);
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new IncomingReader(reader, incoming));
        
        JFrame frame = new JFrame("Telegram Killer");
        frame.getContentPane().add(BorderLayout.CENTER, maiPanel);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setUpNetworking()
    {
        try {
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
            SocketChannel socketChannel = SocketChannel.open(serverAddress);
            
            reader = new BufferedReader(Channels.newReader(socketChannel, UTF_8));
            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            
            System.out.println("Networking established.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private JScrollPane createScrollableTextArea()
    {
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private void sendMessage()
    {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }
}
