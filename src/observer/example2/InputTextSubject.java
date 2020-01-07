package observer.example2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Observable;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class InputTextSubject extends Observable {
    String content;
    JTextArea text;
    InputTextSubject(){
        text = new JTextArea(10,15);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        (text.getDocument()).addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                content = text.getText();
                setChanged();
                notifyObservers(content);
            }
        });
    }

    public String getContent(){
        return content;
    }

    public JTextArea getJTextArea(){
        return text;
    }
}
