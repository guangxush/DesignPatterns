package observer;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public interface SubjectTwo {
    void addObserve(ObserverTwo observer);

    void deleteObserver(ObserverTwo observer);

    void notifyObserver();
}
