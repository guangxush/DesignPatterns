package command.example3;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class PrintNumberCommand implements Command{
    PrintNumber number;

    public PrintNumberCommand(PrintNumber number){
        this.number  = number;
    }

    @Override
    public void execute(){
        number.printEvenNumber();
    }
}
