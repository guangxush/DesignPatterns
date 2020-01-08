package iterator.example;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class UseSet {
    LinkedList<Student> list;
    Hashtable<String, Student> table;
    TreeSet<Student> tree;

    UseSet() {
        list = new LinkedList<>();
        table = new Hashtable<>();
        tree = new TreeSet<>();
    }

    public void addStudent(Student stu) {
        list.add(stu);
        update();
    }

    public void lookStudent(String number) {
        Student stu = table.get(number);
        String num = stu.getNumber();
        String name = stu.getName();
        double score = stu.getSocre();
        System.out.println("学号："+num+"姓名："+name+"分数："+score);
    }

    public void printStudentByScore() {
        Iterator<Student> iterator = tree.iterator();
        while(iterator.hasNext()){
            Student stu = iterator.next();
            String num = stu.getNumber();
            String name = stu.getName();
            double score = stu.getSocre();
            System.out.println("学号："+num+"姓名："+name+"分数："+score);
        }
    }

    private void update() {
        tree.clear();
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            String number = stu.getNumber();
            table.put(number, stu);
            tree.add(stu);
        }
    }
}
