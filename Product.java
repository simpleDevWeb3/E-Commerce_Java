public class Product{
  private String id; 
  private String pName;
  private double price;
  private int quantity;
  Category category;
 
 
  public Product(){

  }

  public Product(String pName, double price, int quantity,Category category){
      this.id = IdGenerator.generateProductId(category.getName());
      this.pName = pName;
      this.price = price;
      this.quantity = quantity;
      this.category = category;
     
  }

 public String getId(){ return id;}



 public String getName(){return pName;}

 public void setName(String name){this.pName = name;}

 public double getPrice(){return price;}

 public void setPrice(double price){this.price = price;}
 
 public void setQuantity (int quantity){this.quantity = quantity;}

 public int getQuantity (){return quantity;}

 public Category getCategory(){return category;}
 


 public void displayProduct() {
  System.out.println("--------------------------------------------------");
  System.out.println("Product ID   : " + id);
  System.out.println("Product Name : " + pName);
  System.out.println("Price        : RM" + price);
  System.out.println("Stock        : " + quantity);
  System.out.println("--------------------------------------------------");
}


  

  

}