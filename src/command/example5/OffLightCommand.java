package command.example5;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class OffLightCommand implements Command{
    Light light;

    public OffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public String getName() {
        return "关闭灯";
    }
}
