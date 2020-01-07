package adapter;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        ThreeElectricOutlet outlet;
        Wash wash = new Wash();
        outlet = wash;
        System.out.println("使用三相电源接通电流：");
        outlet.connectElectricCurrent();

        TV tv = new TV();
        ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv);
        outlet = adapter;
        System.out.println("使用三相电源接通电流：");
        outlet.connectElectricCurrent();
    }
}

class Wash implements ThreeElectricOutlet{
    String name;

    public Wash() {
        this.name = "洗衣机";
    }

    public Wash(String name) {
        this.name = name;
    }


    public void turnOn(){
        System.out.println(name + "开始洗衣服");
    }

    @Override
    public void connectElectricCurrent() {
        turnOn();
    }
}

class TV implements TwoElectricOutlet{
    String name;

    public TV() {
        this.name = "电视机";
    }

    public TV(String name) {
        this.name = name;
    }


    public void turnOn(){
        System.out.println(name + "开始播放节目");
    }

    @Override
    public void connectElectricCurrent() {
        turnOn();
    }
}