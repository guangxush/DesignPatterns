package observer.example2;

import javax.swing.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ShowWord extends JPanel implements Observer {
    Observable subject;

    JTextArea text;

    TreeSet<String> wordList;

    ShowWord(Observable subject){
        this.subject = subject;
        subject.addObserver(this);
        text = new JTextArea(10,15);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setEditable(false);
        add(new JScrollPane(text));
        wordList = new TreeSet<>();
    }

    @Override
    public void update(Observable subject, Object object) {
        text.setText(null);
        text.append("出现的单词按照字典序排序：\n");
        wordList.clear();
        String context = object.toString();
        String regex = "[\\s\\d\\p{Punct}]";
        String[] words = context.split(regex);
        for(int i=0;i<words.length;i++){
            wordList.add(words[i]);
        }
        Iterator<String> iterator = wordList.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            text.append(str+" ");
        }
    }
}
