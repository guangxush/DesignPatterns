package visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Application {
    public static void main(String args[]) {
        Visitor visitor = new Company();
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Undergraduate("张三", 67, 88));
        studentList.add(new Undergraduate("李四", 90, 98));
        studentList.add(new Undergraduate("王五", 85, 92));
        studentList.add(new GraduateStudent("小明", 88, 70, 87));
        studentList.add(new GraduateStudent("小红", 90, 95, 82));
        Iterator<Student> iter = studentList.iterator();
        while (iter.hasNext()) {
            Student stu = iter.next();
            stu.accept(visitor);
        }
    }
}
