package mediator.example1;

import javax.swing.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class YellowLight extends JLabel {
    ImageIcon onIcon, offIcon;

    YellowLight() {
        onIcon = new ImageIcon("onYellow.jpg");
        offIcon = new ImageIcon("offYellow.jpg");
        setHorizontalTextPosition(AbstractButton.CENTER);
        setVerticalTextPosition(AbstractButton.CENTER);
        setFont(new Font("宋体", Font.BOLD, 11));
    }

    public void on() {
        setIcon(onIcon);
        setText("黄灯亮");
    }

    public void off() {
        setIcon(offIcon);
        setText("黄灯灭");
    }
}