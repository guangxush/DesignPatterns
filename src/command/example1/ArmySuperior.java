package command.example1;

/**
 * 指挥官
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ArmySuperior {
    Command command;

    public void setCommand(Command command){
        this.command  = command;
    }

    /**
     * 让具体的命令去执行execute()方法
     */
    public void startExecuteCommand(){
        command.execute();
    }
}
