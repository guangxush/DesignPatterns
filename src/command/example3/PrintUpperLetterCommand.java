package command.example3;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class PrintUpperLetterCommand implements Command{
    PrintLetter letter;

    public PrintUpperLetterCommand(PrintLetter letter){
        this.letter  = letter;
    }

    @Override
    public void execute(){
        letter.printUpper();
    }
}
