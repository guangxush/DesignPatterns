package state;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Thermometer {
    TemperatureState  state;
    public  void  showMessage(){
        System.out.println("***********");
        state.showTemperature();
        System.out.println("***********");
    }
    public void setState(TemperatureState  state){
        this.state=state;
    }
}
