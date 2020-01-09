package template.example1;

import java.io.File;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class WordNoSortTemplate extends WordsTemplate {
    WordNoSortTemplate(File file) {
        super(file);
    }

    @Override
    public boolean isSort() {
        return false;
    }
}