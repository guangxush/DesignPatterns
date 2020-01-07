package chain.example;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public interface Handler {
    void computerMultiply(String number);
    void setNextHandler(Handler handler);
}
