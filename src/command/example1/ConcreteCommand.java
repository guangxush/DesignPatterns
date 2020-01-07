package command.example1;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ConcreteCommand implements Command{

    CompanyArmy army;

    public ConcreteCommand(CompanyArmy companyArmy){
        army = companyArmy;
    }

    /**
     * 封装指挥官的指挥请求
     */
    @Override
    public void execute() {
        //偷袭敌人
        army.sneakAttack();
    }
}
