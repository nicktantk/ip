package chlo.command;

import chlo.exception.*;
import chlo.storage.*;
import chlo.task.*;
import chlo.ui.*;

/**
 * Represents a delete command that deletes a task from the task list.
 * Remove by index.
 */
public class DeleteCommand extends Command {
    private int index;
    public DeleteCommand(String index){
        this.index = Integer.parseInt(index);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task task = tasks.get(index);
            tasks.remove(index);
            ui.showMarkTask(task);
            storage.save(tasks);
        } catch (ChloException e) {
            System.out.println(e.getMessage());
        }
    }
}
