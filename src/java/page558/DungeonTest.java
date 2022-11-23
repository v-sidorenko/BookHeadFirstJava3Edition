package page558;

import java.io.*;

public class DungeonTest
{
    public static void main(String[] args)
    {
        DungeonGame d = new DungeonGame();
        System.out.println(d.getX()+d.getY()+d.getZ());
        
        try {
            FileOutputStream fos = new FileOutputStream("./resources/dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();
            
            FileInputStream fis = new FileInputStream("./resources/dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame) ois.readObject();
            ois.close();
            
            System.out.println(d.getX()+d.getY()+d.getZ());            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
