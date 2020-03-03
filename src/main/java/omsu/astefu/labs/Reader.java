package omsu.astefu.labs;

import java.util.Scanner;
import java.util.function.Predicate;

public class Reader {

    private final Scanner scanner;

    public Reader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getNumber() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Try again, enter number: ");
        }
        return scanner.nextInt();
    }

    public int getNumber(final String message) {
        System.out.print(message);
        return getNumber();
    }

    public int getNumber(final Predicate<Integer> predicate, final String startMessage, final String errorMessage) {
        int x;
        System.out.print(startMessage);
        while (predicate.test(x = getNumber())) {
            System.out.print(errorMessage);
        }
        return x;
    }
}
