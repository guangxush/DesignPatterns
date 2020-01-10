package memento;

import memento.com.shgx.Memento;
import memento.com.shgx.ReadPhrase;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Application {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        ReadPhrase readPhrase = new ReadPhrase(new File("phrase.txt"));
        File favorPhrase = new File("favorPhrase.txt");
        RandomAccessFile out = null;
        try {
            out = new RandomAccessFile(favorPhrase, "rw");
        } catch (IOException exp) {
        }
        System.out.println("是否从上次读取的位置继续读取成语（输入y或n）");
        String answer = reader.nextLine();
        if (answer.startsWith("y") || answer.startsWith("Y")) {
            Caretaker caretaker = new Caretaker();
            Memento memento = caretaker.getMemento();     //得到备忘录
            if (memento != null)
                readPhrase.restoreFromMemento(memento);  //让readPhrase恢复到备忘录中所存储的状态
        }
        String phrase = null;
        while ((phrase = readPhrase.readLine()) != null) {
            System.out.println(phrase);
            System.out.println("是否将该成语保存到" + favorPhrase.getName() + "(输入y或n)");
            answer = reader.nextLine();
            if (answer.startsWith("y") || answer.startsWith("Y")) {
                try {
                    out.seek(favorPhrase.length());
                    byte[] b = phrase.getBytes();
                    out.write(b);
                    out.writeChar('\n');
                } catch (IOException exp) {
                }
            }
            System.out.println("是否继续读取成语？(输入y或n)");
            answer = reader.nextLine();
            if (answer.startsWith("y") || answer.startsWith("Y"))
                continue;
            else {
                readPhrase.closeRead();
                Caretaker caretaker = new Caretaker();
                caretaker.saveMemento(readPhrase.createMemento());   //将备忘录保存到文件中
                try {
                    out.close();
                } catch (IOException exp) {
                }
                System.exit(0);
            }
        }
        System.out.println("读完全部成语");
    }
}
