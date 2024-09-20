package backend;

import backend.Record;

public class Product implements Record {
   public String productID;
   public String productName;
   public String manufacturerName;
   public String supplierName;
    public int quantity;
   public float price;
    public Product(){

    }
   public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price)
   {
       this.productID = productID;
       this.productName = productName;
       this.manufacturerName = manufacturerName;
       this.supplierName = supplierName;
       this.quantity = quantity;
       this.price = price;
   }
   public void setQuantity(int quantity)
   {
       this.quantity = quantity;
   }

    public int getQuantity() {
        return quantity;
    }
    public String lineRepresentation()
    {
        String linerep= this.productID + "," + this.productName + "," + this.manufacturerName + "," + this.supplierName + "," + this.quantity + "," + this.price;
        return linerep;
    }
    public String getSearchKey()
    {
        return this.productID;
    }

    double getPrice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
