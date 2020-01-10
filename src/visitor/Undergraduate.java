package visitor;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Undergraduate implements Student {
    double math, english;    //成绩
    String name;

    Undergraduate(String name, double math, double english) {
        this.name = name;
        this.math = math;
        this.english = english;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}