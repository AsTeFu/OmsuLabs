package omsu.astefu.labs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.function.Predicate;

public class Reader {

    private final Scanner scanner;

    public Reader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readNumber() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Try again, enter number: ");
        }
        return scanner.nextInt();
    }

    public int readNumber(final String message) {
        System.out.print(message);
        return readNumber();
    }

    public int readNumber(final Predicate<Integer> predicate, final String startMessage, final String errorMessage) {
        int x;
        System.out.print(startMessage);
        while (predicate.test(x = readNumber())) {
            System.out.print(errorMessage);
        }
        return x;
    }

    public LocalDate readDate(final String startMessage, final String errorMessage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

        System.out.print(startMessage);

        do {
            try {
                String line = scanner.next();
                return LocalDate.parse(line, formatter);
            } catch (DateTimeParseException ex) {
                System.out.print(errorMessage);
            }
        } while (true);
    }

    public long getTimeCut(Reader reader) {
        long days;
        do {
            LocalDate date1 = reader.readDate("\tInput first date: ", "\tTry again: ");
            LocalDate date2 = reader.readDate("\tInput second date: ", "\tTry again: ");

            days = ChronoUnit.DAYS.between(date1, date2);

            if (days < 0) {
                System.out.println("\tTry again enter time cut!");
            }
        } while (days < 0);

        return days;
    }

    public String getLine(final String message) {
        System.out.print(message);
        return scanner.next();
    }
}
