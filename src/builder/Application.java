package builder;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String args[]) {
        Builder builder = new ConcreteBuilderOne();
        Director director = new Director(builder);
        JPanel panel = director.constructProduct();
        JFrame frameOne = new JFrame();
        frameOne.add(panel);
        frameOne.setBounds(12, 12, 200, 120);
        frameOne.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameOne.setVisible(true);
        builder = new ConcreteBuilderTwo();
        director = new Director(builder);
        panel = director.constructProduct();
        JFrame frameTwo = new JFrame();
        frameTwo.add(panel);
        frameTwo.setBounds(212, 12, 200, 120);
        frameTwo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTwo.setVisible(true);
    }
}
