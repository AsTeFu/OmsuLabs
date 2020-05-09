package omsu.astefu.labs.io;

import java.io.PrintStream;

public class ConsolePrinter implements Printer {

    private final PrintStream printer;

    public ConsolePrinter(final PrintStream printer) {
        this.printer = printer;
    }

    @Override
    public <T> void print(final T message) {
        printer.print(message);
    }

    @Override
    public <T> void println(final T message) {
        printer.println(message);
    }

    @Override
    public <T> void println() {
        printer.println();
    }

    @Override
    public void printf(final String message, final Object... args) {
        printer.printf(message, args);
    }

}
