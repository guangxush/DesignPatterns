package adapter.example;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class IteratorAdapter implements Iterator {
    Enumeration bookenum;

    public IteratorAdapter(Enumeration bookenum) {
        this.bookenum = bookenum;
    }

    @Override
    public boolean hasNext() {
        return bookenum.hasMoreElements();
    }

    @Override
    public Object next() {
        return bookenum.nextElement();
    }

    @Override
    public void remove() {
        System.out.println("枚举器没有remove方法");
    }
}
