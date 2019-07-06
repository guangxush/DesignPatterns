package abstractfactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class WesternTrousers implements Trousers{

    private int waistSize;

    private int height;

    private String name;

    public WesternTrousers(int waistSize, int height, String name) {
        this.waistSize = waistSize;
        this.height = height;
        this.name = name;
    }

    @Override
    public int getWaistSize() {
        return waistSize;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getName() {
        return name;
    }
}
