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
        menu.addMenuItem("Calc Sqrt(X) - 6 / Z", new Task1(reader));
        menu.addMenuItem("Recursion date", new Task2(reader, 2));
        menu.addMenuItem("Strings", new Task3(reader));

        return menu;
    }

}







