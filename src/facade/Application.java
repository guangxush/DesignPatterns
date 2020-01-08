package facade;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String[] args) {
        ClientServerFacade facade;
        String advertisement = "电脑1233元，请联系12334";
        facade = new ClientServerFacade(advertisement);
        facade.doAdversitisement();
    }
}
