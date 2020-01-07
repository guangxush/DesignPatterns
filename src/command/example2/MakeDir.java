package command.example2;

import java.io.File;

/**
 * 接收者
 * @author: guangxush
 * @create: 2020/01/07
 */
public class MakeDir {
    public void createDir(String name){
        File dir = new File(name);
        dir.mkdir();
    }

    public void deleteDir(String name){
        File dir = new File(name);
        dir.delete();
    }
}
