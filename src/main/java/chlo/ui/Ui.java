package chlo.ui;

import java.util.Scanner;

import chlo.command.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.exception.*;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public String getWelcome() {
        return "Welcome back! I'm Chlo! What can I do for you?";
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public String getLine() {
        return "-".repeat(50);
    }

    public String getError(String message) {
        return getLine() + "\n" + message + "\n" + getLine();
    }

    public String getTaskList(TaskList tasks) {
        return getLine() + "\n" +
                (tasks.size() == 0 ? "No current tasks" : "Here are the tasks in your list:\n" +
                        tasks.getTasks()) + "\n" +
                getLine();

    }

    public String getFilteredList(TaskList tasks, String s) {
        return getLine() + "\n" + (tasks.size() == 0 ? "No current tasks." : tasks.getFilteredTasks(s)) + "\n" + getLine();
    }

    public String getLoadingError() {
        return getError("Error loading tasks!");
    }

    public String getAddTask(Task task, int numTasks) {
        return getLine() + "\n" +
                String.format("Got it. I've added this task:\n" + task) + "\n" +
                String.format("Now you have %d tasks in the list.", numTasks) + "\n" +
                getLine();
    }

    public String getMarkTask(Task task) {
        return getLine() + "\n" +
                "Got it. I've marked this task:\n" + task + "\n" +
                getLine();
    }

    public String getUnmarkTask(Task task) {
        return getLine() +  "\n" +
                "Got it. I've unmarked this task:" + task + "\n" +
                getLine();
    }
}
