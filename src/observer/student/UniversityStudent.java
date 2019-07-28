package observer.student;

import observer.Observer;
import observer.Subject;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class UniversityStudent implements Observer {

    private Subject subject;
    private File myFile;

    public UniversityStudent(Subject subject, String fileName){
        this.subject = subject;
        subject.addObserve(this);
        this.myFile = new File(fileName);
    }

    @Override
    public void hearTelephone(String heardMess) {
        try{
            RandomAccessFile out = new RandomAccessFile(myFile, "rw");
            out.seek(out.length());
            byte[] b = heardMess.getBytes();
            out.write(b);
            System.out.println("张三向文件中"+myFile.getName()+"写入如下内容:");
            System.out.println(heardMess);
        }catch (IOException exp){
            System.out.println(exp.toString());
        }
    }
}
