package omsu.astefu.labs.tasks;

import omsu.astefu.labs.io.Printer;

public class HelloWorldTask extends Task {

    public static final String HELLO_WORLD = "Hello, World!";

    private final Printer printer;

    public HelloWorldTask(final String title, final Printer printer) {
        super(title);
        this.printer = printer;
    }

    public HelloWorldTask(final Printer printer) {
        this(HELLO_WORLD, printer);
    }

    @Override
    public void execute() {
        printer.println(HELLO_WORLD);
    }
}
