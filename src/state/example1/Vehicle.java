package state.example1;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Vehicle {
    static State moveState, restState;
    static State state;
    String name;

    Vehicle(String name) {
        this.name = name;
        moveState = new VehicleMoveState();
        restState = new VehicleRestState();
        //车辆的默认状态是静止状态
        state = restState;
    }

    public void startUp() {
        state.startUp(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getMoveState() {
        return moveState;
    }

    public State getRestState() {
        return restState;
    }

    public String getName() {
        return name;
    }
}
