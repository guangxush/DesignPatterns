package observer.push.student;

import observer.push.Observer;
import observer.push.Subject;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class NomalStudent implements Observer {

    private Subject subject;
    private File myFile;

    public NomalStudent(Subject subject, String fileName) {
        this.subject = subject;
        subject.addObserve(this);
        this.myFile = new File(fileName);
    }

    @Override
    public void hearTelephone(String heardMess) {
        boolean boo = heardMess.contains("java开发") || heardMess.contains("算法");
        if (boo) {
            try {
                RandomAccessFile out = new RandomAccessFile(myFile, "rw");
                out.seek(out.length());
                byte[] b = heardMess.getBytes();
                out.write(b);
                System.out.println("Tom向文件中" + myFile.getName() + "写入如下内容:");
                System.out.println(heardMess);
            } catch (IOException exp) {
                System.out.println(exp.toString());
            }
        } else {
            System.out.println("没有合适的岗位！");
        }
    }
}
