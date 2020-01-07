package observer.example2;

import javax.swing.*;
import java.awt.*;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application extends JFrame {
    Application(){
        InputTextSubject textSubject = new InputTextSubject();
        ShowWord observerWord = new ShowWord(textSubject);
        ShowDigit observerDigit = new ShowDigit(textSubject);
        setLayout(new FlowLayout());
        add(new JScrollPane(textSubject.getJTextArea()));
        add(observerWord);
        add(observerDigit);
        setBounds(20,20,400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Application();
    }
}
