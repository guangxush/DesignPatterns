package state.example2;

import javax.swing.*;
import java.awt.*;


/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class AutoCoffeeMachine extends JFrame {
    State haveCoffeeNoCoin, haveCoffeeAndCoin, haveNotCaffee;
    State state;
    JButton putInCoin, getCaffee;
    JLabel messShowing;
    int caffeeCount;             //记录一共有多少杯咖啡

    AutoCoffeeMachine(int caffeeCount) {
        this.caffeeCount = caffeeCount;
        haveCoffeeNoCoin = new HaveCoffeeNoCoin(this);
        haveCoffeeAndCoin = new HaveCoffeeAndCoin(this);
        haveNotCaffee = new HaveNotCaffee(this);
        state = haveCoffeeNoCoin;   //咖啡机的默认状态是有咖啡但无人投币
        putInCoin = new JButton("投币");
        getCaffee = new JButton("取咖啡");
        putInCoin.addActionListener(exp -> {
            if (state == haveCoffeeNoCoin) {
                state = haveCoffeeAndCoin;
                messShowing.setText("您投币一元");
                messShowing.setIcon(new ImageIcon("./machine.jpg"));
            } else if (state == haveCoffeeAndCoin) {
                messShowing.setText("您已经投币一元，请取咖啡");
                messShowing.setIcon(new ImageIcon("./machine.jpg"));
            } else if (state == haveNotCaffee) {
                messShowing.setText("没有咖啡，无法投币");
                messShowing.setIcon(new ImageIcon("./no.jpg"));
            }
        });
        getCaffee = new JButton("取咖啡");
        getCaffee.addActionListener(exp -> giveAnCupCaffee());
        messShowing = new JLabel();
        messShowing.setIcon(new ImageIcon("./machine.jpg"));
        messShowing.setFont(new Font("", Font.BOLD, 14));
        JPanel pSouth = new JPanel();
        pSouth.add(putInCoin);
        pSouth.add(getCaffee);
        add(messShowing, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void giveAnCupCaffee() {
        state.giveAnCupCaffee();
    }

    public void showMessage() {
        state.showMessage();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getHaveCoffeeNoCoin() {
        return haveCoffeeNoCoin;
    }

    public State getHaveCoffeeAndCoin() {
        return haveCoffeeAndCoin;
    }

    public State getHaveNotCaffee() {
        return haveNotCaffee;
    }

    public int getCaffeeCount() {
        return caffeeCount;
    }

    public void setCaffeeCount(int n) {
        caffeeCount = n;
    }
}