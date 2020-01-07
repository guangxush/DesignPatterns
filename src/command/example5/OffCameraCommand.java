package command.example5;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class OffCameraCommand implements Command{

    Camera camera;

    public OffCameraCommand(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void execute() {
        camera.off();
    }

    @Override
    public String getName() {
        return "关闭摄像头";
    }
}
