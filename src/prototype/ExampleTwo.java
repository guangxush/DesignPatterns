package prototype;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ExampleTwo {
    public static void main(String[] args) {
        Geometry geometry = new Geometry(new Rectangle(10, 20), 200);
        System.out.println(geometry.rectangle.m + " " + geometry.rectangle.n);
        try {
            Geometry geometryCopy = (Geometry) geometry.clone();
            System.out.println(geometryCopy.rectangle.m + " " + geometryCopy.rectangle.n);

            geometry.rectangle.m = 111;
            geometry.rectangle.n = 222;
            System.out.println(geometry.rectangle.m + " " + geometry.rectangle.n);
            System.out.println(geometryCopy.rectangle.m + " " + geometryCopy.rectangle.n);

        } catch (CloneNotSupportedException exp) {
            System.out.println(exp);
        }
    }
}

class Geometry implements Cloneable {
    int height;
    Rectangle rectangle;

    public Geometry(Rectangle rectangle, int height) {
        this.height = height;
        this.rectangle = rectangle;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Geometry object = (Geometry) super.clone();
        object.rectangle = (Rectangle) rectangle.clone();
        return object;
    }
}

class Rectangle implements Cloneable {
    double m, n;

    public Rectangle(double m, double n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
