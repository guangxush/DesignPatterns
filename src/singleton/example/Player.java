package singleton.example;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Player extends Thread {
    int MaxDistance;
    int stopTime, step;
    JButton com;
    JTextField showMess;
    Champion champion;

    Player(int stopTime, int step, int MaxDistance, JButton com, int w, int h, JTextField showMess) {
        this.stopTime = stopTime;
        this.step = step;
        this.MaxDistance = MaxDistance;
        this.com = com;
        this.showMess = showMess;
    }

    @Override
    public void run() {
        while (true) {
            int a = com.getBounds().x;
            int b = com.getBounds().y;
            if (a + com.getBounds().width >= MaxDistance) {
                champion = Champion.getChampion(com.getText());
                showMess.setText(champion.getMess());
                return;
            }
            a = a + step;
            com.setLocation(a, b);
            try {
                sleep(stopTime);
            } catch (InterruptedException exp) {
            }
        }
    }
}