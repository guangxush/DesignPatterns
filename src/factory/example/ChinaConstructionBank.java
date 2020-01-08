package factory.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class ChinaConstructionBank extends Bank{
    @Override
    public DepositSlip createDepositSlip(String number,String name,int money){
        return new DepositSlip2(number,name,money);
    }
    @Override
    public Seal createSeal(){
        return new SealTwo();
    }
}
