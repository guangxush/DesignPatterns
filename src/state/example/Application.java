package state.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application {
    public static void main(String args[]) {
        Gun gun = new Gun();
        gun.fire();
        gun.fire();
        gun.fire();
        gun.fire();
        gun.loadBullet();
        gun.fire();
    }
}
