package facade;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class TypeSeting {
    String advertisement;

    public TypeSeting(String advertisement) {
        this.advertisement = advertisement;
    }

    public void typeSeting(){
        System.out.println("广告排版格式");
        System.out.println("**********");
        System.out.println(advertisement);
        System.out.println("**********");
    }
}
