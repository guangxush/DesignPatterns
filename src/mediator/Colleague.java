package mediator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public interface Colleague {
    void giveMess(String[] mess);
    void receiverMess(String mess);
    void setName(String name);
    String getName();
}
