package builder;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ConcreteBuilderOne implements Builder {

    //需要创建的容器
    private PanelProduct panel;

    ConcreteBuilderOne() {
        panel = new PanelProduct();
    }

    @Override
    public void buildButton() {
        panel.button = new JButton("按钮");
    }

    @Override
    public void buildLabel() {
        panel.label = new JLabel("标签");
    }

    @Override
    public void buildTextField() {
        panel.textField = new JTextField("文本框");
    }

    @Override
    public JPanel getPanel() {
        //与ConcreteBuilderTwo添加组件的顺序的不同
        panel.add(panel.button);
        panel.add(panel.label);
        panel.add(panel.textField);
        return panel;
    }
}