//class for manage product data  and category data

import java.util.Scanner;

public class Inventory{
  Category[] categories;
  Product[] products;

  //------------------Main Cat-------------------------------//
  Category menWear = new Category("Men Wear", null);
  Category womenWear = new Category("Women Wear", null);

  //------------------Sub Cat-------------------------------//
  Category menSportShoes = new Category("Men Sport Shoes", menWear);
  Category womenSportShoes = new Category("Women Sport Shoes", womenWear);

  //---------------------Product--------------------------//
  Product product1 = new Product("Adidas Man Sport Shoes",100.0,50,menSportShoes);
  Product product2 = new Product("Adidas Women Sport Shoes",250.0,150,womenSportShoes);
  Product product3 = new Product("Flicker xyzz",100.0,50,womenSportShoes);
  Product product4 = new Product("Man flicker",120.0,230,menSportShoes);


 String[] colors = {"Red", "Blue"};
String[][] sizes = { 
    {"US 8", "US 9", "US 10"}, // Sizes for Red
    {"US 7", "US 8"}           // Sizes for Blue
};
int[][] stock = { 
    {5, 8, 6}, // Stock for Red sizes
    {4, 7}     // Stock for Blue sizes
};

Shoes shoe1 = new Shoes("Flicker XII", 300.00, menSportShoes, "Adidas", colors, sizes, stock, "Leather");

  public Inventory(){

      categories = new Category[]{
       menWear,
       womenWear,
       menSportShoes,
       womenSportShoes
      };
        
     products = new Product[]{
        product1,
        product2,
        product3,
        product4,
        shoe1
     };
  }

  public void displayCat(){
    System.out.println("\n===================================");
    System.out.println("  CATEGORY DETAILS");
    System.out.println("===================================");
      for(Category category : categories){
        if(category.getPCategory() == null){
          System.out.println("\n");
          System.out.printf(" ID         : %s%n", category.getId());
          System.out.printf(" Name       : %s%n", category.getName());
        };
    
    }
  }

  public void displaySubCat(){
      System.out.println("\n===================================");
      System.out.println("  SubCategory details");
      System.out.println("===================================");
        for(Category category : categories){
          if(category.getPCategory()!=null){
            System.out.println("\n");
            System.out.printf(" Parent     :%s%n",category.getPCategory().getName()

            );
            System.out.printf(" ID         : %s%n", category.getId());
            System.out.printf(" Name       : %s%n", category.getName());
          }
      
      
      }
    }

  public void displayProduct(){
     for(Product product : products){
      System.out.println("--------------------------------------------------");
      System.out.println("Product ID   : " + product.getId());
      System.out.println("Product Name : " + product.getName());
      System.out.println("Price        : RM" + product.getPrice());
      System.out.println("Stock        : " + product.getQuantity());
      System.out.println("--------------------------------------------------");
     }
  }

  public void disData(){
    for(Product product : products){
    System.out.printf("%-25s%-15s%-15s%-15s\n",product.getName(),product.getPrice(),product.getQuantity(),product.getCategory().getName());
    }
  }

  
  public void disProduct(){
    int i =1;
    System.out.println("------------------------------------------------------");
    System.out.printf("%-4s%-25s\t%-15s\n","No.", "Name","Price(RM)");
    System.out.println("------------------------------------------------------");
    for(Product product : products){
    System.out.printf("%-4d%-25s\t%-18.2f\n",i,product.getName(),product.getPrice());
    i++;
    }
    System.out.println("------------------------------------------------------");
  }

  public void disP_details(Scanner scanner) {
    disProduct();  // Display available products

    System.out.print("Choose an index (1 - " + (products.length) + "): ");
    int index = scanner.nextInt();  // Get user input

    // Check if the index is within valid range
    if (index >= 1 && index <= products.length) {
      Product product =  products[index-1]; 

        // Display product details
        product.displayProduct();
       
    } else {
        System.out.println("Invalid index! Please choose a valid product index.");
    }
}



}