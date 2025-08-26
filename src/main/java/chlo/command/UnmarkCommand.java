package chlo.command;

import chlo.exception.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;

/**
 * Represents an unmark command that unmarks a task in the task list.
 * Unmarks by index.
 */
public class UnmarkCommand extends Command {
    private final String index;

    public UnmarkCommand(String index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int i = Integer.parseInt(index) - 1;
            Task task = tasks.get(i);
            task.markUndone();
            ui.showUnmarkTask(task);
        } catch (ChloException e) {
            ui.showError(e.getMessage());
        }
    }

}