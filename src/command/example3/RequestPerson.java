package command.example3;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class RequestPerson {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void startExecuteCommand(){
        command.execute();
    }
}
