package command.example3;

import java.util.ArrayList;

/**
 * 创建宏命令
 * @author: guangxush
 * @create: 2020/01/07
 */
public class MacroCommand implements Command{
    ArrayList<Command> commandList;

    public MacroCommand(ArrayList<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        for(int i=0;i<commandList.size();i++){
            Command command = commandList.get(i);
            command.execute();
        }
    }
}
