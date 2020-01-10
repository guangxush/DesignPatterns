package visitor.example;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class FactoryVisitor implements Visitor {
    @Override
    public void visit(Man man) {
        double stature = man.getStature();
        double eyeSight = man.getEyeSight();
        if (stature > 1.55 && eyeSight > 0.8)
            System.out.println(man.getName() + "符合当工人标准");
        else
            System.out.println(man.getName() + "不符合当工人标准");
    }

    @Override
    public void visit(Woman woman) {
        double stature = woman.getStature();
        double eyeSight = woman.getEyeSight();
        int bloodSugar = woman.getBloodSugar();
        boolean boo = bloodSugar >= 50 && bloodSugar <= 100;
        if (stature > 1.45 && eyeSight > 0.8 && boo)
            System.out.println(woman.getName() + "符合当工人标准");
        else
            System.out.println(woman.getName() + "不符合当工人标准");
    }
}