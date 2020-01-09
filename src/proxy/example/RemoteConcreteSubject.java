package proxy.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class RemoteConcreteSubject extends UnicastRemoteObject implements RemoteSubject {
    double width, height;

    RemoteConcreteSubject(double width, double height) throws RemoteException {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() throws RemoteException {
        return width * height;
    }
}
