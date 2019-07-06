package simplefactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class Apple implements Fruit{
    /**
     * 树龄
     */
    private int treeAge;

    @Override
    public void grow() {
        log("Apple is growing.");
    }

    @Override
    public void harvest() {
        log("Apple has been harvested.");
    }

    @Override
    public void plant() {
        log("Apple has been planted.");
    }

    public static void log(String msg)
    {
        System.out.println(msg);
    }

    public int getTreeAge(){
        return treeAge;
    }

    public void setTreeAge(int treeAge){
        this.treeAge = treeAge;
    }
}
