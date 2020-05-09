package omsu.astefu.labs.tasks;

import omsu.astefu.labs.io.Printer;
import omsu.astefu.labs.io.Reader;

public class RecursionDateTask extends Task {

    private static final String RECURSION_DATE = "Recursion date";

    private final int amount = 2;
    private final Reader reader;
    private final Printer printer;

    public RecursionDateTask(final String title, final Reader reader, final Printer printer) {
        super(title);
        this.reader = reader;
        this.printer = printer;
    }

    public RecursionDateTask(final Reader reader, final Printer printer) {
        this(RECURSION_DATE, reader, printer);
    }

    @Override
    public void execute() {
        for (int i = 0; i < amount; i++) {
            printer.printf("\n\tCut %d\n", i);
            long days = reader.getTimeCut();
            printer.println(printFactorial(days));
        }
    }

    private String printFactorial(long cut) {
        try {
            long fact = factorial(cut);
            return String.format("\n\tFactorial %d! = %d\n", cut, fact);
        } catch (IllegalArgumentException ex) {
            return "\t" + ex.getMessage();
        }
    }

    private long factorial(long n) {
        if (n < 0 || n > 30)
            throw new IllegalArgumentException(n < 0 ? "Argument less than zero" : "Argument is sooo big");
        return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
    }
}
