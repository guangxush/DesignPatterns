package factory.example;

/**
 * 存款明细
 * @author: guangxush
 * @create: 2020/01/08
 */
public interface DepositSlip{
    String getBankName();
    String getClientName();
    String getClientNumber();
    int getAmountOfMoney();
}
