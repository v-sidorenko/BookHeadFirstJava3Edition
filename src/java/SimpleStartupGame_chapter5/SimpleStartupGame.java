package SimpleStartupGame_chapter5;

public class SimpleStartupGame
{
    public static void main(String[] args)
    {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimpleStartup theStartup = new SimpleStartup();

        int randomNum = (int) (Math.random() * 5);
        int[] location =
        {
            randomNum, randomNum + 1, randomNum + 2
        };
        theStartup.setLocationCells(location);

        boolean isAlive = true;
        while(isAlive)
        {
            int guess = helper.getUserInput("enter a number");
            String result = theStartup.checkYourself(guess);
            numOfGuesses++;
            if(result == "kill")
            {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
        }
    }
}
