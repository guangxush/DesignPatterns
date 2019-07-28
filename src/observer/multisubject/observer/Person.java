package observer.multisubject.observer;

import observer.multisubject.Observer;
import observer.multisubject.Subject;
import observer.multisubject.subject.TravelAgency;
import observer.multisubject.subject.WeatherSubject;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Person implements Observer {

    private Subject subjectOne, subjectTwo;
    private String forecastTime, forecastMess;
    private String tourStartTime, tourMess;
    private int maxTemplate, minTemplate;

    @Override
    public void update(Subject subject) {
        if(subject instanceof WeatherSubject){
            WeatherSubject weatherSubject = (WeatherSubject) subject;
            System.out.println("天气"+weatherSubject.getForecastMess());
        }else if(subject instanceof TravelAgency){
            TravelAgency travelAgency = (TravelAgency) subject;
            System.out.println("旅游信息"+travelAgency.getTourMess());
        }
    }

    public Person(Subject subjectOne, Subject subjectTwo){
        this.subjectOne = subjectOne;
        this.subjectTwo = subjectTwo;
        subjectOne.addObserve(this);
        subjectTwo.addObserve(this);
    }
}
