package callback.callback;

/**
 * @author: guangxush
 * @create: 2020/10/11
 */
public final class Template {
    private void baseOperation() {
        // do  something
    }

    public void templateMethod(Callback callback) {
        baseOperation();
        callback.customOperation();
    }
}
