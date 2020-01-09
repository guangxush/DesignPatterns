package template.example1;

import java.io.File;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application {
    public static void main(String args[]) {
        File file = new File("./Hello.txt");
        WordsTemplate template = new WordSortTemplate(file);
        System.out.println(file.getName() + "中有如下的单词（按字典序排序）：");
        template.showAllWords();
        template = new WordNoSortTemplate(file);
        System.out.println(file.getName() + "中有如下的单词（按文中出现的先后顺序）：");
        template.showAllWords();
    }
}
