package command.example5;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Light extends JPanel{
    String name;
    Icon imageIcon;
    JLabel label;
    public Light(){
        label = new JLabel("我是灯");
        add(label);
    }

    public void on(){
        label.setIcon(new ImageIcon("LightOpen.jpg"));
    }

    public void off(){
        label.setIcon(new ImageIcon("LightClose.jpg"));
    }
}
