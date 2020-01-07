package adapter;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ThreeElectricAdapter implements ThreeElectricOutlet{
    TwoElectricOutlet outlet;
    ThreeElectricAdapter(TwoElectricOutlet outlet){
        this.outlet = outlet;
    }
    @Override
    public void connectElectricCurrent(){
        outlet.connectElectricCurrent();
    }
}
