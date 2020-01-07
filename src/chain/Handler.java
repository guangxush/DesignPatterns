package chain;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public interface Handler {
    void handleRequest(String number);
    void setNextHandler(Handler handler);
}
