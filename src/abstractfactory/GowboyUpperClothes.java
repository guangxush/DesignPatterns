package abstractfactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class GowboyUpperClothes implements UpperClothes {

    private int chestSize;

    private int height;

    private String name;

    public GowboyUpperClothes(int chestSize, int height, String name) {
        this.chestSize = chestSize;
        this.height = height;
        this.name = name;
    }

    @Override
    public int getChestSize() {
        return chestSize;
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
