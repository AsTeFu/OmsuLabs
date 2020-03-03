package omsu.astefu.labs;

public class Task1 implements Task {

    private Reader reader;

    public Task1(final Reader reader) {
        this.reader = reader;
    }

    @Override
    public void accept() {
        int x = reader.readNumber(num -> num < 0, "\n\tEnter x: ", "\tEnter positive number: ");
        int z = reader.readNumber(num -> num == 0, "\n\tEnter z: ", "\tEnter not zero: ");
        double result = calculateFormula(x, z);
        System.out.println(String.format("\n\tSqrt(%d) - 6 / %d = %.3f\n", x, z, result));
    }

    private double calculateFormula(int x, int z) {
        return Math.sqrt(x) - 6.0 / z;
    }
}
