package adapter.example;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class BookNameList {
    private Vector<String> vector;
    private Enumeration bookenum;

    public BookNameList() {
        this.vector = new Vector<>();
    }

    public void setBookName() {
        vector.add("JAVA");
        vector.add("C#");
        vector.add("C++");
        vector.add("Python");
    }

    public Enumeration getEnumeration() {
        return vector.elements();
    }
}
