package state.example1;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public abstract class State {
    public abstract void startUp(Vehicle vehicle);

    public abstract void stop(Vehicle vehicle);
}

