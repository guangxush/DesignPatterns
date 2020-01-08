package facade.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ReadFile {
    public String readFileContent(String fileName){
        StringBuffer str = new StringBuffer();
        try{
            FileReader inOne = new FileReader(fileName);
            BufferedReader inTwo = new BufferedReader(inOne);
            String s = null;
            while ((s=inTwo.readLine())!=null){
                str.append(s);
                str.append("\n");
            }
            inOne.close();
            inTwo.close();
        }catch (IOException exp){
            System.out.println(exp);
        }
        return new String(str);
    }
}
