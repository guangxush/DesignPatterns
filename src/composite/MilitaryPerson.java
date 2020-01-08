package composite;

import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public interface MilitaryPerson {
    void add(MilitaryPerson person) throws NoSuchMethodException;

    void remove(MilitaryPerson person) throws NoSuchMethodException;

    MilitaryPerson getChild(int index) throws NoSuchMethodException;

    Iterator<MilitaryPerson> getAllChildren() throws NoSuchMethodException;

    boolean isLeaf();

    double getSalary();

    void setSalary(double salary);

    @Override
    String toString();
}