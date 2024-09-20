package backend;

import backend.CustomerProductDatabase;
import backend.ProductDatabase;
import backend.Record;
import static constants.FileNames.CUSTOMERPRODUCT_FILENAME;
import static constants.FileNames.PRODUCT_FILENAME;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
public class EmployeeRole {
     public ProductDatabase pd;
     public CustomerProductDatabase cpd;

    public EmployeeRole( ) {
        this.pd = new ProductDatabase(PRODUCT_FILENAME);
        pd.readFromFile();
        this.cpd = new CustomerProductDatabase(CUSTOMERPRODUCT_FILENAME);
        cpd.readFromFile();

    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity,float price) {
        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity,price);
        pd.insertRecord(product);
        
    }

    public Product[] getListOfProducts() {
        ArrayList<Product> productList = pd.returnAllRecords();
        return productList.toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        ArrayList<CustomerProduct> purchaseList = cpd.returnAllRecords();
        return purchaseList.toArray(new CustomerProduct[0]);
    }


    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product product = (Product) pd.getRecord(productID);

        if (product != null && product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1);
            CustomerProduct newPurchase = new CustomerProduct(customerSSN, productID, purchaseDate);
            cpd.insertRecord(newPurchase);
            

            return true;
        }

        return false;
    }

   public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        if (returnDate.isBefore(purchaseDate)) {
            return -1;
        }
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
       String formatteddate = purchaseDate.format(formatter);
        String customerProductKey =  customerSSN.concat( "," + productID.concat( ","+formatteddate));
        if (!cpd.contains(customerProductKey)) {
            System.out.println("product returned successfully");
            return -1;
        }

        Record customerProduct =cpd.getRecord(customerProductKey);

        LocalDate maxReturnDate = purchaseDate.plusDays(14);
        if (returnDate.isAfter(maxReturnDate)) {
            return -1;
        }

        Product product = (Product) pd.getRecord(productID);
        if (product != null) {

            product.setQuantity(product.getQuantity() + 1);
        }

        cpd.deleteRecord(customerProductKey);

       
        return product.price;
    }


    public void logout() throws FileNotFoundException, IOException {
        pd.saveToFile();
        cpd.saveToFile();
    }
}
