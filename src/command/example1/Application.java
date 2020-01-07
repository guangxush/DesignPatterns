package command.example1;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        //创建接收者
        CompanyArmy army = new CompanyArmy();
        //创建具体命令并指定接收者
        Command command = new ConcreteCommand(army);
        //创建请求者
        ArmySuperior superior = new ArmySuperior();
        superior.setCommand(command);
        superior.startExecuteCommand();
    }
}
