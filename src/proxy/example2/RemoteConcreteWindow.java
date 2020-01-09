package proxy.example2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class RemoteConcreteWindow extends UnicastRemoteObject implements RemoteWindow {
    JFrame window;
    JTextArea text;
    String name;

    RemoteConcreteWindow() throws RemoteException {
        window = new JFrame();
        text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setFont(new Font("", Font.BOLD, 16));
        window.add(new JScrollPane(text), BorderLayout.CENTER);
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public JFrame getWindow() throws RemoteException {
        return window;
    }

    @Override
    public void setName(String name) {
        text.setText(null);
        this.name = name;
        try {
            FileReader readfile = new FileReader(name);
            BufferedReader in = new BufferedReader(readfile);
            String s = null;
            while ((s = in.readLine()) != null){
                text.append(s + "\n");
            }
            readfile.close();
            in.close();
        } catch (IOException ee) {
        }

    }
}
