package template;

import java.io.File;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public abstract class AbstractTemplate {
    File[] allFiles;
    File dir;

    AbstractTemplate(File dir) {
        this.dir = dir;
    }

    public final void showFileName() {
        allFiles = dir.listFiles();
        sort();
        printFiles();
    }

    public abstract void sort();

    public abstract void printFiles();
}

