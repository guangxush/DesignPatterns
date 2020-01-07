package decorator.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ReadEnglishWord extends ReadWord{

    ArrayList<String> wordList = new ArrayList<>();

    @Override
    public ArrayList<String> readWord(File file) {
        try{
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String s = null;
            while((s=inTwo.readLine())!=null){
                wordList.add(s);
            }
            inTwo.close();
            inOne.close();
        }catch (IOException exp){
            System.out.println(exp);
        }
        return wordList;
    }
}
