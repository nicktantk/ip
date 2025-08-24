package chlo.command;

import chlo.ui.*;
import chlo.storage.*;
import chlo.task.*;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }
}
