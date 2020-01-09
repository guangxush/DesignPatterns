package proxy.example;

import java.rmi.Naming;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class RegisterRemoteObject {
    public static void main(String args[]) {
        try {
            RemoteConcreteSubject remoteObject =
                    new RemoteConcreteSubject(12, 88);
            Naming.rebind("rmi://127.0.0.1/rect", remoteObject);
            System.out.println("ready for you server...");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
