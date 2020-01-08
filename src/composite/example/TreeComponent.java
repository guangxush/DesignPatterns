package composite.example;

import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public interface TreeComponent {
    void add(TreeComponent node);

    void remove(TreeComponent node);

    TreeComponent getChild(int index);

    Iterator<TreeComponent> getAllChildren();

    boolean isLeaf();

    double getWeight();
}
