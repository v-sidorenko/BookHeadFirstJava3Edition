package page601;

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.time.format.*;
import java.util.concurrent.*;

import static java.nio.channels.SocketChannel.open;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofLocalizedTime;

public class PingingClient {
    
    public static void main(String[] args)
    {
        InetSocketAddress server = new InetSocketAddress("127.0.0.1", 5000);
        
        try (SocketChannel channel = open(server)){
            System.out.println("Networking established");
            
            PrintWriter writer = new PrintWriter(Channels.newWriter(channel, UTF_8));
            
            for(int i = 0; i < 10; i++){
                String currentTime = now().format(ofLocalizedTime(FormatStyle.MEDIUM));
                String message = "ping " + i;
                writer.println(message);
                writer.flush();
                System.out.println(currentTime + " Sent " + message);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
