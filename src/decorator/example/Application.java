package decorator.example;

import java.io.File;
import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        ReadEnglishWord rew = new ReadEnglishWord();
        WordDecorator wd1 = new WordDecorator(rew, new File("chinese.txt"));
        ReadWord reader = wd1;
        wordList = reader.readWord(new File("word.txt"));
        for(int i=0;i<wordList.size();i++){
            System.out.println(wordList.get(i));
        }

        WordDecorator wd2 = new WordDecorator(rew, new File("englishChinese.txt"));
        reader = wd2;
        wordList = reader.readWord(new File("word.txt"));
        for(int i=0;i<wordList.size();i++){
            System.out.println(wordList.get(i));
        }

    }
}
