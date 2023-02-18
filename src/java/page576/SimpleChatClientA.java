package page576;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.channels.*;
import javax.swing.*;

import static java.nio.channels.SocketChannel.open;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClientA {

    private JTextField outgoing;
    private PrintWriter writer;

    public static void main(String[] args)
    {
        SimpleChatClientA chat = new SimpleChatClientA();
        chat.go();
    }
    
    public void go()
    {
        setUpNetworking();
        
        outgoing = new JTextField(20);
        
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());
        
        JPanel maiPanel = new JPanel();
        maiPanel.add(outgoing);
        maiPanel.add(sendButton);
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER,maiPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setUpNetworking()
    {
        try {
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
            SocketChannel socketChannel = open(serverAddress); 
            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            System.out.println("Networking established");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage()
    {
        // get the text from the text field and
        // send it to the server using the writer (a PrintWriter)
    }
}