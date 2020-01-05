package refactor;

import java.util.Enumeration;

/**
 * @author: guangxush
 * @create: 2020/01/04
 */
public class Main {
    public static void main(String[] args) {

    }

    void printOwing(double previousAmount) {

        Enumeration e = _orders.elements();
        double outstanding = previousAmount * 1.2;
        // print banner
        printBanner();

        outstanding = getOutstanding(outstanding);

        printDetails(outstanding);
    }

    double getOutstanding(double initialValue) {
        Enumeration e = _orders.elements();
        double result = 0.0;
        //calculate outstanding
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    void printDetails(double outstanding) {
        // print details
        System.out.println("name: " + _name);
        System.out.println("amount: " + outstanding);
    }

    void printBanner() {
        System.out.println("**********************");
        System.out.println("****Customer Owes*****");
        System.out.println("**********************");
    }


    int getRating() {
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }

    boolean moreThanFiveLateDeliveries() {
        return _numberOfLateDeliveries > 5;
    }
}

class Account {
    private AccountType _type;
    private double _interestRate;

    double interestForAmount_days(double amount, int day){
        return getInterestRate() * amount * days / 365;
    }

    public double getInterestRate() {
        return _interestRate;
    }

    public void setInterestRate(double _interestRate) {
        this._interestRate = _interestRate;
    }
}

class AccountType{
    double overdraftCharge(Account account){
        if(isPermium()) {
            double result = 10;
            if (account.getDaysOverdrawn() > 7)
                result += (account.getDaysOverdrawn() - 7) * 0.85;
            return result;
        }else{
            return account.getDaysOverdrawn() * 1.75;
        }
    }
}

class Gamma{
    private final Account _account;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    public Gamma(Account _account, int inputVal, int quantity, int yearToDate) {
        this._account = _account;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    int compute(){
        importantValue1 = (inputVal * quantity) + delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        importantThing();
        importantValue3 = importantValue2 * 7;
        //and so on
        return importantValue3 - 2 * importantValue1;
    }

    void importantThing(){
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
    }
}

class Person{
    Department _department;

    public Department getDepartment(){
        return _department;
    }

    public void setDepartment(Department arg){
        this._department = arg;
    }
}
class Department{
    private String _chargeCode;
    private Person _manager;

    public Department(Person _manager){
        _manager = _manager;
    }

    public Person getManager(){
        return _manager;
    }
}
