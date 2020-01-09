package bridge.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class CCTV5 extends CCTV implements Runnable {
    JLabel showFilm;
    Thread thread;
    ArrayList<String> content;

    CCTV5(Program program) {
        programMaker = program;
        setLayout(new BorderLayout());
        showFilm = new JLabel("CCTV5体育频道");
        showFilm.setFont(new Font("", Font.BOLD, 39));
        add(showFilm, BorderLayout.CENTER);
        thread = new Thread(this);
    }

    @Override
    public void makeProgram() {
        content = programMaker.makeTVProgram();
        if (!thread.isAlive()) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < content.size(); i++) {
            showFilm.setText(content.get(i));
            try {
                Thread.sleep(1500);
            } catch (InterruptedException exp) {
            }
        }
    }
}