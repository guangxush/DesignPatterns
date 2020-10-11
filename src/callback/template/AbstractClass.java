package callback.template;

/**
 * @author: guangxush
 * @create: 2020/10/11
 */
public abstract class AbstractClass {
    // 共同的且繁琐的操作
    private void baseOperation() {
        // do something
    }

    // 由子类定制的操作
    protected abstract void customOperation();

    // 模板方法定义的框架
    public final void templateMethod() {
        baseOperation();
        customOperation();
    }
}
