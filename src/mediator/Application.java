package mediator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ColleagueA colleagueA = new ColleagueA(mediator);
        ColleagueB colleagueB = new ColleagueB(mediator);
        ColleagueC colleagueC = new ColleagueC(mediator);
        colleagueA.setName("A");
        colleagueB.setName("B");
        colleagueC.setName("C");

        String[] messA = {"aaaa","bbbb"};
        colleagueA.giveMess(messA);
    }
}
