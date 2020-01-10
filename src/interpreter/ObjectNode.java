package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class ObjectNode implements Node {
    Node node;

    @Override
    public void parse(Context context) {
        node = new ObjectPronounOrNounNode();
        node.parse(context);
    }

    @Override
    public void execute() {
        node.execute();
    }
}