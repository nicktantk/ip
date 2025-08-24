import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(Task t) { tasks.add(t); }

    public Task remove(int index) { return tasks.remove(index); }

    public Task get(int index) { return tasks.get(index); }

    public int size() { return tasks.size(); }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // ... Mark, unmark, etc.
}
