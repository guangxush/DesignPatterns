package observer.multisubject.subject;

import observer.multisubject.Observer;
import observer.multisubject.Subject;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class TravelAgency implements Subject {
    private String tourStartTime;
    private String tourMess;
    private ArrayList<Observer> personList;

    public TravelAgency(){
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

    public void giveMessage(String time, String mess){
        this.tourMess = mess;
        this.tourStartTime = time;
        notifyObserver();
    }

    public String getTourStartTime() {
        return tourStartTime;
    }

    public String getTourMess() {
        return tourMess;
    }
}
