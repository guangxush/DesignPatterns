package observer.multisubject.subject;

import observer.multisubject.Observer;
import observer.multisubject.Subject;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class WeatherSubject implements Subject {

    private String forecastTime, forecastMess;
    private int maxTemperature, minTemperature;
    private ArrayList<Observer> personList;

    public WeatherSubject(){
        personList = new ArrayList<>();
    }

    @Override
    public void addObserve(Observer observer) {
        if(observer == null){
            return ;
        }
        if(!personList.contains(observer)){
            personList.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        if(personList.contains(observer)){
            personList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < personList.size(); i++) {
            Observer observer = personList.get(i);
            // 仅仅通知观察者，不提供数据
            observer.update(this);
        }
    }

    public void doForecast(String t,String mess, int max, int min){
        this.forecastTime = t;
        this.forecastMess = mess;
        this.maxTemperature = max;
        this.minTemperature = min;
        notifyObserver();
    }

    public String getForecastTime(){
        return forecastTime;
    }

    public String getForecastMess() {
        return forecastMess;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

}
