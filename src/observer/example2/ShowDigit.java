package observer.example2;

import javax.swing.*;
import java.util.*;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ShowDigit extends JPanel implements Observer {
    Observable subject;

    JTextArea text;

    Vector<String> vector;

    ShowDigit(Observable subject){
        this.subject = subject;
        subject.addObserver(this);
        text = new JTextArea(10,15);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        add(new JScrollPane(text));
        vector = new Vector<>();
    }

    @Override
    public void update(Observable subject, Object object) {
        text.setText(null);
        text.append("出现的数字有：\n");
        vector.removeAllElements();
        String context = object.toString();
        String regex = "\\D+";
        String[] digitWords = context.split(regex);
        for(int i=0;i<digitWords.length;i++){
            if(!vector.contains(digitWords[i])){
                vector.add(digitWords[i]);
            }
        }
        for(int i=0;i<vector.size();i++){
            text.append(vector.elementAt(i)+" ");
        }
    }
}
