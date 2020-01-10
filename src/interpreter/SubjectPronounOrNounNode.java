package interpreter;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class SubjectPronounOrNounNode implements Node {
    String[] word = {"You", "He", "Teacher", "Student"};
    String token;
    boolean boo;

    @Override
    public void parse(Context context) {
        token = context.nextToken();
        int i = 0;
        for (i = 0; i < word.length; i++) {
            if (token.equalsIgnoreCase(word[i])) {
                boo = true;
                break;
            }
        }
        if (i == word.length)
            boo = false;
    }

    @Override
    public void execute() {
        if (boo) {
            if (token.equalsIgnoreCase(word[0]))
                System.out.print("你");
            if (token.equalsIgnoreCase(word[1]))
                System.out.print("他");
            if (token.equalsIgnoreCase(word[2]))
                System.out.print("老师");
            if (token.equalsIgnoreCase(word[3]))
                System.out.print("学生");
        } else {
            System.out.println("不是该语言中的句子");
            //System.exit(0);
        }
    }

}
