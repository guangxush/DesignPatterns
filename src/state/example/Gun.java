package state.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Gun {
    State stateThree, stateTwo, stateOne, stateNull;
    State state;

    Gun() {
        stateThree = new BulletStateThree(this);
        stateTwo = new BulletStateTwo(this);
        stateOne = new BulletStateOne(this);
        stateNull = new BulletStateNull(this);
        state = stateThree;                   //手枪的默认状态是有3颗子弹
    }

    public void fire() {
        state.fire();
    }

    public void loadBullet() {
        state.loadBullet();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getBulletStateThree() {
        return stateThree;
    }

    public State getBulletStateTwo() {
        return stateTwo;
    }

    public State getBulletStateOne() {
        return stateOne;
    }

    public State getBulletStateNull() {
        return stateNull;
    }
}
