package state.example3;

import state.example3.status.BlackState;

/**
 * @author: guangxush
 * @create: 2020/12/05
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        //初始化状态为黑色
        context.setState(new BlackState());
        context.push();
        context.push();
        context.push();
        context.pull();
        context.push();
        context.push();
        context.push();
    }
}
