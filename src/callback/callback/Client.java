package callback.callback;

/**
 * @author: guangxush
 * @create: 2020/10/11
 */
public class Client {
    public static void main(String[] args) {
        Template template = new Template();
        applyTemplate(template);
    }

    public static void applyTemplate(Template template) {
        Callback c1  = new SubCallback();
        template.templateMethod(c1);
    }
}
