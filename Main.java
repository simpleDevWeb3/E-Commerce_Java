import java.util.Scanner;
public class Main {
  public static void main(String []args){
    Scanner scanner = new Scanner(System.in);
   Inventory i = new Inventory();
   Crud c = new Crud();
   
   //i.displayCategories();/*<=display all category exist in inventory */


   //i.displayProducts(); /*<= display all product exist in inventory*/
  
   //i.disData(); // display database product
   //i.disProductList();; // display product catalog

  //i. displayProductDetails(scanner); //display product detail
 

  c.displayMenu();

 
  
  }
}
