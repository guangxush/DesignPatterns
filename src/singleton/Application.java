package singleton;

import javax.swing.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application{
    public static void main(String args[]){
        MyFrame f1=new MyFrame("张三看月亮");
        MyFrame f2=new MyFrame( "李四看月亮");
        f1.setBounds(10,10,360,150);
        f2.setBounds(370,10,360,150);
        f1.validate();
        f2.validate();
    }
}
class  MyFrame extends JFrame{
    String str;
    MyFrame(String title){
        setTitle(title);
        Moon moon=Moon.getMoon();
        str=moon.show();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        repaint();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("宋体", Font.BOLD,14));
        g.drawString(str,5,100);
    }
}
