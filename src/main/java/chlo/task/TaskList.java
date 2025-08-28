package chlo.task;

import chlo.exception.ChloException;

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

    public Task get(int index) throws ChloException {
        try {
            return tasks.get(index);
        } catch (Exception e) {
            throw new ChloException("Index not valid.");
        }
    }

    public int size() { return tasks.size(); }

    public String getTasks() {
        StringBuilder s =  new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            s.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
        }
        return s.toString();
    }

    public String getFilteredTasks(String s) {
        int count = 0;
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(s)) {
                count++;
                t.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
        }
        if (count == 0) {
            return "No such task found.";
        }
        return t.toString();
    }

    public void markTask(Task t) {
        t.markDone();
    }

    public void unmarkTask(Task t) {
        t.markUndone();
    }
}
