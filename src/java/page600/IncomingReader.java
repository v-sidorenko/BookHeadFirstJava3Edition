package page600;

import java.io.*;
import javax.swing.*;

public class IncomingReader implements Runnable {
    
    private final BufferedReader reader;
    private final JTextArea incoming;
    
    public IncomingReader(BufferedReader reader, JTextArea incoming){
        this.reader = reader;
        this.incoming = incoming;
    }
    
    @Override
    public void run(){
        String message;
        try {
            while((message = reader.readLine()) != null) {                
                System.out.println("read: " + message);
                incoming.append(message + "\n");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
