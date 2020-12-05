package state.example3.status;

import state.example3.Context;

import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/12/05
 */
public class BlackState extends State {
    @Override
    public void handlePush(Context c) {
        c.setState(new GreenState());
    }

    @Override
    public void handlePull(Context c) {
        c.setState(new RedState());
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}
