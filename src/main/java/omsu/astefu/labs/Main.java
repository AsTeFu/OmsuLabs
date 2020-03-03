package omsu.astefu.labs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {


    public static void main(final String[] args) {
        Reader reader = new Reader(new Scanner(System.in));
        Menu menu = setupMenu(reader);

        int element;
        do {
            element = updateMenu(reader, menu);
        } while (element != 0);
    }

    private static int updateMenu(final Reader reader, final Menu menu) {
        menu.print();
        int element = reader.readNumber(num -> num < 0 || num >= menu.getAmountItems(),
                "Enter menu: ",
                String.format("Enter menu from 0 to %d: ", menu.getAmountItems() - 1));
        menu.accept(element);
        return element;
    }

    private static Menu setupMenu(final Reader reader) {
        Menu menu = new Menu();

        menu.addMenuItem("Exit", () -> System.out.println("Exiting..."));
        menu.addMenuItem("Hello, world!", () -> System.out.println("\n\tHello, world!\n"));
        menu.addMenuItem("Calc Sqrt(X) - 6 / Z", printFormula(reader));
        menu.addMenuItem("Recursion date", recursionDate(reader, 2));

        return menu;
    }

    // TASK 1
    private static MenuElement printFormula(final Reader reader) {
        return () -> {
            int x = reader.readNumber(num -> num < 0, "\n\tEnter x: ", "\tEnter positive number: ");
            int z = reader.readNumber(num -> num == 0, "\n\tEnter z: ", "\tEnter not zero: ");
            double result = calculateFormula(x, z);
            System.out.println(String.format("\n\tSqrt(%d) - 6 / %d = %.3f\n", x, z, result));
        };
    }

    private static double calculateFormula(int x, int z) {
        return Math.sqrt(x) - 6.0 / z;
    }


    // TASK 2
    private static MenuElement recursionDate(final Reader reader, final int amount) {
        return () -> {
            for (int i = 0; i < amount; i++) {
                System.out.println(String.format("\n\tCut %d:", i));
                long days = reader.getTimeCut(reader);
                System.out.println(printFactorial(days));
            }
        };
    }

    private static String printFactorial(long cut) {
        try {
            long fact = factorial(cut);
            return String.format("\n\tFactorial %d! = %d\n", cut, fact);
        } catch (IllegalArgumentException ex) {
            return "\t" + ex.getMessage();
        }
    }

    private static long factorial(long n) {
        if (n < 0 || n > 30)
            throw new IllegalArgumentException(n < 0 ? "Argument less than zero" : "Argument is sooo big");
        return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
    }


}







