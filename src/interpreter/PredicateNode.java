package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class PredicateNode implements Node {
    Node verbNode, objectNode;

    @Override
    public void parse(Context context) {
        verbNode = new VerbNode();
        objectNode = new ObjectNode();
        verbNode.parse(context);
        objectNode.parse(context);
    }

    @Override
    public void execute() {
        verbNode.execute();
        objectNode.execute();
    }
}
