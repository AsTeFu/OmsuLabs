package omsu.astefu.labs.tasks;

public abstract class Task {

    private String title;

    public Task(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();
}
