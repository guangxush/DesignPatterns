package command.example2;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ConcreteCommand implements Command{

    ArrayList<String> dirNameList;

    MakeDir makeDir;

    public ConcreteCommand(ArrayList<String> dirNameList, MakeDir makeDir) {
        this.dirNameList = dirNameList;
        this.makeDir = makeDir;
    }

    @Override
    public void execute(String name) {
        makeDir.createDir(name);
        dirNameList.add(name);
    }

    @Override
    public void undo() {
        if(dirNameList.size()>0){
            int m = dirNameList.size();
            String str = dirNameList.get(m-1);
            makeDir.deleteDir(str);
            dirNameList.remove(m-1);
        }else{
            System.out.println("没有需要撤销的操作");
        }
    }
}
