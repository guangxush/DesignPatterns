package mediator.example1;

import javax.swing.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class GreenLight extends JLabel {
    ImageIcon onIcon, offIcon;

    GreenLight() {
        onIcon = new ImageIcon("onGreen.jpg");
        offIcon = new ImageIcon("offGreen.jpg");
        setHorizontalTextPosition(AbstractButton.CENTER);
        setVerticalTextPosition(AbstractButton.CENTER);
        setFont(new Font("宋体",Font.BOLD,11));
    }

    public void on(){
        setIcon(onIcon);
        setText("绿灯亮");
    }

    public void off(){
        setIcon(offIcon);
        setText("绿灯灭");
    }
}
