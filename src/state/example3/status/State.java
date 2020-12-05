package state.example3.status;

import state.example3.Context;

import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/12/05
 */
public abstract class State {
    public abstract void handlePush(Context c);

    public abstract void handlePull(Context c);

    public abstract Color getColor();
}
