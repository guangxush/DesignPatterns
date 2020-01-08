package composite.example;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;


/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application extends JFrame implements TreeSelectionListener {
    TreeComponent mainBody, branchOne, branchTwo, apple[];
    DefaultMutableTreeNode trunk, branch1, branch2, leaf[];
    JTree tree;
    final static int MAX = 18;
    JTextArea text;

    public Application() {
        mainBody = new TreeBody("树干", 786);
        trunk = new DefaultMutableTreeNode(mainBody);
        branchOne = new TreeBody("树枝", 45);
        branch1 = new DefaultMutableTreeNode(branchOne);
        branchTwo = new TreeBody("树枝", 25);
        branch2 = new DefaultMutableTreeNode(branchTwo);
        apple = new Apple[MAX];
        leaf = new DefaultMutableTreeNode[MAX];
        for (int i = 0; i < MAX; i++) {
            apple[i] = new Apple("苹果", 0.25);
            leaf[i] = new DefaultMutableTreeNode(apple[i]);
        }
        mainBody.add(branchOne);
        trunk.add(branch1);
        mainBody.add(branchTwo);
        trunk.add(branch2);
        for (int i = 0; i <= 7; i++) {
            branchOne.add(apple[i]);
            branch1.add(leaf[i]);
        }
        for (int i = 8; i < MAX; i++) {
            branchTwo.add(apple[i]);
            branch2.add(leaf[i]);
        }
        tree = new JTree(trunk);
        tree.addTreeSelectionListener(this);
        text = new JTextArea(20, 20);
        text.setFont(new Font("宋体", Font.BOLD, 12));
        text.setLineWrap(true);
        setLayout(new GridLayout(1, 2));
        add(new JScrollPane(tree));
        add(new JScrollPane(text));
        setBounds(70, 80, 460, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        text.setText(null);
        DefaultMutableTreeNode node =
                (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        TreeComponent treeComponent = (TreeComponent) node.getUserObject();
        String allName = Computer.getAllChildrenName(treeComponent);
        double weight = Computer.computerWeight(treeComponent);
        String mess = null;
        if (treeComponent.isLeaf())
            mess = allName + "的重量:\n" + weight + "公斤";
        else
            mess = allName + "加在一起的重量:\n" + weight + "公斤";
        text.append(mess + "\n");
        double unit = 4;
        double value = Computer.computerValue(treeComponent, unit);
        String name = treeComponent.toString();
        if (treeComponent.isLeaf())
            mess = name + "的价值（" + unit + "元/kg）" + value + "元";
        else
            mess = name + "所结苹果的价值（" + unit + "元/kg）" + value + "元";
        text.append("\n" + mess);
    }

    public static void main(String args[]) {
        new Application();
    }
}