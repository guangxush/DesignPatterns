package command.example4;

import javax.swing.*;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ClientUseButton extends JFrame {
    JButton button;
    Command command;
    Invoker person;

    public ClientUseButton(){
        person = new Invoker();
        command = new MultiCommand(new ShowMultiForm());
        person.setCommand(command);
        JFrame frame = new JFrame();
        frame.setLayout(new java.awt.FlowLayout());
        button = person.getButton();
        frame.add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public static void main(String[] args) {
        ClientUseButton win = new ClientUseButton();
    }
}
