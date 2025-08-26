package chlo.ui;

import java.util.Scanner;
import chlo.command.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.exception.*;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Welcome back! I'm chlo.Chlo!");
        System.out.println("What else can I do?");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("-".repeat(50));
    }

    public void showError(String message) {
        showLine();
        System.out.println(message);
        showLine();
    }

    public void showTaskList(TaskList tasks) {
        showLine();
        if (tasks.size() == 0) {
            System.out.println("No current tasks.");
        } else {
            System.out.println("Here are the tasks in your list:");
            tasks.printTasks();
        }
        showLine();
    }

    public void showLoadingError() {
        showError("Error loading tasks!");
    }

    public void showAddTask(Task task, int numTasks) {
        showLine();
        System.out.println("Got it. I've added this task:\n" + task);
        System.out.printf("Now you have %d tasks in the list.%n", numTasks);
        showLine();
    }

    public void showMarkTask(Task task) {
        showLine();
        System.out.println("Got it. I've marked this task:\n" + task);
        showLine();
    }

    public void showUnmarkTask(Task task) {
        showLine();
        System.out.println("Got it. I've unmarked this task:\n" + task);
        showLine();
    }
}
