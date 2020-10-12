package callback.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: guangxush
 * @create: 2020/10/12
 */
public class CallbackExample1 {
    /**
     * 回调接口
     */
    private interface Response {
        void onSuccess(String data);
        void onFailed(String prompt);
    }

    /**
     * 正常模式完成操作
     * @return
     */
    private static String doSomething() {
        try {
            System.out.println("开始操作...");
            //模拟耗时操作（如网络请求），操作正常返回"Success"，"Success"表示有效的数据
            Thread.sleep(3000);
            return "Success";
        } catch (InterruptedException ex) {
            Logger.getLogger(CallbackExample1.class.getName()).log(Level.SEVERE, null, ex);
            //操作出现问题返回"Failed"，"Failed"包含错误提示，如错误码等
            return "Failed";
        }
    }

    /**
     * 使用回调函数完成操作
     * @param response
     */
    private static void callbackDoSomething(Response response) {
        try {
            System.out.println("开始操作...");
            Thread.sleep(3000);
            response.onSuccess("Success");
        } catch (InterruptedException ex) {
            Logger.getLogger(CallbackExample1.class.getName()).log(Level.SEVERE, null, ex);
            response.onFailed("Failed");
        }
    }

    public static void main(String[] args) {
        System.out.println("正常模式 ------ " + doSomething());
        callbackDoSomething(new Response() {
            @Override
            public void onSuccess(String data) {
                System.out.println("回调模式 ------ " + data);
            }

            @Override
            public void onFailed(String prompt) {
                System.err.println("错误提示：" + prompt);
            }

        });
    }
}
