
import java.util.InputMismatchException;
import java.util.Scanner;
//crud interfce
public class Crud{


  private Inventory inventory;
  Scanner scanner;

  public Crud(){
    inventory =  new Inventory();
    scanner =  new Scanner(System.in);
  }

  public void displayMenu(){
      try{
        do{
          System.out.println("\n========= Inventory System =========");
          System.out.printf("%-10s%s\n","1." ," Add Categories");
          System.out.printf("%-10s%s\n","2." ," Add Product");
          System.out.printf("%-10s%s\n","3." ," Edit Product");
          System.out.printf("%-10s%s\n","4." ," Delete Product");
          System.out.printf("%-10s%s\n","5." ," Exit");
          System.out.println("====================================");
          System.out.print("Choose an option: ");

          int choice = scanner.nextInt();
          scanner.nextLine();

          switch(choice){
            case 1 ->{
                       System.out.println( "Add category");
                       addCategory();
                     }
            case 2 ->{
                      System.out.println( "Add product");
                      addProduct();
                     }

                      
            case 3 ->{            
                        inventory.filter(scanner);
                      
                        editProduct();
                    }
            case 4 ->{System.out.println( "Delete Product....");

                        inventory.filter(scanner);
                              
                        deleteProduct();  
                     }
            case 5 ->{System.out.println( "Exiting....");
                      return;}           
            default ->System.out.println("Not a choice");
                      
          } 
      }while(true);
    
    }catch(InputMismatchException e){ 
      System.out.println(" Invalid input! Please enter a number.");
      scanner.next();
      displayMenu();
     }
    
}

public void editProduct(){
  System.out.println("\n========= Edit Product =========");
  System.out.printf( "%-8s%s\n" ,"1.", " Edit category");
  System.out.printf( "%-8s%s\n" ,"2.", " Edit name");
  System.out.printf( "%-8s%s\n" ,"3.", " Edit stock");
  System.out.printf( "%-8s%s\n" ,"4.", " Edit price");
  System.out.println("=================================");
 
  System.out.print("Choose an option: ");

  int choice = scanner.nextInt();
  scanner.nextLine();
}
public void deleteProduct(){
  System.out.println("\n=========Delete product =========");
  System.out.println("  Select product: " );
  System.out.println("=================================");
}
public void addProduct(){
                    
  



  System.out.println("\n=========Adding product =========");
  System.out.print("  Enter product name: " );
  String name = scanner.nextLine();
  
  inventory.displayCategories();
  System.out.print("Choose category: ");
  int choice = scanner.nextInt();
  Category[] subcats = inventory.getSubCatList(choice-1);// get main category's subcatList

  if(choice >= 1 && choice <= inventory.categories.length){
    
    Category subcat = inventory.chooseSubCat(choice, scanner, subcats);//display Subcategory, get specific subcats
 }
  
  System.out.print("  Enter number of color: ");
  System.out.println("\n=================================");
}

public void addCategory(){
  System.out.println("\n========= Adding category =========");
  System.out.println("  Enter category name: " );
  System.out.println("  Enter number of subcategory: " );
  System.out.println("  Enter subcategory name: ");
  System.out.println("=================================");
  
}


 
}