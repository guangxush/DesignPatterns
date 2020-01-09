package bridge.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application extends JFrame {
    JButton seeProgram;
    CCTV cctv;
    Program program;

    Application(CCTV tv, Program program) {
        cctv = tv;
        this.program = program;
        add(cctv, BorderLayout.CENTER);
        seeProgram = new JButton("看节目");
        add(seeProgram, BorderLayout.SOUTH);
        seeProgram.addActionListener((e) -> cctv.makeProgram());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {
        Program program = new AthleticProgram();
        CCTV cctv = new CCTV5(program);
        Application application1 = new Application(cctv, program);
        application1.setBounds(10, 10, 200, 300);
        program = new FilmProgram();
        cctv = new CCTV6(program);
        Application application2 = new Application(cctv, program);
        application2.setBounds(220, 10, 200, 300);
    }
}