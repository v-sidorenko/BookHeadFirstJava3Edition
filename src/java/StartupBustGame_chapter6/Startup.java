package StartupBustGame_chapter6;

import java.util.*;

public class Startup
{
    private ArrayList<String> locationCells;
    private String name;

    String checkYourself(String userInput)
    {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if(index >= 0)
        {
            locationCells.remove(index);
            if(locationCells.isEmpty())
            {
                result = "kill";
            } else
            {
                result = "hit";
            }
        }
        return result;
    }

    public void setLocationCells(ArrayList<String> locs)
    {
        locationCells = locs;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
