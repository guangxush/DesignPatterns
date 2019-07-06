package abstractfactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public interface ClothesFactory {
    UpperClothes createUpperClothes(int chestSize, int height);
    Trousers createTrousers(int waitSize, int height);
}
