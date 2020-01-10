package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class SentenceNode implements Node {
    Node subjectNode, predicateNode;

    @Override
    public void parse(Context context) {
        subjectNode = new SubjectNode();
        predicateNode = new PredicateNode();
        subjectNode.parse(context);
        predicateNode.parse(context);
    }

    @Override
    public void execute() {
        subjectNode.execute();
        predicateNode.execute();
    }
}