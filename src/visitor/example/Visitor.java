package visitor.example;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public interface Visitor {
    void visit(Man man);
    void visit(Woman woman);
}
