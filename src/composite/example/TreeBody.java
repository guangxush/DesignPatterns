package composite.example;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class TreeBody implements TreeComponent {
    LinkedList<TreeComponent> list;
    double weight;
    String name;

    TreeBody(String name, double weight) {
        this.name = name;
        this.weight = weight;
        list = new LinkedList<>();
    }

    @Override
    public void add(TreeComponent node) {
        list.add(node);
    }

    @Override
    public void remove(TreeComponent node) {
        list.remove(node);
    }

    @Override
    public TreeComponent getChild(int index) {
        return list.get(index);
    }

    @Override
    public Iterator<TreeComponent> getAllChildren() {
        return list.iterator();
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
