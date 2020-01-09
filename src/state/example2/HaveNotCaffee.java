package state.example2;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class HaveNotCaffee extends State {
    AutoCoffeeMachine machine;

    HaveNotCaffee(AutoCoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void giveAnCupCaffee() {
        machine.messShowing.setIcon(new ImageIcon("no.jpg"));
        machine.putInCoin.setEnabled(false);
        machine.getCaffee.setEnabled(false);
        showMessage();
    }

    @Override
    public void showMessage() {
        machine.messShowing.setText("目前机器中没有咖啡");
    }
}

