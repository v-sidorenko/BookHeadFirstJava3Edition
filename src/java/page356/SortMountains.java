package page356;

import java.util.*;

public class SortMountains
{
    public static void main(String[] args)
    {
        new SortMountains().go();
    }

    public void go()
    {
        List<Mountain> mountains = new ArrayList<>();
        mountains.add(new Mountain("Longs", 14255));
        mountains.add(new Mountain("Elbert", 14433));
        mountains.add(new Mountain("Maroon", 14156));
        mountains.add(new Mountain("Castle", 14265));
        System.out.println("as entered:\n" + mountains);

        mountains.sort((o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println("by name:\n" + mountains);

        mountains.sort((o1, o2) -> o2.height - o1.height);
        System.out.println("by height:\n" + mountains);
    }
}

class Mountain
{
    String name;
    int height;

    Mountain(String n, int h)
    {
        this.name = n;
        this.height = h;
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.height;
    }
}
