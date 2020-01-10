package memento.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class UnicodeLabel extends JLabel {
    private Integer m;

    public UnicodeLabel() {
        setFont(new Font("宋体", Font.BOLD, 100));
        setHorizontalAlignment(SwingConstants.CENTER);
        m = new Integer(19968);
        setText("" + (char) m.intValue());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    m = (int) (Math.random() * 1000 + 19968);
                    setText("" + (char) m.intValue());
                }
            }
        });
    }

    public Memento createMemento() {
        Memento mem = new Memento();
        mem.setState(m);
        return mem;
    }

    public void restoreFromMemento(Memento mem) {
        m = mem.getState();
        if (m != null)
            setText("" + (char) m.intValue());
    }

    public class Memento {        //Mememo是UnicodeLabel中的内部类
        private Integer m;

        private void setState(Integer m) {
            this.m = m;
        }

        private Integer getState() {
            return m;
        }
    }
}
