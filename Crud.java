
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
//#region displayMenu
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
//#endregion
//#region editProduct
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
//#endregion
//#region deleteProduct
public void deleteProduct(){
  System.out.println("\n=========Delete product =========");
  System.out.println("  Select product: " );
  System.out.println("=================================");
}
//#endregion
//#region addProduct()

public void addProduct(){
  boolean isValid = true;
 
  String name;
  String brand;
  String material;
  double price = 0;
  Category[] subcats = null;
  Category subcat = null;
//#region name brand material price
  System.out.println("\n=========Adding product =========");
  System.out.print("  Enter product name :  " );
  name = scanner.nextLine();

  System.out.print("  Enter the brand    :  ");
  brand = scanner.nextLine();

  System.out.print("  Enter the material : ");
  material = scanner.nextLine();
  
  do{
    isValid = true;
    try { 
      System.out.print("  Enter product price: RM");
       price = scanner.nextDouble();
      scanner.nextLine();   

    } catch (InputMismatchException e) {

      System.out.print("  Invalid input! Please enter a number.\n");
      scanner.nextLine(); 
      isValid = false;
    }
  }while(isValid == false);                
 //#endregion 

 //#region category subcategory
 do { 
    try {
      //flag 
      isValid = true;

    
        inventory.displayCategories();
        System.out.print("Choose category: ");
        int choice = scanner.nextInt();
        if(choice >= 1 && choice <= inventory.categories.length){

          subcats = inventory.getSubCatList(choice-1);// get main category's subcatList    

          subcat = inventory.chooseSubCat(choice, scanner, subcats);//display Subcategory, get specific subcats

          System.out.println("Selected Subcategory: " + subcat.getName());

        }else {

          System.out.println("Invalid choice! Please enter a number between 1 and " + inventory.categories.length);

          isValid =false;
        }
        
        
    } catch (InputMismatchException e) {

      System.out.print("  Invalid input! Please enter a number.\n");
      scanner.nextLine(); 
      isValid = false;

    }catch (ArrayIndexOutOfBoundsException e){

      System.out.printf("  Invalid choice!Choose(1-\n%d", subcats.length);
      scanner.nextLine(); 
      isValid = false;

    }catch (NullPointerException e){

      scanner.nextLine(); 
      isValid = false;

    }
} while (isValid == false);
//#endregion 
  

//#region choose color
int numOfColor = 0;
 System.out.println("---------------------------------");
 System.out.println("        Choosing color");
 System.out.println("---------------------------------");
 
  //Todo: validate number of color  less than 5
  do { 
      //Todo: validate input must be number
    try {

      System.out.print("Enter number of color: ");
      numOfColor =  scanner.nextInt();
      scanner.nextLine();
      isValid = (numOfColor >= 1 && numOfColor <= 5) ? true : false;
  
      //giving feedback
      String feedback = isValid ? "Product have " + numOfColor +" color..": "Product must have atleast one color and contain  atless  less than 6 colors";
      System.out.println(feedback);
        
    } catch (InputMismatchException e) {
      System.out.println(" Invalid input! Please enter a number.");
      scanner.next();
      isValid = false;
    }
   

  } while (isValid == false);
  

  

  String[]colors = new String[numOfColor];
  int count = numOfColor;

  boolean isDuplicate = false;

    for(int i =0; i < colors.length; i++){
      //Todo: validate color input must be character only
      //Todo : validate it is repeat color?
      do { 
        System.out.printf("%d.)%s _>",(i+1),"Color");
        colors[i]  = scanner.nextLine();

        isValid = isValidString(colors[i]);

        isDuplicate =  isDuplicate(colors[i], colors, i);

        
      
        
       

            if (!isValid) {
              System.out.println("\nInput invalid! It must contain only letters.");
          } else if (isDuplicate) {
              System.out.println("\nColor cannot be the same!");
              isValid = false;
          } else {
              count--; // Reduce count only for valid & unique inputs
              System.out.println("You added " + colors[i] + " color successfully! " + count + " color(s) left.");
          }
        

      } while (isValid == false);
    }
  
      
 
  


  String[][] eachSize = new String[numOfColor][];
  int[] numOfSizes = new int[numOfColor];


  for(int i = 0; i < numOfColor ; i++){
    System.out.printf("Enter number of sizes available for  %s color_>",colors[i]);
    numOfSizes[i] = scanner.nextInt();
    scanner.nextLine(); 
    eachSize[i] = new String[numOfSizes[i]];
  }
 
 //#endregion 
 
 //#region add number of size avalale for each color
 //todo: validate it the number > 0 ;
 //todo: validate it is number ;
 //todo: check shoes size;
  for (int i = 0; i < numOfColor; i++) {
      System.out.printf("\n%d.) %s colors\n", (i + 1), colors[i]);
      System.out.println("========================================");

      for (int j = 0; j < numOfSizes[i]; j++) { 
          System.out.printf("Enter size %d for color %s: ", (j + 1), colors[i]);
          eachSize[i][j] = scanner.nextLine();
         
      }
  }

  int[][]stock  = new int[numOfColor][];

  for(int i = 0; i < numOfColor ; i++){

      stock[i]= new int[numOfSizes[i]];
      
    for(int j = 0; j < numOfSizes[i]; j++ ){
       System.out.printf("Enter stock for %s (Size %s): ",colors[i],eachSize[i][j]);
       stock[i][j] = scanner.nextInt();
     }
  }
//#endregion
  System.out.println("\n=====================================");
  System.out.println("          Product Stock             ");
  System.out.println("=====================================");
  
  for (int i = 0; i < numOfColor; i++) {  
      System.out.printf("%s:\n", colors[i]);  // Print color name
      for (int j = 0; j < numOfSizes[i]; j++) {  
          System.out.printf("  Size %s: %d\n", eachSize[i][j], stock[i][j]);  // Print size and stock
      }
  }
  System.out.println("=====================================");

 Shoes shoe = new Shoes(name,price,subcat,brand,colors, eachSize,stock,material);
 inventory.addProduct(shoe);
}
//#endregion
//#region addCategory
public void addCategory(){
  System.out.println("\n========= Adding category =========");
  System.out.println("  Enter category name: " );
  System.out.println("  Enter number of subcategory: " );
  System.out.println("  Enter subcategory name: ");
  System.out.println("=================================");
  
}

//#endregion


public static boolean isValidString(String input) {
  return input.matches("[a-zA-Z ]+"); // Allows only letters and spaces

}

public static boolean isDuplicate(String input, String[] arr, int size) {
  for (int i = 0; i < size; i++) {

      if (arr[i].equalsIgnoreCase(input)) {
          return true; // Duplicate found
      }
  }
  return false; // No duplicate found
}
}
