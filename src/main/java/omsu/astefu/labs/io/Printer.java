package omsu.astefu.labs.io;

public interface Printer {

    <T> void print( T message);

    <T> void println(T message);
    <T> void println();

    void printf(String message, Object... args);

}
