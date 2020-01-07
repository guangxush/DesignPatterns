package command.example4;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class MultiCommand implements Command{
    ShowMultiForm showMultiForm;

    public MultiCommand(ShowMultiForm showMultiForm) {
        this.showMultiForm = showMultiForm;
    }

    @Override
    public void execute() {
        showMultiForm.show();
    }

    @Override
    public String getName() {
        return "显示乘法口诀表";
    }
}
