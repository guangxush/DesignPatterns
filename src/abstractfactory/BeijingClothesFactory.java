package abstractfactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class BeijingClothesFactory implements ClothesFactory{
    @Override
    public UpperClothes createUpperClothes(int chestSize, int height) {
        return new WesternUpperClothes(chestSize, height, "北京牌西服上衣");
    }

    @Override
    public Trousers createTrousers(int waitSize, int height) {
        return new WesternTrousers(waitSize, height, "北京牌西服裤子");
    }
}
