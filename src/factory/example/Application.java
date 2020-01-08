package factory.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String args[]){
        ShowDepositSlip showDepositSlip=new ShowDepositSlip();
        Bank bank=new ChinaBank();
        showDepositSlip.showDepositSlip(bank,"298765423","张三",5000);
        showDepositSlip.setLocation(20,20);
        showDepositSlip=new ShowDepositSlip();
        bank=new ChinaConstructionBank();
        showDepositSlip.showDepositSlip(bank,"128700542","李四",3000);
        showDepositSlip.setLocation(240,20);
        showDepositSlip=new ShowDepositSlip();
        bank=new BankOfCommunications();
        showDepositSlip.showDepositSlip(bank,"108765469","孙五",8000);
        showDepositSlip.setLocation(460,20);
    }
}
