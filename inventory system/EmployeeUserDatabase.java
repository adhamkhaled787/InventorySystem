package backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeUserDatabase extends Database {


    public EmployeeUserDatabase(String filename) {
       super(filename);
    }





    public EmployeeUser createRecordFrom(String line) {
        Scanner sc = new Scanner(line);
        String str = sc.nextLine();
        String[] arr = str.split(",");
        String id = arr[0];
        String name = arr[1];
        String email = arr[2];
        String address = arr[3];
        String phonenumber = arr[4];
        EmployeeUser user = new EmployeeUser(id, name, email, address, phonenumber);
        return user;
    }


    }


