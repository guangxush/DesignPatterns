package proxy.example;

import java.rmi.Naming;
import java.rmi.Remote;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class ClientApplication {
    public static void main(String[] args) {
        try {
            Remote remoteObject = Naming.lookup("rmi://127.0.0.1/rect");
            RemoteSubject remoteSubject = (RemoteSubject) remoteObject;
            double area = remoteSubject.getArea();
            System.out.println("面积：" + area);
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
