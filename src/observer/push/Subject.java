package observer.push;

import observer.push.Observer;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public interface Subject {

    void addObserve(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserver();

}
