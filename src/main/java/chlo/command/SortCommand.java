package chlo.command;


import chlo.storage.Storage;
import chlo.task.TaskList;
import chlo.ui.Ui;


public class SortCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.sort();
        setString(ui.getTaskList(tasks));
    }
}
