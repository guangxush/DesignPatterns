package template.example1;

import java.io.File;
import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class WordSortTemplate extends WordsTemplate {
    WordSortTemplate(File file) {
        super(file);
    }

    @Override
    public void sort(String[] word) {
        Arrays.sort(word);
    }
}
