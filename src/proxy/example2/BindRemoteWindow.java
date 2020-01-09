package proxy.example2;

import proxy.example.RemoteConcreteSubject;

import java.rmi.Naming;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class BindRemoteWindow {
    public static void main(String args[]) {
        try {
            RemoteConcreteWindow remoteObject = new RemoteConcreteWindow();
            Naming.rebind("rmi://127.0.0.1/window", remoteObject);
            System.out.println("ready for you server...");
        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
}
