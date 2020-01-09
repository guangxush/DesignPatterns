package state.example1;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class VehicleRestState extends State {
    @Override
    public void startUp(Vehicle vehicle) {
        System.out.println(vehicle.getName() + "开始运动");
        vehicle.setState(vehicle.getMoveState());
    }

    @Override
    public void stop(Vehicle vehicle) {
        System.out.println(vehicle.getName() + "已经是静止状态了");
    }
}