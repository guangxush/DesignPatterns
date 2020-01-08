package factory.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public abstract class Bank{
    public abstract DepositSlip createDepositSlip(String number,String name,int money);
    public abstract Seal createSeal();
}