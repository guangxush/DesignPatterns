package chain;

import java.util.ArrayList;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public class Tianjin implements Handler{
    private Handler handler;

    private ArrayList<String> numberList;

    Tianjin(){
        numberList = new ArrayList<>();
        numberList.add("2313123123123");
        numberList.add("6564564004232");
        numberList.add("3208734012383");
        numberList.add("2339977402131");
    }

    @Override
    public void handleRequest(String number) {
        if(numberList.contains(number)){
            System.out.println("该人在天津居住");
        }else{
            System.out.println("该人不在天津居住");
            if(handler!=null){
                //请求传递给下一个处理者
                handler.handleRequest(number);
            }
        }
    }

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
}
