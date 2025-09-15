package chlo.ui;

import chlo.task.Task;
import chlo.task.TaskList;

import java.util.Scanner;



public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public String getError(String message) {
        return message;
    }

    public String getTaskList(TaskList tasks) {
        return (tasks.size() == 0 ? "No current tasks" : "Here are the tasks in your list:\n" + tasks.getTasks());
    }

    public String getFilteredList(TaskList tasks, String s) {
        return (tasks.size() == 0 ? "No current tasks." : tasks.getFilteredTasks(s));
    }

    public String getLoadingError() {
        return getError("Error loading tasks!");
    }

    public String getAddTask(Task task, int numTasks) {
        return String.format("Got it. I've added this task:\n" + task) + "\n" + String.format("Now you have %d tasks in the list.", numTasks);
    }

    public String getMarkTask(Task task) {
        return "Got it. I've marked this task:\n" + task;
    }

    public String getUnmarkTask(Task task) {
        return "Got it. I've unmarked this task:\n" + task;
    }
}
