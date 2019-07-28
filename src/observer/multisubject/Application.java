package observer.multisubject;

import observer.multisubject.observer.Person;
import observer.multisubject.subject.TravelAgency;
import observer.multisubject.subject.WeatherSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Application {
    public static void main(String[] args) {
        WeatherSubject weatherSubject = new WeatherSubject();
        TravelAgency travelAgency = new TravelAgency();
        Person person = new Person(weatherSubject, travelAgency);
        weatherSubject.doForecast("10","小雨", 28,30);
        travelAgency.giveMessage("10","旅游");
    }
}
