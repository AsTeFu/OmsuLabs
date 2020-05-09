package omsu.astefu.labs;

import omsu.astefu.labs.io.Printer;
import omsu.astefu.labs.io.Reader;
import omsu.astefu.labs.tasks.ExitTask;
import omsu.astefu.labs.tasks.FormulaTask;
import omsu.astefu.labs.tasks.HelloWorldTask;
import omsu.astefu.labs.tasks.RecursionDateTask;
import omsu.astefu.labs.tasks.StringsTask;
import omsu.astefu.labs.tasks.Task;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Menu {

    private final Printer printer;
    private final Reader reader;

    private final ArrayList<Task> tasks = new ArrayList<>();

    private static final String ENTER_MENU = "Enter menu: ";
    private static final String ENTER_AGAIN = "Enter again: ";

    public Menu(final Printer printer, final Reader reader) {
        this.printer = printer;
        this.reader = reader;

        tasks.add(new ExitTask(printer));
        tasks.add(new HelloWorldTask(printer));
        tasks.add(new FormulaTask(reader, printer));
        tasks.add(new RecursionDateTask(reader, printer));
        tasks.add(new StringsTask(reader, printer));
    }

    public void addMenuItem(final Task task) {
        tasks.add(task);
    }

    public void print() {
        printer.println("\n===MENU==========================\n");

        IntStream.range(0, tasks.size())
                .mapToObj(index -> String.format("[%d] %s", index, tasks.get(index).getTitle()))
                .forEach(printer::println);

        printer.println();
    }

    public Task getTask() {
        int taskIndex = reader.readNumber(num -> num >= 0 && num <= tasks.size(), ENTER_MENU, ENTER_AGAIN);
        return tasks.get(taskIndex);
    }
}
