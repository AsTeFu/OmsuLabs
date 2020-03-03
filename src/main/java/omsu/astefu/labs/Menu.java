package omsu.astefu.labs;

import java.util.ArrayList;

public class Menu {
    private final ArrayList<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(final String name, final Task func) {
        menuItems.add(new MenuItem(name, func));
    }

    public void print() {
        System.out.println("Menu:");
        menuItems.forEach(
                item -> System.out.println(String.format("[%d] %s", item.getIndex(), item.getName())));
    }

    public void accept(int index) {
        menuItems.get(index).accept();
    }

    public int getAmountItems() {
        return menuItems.size();
    }
}
