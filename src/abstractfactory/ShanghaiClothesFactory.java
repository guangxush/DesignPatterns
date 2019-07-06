package abstractfactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class ShanghaiClothesFactory implements ClothesFactory{
    @Override
    public UpperClothes createUpperClothes(int chestSize, int height) {
        return new WesternUpperClothes(chestSize, height, "上海牌牛仔上衣");
    }

    @Override
    public Trousers createTrousers(int waitSize, int height) {
        return new WesternTrousers(waitSize, height, "上海牌牛仔裤子");
    }
}
