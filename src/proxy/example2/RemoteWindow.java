package proxy.example2;

import javax.swing.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public interface RemoteWindow extends Remote {
    JFrame getWindow() throws RemoteException;
    void setName(String name) throws RemoteException;
}
