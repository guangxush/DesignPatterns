package command.example3;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class PrintLetter {
    public void printLower() {
        for (char c = 'a'; c < 'z'; c++) {
            System.out.print(" " + c);
        }
    }

    public void printUpper() {
        for (char c = 'A'; c < 'Z'; c++) {
            System.out.print(" " + c);
        }
    }
}
