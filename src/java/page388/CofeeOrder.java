package page388;

import java.util.*;
import java.util.stream.*;

public class CofeeOrder
{
    public static void main(String[] args)
    {
        List<String> coffees = List.of("Cappuccino", "Americano", "Espresso",
                                       "Cortado", "Mocha", "Cappuccino", "Flat White", "Latte");
        List<String> coffeesEndingIno = coffees.stream()
                .filter(s -> s.endsWith("o"))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(coffeesEndingIno);
    }
}
