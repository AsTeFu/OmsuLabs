package omsu.astefu.labs;

import omsu.astefu.labs.io.ConsolePrinter;
import omsu.astefu.labs.io.Printer;
import omsu.astefu.labs.io.Reader;
import omsu.astefu.labs.tasks.Task;

import java.util.*;

public class Main {

    public static void main(final String[] args) {
        Reader reader = new Reader(new Scanner(System.in));
        Printer printer = new ConsolePrinter(System.out);

        Menu menu = new Menu(printer, reader);

        while (true) {
            menu.print();

            Task task = menu.getTask();
            task.execute();
        }
    }
}







