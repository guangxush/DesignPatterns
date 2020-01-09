package state.example2;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class HaveCoffeeAndCoin extends State {
    AutoCoffeeMachine machine;

    HaveCoffeeAndCoin(AutoCoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void giveAnCupCaffee() {
        int count = machine.getCaffeeCount();
        if (count == 0) {
            machine.setState(machine.getHaveNotCaffee());
            machine.messShowing.setText("没有咖啡了");
            machine.messShowing.setIcon(new ImageIcon("no.jpg"));
        } else if (count == 1) {
            machine.messShowing.setIcon(new ImageIcon("caffee.jpg"));
            machine.setCaffeeCount(count - 1);
            showMessage();
            machine.setState(machine.getHaveNotCaffee());
        } else {
            machine.messShowing.setIcon(new ImageIcon("caffee.jpg"));
            machine.setCaffeeCount(count - 1);
            showMessage();
            machine.setState(machine.getHaveCoffeeNoCoin());
        }
    }

    @Override
    public void showMessage() {
        machine.messShowing.setText("您得到一杯咖啡");
    }
}