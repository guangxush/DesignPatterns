package observer.example1;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        WaterMessStation waterStation = new WaterMessStation();
        WaterDepartment department = new WaterDepartment(waterStation);
        waterStation.giveMessage(10,209);
        waterStation.giveMessage(8,210);
        waterStation.giveMessage(9,211);
    }
}
