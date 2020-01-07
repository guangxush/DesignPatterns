package strategy.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class StrategyOne implements EncryptStrategy{
    String password;

    StrategyOne(){
        this.password = "I love this game!";
    }

    public StrategyOne(String password) {
        if(password.length() == 0){
            this.password = "I love this game!";
        }
        this.password = password;
    }

    @Override
    public void encryptFile(File file) {
        try{
            byte[] a = password.getBytes();
            FileInputStream in = new FileInputStream(file);
            long length = file.length();
            byte[] c = new byte[(int)length];
            int m = in.read(c);
            for(int i=0;i<m;i++){
                //加密
                int n = c[i] + a[i%a.length];
                c[i] = (byte)n;
            }
            in.close();
            FileOutputStream out = new FileOutputStream(file);
            out.write(c,0,m);
            out.close();
        }catch (IOException exp){
            System.out.println(exp);
        }
    }

    @Override
    public void decryptFile(File file) {
        try{
            byte[] a = password.getBytes();
            FileInputStream in = new FileInputStream(file);
            long length = file.length();
            byte[] c = new byte[(int)length];
            int m = in.read(c);
            for(int i=0;i<m;i++){
                //解密
                int n = c[i] - a[i%a.length];
                c[i] = (byte)n;
            }
            in.close();
            FileOutputStream out = new FileOutputStream(file);
            out.write(c,0,m);
            out.close();
        }catch (IOException exp){
            System.out.println(exp);
        }
    }
}
