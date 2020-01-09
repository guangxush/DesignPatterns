package state.example2;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class HaveCoffeeNoCoin extends State {
    AutoCoffeeMachine machine;

    HaveCoffeeNoCoin(AutoCoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void giveAnCupCaffee() {
        machine.messShowing.setIcon(new ImageIcon("machine.jpg"));
        showMessage();
    }

    @Override
    public void showMessage() {
        machine.messShowing.setText("请投入一枚一元硬币");
    }
}
