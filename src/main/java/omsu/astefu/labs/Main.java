package omsu.astefu.labs;

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
        int element = reader.getNumber(num -> num < 0 || num >= menu.getAmountItems(),
                "Enter menu: ",
                String.format("Enter menu from 0 to %d: ", menu.getAmountItems() - 1));
        menu.accept(element);
        return element;
    }

    private static Menu setupMenu(final Reader reader) {
        Menu menu = new Menu();

        menu.addMenuItem("Exit", () -> {
            System.out.println("Exiting...");
        });

        menu.addMenuItem("Hello, world!", () -> System.out.println("\n\tHello, world!\n"));

        menu.addMenuItem("Calc Sqrt(X) - 6 / Z", () -> {
            int x = reader.getNumber(num -> num < 0, "\n\tEnter x: ", "\tEnter positive number: ");
            int z = reader.getNumber(num -> num == 0, "\n\tEnter z: ", "\tEnter not zero: ");
            double result = Math.sqrt(x) - 6.0 / z;
            System.out.println(String.format("\n\tSqrt(%d) - 6 / %d = %.3f\n", x, z, result));
        });

        return menu;
    }


}







