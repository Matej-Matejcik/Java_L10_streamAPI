package sk.ness.matejcik;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {

    public static void main(String [ ] args)
    {

        // EXERCISE 1
        System.out.println("1.\tUsing Java Stream API find out sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7 ");
        System.out.println(IntStream.range(1,10001)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .filter(x -> x % 7 != 0)
                .sum()
        );
        // ***************************************************************

        // EXERCISE 2
        System.out.println("\n\n2.\tUsing Java Stream API print first 100 even numbers that are not dividable by 8");
        IntStream.range(1,101)
                .filter(x -> x % 8 != 0)
                .forEach(x -> System.out.print(x + ", "));
        // ***************************************************************

        List<Book> list = Arrays.asList(
                new Book("qB1", 20),
                new Book("wBook2", 40),
                new Book("eB3", 60),
                new Book("rBook4", 80) ,
                new Book("tB5", 150),
                new Book("yBook6", 250),
                new Book("uB7", 350),
                new Book("iBook8", 450),
                new Book("oB9", 675),
                new Book("pBook10", 750),
                new Book("aB11", 825),
                new Book("sBook12", 900),
                new Book("dB13", 975),
                new Book("fBook14", 1050),
                new Book("gB15", 1125)
        );

        // EXERCISE 3.1
        System.out.println("\n\n3.1\tUsing Java Stream API print names (in alphabetic order) of all books that have price smaller than 100.");
        list.stream()
                .filter(p -> p.getPrice() < 100)
                .sorted(Comparator.comparing(Book::getName))
                .forEach(x -> System.out.print(x.getName() + ", "));
        // ***************************************************************

        // EXERCISE 3.2
        System.out.println("\n\n3.2\tUsing Java stream API find out how many books have name shorter than 5 characters.");
        System.out.println(list.stream()
                .filter(n -> n.getName().length() < 5)
                .count()
        );
        // ***************************************************************

        // EXERCISE 3.3
        System.out.println("\n\n3.3\tUsing Java stream API find out what is the average price of the book in the list");
        OptionalDouble result = list.stream()
                                    .mapToInt(Book::getPrice)
                                    .average();
        if (result.isPresent()) System.out.println(result.getAsDouble());
        // ***************************************************************

        // EXERCISE 3.4
        System.out.println("\n\n3.4\tUsing Java stream API find out if all books in list are cheaper than 500");
        if (list.stream()
            .map(Book::getPrice)
            .allMatch(p -> p < 500)) {
            System.out.println("All elements are cheaper than 500");
        } else {
            System.out.println("Some of the elements are not cheaper than 500.");
        }
        // ***************************************************************
    }
}
