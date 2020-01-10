package visitor.example;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Woman extends Person {
    String name;
    double stature;       //身高
    double eyeSight;        //视力
    int bloodSugar;   //血糖

    Woman(String name, double stature, double eyeSight, int bloodSugar) {
        this.name = name;
        this.stature = stature;
        this.eyeSight = eyeSight;
        this.bloodSugar = bloodSugar;
    }

    public double getStature() {
        return stature;
    }

    public double getEyeSight() {
        return eyeSight;
    }

    public int getBloodSugar() {
        return bloodSugar;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
