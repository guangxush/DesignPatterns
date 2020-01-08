package mediator.example;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ConcreteMediator {
    JMenu menu;
    JMenuItem copyItem, cutItem, pasteItem;
    JTextArea text;
    public void openMenu(){
        Clipboard clipboard = text.getToolkit().getSystemClipboard();
        String str = text.getSelectedText();
        if(str==null){
            copyItem.setEnabled(false);
            cutItem.setEnabled(false);
        }else{
            copyItem.setEnabled(true);
            cutItem.setEnabled(true);
        }
        boolean boo = clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor);
        if(boo){
            pasteItem.setEnabled(true);
        }
    }

    public void paste(){
        text.paste();
    }

    public void copy(){
        text.copy();
    }

    public void cut(){
        text.cut();
    }

    public void registerMenu(JMenu menu){
        this.menu = menu;
    }

    public void registerPasterItem(JMenuItem item){
        pasteItem = item;
    }

    public void registerCopyItem(JMenuItem item){
        copyItem = item;
        copyItem.setEnabled(false);
    }

    public void registerCutItem(JMenuItem item){
        cutItem = item;
        copyItem.setEnabled(false);
    }

    public void registerText(JTextArea text){
        this.text = text;
    }
}
