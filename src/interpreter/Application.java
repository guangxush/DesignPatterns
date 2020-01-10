package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Application {
    public static void main(String args[]) {
        String text = "Teacher beat tiger";
        Context context = new Context(text);
        Node node = new SentenceNode();
        node.parse(context);
        node.execute();
        text = "You eat  apple";
        context.setContext(text);
        System.out.println();
        node.parse(context);
        node.execute();
        text = "you look  him";
        context.setContext(text);
        System.out.println();
        node.parse(context);
        node.execute();
    }
}
