package state;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class HeightState implements TemperatureState {
    double n = 26;

    HeightState(int n) {
        if (n > 26) {
            this.n = n;
        }
    }

    @Override
    public void showTemperature() {
        System.out.println("现在温度是" + n + "属于高温度");
    }
}
