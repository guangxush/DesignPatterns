package builder;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ConcreteBuilderTwo implements Builder {
    //需要创建的容器
    private PanelProduct panel;

    ConcreteBuilderTwo() {
        panel = new PanelProduct();
    }

    @Override
    public void buildButton() {
        panel.button = new JButton("button");
    }

    @Override
    public void buildLabel() {
        panel.label = new JLabel("label");
    }

    @Override
    public void buildTextField() {
        panel.textField = new JTextField("textField");
    }

    @Override
    public JPanel getPanel() {
        //与ConcreteBuilderOne添加组件的顺序的不同
        panel.add(panel.textField);
        panel.add(panel.label);
        panel.add(panel.button);
        return panel;
    }
}
