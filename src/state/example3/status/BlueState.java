package state.example3.status;

import state.example3.Context;

import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/12/05
 */
public class BlueState extends State {

    @Override
    public void handlePush(Context c) {
        c.setState(new RedState());
    }

    @Override
    public void handlePull(Context c) {
        c.setState(new GreenState());
    }

    @Override
    public Color getColor() {
        return (Color.BLUE);
    }
}
