package visitor;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public interface Visitor {
    void visit(Undergraduate stu);
    void visit(GraduateStudent stu);
}
