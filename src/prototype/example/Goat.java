package prototype.example;

import java.io.*;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Goat implements Prototype, Serializable {
    StringBuffer color;

    public void setColor(StringBuffer c) {
        color = c;
    }

    public StringBuffer getColor() {
        return color;
    }

    @Override
    public Object cloneMe() throws CloneNotSupportedException { //实现接口中的方法
        Object object = null;
        try {
            ByteArrayOutputStream outOne = new ByteArrayOutputStream();
            ObjectOutputStream outTwo = new ObjectOutputStream(outOne);
            outTwo.writeObject(this);     //将原型对象写入对象输出流
            ByteArrayInputStream inOne =
                    new ByteArrayInputStream(outOne.toByteArray());
            ObjectInputStream inTwo = new ObjectInputStream(inOne);
            object = inTwo.readObject();    //创建新的对象：原型的复制品
        } catch (Exception event) {
            System.out.println(event);
        }
        return object;
    }
}
