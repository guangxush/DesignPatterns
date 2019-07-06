package simplefactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class FruitGardener {
    /**
     * 静态工厂方法
     *
     * @param args
     */
    public static void main(String[] args) {
        try{
            Fruit fruit = FruitGardener.factory("apple");
            fruit.harvest();
            fruit = FruitGardener.factory("grape");
            fruit.harvest();
            fruit = FruitGardener.factory("strawberry");
            fruit.harvest();
        }catch (BadFruitException e){
            e.printStackTrace();
        }
    }


    public static Fruit factory(String fruit) throws BadFruitException {
        switch (fruit) {
            case "apple":
                return new Apple();
            case "strawberry":
                return new Strawberry();
            case "grape":
                return new Grape();
            default:
                throw new BadFruitException("Bad fruit request");
        }
    }


}
