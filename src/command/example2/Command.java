package command.example2;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public interface Command {
    void execute(String name);

    /**
     * 撤销
     */
    void undo();
}
