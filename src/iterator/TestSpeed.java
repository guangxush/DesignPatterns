package iterator;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class TestSpeed {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        Iterator<String> iterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (iterator.hasNext()){
            String item = iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iterator方法所用时间："+(endTime-startTime));

        startTime = System.currentTimeMillis();
        for(int i=0;i<list.size();i++){
            String item = list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("get方法所用时间："+(endTime-startTime));
    }
}
