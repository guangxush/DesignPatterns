package proxy.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public interface RemoteSubject extends Remote {
    double getArea() throws RemoteException;
}
