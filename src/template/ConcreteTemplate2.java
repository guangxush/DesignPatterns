package template;

import java.io.File;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class ConcreteTemplate2 extends AbstractTemplate {
    ConcreteTemplate2(File dir) {
        super(dir);
    }

    @Override
    public void sort() {
        for (int i = 0; i < allFiles.length; i++)
            for (int j = i + 1; j < allFiles.length; j++)
                if (allFiles[j].length() < allFiles[i].length()) {
                    File file = allFiles[j];
                    allFiles[j] = allFiles[i];
                    allFiles[i] = file;
                }
    }

    @Override
    public void printFiles() {
        for (int i = 0; i < allFiles.length; i++) {
            long fileSize = allFiles[i].length();
            String name = allFiles[i].getName();
            int k = i + 1;
            System.out.println(k + " " + name + "(" + fileSize + " 字节)");
        }
    }
}
