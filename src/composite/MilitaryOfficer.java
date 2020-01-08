package composite;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class MilitaryOfficer implements MilitaryPerson {
    LinkedList<MilitaryPerson> list;
    String name;
    double salary;

    MilitaryOfficer(String name, double salary) {
        this.name = name;
        this.salary = salary;
        list = new LinkedList<MilitaryPerson>();
    }

    @Override
    public void add(MilitaryPerson person) {
        list.add(person);
    }

    @Override
    public void remove(MilitaryPerson person) {
        list.remove(person);
    }

    @Override
    public MilitaryPerson getChild(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<MilitaryPerson> getAllChildren() {
        return list.iterator();
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
