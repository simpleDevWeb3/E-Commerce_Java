
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

                        inventory.disProductData();
                              
                        deleteProduct();  
                     }
            case 5 ->{System.out.println( "Exiting....");
                      return;}           
            default ->System.out.println("Not a choice");
                      
          } 
      }while(true);
    
    }catch(Exception e){ 
      System.out.println(" Invalid input! Please enter a number.");
      scanner.nextLine();
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
  boolean isValid = true;
  try {
    System.out.println("\n=========Delete product =========");
    Product selectedProduct =inventory.chooseProduct(inventory.getProducts(), scanner);
    String productId = selectedProduct.getId();
    isValid = (selectedProduct!= null) ? true : false;
    if(isValid){
      inventory.deleteProduct(productId);
    }
  
    System.out.println("=================================");
    
  } catch (InputMismatchException e) {
    System.out.println(" Invalid input! Please enter a number.");
    scanner.nextLine();
    deleteProduct();
  };

}
//#endregion
//#region addProduct()

public void addProduct(){
  boolean isValid = true;
 
  String name;
  String brand;
  String material = "";
  double price = 0;
  Category[] subcats = null;
  Category subcat = null;
//#region name brand material price
  System.out.println("\n=========Adding product =========");
  System.out.print("  Enter product name :  " );
  name = scanner.nextLine();

  System.out.print("  Enter the brand    :  ");
  brand = scanner.nextLine();

do { 
  
   try {
    Shoes.displayMaterials();
    System.out.print("Select Materials: ");
    int choice = scanner.nextInt()-1;
    isValid = (choice >= 0 && choice < Shoes.AVAILABLE_MATERIALS.length) ? true : false;
    material = isValid ?  Shoes.AVAILABLE_MATERIALS[choice] : null;
    String feedback = isValid ? "  Material:  " + Shoes.AVAILABLE_MATERIALS[choice] : "Choose between 1-" + Shoes.AVAILABLE_MATERIALS.length;
    System.out.println(feedback);

   } catch (Exception e) {

    System.out.print("  Invalid input! Please enter a number.\n");
    scanner.nextLine(); 
    isValid = false;
   }

} while(isValid == false);
 
  
  do{
    isValid = true;
    try { 
      System.out.print("  Enter product price: RM");
       double p = scanner.nextDouble();
      scanner.nextLine();  
      isValid = (p>0 && p<1000)? true:false;
      price = isValid ? p : 0; 
      String feedback = isValid ? "":"price must be more than 0 and less than 1000\n";
      System.out.println(feedback);

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
        if(choice >= 1 && choice <= inventory.getCategories().length){

          subcats = inventory.getSubCatList(choice-1);// get main category's subcatList    

          subcat = inventory.chooseSubCat(choice, scanner, subcats);//display Subcategory, get specific subcats

          System.out.println("Selected Subcategory: " + subcat.getName());

        }else {

          System.out.println("Invalid choice! Please enter a number between 1 and " + inventory.getCategories().length);

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
        try {
          Shoes.displayColor();
          System.out.printf("%d.)%s _>",(i+1),"Color");
          int choice = scanner.nextInt() - 1;
          scanner.nextLine();
  
          isValid = (choice >= 0 && choice < Shoes.AVAILABLE_COLORS.length) ? true : false;
  
          
          if (!isValid) {
              System.out.println("\nChoose a valid option (1-" + (Shoes.AVAILABLE_COLORS.length - 1) + ").");
          } 
          else {
              colors[i] = Shoes.AVAILABLE_COLORS[choice];
              isDuplicate = isDuplicate(colors[i], colors, i); // Check first before adding
              
              if (isDuplicate) {
                  System.out.println("\nColor cannot be the same! Try again.");
                  isValid = false;
              } else {
                  colors[i] = Shoes.AVAILABLE_COLORS[choice]; // Assign only if unique
                  count--; // Reduce count only for valid & unique inputs
                  System.out.println("You added " + colors[i] + " color successfully! " + count + " color(s) left.");
              }
          }
            
        } catch (Exception e) {
          System.out.println("\nInvalid input! Please enter a number.");
          scanner.nextLine();
          isValid = false;
        }
       
        
      } while (isValid == false);
    }
  
      
  //#endregion 
 
 //#region add number of size avalale for each color

 //todo: check shoes size;
//todo: check each shoes size must be mumber

  double[][] eachSize = new double[numOfColor][];
  int[] numOfSizes = new int[numOfColor];


  for(int i = 0; i < numOfColor ; i++){
    do { 
       //todo: validate it is number ;
      try {
         //todo: validate it the number > 0 ;
        
        System.out.printf("Enter number of sizes available for  %s color_>",colors[i]);
        numOfSizes[i] = scanner.nextInt();
        numOfSizes[i] = (numOfSizes[i] > 0 && numOfSizes[i] <6) ?  numOfSizes[i] : 0;
        isValid =  (numOfSizes[i] <= 0 && numOfSizes[i] <6) ? false : true;
        String err = isValid ? "":"Number must be more than 0 and less than 6";
        System.out.println(err);

      } catch (InputMismatchException e) {

        System.out.println(" Invalid input! Please enter a number.");
        scanner.nextLine();
        isValid = false;
      }
      
  
    } while (!isValid);
   
    scanner.nextLine(); 
    eachSize[i] = new double[numOfSizes[i]];
    
  
  }
 


  for (int i = 0; i < numOfColor; i++) {
      //validate size x duplicate 
      Shoes.displaySize();
      System.out.printf("\n%d.) %s colors\n", (i + 1), colors[i]);
      System.out.println("========================================");

      for (int j = 0; j < numOfSizes[i]; j++) { 
      
          do {
             try {
             //todo : validate size x duplicate
              System.out.printf("%d.) size  for color %s: ", (j + 1), colors[i]);

              int choice = scanner.nextInt()-1;
              scanner.nextLine();
              isValid = (choice>= 0 && choice < Shoes.AVAILABLE_SIZES_CM.length) ? true : false;
        
              
              if (isValid) {
                double size = Shoes.AVAILABLE_SIZES_CM[choice];

                if (isDuplicate(size,eachSize[i],j)) {
                    System.out.println(" Duplicate size! Please enter a unique size.");
                    isValid = false;
                } else {
                    eachSize[i][j] = size;
                    System.out.println(" Added successfully!");
                }
            } else {
                System.out.println("Invalid choice! Choose between 1 and " + Shoes.AVAILABLE_SIZES_CM.length);
            }

            } catch (InputMismatchException e) {

              System.out.println(" Invalid input! Please enter a number.");
              scanner.nextLine();
              isValid = false;

            }
  
          } while (isValid == false);     
            
               
         
      }
  }

  int[][]stock  = new int[numOfColor][];

  for(int i = 0; i < numOfColor ; i++){
      
      stock[i]= new int[numOfSizes[i]];
     
      System.out.println("\nStock for "+ colors[i] + " Color");
      System.err.println("---------------------------------");

    for(int j = 0; j < numOfSizes[i]; j++ ){
      do {
        try {
          System.out.printf("Enter stock for (Size %s): ",eachSize[i][j]);
          stock[i][j] = scanner.nextInt();
          isValid = (stock[i][j] >= 0  && stock[i][j] < 9999)? true  : false;

          if(isValid){
            stock[i][j] = stock[i][j];
          }else{
            System.out.println("Stock must be positive and less than 9999");
          }
            
        } catch (InputMismatchException e) {
          System.out.println(" Invalid input! Please enter a number.");
          scanner.nextLine();
          isValid = false;
        }
       
      } while (!isValid);
       
       
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

System.out.println("\n=====================================");
System.out.println("          Product Summary           ");
System.out.println("=====================================");
shoe.displayProduct();  // Show the final product details


// Ask for confirmation before adding the product
char choice;
  do {
      System.out.print("Do you confirm adding this product? (y/n): ");
      choice = scanner.next().toLowerCase().charAt(0);

      if (choice == 'y') {
          inventory.addProduct(shoe);
          System.out.println(" Product added successfully!");
      } else if (choice == 'n') {
          System.out.println(" Product addition canceled.");
      } else {
          System.out.println("Invalid choice! Please enter 'y' or 'n'.");
      }
  } while (choice != 'y' && choice != 'n');  
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


//#region inner validation method
public static boolean isValidString(String input) {
  return input.matches("[a-zA-Z ]+"); // Allows only letters and spaces

}

//validate string only
public static boolean isDuplicate(String input, String[] arr, int size) {
  for (int i = 0; i < size; i++) {

      if (arr[i].equalsIgnoreCase(input)) {
          return true; // Duplicate found
      }
  }
  return false; // No duplicate found
}


public static boolean isDuplicate(double input, double[] arr, int size) {
  for (int i = 0; i < size; i++) {

      if (arr[i] == input) { 
            return true; // Duplicate found
       }
  }

  return false; // No duplicate found
}

//#endregion
}
