package mediator.example1;

import javax.swing.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application extends JFrame {

    ConcreteMediator mediator;
    RedLight SNredLight;
    GreenLight SNgreenLight;
    YellowLight SNyellowLight;

    RedLight EWredLight;
    GreenLight EWgreenLight;
    YellowLight EWyellowLight;

    public Application() {
        mediator = new ConcreteMediator();
        SNredLight = new RedLight();
        SNgreenLight = new GreenLight();
        SNyellowLight = new YellowLight();
        EWredLight = new RedLight();
        EWgreenLight = new GreenLight();
        EWyellowLight = new YellowLight();

        Box westBox = Box.createVerticalBox();
        westBox.add(EWgreenLight);
        westBox.add(EWyellowLight);
        westBox.add(EWredLight);

        Box northBox = Box.createHorizontalBox();
        northBox.add(SNgreenLight);
        northBox.add(SNyellowLight);
        northBox.add(SNredLight);

        JPanel pNorth = new JPanel();
        pNorth.add(northBox);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(pNorth, BorderLayout.NORTH);
        add(westBox, BorderLayout.WEST);

        JButton road = new JButton(new ImageIcon("road.jpg"));
        add(road, BorderLayout.CENTER);
        register();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mediator.startRun();
    }

    private void register() {
        mediator.registerSNYellowLight(SNyellowLight);
        mediator.registerEWYellowLight(EWyellowLight);
        mediator.registerSNRedLight(SNredLight);
        mediator.registerEWRedLight(EWredLight);
        mediator.registerSNGreenLight(SNgreenLight);
        mediator.registerEWGreenLight(EWgreenLight);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.setBounds(100,200,300,300);
        application.setVisible(true);
    }
}
