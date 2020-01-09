package proxy.example1;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application extends JFrame {
    ImageIconProxy icon;
    JButton button;

    Application() {
        try {
            icon = new ImageIconProxy(new URL("http://127.0.0.1:8080/tv.jpg"));
        } catch (Exception exp) {
        }
        button = new JButton();
        add(button, BorderLayout.CENTER);
        button.setIcon(icon);
        setSize(400, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String args[]) {
        new Application();
    }
}