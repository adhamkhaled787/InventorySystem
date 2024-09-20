
package backend;

import backend.Record;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements Record {
     String customerSSN;
     String productID;
     LocalDate purchaseDate;
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    @Override
    public String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatteddate = this.purchaseDate.format(formatter);
        String rep= this.customerSSN.concat( "," + this.productID.concat( ","+formatteddate));
        return rep;
    }

    @Override
    public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatteddate = this.purchaseDate.format(formatter);
        String rep= this.customerSSN.concat( "," + this.productID.concat( ","+formatteddate));
        return rep;
    }
}
