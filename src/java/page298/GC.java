package page298;

public class GC
{
    public static GC doStuff()
    {
        GC newGC = new GC();
        doStuff2(newGC);
        return newGC;
    }

    public static void main(String[] args)
    {
        GC gc1;
        GC gc2 = new GC();
        GC gc3 = new GC();
        GC gc4 = gc3;
        gc1 = doStuff();

        gc2 = null;
        gc1 = null;
//        gc3 = gc2;
        gc1 = gc4;

        // call more methods
    }

    public static void doStuff2(GC copyGC)
    {
        GC localGC = copyGC;
    }
}

//copyGC = null;
//
//gc2 = null;
//
//newGC = gc3;
//
//gc1 = null;
//
//newGC = null;
//
//gc4 = null;
//
//gc3 = gc2;
//
//gc1 = gc4;
//
//gc3 = null;
