package mediator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ColleagueC implements Colleague{
    ConcreteMediator mediator;
    String name;

    public ColleagueC(ConcreteMediator mediator) {
        this.mediator = mediator;
        mediator.registerColleagueC(this);
    }

    @Override
    public void giveMess(String[] mess) {
        mediator.deliverMess(this, mess);
    }

    @Override
    public void receiverMess(String mess) {
        System.out.print(name+"收到的信息是：");
        System.out.println("\t"+mess);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
