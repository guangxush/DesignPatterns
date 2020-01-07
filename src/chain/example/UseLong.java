package chain.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class UseLong implements Handler{
    private Handler handler;

    private long result = 1;

    @Override
    public void computerMultiply(String number) {
        try{
            long n = Long.parseLong(number);
            long i = 1;
            while(i<=n){
                result *= i;
                if(result <= 0){
                    System.out.println("超出计算能力，无法完成计算");
                    handler.computerMultiply(number);
                    return;
                }
                i++;
            }
            System.out.println(number+"的阶乘："+result);
        }catch (NumberFormatException exp){
            System.out.println(exp);
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}

