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

    boolean moreThanFiveLateDeliveries(){
        return _numberOfLateDeliveries > 5;
    }
}
