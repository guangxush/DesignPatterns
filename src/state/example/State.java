package state.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public abstract class State {
    public abstract void fire();

    public abstract void loadBullet();

    public abstract String showStateMess();
}
