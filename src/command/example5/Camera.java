package command.example5;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Camera extends JPanel {
    String name;
    Icon imageIcon;
    JLabel label;
    public Camera(){
        label = new JLabel("我是摄像头");
        add(label);
    }

    public void on(){
        label.setIcon(new ImageIcon("cameraOpen.jpg"));
    }

    public void off(){
        label.setIcon(new ImageIcon("cameraClose.jpg"));
    }
}
