package singleton;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Moon {
    private static Moon uniqueMoon;
    double radius;
    double distanceToEarth;

    private Moon() {
        uniqueMoon = this;
        radius = 1738;
        distanceToEarth = 363300;
    }

    public static synchronized Moon getMoon() {   //这是一个同步方法
        if (uniqueMoon == null) {
            uniqueMoon = new Moon();
        }
        return uniqueMoon;
    }

    public String show() {
        String s = "月亮的半径是" + radius + "km,距地球是" + distanceToEarth + "km";
        return s;
    }
}
