
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
          System.out.printf("%-10s%s\n","5." ," Edit Categories");
          System.out.printf("%-10s%s\n","6." ," Delete Categories");
          System.out.printf("%-10s%s\n","7." ," Exit");
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
                        Product selectedProduct =  inventory.filter(scanner); 
                          
                        editProduct(selectedProduct);
                     }

            case 4 ->{
                       System.out.println( "Delete Product....");

                        inventory.disProductData();
                              
                        deleteProduct();  
                     }

            case 5 -> {
                        System.out.println( "Edit Category....");
                        Category selectedCategory = inventory.selectCategory(scanner);
                      
                        editCategory(selectedCategory, inventory.getCategories());
                      }

            case 6 -> {

                        System.out.println( "Delete Category....");

                        deleteCategory();

                      }

            case 7 ->{

                      System.out.println( "Exiting....");

                      return;

                     }     

            default -> System.out.println("Not a choice");
                      
          } 
      }while(true);
    
    }catch(InputMismatchException e){ 
      System.out.println(" Invalid input! Please enter a number.");
      scanner.nextLine();
      displayMenu();
    }
  
}
//#endregion

//#region editProduct
 public void editProduct(Product product){
 boolean isValid = true;
  Shoes  selectedProduct = (Shoes)product;
 System.out.println("You choose to edit " + selectedProduct.getName());
  if(selectedProduct != null){
    do{
      try{
       
          System.out.printf( "%-8s%s\n" ,"1.", " Edit category");
          System.out.printf( "%-8s%s\n" ,"2.", " Edit name");
          System.out.printf( "%-8s%s\n" ,"3.", " Edit Brand");
          System.out.printf( "%-8s%s\n" ,"4.", " Edit Material");
          System.out.printf( "%-8s%s\n" ,"5.", " Edit stock");
          System.out.printf( "%-8s%s\n" ,"6.", " Edit price");
          System.out.printf( "%-8s%s\n" ,"7.", " Edit color");
          System.out.printf( "%-8s%s\n" ,"8.", " Edit size");
          System.out.printf( "%-8s%s\n" ,"9.", " Back To Menu");
          
          System.out.print("\nChoose an option (1-9): ");

          int choice = scanner.nextInt();
          scanner.nextLine();
          switch(choice){
            //#region update Category
             case 1
              ->{
     
                  Category selectedCategory = inventory.selectCategory(scanner);
                  System.out.printf("Direct to %s Category\n",selectedCategory.getName());
                  System.out.println("Current category: " + selectedProduct.getCategory().getName());
                  String oldCat = selectedProduct.getCategory().getName();
                  Category selectedSCategory = inventory.chooseSubCat(choice, scanner, selectedCategory.getSCategories());
                 selectedProduct.setCategory(selectedSCategory);
                 selectedProduct.setProductId(selectedSCategory);
                 selectedProduct.displayProduct();
                 System.out.println("Product's category updated  succesfully...");
                 System.out.printf("%s changed to %s\n" , oldCat,selectedSCategory.getName());
                 editProduct(selectedProduct);
               }
             //#endregion
             
           //#region update name
             case 2
              ->{
                  do {
               
                     System.out.printf("Current product name -> %s\n",selectedProduct.getName());
                     System.out.print("Enter new product name: ");
                     String oldName = selectedProduct.getName();
                     String newName = scanner.nextLine();
                     isValid = isValidString(newName);
                     if(isValid){
                       selectedProduct.setName(newName);
                       selectedProduct.displayProduct();
                       System.out.printf("%s changed-> %s\n" , oldName,newName);
                       editProduct(selectedProduct);
                      
                     }else{
                       System.out.println("Invalid input, input must be words!");
                       
                     }
              
                           
                  } while (isValid == false);              
              }
             //#endregion
              
            //#region update brand 
             case 3 
              ->{
                   do {
                   
                     System.out.printf("Current product brand -> %s\n",selectedProduct.getBrand());
                     System.out.print("Enter new product brand: ");
                     String oldBrand= selectedProduct.getBrand();
                     String newBrand = scanner.nextLine();
                     isValid = isValidString(newBrand);
                     if(isValid){
                       selectedProduct.setBrand(newBrand);
                       selectedProduct.displayProduct();
                       System.out.printf("%s changed to %s\n" , oldBrand,newBrand);
                       editProduct(selectedProduct);
                     
                     }else{
                       System.out.println("Invalid input, input must be words!");
                       
                     }
             
                           
                 } while (isValid == false);   
              }
            //#endregion
              
            case 4
            ->{
                String oldMaterial = selectedProduct.getMaterial();
                String selectedMaterial = inventory.selectMaterial(scanner);
               selectedProduct.setMaterial(selectedMaterial);
       
               selectedProduct.displayProduct();
               System.out.println("Product's category updated  succesfully...");
               System.out.printf("%s changed to %s\n" , oldMaterial,selectedMaterial);
               editProduct(selectedProduct);
            }
            //#region update stock
            case 5
            ->{
              String[] productColor =  selectedProduct.getColor();
              double[][]productSize = selectedProduct.getSize();

               int[][] productStock = selectedProduct.getStock();
               int row = 0;
               int column = 0;

              do{
                
                inventory.chooseSize_colorInterface(scanner , selectedProduct);
                 row = inventory.chooseColor(scanner, selectedProduct);
                 column = inventory. chooseSize(scanner, selectedProduct, row);

                //validate if the row and column exist   
                isValid = (column >= 0 && column < productStock[row].length);
                //exception(int[] selection, int choice,Scanner scanner)
                String feedback = isValid? "" : "Column and row doesnt exist, choose again!";
                System.out.println(feedback);
               

              }while(!isValid);

          
              inventory.disSelectedColor( row, column,selectedProduct);
              int oldStock = productStock[row][column];
              int newQuantity  = 0;
              do { 
                try {
                  System.out.print("\nEnter new quantity: ");
                  newQuantity = scanner.nextInt();
                  isValid =  (newQuantity > 0);
                  String feedback = isValid? "Stock quantity changed succesfully" : "Stock quantity must more than 0";
                  System.out.println(feedback);
                } catch (InputMismatchException e) {
                  System.out.println("Input invalid,must be number!");
                  isValid = false;
                  scanner.nextLine();
                }
             
              } while (!isValid);
          
              selectedProduct.setStock(row,column,newQuantity);
              System.out.println(oldStock + " changed to " + productStock[row][column]);
              

              inventory.disSelectedColor( row, column,selectedProduct);
           
              editProduct(selectedProduct);
            }
            //#endregion
           //#region update price
            case 6
               ->{
                 do {
                  try {
                   System.out.printf("Current product price -> %s\n",selectedProduct.getPrice());
                   System.out.print("Enter new product price: ");
                   double oldPrice = selectedProduct.getPrice();
                   double newPrice = scanner.nextDouble();
                   isValid = (newPrice > 0 && newPrice <9999);
                   if(isValid){
                     selectedProduct.setPrice(newPrice);
                     selectedProduct.displayProduct();
                     System.out.printf("RM%s changed to RM%s\n" , oldPrice,newPrice);
                     editProduct(selectedProduct);
                    
                   }else{
                     System.out.println("Price must be more than 0 and less than 9999");
                     isValid = false;
                   }
                      
                  } catch (InputMismatchException e) {
                    System.out.println("Invalid input ,Input must be number!");
                    scanner.nextLine();
                    isValid = false;
                  }
                                  
                 } while (isValid == false);
               }
             //#endregion
             //#region change color
             case 7
             ->{
              String[] productColor =  selectedProduct.getColor();
               
                for(String color : productColor){
                  System.out.println(color);
                }

               int row = 0;
               int column = 0;
               boolean isDuplicate;

              do{
                
                inventory.chooseSize_colorInterface(scanner , selectedProduct);
                 row = inventory.chooseColor(scanner, selectedProduct);
    
        
              }while(!isValid);

              inventory.disSelectedColor( row,selectedProduct);
              String oldColor = productColor[row];
              String newColor ;
              String feedback;
              do { 
                
                  System.out.print("\nEnter new color: ");
                  newColor = scanner.nextLine();
                  isValid =  isValidString(newColor);
                  feedback = isValid ? " " : "Input must be word only!";
                  System.out.println(feedback);
                  isDuplicate =isDuplicate(newColor, productColor,productColor.length);
                  feedback = isDuplicate ? "Color already exist please change to other color instead!" : "";
                  System.out.println(feedback);
              } while (!isValid || isDuplicate);
            
              selectedProduct.setColor(row,newColor);
              System.out.println(oldColor + " changed to " + productColor[row]);
              

              inventory.disSelectedColor( row,selectedProduct);
           
              editProduct(selectedProduct);
             }
             //#endregion

             //#region change size
             //validate duplicate size 
             //validate duplicate color
             
             case 8
             ->{
              String[] productColor =  selectedProduct.getColor();
              double[][]productSize = selectedProduct.getSize();

               int[][] productStock = selectedProduct.getStock();
               int row = 0;
               int column = 0;

              do{
                
                inventory.chooseSize_colorInterface(scanner , selectedProduct);
                 row = inventory.chooseColor(scanner, selectedProduct);
                 column = inventory. chooseSize(scanner, selectedProduct, row);

                //validate if the row and column exist   
                isValid = (column >= 0 && column < productStock[row].length);
                //exception(int[] selection, int choice,Scanner scanner)
                String feedback = isValid? "" : "Column and row doesnt exist, choose again!";
                System.out.println(feedback);
               

              }while(!isValid);

          
              inventory.disSelectedColor( row, column,selectedProduct);
              double oldSize=  productSize[row][column];
              double newSize  = 0;
              do { 
                try {
                  System.out.print("\nEnter new size: ");
                  newSize = scanner.nextDouble();
                  isValid =  (newSize > 0);
                  String feedback = isValid? "Stock quantity changed succesfully" : "Size  must be more than 0";
                  System.out.println(feedback);
                } catch (InputMismatchException e) {
                  System.out.println("Input invalid,must be number!");
                  isValid = false;
                  scanner.nextLine();
                }
             
              } while (!isValid);
          
              selectedProduct.setSize(row,column,newSize);
              System.out.println(oldSize + " changed to " + productSize[row][column]);
              

              inventory.disSelectedColor( row, column,selectedProduct);
           
              editProduct(selectedProduct);
             }

             case 9
              ->{
                 System.out.println("Back to menu......"); 
                 return;
               }
     
             default 
             ->{
               System.out.println("Select between 1-7");
               isValid = false;
             }
         }
        }catch(InputMismatchException e){
          System.out.println("Input must be number!");
          scanner.nextLine();
          isValid = false;
         
      }
    }while (!isValid); 
   
  }


 
}
//#endregion

//#region deleteProduct
public void deleteProduct(){
  boolean isValid = true;
  if(Product.getProductCount() > 0){
    try {

      System.out.println("\n=========Delete product =========");
      Product selectedProduct =inventory.chooseProduct(Inventory.getProducts(), scanner);
      String productId = selectedProduct.getId();
      isValid = (selectedProduct!= null);
      if(isValid){
        inventory.deleteProduct(productId,scanner, selectedProduct);
      }
    
      System.out.println("=================================");
      
    } catch (InputMismatchException e) {
      System.out.println(" Invalid input! Please enter a number.");
      scanner.nextLine();
      deleteProduct();
    }
  
  }
  
}
//#endregion
//#region addProduct()

public void addProduct(){
  boolean isValid;
  boolean isDuplicate;
  String feedback;
  String name;
  String brand;
  String material = "";
  double price = 0;
  Category[] subcats = null;
  Category subcat = null;

  // get array of product name for duplicate validation
  Product []arrProduct = inventory.getProducts();
  String []arrProductName =  new String [arrProduct.length];

  for(int i = 0; i < arrProduct.length; i++){
    arrProductName[i] = arrProduct[i].getName();
    System.out.println(arrProductName[i]);
  
  }
  


//#region name brand material price
do {  

  System.out.println("\n=========Adding product =========");
  System.out.print("  Enter product name :  " );
  name = scanner.nextLine();
  isDuplicate  = isDuplicate(name, arrProductName, arrProduct.length);
  feedback = isDuplicate ? name + " already exist please change to other name instead" : "";
  System.out.println(feedback);
  
} while (isDuplicate);
 System.out.print("  Enter product brand : ");
  brand = scanner.nextLine();
  System.out.println(" ");

do { 
  
   try {
    Shoes.displayMaterials();
    System.out.print("Select Materials: ");
    int choice = scanner.nextInt()-1;
    isValid = (choice >= 0 && choice < Shoes.AVAILABLE_MATERIALS.length);
    material = isValid ?  Shoes.AVAILABLE_MATERIALS[choice] : null;
     feedback = isValid ? "  Material:  " + Shoes.AVAILABLE_MATERIALS[choice] : "Choose between 1-" + Shoes.AVAILABLE_MATERIALS.length;
    System.out.println(feedback);

   } catch (Exception e) {

    System.out.print("  Invalid input! Please enter a number.\n");
    scanner.nextLine(); 
    isValid = false;
   }

} while(isValid == false);
 
  
  do{
  
    try { 
      System.out.print("  Enter product price: RM");
       double p = scanner.nextDouble();
      scanner.nextLine();  
      isValid = (p>0 && p<1000);
      price = isValid ? p : 0; 
      feedback = isValid ? "":"price must be more than 0 and less than 1000\n";
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
 
  // validate number of color  less than 5
  do { 
      // validate input must be number
    try {
    
      System.out.print("Enter number of color: ");
      numOfColor =  scanner.nextInt();
      scanner.nextLine();
      isValid = (numOfColor >= 1 && numOfColor <= 5);
  
      //giving feedback
       feedback = isValid ? "Product have " + numOfColor +" color..": "Product must have atleast one color and contain  atless  less than 6 colors";
      System.out.println(feedback);
        
    } catch (InputMismatchException e) {
      System.out.println(" Invalid input! Please enter a number.");
      scanner.next();
      isValid = false;
    }
   

  } while (isValid == false);
  

  

  String[]colors = new String[numOfColor];
  int count = numOfColor;



    for(int i =0; i < colors.length; i++){
      // validate color input must be character only
      // validate it is repeat color?
      do { 
        try {
          Shoes.displayColor();
          System.out.printf("%d.)%s _>",(i+1),"Color");
          int choice = scanner.nextInt() - 1;
          scanner.nextLine();
  
          isValid = (choice >= 0 && choice < Shoes.AVAILABLE_COLORS.length);
  
          
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

 //: check shoes size;
// check each shoes size must be mumber

  double[][] eachSize = new double[numOfColor][];
  int[] numOfSizes = new int[numOfColor];


  for(int i = 0; i < numOfColor ; i++){
    do { 
       //: validate it is number ;
      try {
         //: validate it the number > 0 ;
        
        System.out.printf("Enter number of sizes available for  %s color_>",colors[i]);
        numOfSizes[i] = scanner.nextInt();

        numOfSizes[i] = (numOfSizes[i] > 0 && numOfSizes[i] <6) ?  numOfSizes[i] : 0;
        isValid =  (numOfSizes[i] > 0 && numOfSizes[i] <6);
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
             // : validate size x duplicate
              System.out.printf("%d.) size  for color %s: ", (j + 1), colors[i]);

              int choice = scanner.nextInt()-1;
              scanner.nextLine();
              isValid = (choice>= 0 && choice < Shoes.AVAILABLE_SIZES_CM.length);
        
              
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
          int quantity = scanner.nextInt();
          isValid = ( quantity >= 0  &&  quantity < 9999);

          if(isValid){
            stock[i][j] = quantity;
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
          inventory.disProductData();
      } else if (choice == 'n') {
          System.out.println(" Product addition canceled.");
      } else {
          System.out.println("Invalid choice! Please enter 'y' or 'n'.");
      }
  } while (choice != 'y' && choice != 'n');  
}
//#endregion
//#region addCategory
public void addCategory() {
  //validation
  Category[] catArr= inventory. getCategories();// meow meow array bruh i mean category
  boolean isValid;   
  boolean isConfirm;
  boolean isDuplicate;
  boolean isNeg;
  int size = catArr.length;
  String [] arrName = new String [size];
  String feedback;
  char confirm;
 // validation

  String cName;
  
  //get the available catName
  for(int i = 0 ; i <size ; i++){
    arrName[i] = catArr[i].getName();
  }
  //#region enter main category
  do {
    System.out.println("\n========= Adding category =========");
    System.out.print("Enter category name: ");
    cName = scanner.nextLine();
   
    //confirmation on category name
    do { 
      System.out.print("Are you confirm to add new Category->" + cName + "(y/n): ");
       confirm = Character.toLowerCase(scanner.nextLine().charAt(0));
      isConfirm  = confirm == 'y';
       isValid  = confirm == 'y' || confirm =='n';
       feedback = isValid ? "" :  "choose beetween y or n";
       System.out.println(feedback);
    } while (!isValid);
   
   // validation 
    System.out.println(feedback);
    isValid =  isValidString(cName);// checking if user enter backsapce 
    feedback = isValid ?  " ": "Invalid input!Input must be words or Input is empty Please enter again!";
    System.out.println(feedback);
    isDuplicate = isDuplicate(cName,arrName,size) ;
    feedback =  !isDuplicate ? " ": " " + cName + " Already exist try different name!";
    System.out.println(feedback);
    
  } while (!isValid || !isConfirm ||isDuplicate);
  
//#endregion

//#region enter  number of subcategory for the cat ~~~ 
  int numSCat = 0;
  do {

    try {
      //#region validation for number preven user enter negative or value
      do {
        System.out.printf("Enter number of subcategories for %s: ",cName);
        numSCat = scanner.nextInt();
        isNeg = numSCat < 0 ;
        feedback = isNeg ? "Must be positive number" : " ";
        System.out.println(feedback);         
      } while (isNeg);
      //#endregion
      scanner.nextLine();
     //#region confirmation
      do {
        System.out.print("Are you confirm to add "  + numSCat + " subcategory for " +cName + "(y/n): ");
        confirm = Character.toLowerCase(scanner.nextLine().charAt(0));

        isConfirm  = confirm == 'y';
  
        isValid  = confirm == 'y' || confirm =='n';
  
       feedback = isValid ? "" :  "choose beetween y or n";
        System.out.println(feedback);
  
      } while (!isValid);
     //#endregion
    } catch (InputMismatchException e) {
      System.out.println("Input invalid must be number");
      scanner.nextLine();
      isValid = false;
    }

    
  } while (!isValid || !isConfirm);
//#endregion

  //cat rest house
  Category newCategory = new Category(cName, null);
 
  // subCat name
  String sName ;
//#region enter subCategory name 
 String []arrSName = new String[numSCat];  // place the put sCat name 
  for (int i = 0; i < numSCat; i++) {
    //#region validation for valid input for sName
    do {
      System.out.print("Enter subcategory name: ");
      sName = scanner.nextLine();
      arrSName[i] = sName;  
      isValid =  isValidString(sName);// checking if user enter backsapce 
      isDuplicate = isDuplicate(sName, arrSName, i);// prevent duplicat same name subCat
      feedback = isValid ?  " ": "Invalid input!Input must be words or Input is empty Please enter again!";
      System.out.println(feedback);  
      feedback = isDuplicate ? "Subcategory " + sName + " is already exist change ot other name instead!" : "";
      System.out.println(feedback);  

    } while (!isValid || isDuplicate);
    //#endregion

      //#region object created
      Category newSCategory = new Category(sName, newCategory);
      newCategory.addSubcategory(newSCategory); 
      //#endregion
  }
//#endregion
  System.out.println("=================================");
  int i = 1;
  System.out.printf("Main category: %s\n",newCategory.getName());
  for (Category sCat : newCategory.getSCategories()) {
     System.out.printf("%d.) %s\n",i,sCat.getName());
       i ++;
  }

  do {
    System.out.println("=================================");
    System.out.print("Are you confirm to add this category(y/n): ");
    confirm = Character.toLowerCase(scanner.nextLine().charAt(0));

 

    isValid  = confirm == 'y' || confirm =='n';
  
   feedback = isValid ? "" :  "choose beetween y or n";
  
  } while (!isValid);

  isConfirm  = confirm == 'y';
  if(isConfirm){
    inventory.addCategory(newCategory);
    inventory.displayCategories();
  }else{
    System.out.println("Addition new cateogory is cancelled");
  }
 
  
  System.out.println(feedback);

}

//#endregion


//#region inner validation method
public static boolean isValidString(String input) {
  return input != null && input.trim().matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$");

}

//validate string only
public static boolean isDuplicate(String input, String[] arr, int size) {
      // Normalize input: Convert to lowercase and remove all spaces
      String normalizedInput = input.toLowerCase().replaceAll("\\s+", "");
      String normalizedArrayElement ;

      for (int i = 0; i < size; i++) {
          // Normalize array elements: Convert to lowercase and remove all spaces
          if(arr[i]!= null){

            normalizedArrayElement = arr[i].toLowerCase().replaceAll("\\s+", "");

              if (normalizedArrayElement.equals(normalizedInput)) {
                return true; // Duplicate found
            }

          }
        
          
      }
      return false; // No duplicate found
  
}

//validate duplicate intiger
public static boolean isDuplicate(double input, double[] arr, int size) {
  for (int i = 0; i < size; i++) {

      if (arr[i] == input) { 
            return true; // Duplicate found
       }
  }

  return false; // No duplicate found
}

//#endregion

public void editCategory(Category category, Category[] arr){
  Category[] catArr =  arr;
  Category[] subCat = category.getSCategories();
  int size = catArr.length;
  String feedback;
  boolean isDuplicate;
  boolean isValid;
  boolean isConfirm;
  char confirm ;
  System.out.println("\nYou choosed " + category.getName() + " what do you want to edit?\n");
  System.out.println("==========================");
  System.out.println("  Edit Category: " + category.getName());
  System.out.println("==========================");
  System.out.println("1. Add new subcategory"    );
  System.out.println("2. delete  subcategory"    );
  System.out.println("3. change subcategory name");
  System.out.println("4. change category name"   );
  System.out.println("5. Back to menu"   );
  System.out.println("==========================");

  System.out.print("Enter your choice(1-5): ");
  int choice = scanner.nextInt();
  scanner.nextLine();

  switch(choice){
    case 1 -> {
            int numOfSCat = 0;
            Category[] arrSCat = inventory.getSubCatList(category);
            String[]  arrSCatName = new String [arrSCat.length + 1];

            int totalSize = arrSCat.length + catArr.length;  // Combined size of both arrays
            String[] arrName = new String[totalSize];

            //  Copy subcategory names
            for (int i = 0; i < arrSCat.length; i++) {
                arrName[i] = arrSCat[i].getName();
            }

            // Copy main category names after subcategories
            for (int i = 0; i < catArr.length; i++) {
                arrName[arrSCat.length + i] = catArr[i].getName();
            }


            inventory.displaySCategories(subCat);
        

             do {
              try {
                System.out.println("Add new subcategory in " + category.getName());

                System.out.print("Enter number of subcategory in " + category.getName() + ": ");
  
                 numOfSCat  = scanner.nextInt();
                
                 isValid = numOfSCat > 0 ;
                 feedback = isValid ?  " " : "Number must be more than 0";
                 System.out.println(feedback);

              } catch (InputMismatchException e) {

                  System.out.println("Input invalid! must be number!");
                  scanner.nextLine();
                  isValid = false;

              } 
             
             } while (!isValid);

             
                scanner.nextLine();
                
                // create a copy of array subcat for updated category
                String []newArrSCatName = new String[arrSCat.length + numOfSCat]; 

                for(int i = 0 ; i < newArrSCatName.length; i++){
                  if(i < arrSCat.length){
                    newArrSCatName[i] = arrSCatName[i]; //initialize existed subcatname 
                  }
             
                }

                //New Arr for new subcat object
                //Category []newSCatArr = new  Category[numOfSCat]; 

               String sName;
               Category newSCat = new Category();

               for(int i = 0; i < numOfSCat ; i++){
                do { 
                  System.out.printf("%d.) Enter subcategory name: " , i+1);
                  sName = scanner.nextLine();

                  
                  newSCat = new Category(sName,category);  
                  isDuplicate =  isDuplicate(sName,  arrName,  arrName.length);

                  


                  feedback = isDuplicate? sName + " already exist choose other name instead!" : " ";
                  System.out.println(feedback);

                } while (isDuplicate);    

                newArrSCatName[arrSCat.length + i] = sName; // intialize new subcategory into the array
                category.addSubcategory(newSCat);  
                
               }
          
                                
               System.out.println("Updated list of subcategories:");
               System.out.println("================================");
               int i = 0;
               for (String name : newArrSCatName) {
                   System.out.println(i+1 + ".) "+ name);
                   i++;
               }
              
               editCategory(category, arr);
              

              }
              
         

      case 2 -> {
                  Category[] sCat = category.getSCategories();

                  // Let the user choose a subcategory (prompt is inside this method)
                  Category selectedSCat = inventory.chooseSubCat(choice, scanner, sCat);
                  
                  // Find the index of the selected category in the array
                  choice = -1;
                  for (int i = 0; i < sCat.length; i++) {
                      if (sCat[i].getId().equals(selectedSCat.getId())) {
                          choice = i;
                          break;
                      }
                  }
                  
                  // Only delete if a valid choice was made
                  if (choice >= 0 && choice < sCat.length) {
                      inventory.deleteSubCat(selectedSCat.getId(), scanner, category);
                  }

                  editCategory(category, arr);
              }
    
     case 3 -> {
              
                System.out.println("Change subcategory to edit: ");
                Category selectedSCat =inventory.chooseSubCat(choice, scanner, subCat);
                    
                Category[] sCatArr = inventory.getSubCatList(category);

                String [] sCatNameArr = new String[sCatArr.length];
                sCatNameArr[0] = category.getName();
                for (int i = 1; i < sCatArr.length ; i++) {
                  sCatNameArr[i] =  sCatArr[i].getName();
                }

                String sName = selectedSCat.getName(); 
                System.out.println("You choose " +sName+ " to edit");
                String newSName;

                do { 
                  System.out.println("=============================");
                  System.out.println("Change category name" );
                  System.out.println("=============================");
                  System.out.println("Current subcategory name : " + sName);
                  System.out.print("Enter new subcategory: ");
  
                  newSName = scanner.nextLine();
                  isDuplicate = isDuplicate(newSName, sCatNameArr, sCatArr.length);

                  feedback = isDuplicate ?  newSName + " is already is exist, change other name exist" : " ";
                  System.out.println(feedback); 

                  isValid = isValidString(newSName);
                  feedback = isValid ? "" : "Input must be word!";
                  System.out.println(feedback);

                } while (isDuplicate || !isValid);

                do {

                  System.out.print("Are you confirm to change to this  " + newSName + "(y/n): ");
                  confirm = Character.toLowerCase(scanner.nextLine().charAt(0));
                  
                  isValid  = confirm == 'y' || confirm =='n';
                  feedback = isValid ? "" :  "choose beetween y or n";
                  System.out.println(feedback);
                  
                } while (!isValid);
                
                if(confirm == 'y'){
                  System.out.println("You Changed " + sName + " to " + newSName + " succesfully!");
                  selectedSCat.setName(newSName);
                  inventory.displaySCategories(subCat);
                  editCategory(category, arr);
                }else{
                  System.out.println("subcategory name change cancelled!");
                  editCategory(category, arr);
                }
               
                
               }
       
     case 4 -> {
                 String newCname;
                
                String oldCname = category.getName();
                Category[] arrSCat = inventory.getSubCatList(category);

                int totalSize = arrSCat.length + catArr.length;  // Combined size of both arrays
                String[] arrCName = new String[totalSize];

                //  Copy subcategory names
                for (int i = 0; i < arrSCat.length; i++) {
                    arrCName[i] = arrSCat[i].getName();
                }

                // Copy main category names after subcategories
                for (int i = 0; i < catArr.length; i++) {
                    arrCName[arrSCat.length + i] = catArr[i].getName();
                }

              

                  do { 
                    System.out.println("=============================");
                    System.out.println("Change category name" );
                    System.out.println("=============================");
                    System.out.println("Current category  : " + oldCname);
                    System.out.print("Enter new category: ");
    
                    newCname = scanner.nextLine(); 
                    isDuplicate = isDuplicate(newCname, arrCName, size);

                    feedback = isDuplicate ? newCname + " already exist please enter other name instead." : "";

                    System.out.println(feedback);
                    isValid  = isValidString(newCname);

                    feedback = isValid ? "" : "Input must be word!";
                    System.out.println(feedback);

                  } while (isDuplicate || !isValid);

                do {

                  System.out.print("Are you confirm to change to this  " + newCname + "(y/n): ");
                  confirm = Character.toLowerCase(scanner.nextLine().charAt(0));
                  
                  isValid  = confirm == 'y' || confirm =='n';
                  feedback = isValid ? "" :  "choose beetween y or n";
                  System.out.println(feedback);
                  
                } while (!isValid);
                
                  if(confirm == 'y'){
                    category.setName(newCname);
                    System.out.println("You Changed " + oldCname + " to " + newCname + " succesfully!");
                    inventory.displayCategories();
                    editCategory(category, arr);
                  }else{
                    System.out.println("Category name change cancelled!");
                    editCategory(category, arr);
                  }
        
               }
                  
     case 5 -> {
                System.out.println("Back to menu");
                return ;
               }
                  
     
  }
}

public void deleteCategory(){

}

}
