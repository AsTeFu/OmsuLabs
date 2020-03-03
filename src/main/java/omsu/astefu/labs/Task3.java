package omsu.astefu.labs;

import java.util.regex.Pattern;

public class Task3 implements Task {

    public static final String REGEX_EMAIL = "[^@ \t\r\n]+@[^@ \t\r\n]+\\.[^@ \t\r\n]+";
    public static final String REGEX_PHONE = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";
    public static final String REGEX_IP = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
    private Reader reader;

    public Task3(final Reader reader) {
        this.reader = reader;
    }

    @Override
    public void accept() {
        String line1 = reader.getLine("\nEnter first line: ");
        String line2 = reader.getLine("Enter second line: ");

        System.out.println(isEquals(line1, line2));
        System.out.println(isEquals(formatLine(line1), formatLine(line2)));
        System.out.println(String.format("The line '%s' is %s a shifter of line '%s'",
                line1, isShifter(line1, line2) ? "" : "not", line2));
        System.out.println(String.format("Email: line1: %b; line2: %b",
                isPattern(line1, REGEX_EMAIL), isPattern(line2, REGEX_EMAIL)));
        System.out.println(String.format("Phone: line1: %b; line2: %b",
                isPattern(line1, REGEX_PHONE), isPattern(line2, REGEX_PHONE)));
        System.out.println(String.format("IP: line1: %b; line2: %b",
                isPattern(line1, REGEX_IP), isPattern(line2, REGEX_IP)));
    }

    private static boolean isPattern(final String line, final String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(line).find();
    }

    private static boolean isShifter(final String line1, final String line2) {
        if (line1.length() != line2.length()) return false;
        for (int i = 0; i < line1.length() / 2; i++) {
            if (line1.charAt(i) != line2.charAt(line2.length() - i - 1)) return false;
        }
        return true;
    }

    private static String formatLine(final String line) {
        return line.toLowerCase().trim().replaceAll("[\\s]+", " ");
    }

    private static String isEquals(String line1, String line2) {
        return String.format("%s %s equals %s", line1, line1.equals(line2) ? "" : "not", line2);
    }
}
