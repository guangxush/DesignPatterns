package command.example5;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class OnCameraCommand implements Command{
    Camera camera;

    public OnCameraCommand(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void execute() {
        camera.on();
    }

    @Override
    public String getName() {
        return "打开摄像头";
    }
}
