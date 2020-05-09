package omsu.astefu.labs.tasks;

import omsu.astefu.labs.io.Printer;
import omsu.astefu.labs.io.Reader;

import javax.xml.bind.ValidationException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class StringsTask extends Task {

    private static final String STRINGS = "Strings";

    private static final String REGEX_EMAIL = "[^@ \t\r\n]+@[^@ \t\r\n]+\\.[^@ \t\r\n]+";
    private static final String REGEX_PHONE = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";
    private static final String REGEX_IP = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";

    private final Reader reader;
    private final Printer printer;

    public StringsTask(final String title, final Reader reader, final Printer printer) {
        super(title);
        this.reader = reader;
        this.printer = printer;
    }

    public StringsTask(final Reader reader, final Printer printer) {
        this(STRINGS, reader, printer);
    }

    @Override
    public void execute() {
        String line1 = reader.getLine("\nEnter first line: ");
        String line2 = reader.getLine("Enter second line: ");

        validation(line1, line2, this::validationEquals);
        validation(formatLine(line1), formatLine(line2), this::validationEquals);

        validation(line1, line2, this::validationShifter);

        validationLinesByPattern(REGEX_EMAIL, line1, line2);
        validationLinesByPattern(REGEX_PHONE, line1, line2);
        validationLinesByPattern(REGEX_IP, line1, line2);

        /*
        printer.println(equalsStrings(line1, line2));
        printer.println(equalsStrings(formatLine(line1), formatLine(line2)));

        printer.printf("The line '%s' is %s a shifter of line '%s'\n",
                line1, isShifter(line1, line2) ? "" : "not", line2);

        printer.printf("Email: line1: %b; line2: %b\n",
                isPattern(REGEX_EMAIL, line1), isPattern(REGEX_EMAIL, line2));

        printer.printf("Phone: line1: %b; line2: %b\n",
                isPattern(REGEX_PHONE, line1), isPattern(REGEX_PHONE, line2));

        printer.printf("IP: line1: %b; line2: %b\n",
                isPattern(REGEX_IP, line1), isPattern(REGEX_IP, line2));
        */
    }

    private void validation(String s1, String s2, ValidatorLine validator) {
        try {
            validator.validation(s1, s2);
        } catch (ValidationException ex) {
            printer.println(ex.getMessage());
        }
    }

    private void validationLinesByPattern(final String regex, final String line1, final String line2) {
        validation(regex, line1, this::validationPatter);
        validation(regex, line2, this::validationPatter);
    }

    private boolean isPattern(final String regex, final String line) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(line).find();
    }

    private boolean isShifter(final String line1, final String line2) {
        return line1.equals(new StringBuilder(line2).reverse().toString());
    }

    private String formatLine(final String line) {
        return line.toLowerCase().trim().replaceAll("[\\s]+", " ");
    }

    private String equalsStrings(final String line1, final String line2) {
        return String.format("%s %s equals %s", line1, line1.equals(line2) ? "" : "not", line2);
    }

    private void validationEquals(final String line1, final String line2) throws ValidationException {
        if (!line1.equals(line2))
            throw new ValidationException(String.format("%s not equals %s", line1, line2));

        printer.printf("%s equals %s\n", line1, line2);
    }

    private void validationShifter(final String line1, final String line2) throws ValidationException {
        if (!isShifter(line1, line2))
            throw new ValidationException(String.format("%s is not a shifter %s", line1, line2));

        printer.printf("%s is a shifter %s\n", line1, line2);
    }

    private void validationPatter(final String regex, final String line) throws ValidationException {
        if (!isPattern(regex, line))
            throw new ValidationException(line + " doesn't match " + regex.replaceAll("[\\n\\r\\t]+", ""));

        printer.printf("%s match %s\n", line, regex);
    }

}

