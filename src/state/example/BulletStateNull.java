package state.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class BulletStateNull extends State {
    Gun gun;

    BulletStateNull(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void fire() {
        System.out.print("不能射出子弹");
        System.out.println("(目前是" + showStateMess() + ")");
    }

    @Override
    public void loadBullet() {
        System.out.print("装弹");
        gun.setState(gun.getBulletStateThree());
        System.out.println("(进入" + gun.getBulletStateThree().showStateMess() + ")");
    }

    @Override
    public String showStateMess() {
        return "无子弹状态";
    }
}
