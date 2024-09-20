package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDatabase extends Database {

    public ProductDatabase(String filename) {
        super(filename);
    }




    public Product createRecordFrom(String line) {
        Scanner sc = new Scanner(line);
        String str = sc.nextLine();
        String[] parts = str.split(",");
        String productid = parts[0];
        String productname = parts[1];
        String manufacturerName = parts[2];
        String supplierName = parts[3];
        int quantity = Integer.parseInt(parts[4]);
        float price = Float.parseFloat(parts[5]);
        Product p1 = new Product(productid, productname, manufacturerName, supplierName, quantity, price);
        System.out.println(productid);
        return p1;
    }

}