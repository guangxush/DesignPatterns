package command.example3;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class PrintLowerLetterCommand implements Command{
    PrintLetter letter;

    public PrintLowerLetterCommand(PrintLetter letter){
        this.letter  = letter;
    }

    @Override
    public void execute(){
        letter.printLower();
    }
}
