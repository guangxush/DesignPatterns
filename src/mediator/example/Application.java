package mediator.example;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;


/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application extends JFrame{
    ConcreteMediator mediator;
    JMenuItem copyItem, cutItem, pasteItem;
    JMenu menu;
    JMenuBar bar;
    JTextArea text;

    Application(){
        mediator = new ConcreteMediator();
        bar = new JMenuBar();
        menu = new JMenu("编辑");
        menu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                mediator.openMenu();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        copyItem = new JMenuItem("复制");
        copyItem.addActionListener( e ->  mediator.copy());
        cutItem = new JMenuItem("剪切");
        cutItem.addActionListener(e -> mediator.cut());
        pasteItem = new JMenuItem("粘贴");
        pasteItem.addActionListener(e -> mediator.paste());

        text = new JTextArea();
        bar.add(menu);
        menu.add(cutItem);
        menu.add(copyItem);
        menu.add(pasteItem);

        setJMenuBar(bar);
        add(text, BorderLayout.CENTER);
        register();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void register(){
        mediator.registerMenu(menu);
        mediator.registerCopyItem(copyItem);
        mediator.registerCutItem(cutItem);
        mediator.registerPasterItem(pasteItem);
        mediator.registerText(text);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.setBounds(100,200,300,300);
        application.setVisible(true);
    }
}
