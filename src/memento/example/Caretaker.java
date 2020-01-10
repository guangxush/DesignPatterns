package memento.example;

import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Caretaker {
    Stack<UnicodeLabel.Memento> stack;

    Caretaker() {
        stack = new Stack<UnicodeLabel.Memento>();
    }

    public UnicodeLabel.Memento getMemento() {
        if (!(stack.isEmpty())) {
            UnicodeLabel.Memento memento = stack.pop();
            return memento;
        } else {
            return null;
        }
    }

    public void saveMemento(UnicodeLabel.Memento memento) {
        stack.push(memento);
    }
}
