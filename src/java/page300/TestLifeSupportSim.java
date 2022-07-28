package page300;

import java.util.*;

class V2Radiator
{
    V2Radiator(ArrayList<SimUnit> list)
    {
        for(int x = 0; x < 5; x++)
        {
            list.add(new SimUnit("V2Radiator"));
        }
    }
}

class V3Radiator
        extends V2Radiator
{
    V3Radiator(ArrayList<SimUnit> lglist)
    {
        //super(lglist);
        for(int g = 0; g < 10; g++)
        {
            lglist.add(new SimUnit("V3Radiator"));
        }
    }
}

class RetentionBot
{
    RetentionBot(ArrayList<SimUnit> rlist)
    {
        rlist.add(new SimUnit("Retention"));
    }
}

//import java.util.ArrayList;
public class TestLifeSupportSim
{
    public static void main(String[] args)
    {
        ArrayList<SimUnit> aList = new ArrayList<SimUnit>();
        V2Radiator v2 = new V2Radiator(aList); // v2=5
        V3Radiator v3 = new V3Radiator(aList); // v2=5, v3=10
        for(int z = 0; z < 20; z++)
        {
            RetentionBot ret = new RetentionBot(aList); // v2=5, v3=10, ret=20
        }
    }
}

class SimUnit
{
    String botType;

    SimUnit(String type)
    {
        botType = type;
    }

    int powerUse()
    {
        if("Retention".equals(botType))
        {
            return 2;
        } else
        {
            return 4;
        }
    }
}
