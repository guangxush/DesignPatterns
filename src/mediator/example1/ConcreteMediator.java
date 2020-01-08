package mediator.example1;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ConcreteMediator implements Runnable {
    RedLight SNredLight;
    GreenLight SNgreenLight;
    YellowLight SNyellowLight;

    RedLight EWredLight;
    GreenLight EWgreenLight;
    YellowLight EWyellowLight;

    Thread thread;
    int timeOne = 8, timeTwo = 3, timeThree = 10, timeFour = 3;
    ConcreteMediator(){
        thread = new Thread(this);
    }

    public void startRun(){
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            for(int i=1;i<timeOne;i++){
                SNgreenLight.on();
                EWredLight.on();
                SNyellowLight.off();
                EWyellowLight.off();
                SNredLight.off();
                EWgreenLight.off();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException exp){

                }
            }
            for(int i=1;i<timeTwo;i++){
                SNgreenLight.off();
                EWredLight.on();
                SNyellowLight.on();
                EWyellowLight.off();
                SNredLight.off();
                EWgreenLight.off();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException exp){

                }
            }
            for(int i=1;i<timeThree;i++){
                SNgreenLight.off();
                EWredLight.off();
                SNyellowLight.off();
                EWyellowLight.off();
                SNredLight.on();
                EWgreenLight.on();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException exp){

                }
            }
            for(int i=1;i<timeFour;i++){
                SNgreenLight.off();
                EWredLight.off();
                SNyellowLight.off();
                EWyellowLight.on();
                SNredLight.on();
                EWgreenLight.off();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException exp){

                }
            }
        }
    }

    public void registerSNRedLight(RedLight redLight){
        SNredLight = redLight;
    }
    public void registerSNGreenLight(GreenLight greenLight){
        SNgreenLight = greenLight;
    }
    public void registerSNYellowLight(YellowLight yellowLight){
        SNyellowLight = yellowLight;
    }

    public void registerEWRedLight(RedLight redLight){
        EWredLight = redLight;
    }
    public void registerEWGreenLight(GreenLight greenLight){
        EWgreenLight = greenLight;
    }
    public void registerEWYellowLight(YellowLight yellowLight){
        EWyellowLight = yellowLight;
    }

}
