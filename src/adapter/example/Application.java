package adapter.example;

import java.util.Enumeration;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Application {
    public static void main(String[] args) {
        BookNameList oldBookList = new BookNameList();
        oldBookList.setBookName();

        Enumeration bookenum = oldBookList.getEnumeration();
        IteratorAdapter adapter = new IteratorAdapter(bookenum);

        NewBookNameList newBookList = new NewBookNameList(adapter);
        newBookList.setBookName();

        System.out.println("导入新系统中的图书列表：");

        newBookList.getBookName();
    }
}
