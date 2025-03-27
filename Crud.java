
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
          System.out.println("1. Display Categories");
          System.out.println("2. Display Products");
          System.out.println("3. Add Product");
          System.out.println("4. Exit");
          System.out.print("Choose an option: ");

          int choice = scanner.nextInt();
          scanner.nextLine();

          switch(choice){
            case 1 ->System.out.println( "Display category");
            case 2 ->{System.out.println( "Display product");
                      inventory. displayProductDetails(scanner);}
                      
            case 3 ->{
                    System.out.println( "Add Product");
                    addNewProduct();
                    }

            case 4 ->{System.out.println( "Exiting....");
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
  public void addNewProduct(){
    inventory.displayCategories();
      try{ 
        System.out.print("Choose category: ");
        int choice = scanner.nextInt();

        if(choice > 0 && choice <= inventory.categories.length){
          Product[] subCatProduct = inventory.getSubCatProduct(choice-1, scanner);
           for(Product product: subCatProduct){
            System.out.println(product.getName());
           }         
        } else{System.out.println("Not a choice"); addNewProduct();};

    }catch(InputMismatchException e){ 
      System.out.println(" Invalid input! Please enter a number.");
      scanner.next();
      addNewProduct();
    }
   

  }
 
}