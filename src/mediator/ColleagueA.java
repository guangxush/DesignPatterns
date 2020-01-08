package mediator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ColleagueA implements Colleague{
    ConcreteMediator mediator;
    String name;

    public ColleagueA(ConcreteMediator mediator) {
        this.mediator = mediator;
        mediator.registerColleagueA(this);
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
