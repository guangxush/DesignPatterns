package refactor.one.two;

import refactor.one.old.Rental;
import refactor.one.one.RentalOne;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public class CustomerTwo {
    private String name;
    private Vector rentals = new Vector();

    public CustomerTwo(String name) {
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
            // double thisAmount = 0;
            RentalOne each = (RentalOne) enumRentals.nextElement();

            // determine amounts for each line
            // thisAmount = each.getCharge();
            // add frequent renter points
            // frequentRenterPoints++;
            // add bonus for a one day new release rental
            // frequentRenterPoints += each.getFrequentRenterPoints();
//            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDayRented() > 1) {
//                frequentRenterPoints++;
//            }
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
//            totalAmount += each.getCharge();
        }
        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points.";
        return result;
    }

    public String htmlStatement(){
        Enumeration enumRentals = rentals.elements();
        String result = "<H1> Rental for <EM>"+getName()+"</EM></H1><p>\n";
        while(enumRentals.hasMoreElements()){
            RentalOne each = (RentalOne) enumRentals.nextElement();
            result += each.getMovie().getTitle()+": "+each.getCharge()+"<BR>\n";
        }
        // add footer lines
        result += "<P>You own <EM>"+getTotalCharge()+"</EM></P>\n";
        result += "One this rental you earned <EM>" + getTotalFrequentRenterPoints()+"</EM> frequent renter points";
        return result;
    }

//    private double amountFor(RentalOne aRental){
//        return aRental.getCharge(aRental);
//    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration enumRentals = rentals.elements();
        while (enumRentals.hasMoreElements()) {
            RentalOne each = (RentalOne) enumRentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration enumRentals = rentals.elements();
        while (enumRentals.hasMoreElements()) {
            RentalOne each = (RentalOne) enumRentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
