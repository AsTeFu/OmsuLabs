package omsu.astefu.labs.tasks;

import omsu.astefu.labs.io.Printer;
import omsu.astefu.labs.io.Reader;

public class FormulaTask extends Task {

    private static final String FORMULA = "\n\tSqrt(%d) - 6 / %d = %.3f\n";
    private static final String TITLE = "Calc Sqrt(X) - 6 / Z";

    private final Reader reader;
    private final Printer printer;

    public FormulaTask(final String title, final Reader reader, final Printer printer) {
        super(title);
        this.reader = reader;
        this.printer = printer;
    }

    public FormulaTask(final Reader reader, final Printer printer) {
        this(TITLE, reader, printer);
    }

    @Override
    public void execute() {
        int x = reader.readNumber(num -> num > 0, "\n\tEnter x: ", "\tEnter positive number: ");
        int z = reader.readNumber(num -> num != 0, "\n\tEnter z: ", "\tEnter not zero: ");

        double result = calculate(x, z);

        printer.printf(FORMULA, x, z, result);
    }

    private double calculate(int x, int z) {
        return Math.sqrt(x) - 6.0 / z;
    }
}
