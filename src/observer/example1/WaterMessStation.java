package observer.example1;

import java.util.Observable;

/**
 * 具体主题
 * 水文站
 * @author: guangxush
 * @create: 2020/01/07
 */
public class WaterMessStation extends Observable {
    double waterVelocity;
    double waterDischarge;

    public void giveMessage(double waterVelocity, double waterDischarge) {
        if (this.waterVelocity != waterVelocity || this.waterDischarge != waterDischarge) {
            setChanged();
        }
        this.waterDischarge = waterDischarge;
        this.waterVelocity = waterVelocity;
        notifyObservers();
    }

    public double getWaterVelocity() {
        return waterVelocity;
    }

    public double getWaterDischarge() {
        return waterDischarge;
    }
}
