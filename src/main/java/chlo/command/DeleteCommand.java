package chlo.command;

import chlo.exception.ChloException;
import chlo.storage.Storage;
import chlo.task.Task;
import chlo.task.TaskList;
import chlo.ui.Ui;

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
