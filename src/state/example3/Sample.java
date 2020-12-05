package state.example3;

import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/12/05
 */
public class Sample {
    private Color color;

    public Sample(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void operate(){
        System.out.println();
    }
}
