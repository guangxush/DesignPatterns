package adapter;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ThreeAndTwoElectricAdapter implements ThreeElectricOutlet, TwoElectricOutlet{

    TwoElectricOutlet twoElectricOutlet;
    ThreeElectricOutlet threeElectricOutlet;

    public ThreeAndTwoElectricAdapter(TwoElectricOutlet twoElectricOutlet, ThreeElectricOutlet threeElectricOutlet) {
        this.twoElectricOutlet = twoElectricOutlet;
        this.threeElectricOutlet = threeElectricOutlet;
    }

    public ThreeAndTwoElectricAdapter(ThreeElectricOutlet threeElectricOutlet, TwoElectricOutlet twoElectricOutlet) {
        this.twoElectricOutlet = twoElectricOutlet;
        this.threeElectricOutlet = threeElectricOutlet;
    }

    @Override
    public void connectElectricCurrent() {
        if(this instanceof ThreeElectricOutlet){
            // two是被适配的接口
            twoElectricOutlet.connectElectricCurrent();
        }
        if(this instanceof TwoElectricOutlet){
            // three是被适配的接口
            threeElectricOutlet.connectElectricCurrent();
        }
    }
}
