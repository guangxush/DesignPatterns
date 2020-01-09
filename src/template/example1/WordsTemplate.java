package template.example1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public abstract class WordsTemplate {
    File file;
    String content;
    String[] word;

    WordsTemplate(File file) {
        this.file = file;
        content = "";
    }

    public final void showAllWords() {
        readContent();
        getWords();
        if (isSort())
            sort(word);
        printWords(word);
    }

    public boolean isSort() {       //钩子方法
        return true;
    }

    public final void readContent() {
        try {
            StringBuffer str = new StringBuffer();
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String s = null;
            while ((s = inTwo.readLine()) != null)
                str.append(s + "\n");
            content = new String(str);
            inOne.close();
            inTwo.close();
        } catch (IOException exp) {
        }
    }

    public final void getWords() {
        //空格字符、数字和符号(!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~)组成的正则表达式:
        String regex = "[\\s\\d\\p{Punct}]+";
        word = content.split(regex);
    }

    public void sort(String[] word) {
    }             //钩子方法

    public final void printWords(String[] word) {
        for (int i = 0; i < word.length; i++) {
            System.out.printf("%-10s", word[i]);
        }
        System.out.println();
    }
}
