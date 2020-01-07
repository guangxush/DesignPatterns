package command.example5;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Invoker {
    JButton button;
    Command command;
    Invoker(){
        button = new JButton();
        button.addActionListener(e -> executeCommand());
    }

    public void setCommand(Command command) {
        this.command = command;
        button.setText(command.getName());
    }

    public JButton getButton() {
        return button;
    }

    private void executeCommand(){
        command.execute();
    }
}
