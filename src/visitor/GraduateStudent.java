package visitor;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class GraduateStudent implements Student {
    double math, english, physics;    //成绩
    String name;

    GraduateStudent(String name, double math, double english, double physics) {
        this.name = name;
        this.math = math;
        this.english = english;
        this.physics = physics;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public double getPhysics() {
        return physics;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
