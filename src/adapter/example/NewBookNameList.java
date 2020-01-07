package adapter.example;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class NewBookNameList {
    LinkedList<String> bookList;
    Iterator iterator;

    public NewBookNameList(Iterator iterator) {
        bookList = new LinkedList<>();
        this.iterator = iterator;
    }

    public void setBookName(){
        while(iterator.hasNext()){
            String name = (String)iterator.next();
            bookList.add(name);
        }
    }

    public void getBookName(){
        Iterator<String> iterator = bookList.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
