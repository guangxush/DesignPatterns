package observer.example1;

import java.util.Observable;
import java.util.Observer;

/**
 * 抗洪指挥部：观察者
 *
 * @author: guangxush
 * @create: 2020/01/07
 */
public class WaterDepartment implements Observer {

    Observable subject;
    double waterVelotity;
    double waterDischarge;

    public WaterDepartment(Observable subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (subject instanceof WaterMessStation) {
            WaterMessStation wms = (WaterMessStation) subject;
            waterVelotity = wms.getWaterVelocity();
            waterDischarge = wms.getWaterDischarge();
            System.out.println("流速：" + waterVelotity);
            System.out.println("流量：" + waterDischarge);
        }
    }
}
