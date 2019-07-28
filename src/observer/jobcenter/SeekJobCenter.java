package observer.jobcenter;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class SeekJobCenter implements Subject {

    private String mess;
    private boolean changed;
    private ArrayList<Observer> personList;

    public SeekJobCenter(){
        this.personList = new ArrayList<Observer>();
        this.mess = "";
        this.changed = false;
    }


    @Override
    public void addObserve(Observer observer) {
        if(!personList.contains(observer)){
            personList.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        if(!personList.contains(observer)){
            personList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        if(changed){
            for(int i=0;i<personList.size();i++){
                Observer observer = personList.get(i);
                observer.hearTelephone(mess);
            }
        }
        changed = false;
    }

    public void giveMessage(String str){
        if(str.equals(mess)){
            changed = false;
        }else{
            mess = str;
            changed = true;
        }
    }
}
