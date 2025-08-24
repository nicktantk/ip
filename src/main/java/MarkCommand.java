public class MarkCommand extends Command {
    private int index;
    public MarkCommand(String index) {
        this.index = Integer.parseInt(index) - 1;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.get(index);
        task.markDone();
        ui.showMarkTask(task);
    }
}
