package command.example2;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        MakeDir makeDir = new MakeDir();
        Command command = new ConcreteCommand(new ArrayList<>(), makeDir);
        RequestMakedir askMakedir = new RequestMakedir();
        askMakedir.setCommand(command);
        askMakedir.startExecuteCommand("hello");
        askMakedir.startExecuteCommand("world");
        askMakedir.undoCommand();
        askMakedir.undoCommand();
    }
}
