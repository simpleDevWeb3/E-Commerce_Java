
import java.util.Scanner;
import java.util.InputMismatchException;
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
          System.out.println("1. Add Categories");
          System.out.println("2. Add Products");
          System.out.println("3. Edit Product");
          System.out.println("4. Delete Product");
          System.out.println("5. Exit");
          System.out.print("Choose an option: ");

          int choice = scanner.nextInt();
          scanner.nextLine();

          switch(choice){
            case 1 ->System.out.println( "Add category");
            case 2 ->{System.out.println( "Add product");
                      inventory. displayProductDetails(scanner);}
                      
            case 3 ->{
                    System.out.println( "Edit Product");
                    inventory.displayProductByCat(scanner);
                    }
            case 4 ->{System.out.println( "Delete Product....");}
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

public void deleteProduct(){}
public void addProduct(){}
public void addCategory(){}
 
}