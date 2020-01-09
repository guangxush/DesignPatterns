package proxy;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class TriangleProxy implements Geometry {
    double sideA, sideB, sideC;
    Triangle triangle;

    public void setABC(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    @Override
    public double getArea() {
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            triangle = new Triangle(sideA, sideB, sideC);
            //让所代理的对象调用getArea()方法
            double area = triangle.getArea();
            return area;
        } else {
            return -1;
        }
    }
}
