package state.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class BulletStateThree extends State {
    Gun gun;

    BulletStateThree(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void fire() {
        System.out.print("射出一颗子弹");
        gun.setState(gun.getBulletStateTwo());
        System.out.println("(进入" + gun.getBulletStateTwo().showStateMess() + ")");
    }

    @Override
    public void loadBullet() {
        System.out.println("无法装弹");
    }

    @Override
    public String showStateMess() {
        return "3颗子弹状态";
    }
}
