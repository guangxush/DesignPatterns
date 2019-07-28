package observer;

import observer.student.NomalStudent;
import observer.student.UniversityStudent;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Application {
    public static void main(String[] args) {
        SeekJobCenter centenr = new SeekJobCenter();
        UniversityStudent zhangsan = new UniversityStudent(centenr, "A.txt");
        NomalStudent tom = new NomalStudent(centenr, "B.txt");
        centenr.addObserve(zhangsan);
        centenr.addObserve(tom);
        centenr.giveMessage("Java程序员");
        centenr.notifyObserver();
        centenr.giveMessage("Java程序员");
        centenr.notifyObserver();
        centenr.giveMessage("算法");
        centenr.notifyObserver();
        centenr.giveMessage("测试");
        centenr.notifyObserver();
    }
}
