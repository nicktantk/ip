package chlo.command;

import chlo.exception.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;

/**
 * Represents a mark command that marks a task as done.
 * Marks by index.
 */
public class MarkCommand extends Command {
    private String index;
    public MarkCommand(String index) {
        this.index = index;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int i =  Integer.parseInt(index) - 1;
            Task task = tasks.get(i);
            task.markDone();
            ui.showMarkTask(task);
        } catch (ChloException e) {
            ui.showError(e.getMessage());
        }
    }
}