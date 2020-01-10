package memento.com.shgx;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class ReadPhrase implements Serializable {
    long readPosition;     //在文件中的读取的位置
    File file;
    RandomAccessFile in;
    String phrase = null;

    public ReadPhrase(File file) {
        this.file = file;
        try {
            in = new RandomAccessFile(file, "r");
        } catch (IOException exp) {
        }
    }

    public Memento createMemento() {
        Memento mem = new Memento();
        mem.setPositionState(readPosition);
        return mem;
    }

    public void restoreFromMemento(Memento mem) {
        readPosition = mem.getPositionState();
    }

    public String readLine() {
        try {
            in.seek(readPosition);
            phrase = in.readLine();
            if (phrase != null) {
                byte b[] = phrase.getBytes("iso-8859-1");
                phrase = new String(b);
            }
            readPosition = in.getFilePointer();    //获取当前的读取位置
        } catch (IOException exp) {
        }
        return phrase;
    }

    public void closeRead() {
        try {
            in.close();
        } catch (IOException exp) {
        }
    }
}
