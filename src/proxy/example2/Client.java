package proxy.example2;

import javax.swing.*;
import java.rmi.Naming;
import java.rmi.Remote;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Client {
    public static void main(String[] args) {
        try{
            Remote object = Naming.lookup("rmi://127.0.0.1/window");
            RemoteWindow remoteWindow = (RemoteWindow) object;
            remoteWindow.setName("hello.txt");
            JFrame frame = remoteWindow.getWindow();
            frame.setVisible(true);
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}
