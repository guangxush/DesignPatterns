package template;

import java.io.File;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application {
    public static void main(String args[]) {
        File dir = new File("../");
        AbstractTemplate template = new ConcreteTemplate1(dir);
        System.out.println(dir.getPath() + "目录下的文件：");
        template.showFileName();
        template = new ConcreteTemplate2(dir);
        System.out.println(dir.getPath() + "目录下的文件：");
        template.showFileName();
    }
}
