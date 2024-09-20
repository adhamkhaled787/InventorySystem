package backend;

import backend.Record;

public class EmployeeUser implements Record
{
    public String employeeID;
   public String name;
   public String email;
    public String address;
    public String phoneNumber;
    public EmployeeUser()
    {

    }
    public EmployeeUser(String employeeID, String name, String email, String address, String phoneNumber)
    {
        this.employeeID = employeeID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
public String lineRepresentation()
{
    String linerep=this.employeeID + "," + this.name + ',' + this.email + "," + this.address +"," + this.phoneNumber;
    return linerep;
}
public String getSearchKey()
{
    return this.employeeID;
}

    public Object getEmployeeId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getPhoneNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

