public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(String index) {
        this.index = Integer.parseInt(index);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.get(index);
        task.markUndone();
        ui.showUnmarkTask(task);
    }

}
