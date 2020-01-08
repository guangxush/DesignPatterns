package iterator.example;

import java.util.Comparator;
import java.util.regex.Matcher;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Student implements Comparable {
    String number, name;
    double socre = 0;
    private int x = 10;

    Student() {

    }

    public Student(String number, String name, double socre) {
        this.number = number;
        this.name = name;
        this.socre = socre;
    }

    @Override
    public int compareTo(Object b) {
        Student stu = (Student) b;
        if (Math.abs(this.socre - stu.socre) <= 1 / 10000) {
            return 1;
        }
        return (int) (1000 * (this.socre - stu.socre));
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getSocre() {
        return socre;
    }
}
