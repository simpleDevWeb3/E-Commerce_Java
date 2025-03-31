import java.util.Scanner;
public class Main {
  public static void main(String []args){
    Scanner scanner = new Scanner(System.in);
   //Inventory i = new Inventory();

  Crud c = new Crud();
   

   //i.displayCategories();/*<=display main category exist in inventory */

   //i.displayProducts(); /*<= display all product exist in inventory*/
  
   //i.disData(); // display database product
   //i.disProductList();; // display product catalog

  //i. displayProductDetails(scanner); //display product detail
 

  c.displayMenu();

  //i.getProducts();
 /*  for(Product product :  i.getProducts()){
      System.out.println(product.getProductCount());
  }
  //System.out.println("DEBUG: Actual products array length: " + i.getProducts().length);
System.out.println("DEBUG: Stored product count: " + Product.getProductCount());
  //i.disProductList();*/
 
  
  }

  // check number enter in the range array
  public static boolean validation(int choice, int[] selection) {

    for(int select: selection) {
      if  (choice == select) {
        return true;
      }
    }
    System.out.println("Invalid input. Number entered is out of range.");
    return false;
  }



 // check if number
  public static boolean exception(int[] selection , Scanner s, int choice ) { 
    boolean validInput ;
    //array of selection  int[]selection

    try {
      System.out.print("Enter number: ");
      choice = s.nextInt();
      s.nextLine();
      validInput = validation(choice, selection);
      return validInput; 

    } catch(Exception ex) {
      System.out.println("Invalid input. Must be digit.");
      s.nextLine();
    }
    return false;
  }


  
}
