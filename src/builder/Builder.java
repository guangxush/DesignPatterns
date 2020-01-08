package builder;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public interface Builder {
    void buildButton();

    void buildLabel();

    void buildTextField();

    JPanel getPanel();
}