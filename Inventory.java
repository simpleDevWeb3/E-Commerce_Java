import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory {
    private Category[] categories;
    private Product[] products;
   

   

//#region  Data
    Category menWear = new Category("Men Wear", null);
    Category womenWear = new Category("Women Wear", null);
    
    //------------------Sub Categories-------------------------------//
    Category menSportShoes = new Category("Men Sport Shoes", menWear);
    Category menSandal = new Category("Men Sandal", menWear);
    Category womenSportShoes = new Category("Women Sport Shoes", womenWear);
//#endregion Data
//#region Constructor
    public Inventory() {
        categories = new Category[]{
            menWear,
            womenWear        
        };

        products = new Product[]{
            new Shoes(
                "Adidas Running Max", 350.00, menSportShoes, "Adidas",
                new String[]{"Black", "White"},
                new double[][]{
                    {7, 8, 9}, // Black sizes
                    {6, 7}     // White sizes
                },
                new int[][]{
                    {5, 3, 7}, // Stock for Black
                    {6, 2}     // Stock for White
                },
                "Mesh"
            ),
            new Shoes(
                "Nike Air Zoom", 400.00, menSportShoes, "Nike",
                new String[]{"Blue", "Red","Pink"},
                new double[][]{
                    {8, 9, 10}, // Blue sizes
                    {7, 8},     // Red sizes
                    {7, 8}      // Pink sizes    
                },
                new int[][]{
                    {4, 6, 8}, // Stock for Blue
                    {5, 9},    // Stock for Red
                    {15, 9}    // Stock for Pink
                },
                "Synthetic Leather"
            ),
            new Shoes(
                "Puma Sports", 280.00, womenSportShoes, "Puma",
                new String[]{"Pink", "Grey"},
                new double[][]{
                    {6, 7, 8}, // Pink sizes
                    {5, 6}     // Grey sizes
                },
                new int[][]{
                    {8, 6, 3}, // Stock for Pink
                    {4, 5}     // Stock for Grey
                },
                "Knit Fabric"
            )
        };
    }        
//#endregion Constructor

//#region  displayCategories
public void displayCategories() {
        System.out.println("\n===================================");
        System.out.println("  CATEGORY DETAILS");
        System.out.println("===================================");
    
        int i = 1;
        for (Category category : categories) {
           
            
                System.out.printf("%-5d %s%n",i, category.getName());
                i++;
           
              
        }
        System.out.println("===================================");
    }
//#endregion displayCategories
 
//#region displayScategories param: Category[] subcat
public void displaySCategories(Category[] subCat){
        System.out.println("\n===================================");
        System.out.println("  SUB CATEGORY DETAILS");
        System.out.println("===================================");
    
        int i = 1;
        for (Category sCategory : subCat) {
                
                System.out.printf("%-5d %s%n",i, sCategory.getName());
                i++;
           
              
        }
        System.out.println("===================================");
    }
//#endregion

//#region displayProducts unused
/*  public void displayProducts() {
    System.out.println("\n===================================");
    System.out.println("  SHOES COLLECTION");
    System.out.println("===================================");
    for (Product product : products) {
          if(product instanceof Shoes){
              ((Shoes) product).displayProduct(); // castcasting like (int)12.0 
          }else{
            product.displayProduct();
          }
            
     }
 }*/
//#endregion displayProducts

//#region disProductData 

public void disProductData(){
    
    int i = 1;
    System.out.println("------------------------------------------------------");
    System.out.printf("%-4s\t%-25s%-15s%-4s\n", "No.", "Name", "Price(RM)","Stock");
    System.out.println("------------------------------------------------------");
    for(Product p : products){
        if (p instanceof Shoes) {
            Shoes shoe = (Shoes) p; // Downcasting to Shoes
            System.out.printf("%d.)\t%-25s%-15.2f%d\n",
                    i++,
                    shoe.getName(),
                    shoe.getPrice(),
                    shoe.getTotalStock() // Using Shoes method
            );
        } else {
            // For other products, display without stock info
            System.out.printf("%d.)\t%-25s%-15.2f%d\n",
                    i++,
                    p.getName(),
                    p.getPrice(),
                    p.getQuantity()
            );
        }
    }
    System.out.println("------------------------------------------------------");

}
//#endregion disProductData
//#region disProductData overload params: Product []subCatProduct 

public void disProductData(Product [] subCatProduct){
    
    int i = 1;
    System.out.println("------------------------------------------------------");
    System.out.printf("%-4s\t%-25s%-15s%-4s\n", "No.", "Name", "Price(RM)","Stock");
    System.out.println("------------------------------------------------------");
    for(Product p : subCatProduct){
        if (p instanceof Shoes) {
            Shoes shoe = (Shoes) p; // Downcasting to Shoes
            System.out.printf("%d.)\t%-25s%-15.2f%d\n",
                    i++,
                    shoe.getName(),
                    shoe.getPrice(),
                    shoe.getTotalStock() // Using Shoes method
            );
        } else {
            // For other products, display without stock info
            System.out.printf("%d.)\t%-25s%-15.2f%d\n",
                    i++,
                    p.getName(),
                    p.getPrice(),
                    p.getQuantity()
            );
        }
    }
    System.out.println("------------------------------------------------------");

}
//#endregion disProductData
//#region disProductList unused replace disProductData
  /*   public void disProductList() {
        int i = 1;
        System.out.println("------------------------------------------------------");
        System.out.printf("%-4s%-25s\t%-15s\n", "No.", "Name", "Price(RM)");
        System.out.println("------------------------------------------------------");
        for (Product product : products) {
          if(product instanceof Shoes){
            System.out.printf("%-4d%-25s\t%-18.2f\n", i,((Shoes)product).getName(), ((Shoes)product).getPrice());
            i++;
          }else{
            System.out.printf("%-4d%-25s\t%-18.2f\n", i,product.getName(), product.getPrice());
            i++;
          } 
      
           
        }
        System.out.println("------------------------------------------------------");
    }*/
//#endregion disProductList
 
//#region disProductList overload param: Category Unused
/*public void disProductList(Category category) {
        int i = 1;
        for(Product product : products){
            if(product.getCategory().equals(category)){
                System.out.println("------------------------------------------------------");
                System.out.printf("%-4s%-25s\t%-15s\n", "No.", "Name", "Price(RM)");
                System.out.println("------------------------------------------------------");
                for (Product p : products) {
                  if(product instanceof Shoes){
                    System.out.printf("%-4d%-25s\t%-18.2f\n", i,((Shoes)p).getName(), ((Shoes)p).getPrice());
                    i++;
                  }else{
                    System.out.printf("%-4d%-25s\t%-18.2f\n", i,p.getName(), p.getPrice());
                    i++;
                  } 
              
                   
                }
                System.out.println("------------------------------------------------------");
            }
        }
       
    }*/
 //#endregion    

 //#region displayAllProduct param: scanner  (display product's detail)   
    public void displayAllProduct(Scanner scanner) {
       // disProductList();
        disProductData();
     try{
        System.out.print("Choose an index (1 - " + products.length + "): ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= products.length) {
          Product selectedProduct = products[index-1];
          displayProductDetails(selectedProduct);
            
        } 
        else {
            System.out.println("Invalid index! Please choose a valid product index.");
            displayAllProduct(scanner);
        }
     }catch(InputMismatchException e){
        System.out.println(" Invalid input! Please enter a number.");
        scanner.next(); // Clear invalid input
        displayAllProduct(scanner);
     }
       
    }
  //#endregion	

//#region displayProductDetails param: Product product
    public void displayProductDetails(Product product) {
      
 
       Product selectedProduct = product;

        if(selectedProduct instanceof Shoes){
           ((Shoes)selectedProduct).displayProduct();
          }
         else{
            selectedProduct.displayProduct(); 
          }
            
      
       
    }

//#endregion

//#region addProduct
 public void addProduct(Product newProduct){
     //expand array
     products = Arrays.copyOf(products,products.length + 1 );
     
     //asign new subcat to last index
     products[products.length - 1] = newProduct;
 }
//#endregion addProduct


//#region getSubCatList return Category[]subCat
    // get subCategoryList from main category
    public Category[]getSubCatList(int choice){
        Category[] subcats = categories[choice].getSCategories();
        return subcats;
    }
//#endregion
  
//#region getSubCatProduct return Product[] subCatProduct
    //get Product from subCategory
    public Product[]getSubCatProduct(int choice, Scanner scanner) {
        // Retrieve subcategories
        Category[] subcats = getSubCatList(choice); // Returns array
    
        // Check if subcategories exist
        if (subcats == null || subcats.length == 0) {
            System.out.println("No subcategories available.");
            
        }

        Category subCat = chooseSubCat(choice, scanner, subcats); 
        int count = 0;
        for(Product product : products)
        
        if(product.getCategory().equals(subCat)){ 
          count++;
        }

 
        Product []subCatProduct = new Product[count]; 
        int i = 0; 
        for(Product product : products)
        
        if(product.getCategory().equals(subCat)){
          subCatProduct[i] = product;
          i++;
        }
        

      
        return subCatProduct;

        
    }
//#endregion 
    

//#region chooseSubcat get user input for subCat and return Category subcats
   //display subCategory from specific main category
    public Category chooseSubCat(int choice, Scanner scanner, Category[] subcats) {
        try {
            // Display subcategories
            displaySCategories(subcats);
    
            // Get user input
            System.out.printf("Choice (1-%d): ", subcats.length);
            int subChoice = scanner.nextInt();
            scanner.nextLine(); // Clear newline buffer
    
            // Validate choice
            if (subChoice >= 1 && subChoice <= subcats.length) {
                System.out.println("You chose: " + subcats[subChoice - 1].getName());
                Category subCat = subcats[subChoice - 1];
               
                return subCat; // Return valid choice
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and " + subcats.length);
                return chooseSubCat(choice, scanner, subcats); // Recursively ask again
            }
        } catch (InputMismatchException e) {
            System.out.println(" Must be a number!");
            scanner.next(); // Clear invalid input
            return chooseSubCat(choice, scanner, subcats); // Recursively ask again
        }
    }
    
//#endregion
   
//#region diplayProductByCat param: scanner -> display product by category
public void displayProductByCat(Scanner scanner){
         displayCategories();
          try{ 
            System.out.print("Choose category: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice > 0 && choice <= categories.length){
              Product[] subCatProduct = getSubCatProduct(choice-1, scanner);

              disProductData(subCatProduct);
        
              Product selectedProduct = chooseProduct(subCatProduct , scanner);
              System.out.println("You want to edit--->" + selectedProduct.getName());
              displayProductDetails(selectedProduct);
          
            } else{System.out.println("Not a choice"); displayProductByCat(scanner);};
    
        }catch(InputMismatchException e){ 
          System.out.println(" Invalid input! Please enter a number.");
          scanner.next();
          displayProductByCat(scanner);
        }
       
    
      }
//#endregion
 
//#region chooseProduct param: Product[] products, Scanner scanner -> accept user input for choosing product return product object
public Product chooseProduct(Product[] products, Scanner scanner){

     System.out.print("Choose Product: ");
     int choice = scanner.nextInt();
    try {
        if(choice > 0 && choice <= products.length){

            Product selectedProduct = products[choice-1];
    
            return (selectedProduct instanceof Shoes) ? (Shoes)selectedProduct : selectedProduct;
         }
        
    } catch (InputMismatchException e) {
        System.out.println("Not a choice"); 
        return chooseProduct(products, scanner);
    }
     
     System.out.println("You can only Choose 1-" + products.length);
     return chooseProduct(products, scanner);
 }
//#endregion
 
//Globally use* 
//#region filter params: Scanner scanner -> accept user input for choosing how the product display
//display filtered product
 //All
 //Cateogory
 public void filter(Scanner scanner){
    try {
        System.out.println( "\n====================");
        System.out.println("1. Display all product");
        System.out.println("2. Display by category");
        System.out.println( "========================");
        System.out.print("Choice(1-2): ");
        int choice = scanner.nextInt();
        switch(choice){
          case 1 ->{ displayAllProduct(scanner);}
          case 2 ->{ displayProductByCat(scanner);}
          default ->{
                      System.out.println("Invalid Choice only can choose 1-2");
                       filter(scanner);
                    }
        }
        
    } catch (InputMismatchException e) {
        System.out.println(" Invalid input! Please enter a number.");
        scanner.next();
        filter(scanner);
    }
   
  
  }
//#endregion


 public Category[] getCategories() {
     return categories;
 }

 public Product[] getProducts() {
        return products;
 }

    
    
}

