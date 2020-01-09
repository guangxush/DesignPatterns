package template.example2;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application {
    public static void main(String args[]) {
        OperationDatabase operation1 = new OperationAccessDatabase("student", "hello");
        OperationDatabase operation2 = new OperationSQLServerDatabase("teacher", "world");
        System.out.println("查询到的记录:");
        operation1.lookResult();
        System.out.println("查询到的记录:");
        operation2.lookResult();
    }
}

