package backend;

import backend.EmployeeUser;
import backend.EmployeeUserDatabase;
import static constants.FileNames.EMPLOYEE_FILENAME;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public  class AdminRole {
  public EmployeeUserDatabase database;
    public AdminRole()
    {
        this.database = new EmployeeUserDatabase(EMPLOYEE_FILENAME);
        this.database.readFromFile();
        

    }
    public void addEmployee(String employeeId,String name, String email, String address, String phonenumber)
    {  
       
       EmployeeUser user1 = new EmployeeUser(employeeId,name,email,address,phonenumber);
       database.insertRecord(user1);
       

    }
   public EmployeeUser[] getListOfEmployees()
    {
         ArrayList<EmployeeUser> employeeList = database.returnAllRecords();
        return employeeList.toArray(new EmployeeUser[0]);
    }
    public void removeEmployee(String key)
    {
        if (database.contains(key)) {
            database.deleteRecord(key);
        } else {
            System.out.println("not found");
        }
    }
    public void logout() throws FileNotFoundException, IOException
    {
        database.saveToFile();
    }
}
