package visitor.example;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class ArmyVisitor implements Visitor {
    @Override
    public void visit(Man man) {
        double stature = man.getStature();
        double eyeSight = man.getEyeSight();
        if (stature > 1.72 && eyeSight > 1.2)
            System.out.println(man.getName() + "符合当兵标准");
        else
            System.out.println(man.getName() + "不符合当兵标准");
    }

    @Override
    public void visit(Woman woman) {
        double stature = woman.getStature();
        double eyeSight = woman.getEyeSight();
        int bloodSugar = woman.getBloodSugar();
        boolean boo = bloodSugar >= 60 && bloodSugar <= 80;
        if (stature > 1.65 && eyeSight > 1.2 && boo)
            System.out.println(woman.getName() + "符合当兵标准");
        else
            System.out.println(woman.getName() + "不符合当兵标准");
    }
}
