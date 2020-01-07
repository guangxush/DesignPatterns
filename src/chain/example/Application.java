package chain.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {

    private Handler useInt, useLong, useBigInteger;

    public void createrChain(){
        useInt = new UseInt();
        useLong = new UseLong();
        useBigInteger = new UseBigInteger();
        useInt.setNextHandler(useLong);
        useLong.setNextHandler(useBigInteger);
    }

    public void responseClient(String number){
        useInt.computerMultiply(number);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.createrChain();
        application.responseClient("32");
    }
}
