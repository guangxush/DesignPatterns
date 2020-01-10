package memento.com.shgx;

import java.io.Serializable;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Memento implements Serializable {
    private long state;

    void setPositionState(long state) {
        this.state = state;
    }

    long getPositionState() {
        return state;
    }
}
