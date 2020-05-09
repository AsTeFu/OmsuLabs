package omsu.astefu.labs.tasks;

import omsu.astefu.labs.io.Printer;

public class ExitTask extends Task {

    private static final String EXIT = "Exit";

    private final Printer printer;

    public ExitTask(final String title, final Printer printer) {
        super(title);
        this.printer = printer;
    }

    public ExitTask(final Printer printer) {
        this(EXIT, printer);
    }


    @Override
    public void execute() {
        printer.println("Exiting...");
        System.exit(0);
    }
}
