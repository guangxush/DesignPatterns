package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public interface Node {
    void parse(Context text);
    void execute();
}
