package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class SubjectNode implements Node {
    Node node;

    @Override
    public void parse(Context context) {
        node = new SubjectPronounOrNounNode();
        node.parse(context);
    }

    @Override
    public void execute() {
        node.execute();
    }
}
