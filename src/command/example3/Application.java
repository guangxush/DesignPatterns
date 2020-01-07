package command.example3;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        RequestPerson person = new RequestPerson();
        Command command1 = new PrintLowerLetterCommand(new PrintLetter());
        Command command2 = new PrintUpperLetterCommand(new PrintLetter());
        Command command3 = new PrintNumberCommand(new PrintNumber(20));
        ArrayList<Command> list = new ArrayList<>();
        list.add(command1);
        list.add(command2);
        list.add(command3);
        Command macroCommand = new MacroCommand(list);
        System.out.println("英文字母：");
        person.setCommand(command1);
        person.startExecuteCommand();
        System.out.println();
        System.out.println("打印宏命令：");
        person.setCommand(macroCommand);
        person.startExecuteCommand();
    }
}
