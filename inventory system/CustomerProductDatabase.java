package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CustomerProductDatabase extends Database {

    public CustomerProductDatabase (String filename)
    {
        super(filename);

    }


    @Override
    public CustomerProduct createRecordFrom(String line)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String[] parts = line.split(",");

            String ssn = parts[0];
            String p_id = parts[1];
            LocalDate purdate = LocalDate.parse(parts[2],formatter);
            CustomerProduct product = new CustomerProduct(ssn,p_id,purdate);
        return product;

    }


}
