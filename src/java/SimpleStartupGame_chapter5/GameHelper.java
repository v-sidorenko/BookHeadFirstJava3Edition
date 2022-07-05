package SimpleStartupGame_chapter5;

import java.util.*;

public class GameHelper
{
    public int getUserInput(String promt)
    {
        System.out.println(promt + ":");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
