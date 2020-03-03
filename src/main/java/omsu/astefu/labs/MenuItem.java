package omsu.astefu.labs;

public class MenuItem {

    private String name;
    private int index;
    private Task function;

    private static int maxIndex = 0;

    public MenuItem(String name, Task function) {
        this.name = name;
        this.function = function;
        this.index = maxIndex++;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void accept() {
        function.accept();
    }
}
