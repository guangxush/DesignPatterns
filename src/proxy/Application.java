package proxy;

import java.util.Scanner;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入三个数，每输入一个数回车确认");
        double a = -1, b = -1, c = -1;
        a = reader.nextDouble();
        b = reader.nextDouble();
        c = reader.nextDouble();
        TriangleProxy proxy = new TriangleProxy();
        proxy.setABC(a, b, c);
        double area = proxy.getArea();
        System.out.println("面积是：" + area);
    }
}
