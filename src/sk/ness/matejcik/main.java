package sk.ness.matejcik;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {

    public static void main(String [ ] args)
    {
        System.out.println("1.\tUsing Java Stream API find out sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7 ");
        System.out.println(IntStream.range(1,10001)
                .filter(X -> X % 3 == 0 && X % 5 == 0)
                .filter(X -> X % 7 != 0)
                .sum());

        System.out.println();
        System.out.println("2.\tUsing Java Stream API print first 100 even numbers that are not dividable by 8");
        IntStream.range(1,101)
                .filter(X -> X % 8 != 0)
                .forEach(X -> System.out.print(X + ", "));

    }

}
