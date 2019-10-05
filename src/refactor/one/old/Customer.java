package refactor.one.old;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        Enumeration enumRentals = rentals.elements();
        while (enumRentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enumRentals.nextElement();

            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDayRented() > 2) {
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDayRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3) {
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    }
                    break;
                default:
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a one day new release rental
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }
}
