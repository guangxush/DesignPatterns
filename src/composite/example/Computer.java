package composite.example;

import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Computer {
    public static double computerWeight(TreeComponent node) {
        double weightSum = 0;
        if (node.isLeaf()) {
            weightSum = weightSum + node.getWeight();
        }
        if (!node.isLeaf()) {
            weightSum = weightSum + node.getWeight();
            Iterator<TreeComponent> iterator = node.getAllChildren();
            while (iterator.hasNext()) {
                TreeComponent p = iterator.next();
                weightSum = weightSum + computerWeight(p);
                ;
            }
        }
        return weightSum;
    }

    public static double computerValue(TreeComponent node, double unit) {
        double appleWorth = 0;
        if (node.isLeaf()) {
            appleWorth = appleWorth + node.getWeight() * unit;
        }
        if (!node.isLeaf()) {
            Iterator<TreeComponent> iterator = node.getAllChildren();
            while (iterator.hasNext()) {
                TreeComponent p = iterator.next();
                appleWorth = appleWorth + computerValue(p, unit);
            }
        }
        return appleWorth;
    }

    public static String getAllChildrenName(TreeComponent node) {
        StringBuffer mess = new StringBuffer();
        if (node.isLeaf()) {
            mess.append(" " + node.toString());
        }
        if (!node.isLeaf()) {
            mess.append(" " + node.toString());
            Iterator<TreeComponent> iterator = node.getAllChildren();
            while (iterator.hasNext()) {
                TreeComponent p = iterator.next();
                mess.append(getAllChildrenName(p));
            }
        }
        return new String(mess);
    }
}
