package omsu.astefu.labs;

public class Task2 implements Task {

    private final Reader reader;
    private final int amount;

    public Task2(final Reader reader, final int amount) {
        this.reader = reader;
        this.amount = amount;
    }

    @Override
    public void accept() {
        for (int i = 0; i < amount; i++) {
            System.out.println(String.format("\n\tCut %d:", i));
            long days = reader.getTimeCut(reader);
            System.out.println(printFactorial(days));
        }
    }

    private static String printFactorial(long cut) {
        try {
            long fact = factorial(cut);
            return String.format("\n\tFactorial %d! = %d\n", cut, fact);
        } catch (IllegalArgumentException ex) {
            return "\t" + ex.getMessage();
        }
    }

    private static long factorial(long n) {
        if (n < 0 || n > 30)
            throw new IllegalArgumentException(n < 0 ? "Argument less than zero" : "Argument is sooo big");
        return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
    }
}
