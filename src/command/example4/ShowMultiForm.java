package command.example4;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class ShowMultiForm {
    public void show() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(j + "x" + i + "=" + j * i + " ");
            }
            System.out.println();
        }
    }
}
