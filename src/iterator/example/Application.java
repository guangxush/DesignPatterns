package iterator.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String[] args) {
        UseSet useSet = new UseSet();
        useSet.addStudent(new Student("001", "张三", 89));
        useSet.addStudent(new Student("002", "李四", 79));
        useSet.addStudent(new Student("003", "王五", 99));
        useSet.addStudent(new Student("004", "赵六", 69));
        String n = "003";
        System.out.println("学号"+n+"的学生信息为：");
        useSet.lookStudent(n);
        System.out.println("将学生按成绩排列为：");
        useSet.printStudentByScore();
    }
}
