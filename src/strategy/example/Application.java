package strategy.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        File fileOne = new File("A.txt");
        File fileTwo = new File("B.txt");

        String s = "";
        EncodeContext encode = new EncodeContext();
        encode.setStrategy(new StrategyOne("hello"));
        encode.encryptFile(fileOne);
        System.out.println(fileOne.getName() + "加密后的内容：");
        try {
            FileReader inOne = new FileReader(fileOne);
            BufferedReader inTwo = new BufferedReader(inOne);
            while ((s = inTwo.readLine()) != null) {
                System.out.println(s);
            }
            inOne.close();
            inTwo.close();
        }catch (IOException exp){
            System.out.println(exp);
        }
        String str = encode.decryptFile(fileOne);
        System.out.println(fileOne.getName()+"解密后的内容：");
        System.out.println(str);

        encode.setStrategy(new StrategyTwo("world"));
        encode.encryptFile(fileTwo);
        System.out.println(fileTwo.getName() + "加密后的内容：");
        try {
            FileReader inOne = new FileReader(fileTwo);
            BufferedReader inTwo = new BufferedReader(inOne);
            while ((s = inTwo.readLine()) != null) {
                System.out.println(s);
            }
            inOne.close();
            inTwo.close();
        }catch (IOException exp){
            System.out.println(exp);
        }
        str = encode.decryptFile(fileTwo);
        System.out.println(fileTwo.getName()+"解密后的内容：");
        System.out.println(str);

    }
}
