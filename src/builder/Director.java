package builder;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Director {
    private Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }

    public JPanel constructProduct() {
        builder.buildButton();
        builder.buildLabel();
        builder.buildTextField();
        JPanel product = builder.getPanel();
        return product;
    }
}
