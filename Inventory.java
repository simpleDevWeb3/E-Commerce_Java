import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory {
    private static Category[] categories;
    private static Product[] products;

    //#region Data
    // Main Categories for Shoes
    Category casualWear = new Category("Casual Wear", null);
    Category formalWear = new Category("Formal Wear", null);
    Category sportsOutdoor = new Category("Sports & Outdoor", null);
    Category seasonalShoes = new Category("Seasonal & Special Occasion", null);
    Category workSafety = new Category("Work & Safety Shoes", null);
    Category fashionLuxury = new Category("Fashion & Luxury", null);

    // Subcategories under each main category
    Category sneakers = new Category("Sneakers", casualWear);
    Category loafers = new Category("Loafers", casualWear);
    Category slipOns = new Category("Slip-Ons", casualWear);
    
    Category oxfords = new Category("Oxfords", formalWear);
    Category derbyShoes = new Category("Derby Shoes", formalWear);
    Category dressBoots = new Category("Dress Boots", formalWear);
    
    Category runningShoes = new Category("Running Shoes", sportsOutdoor);
    Category hikingBoots = new Category("Hiking Boots", sportsOutdoor);
    Category cleats = new Category("Cleats", sportsOutdoor);
    
    Category sandals = new Category("Sandals", seasonalShoes);
    Category winterBoots = new Category("Winter Boots", seasonalShoes);
    
    Category steelToeBoots = new Category("Steel-Toe Boots", workSafety);
    Category nonSlipShoes = new Category("Non-Slip Shoes", workSafety);
    
    Category designerShoes = new Category("Designer Shoes", fashionLuxury);
    Category highEndBoots = new Category("High-End Boots", fashionLuxury);

    //#endregion Data

    //#region Constructor
    public Inventory() {
        // Main Categories
        categories = new Category[]{
            casualWear, formalWear, sportsOutdoor, seasonalShoes, workSafety, fashionLuxury
        };

        // Adding Subcategories
        casualWear.addSubcategory(sneakers);
        casualWear.addSubcategory(loafers);
        casualWear.addSubcategory(slipOns);
        
        formalWear.addSubcategory(oxfords);
        formalWear.addSubcategory(derbyShoes);
        formalWear.addSubcategory(dressBoots);
        
        sportsOutdoor.addSubcategory(runningShoes);
        sportsOutdoor.addSubcategory(hikingBoots);
        sportsOutdoor.addSubcategory(cleats);
        
        seasonalShoes.addSubcategory(sandals);
        seasonalShoes.addSubcategory(winterBoots);
        
        workSafety.addSubcategory(steelToeBoots);
        workSafety.addSubcategory(nonSlipShoes);
        
        fashionLuxury.addSubcategory(designerShoes);
        fashionLuxury.addSubcategory(highEndBoots);

        // Adding Products (1 per Subcategory) with sizes in CM
        products = new Product[]{
            new Shoes("Nike Air Force 1", 120.00, sneakers, "Nike",
                new String[]{"White", "Black"},
                new double[][]{{24.0, 25.0, 26.0}, {25.5, 26.5, 27.5}},
                new int[][]{{5, 3, 7}, {4, 6, 8}}, "Leather"),
            
            new Shoes("Clarks Leather Loafers", 150.00, loafers, "Clarks",
                new String[]{"Brown", "Black"},
                new double[][]{{25.0, 26.0, 27.0}, {24.5, 25.5, 26.5}},
                new int[][]{{6, 5, 4}, {3, 7, 6}}, "Genuine Leather"),
            
            new Shoes("Vans Classic Slip-On", 90.00, slipOns, "Vans",
                new String[]{"White", "Grey"},
                new double[][]{{23.0, 24.0, 25.0}, {24.5, 25.5, 26.5}},
                new int[][]{{10, 12, 9}, {7, 8, 6}}, "Canvas"),
            
            new Shoes("Allen Edmonds Park Avenue", 300.00, oxfords, "Allen Edmonds",
                new String[]{"Black"},
                new double[][]{{25.0, 26.0, 27.0}},
                new int[][]{{4, 6, 3}}, "Premium Leather"),
            
            new Shoes("Dr. Martens Derby", 200.00, derbyShoes, "Dr. Martens",
                new String[]{"Brown"},
                new double[][]{{26.0, 27.0, 28.0}},
                new int[][]{{5, 8, 4}}, "Full-Grain Leather"),
            
            new Shoes("Timberland Dress Boots", 250.00, dressBoots, "Timberland",
                new String[]{"Black"},
                new double[][]{{26.0, 27.0, 28.0}},
                new int[][]{{6, 7, 4}}, "Leather"),
            
            new Shoes("Nike Zoom Pegasus", 180.00, runningShoes, "Nike",
                new String[]{"Blue", "Red"},
                new double[][]{{24.0, 25.0, 26.0}, {25.5, 26.5, 27.5}},
                new int[][]{{8, 5, 4}, {3, 6, 7}}, "Mesh"),
            
            new Shoes("Salomon Quest 4D", 250.00, hikingBoots, "Salomon",
                new String[]{"Green", "Black"},
                new double[][]{{26.0, 27.0, 28.0}, {28.5, 29.0, 30.0}},
                new int[][]{{7, 6, 4}, {5, 3, 2}}, "Waterproof Synthetic"),
            
            new Shoes("Adidas Predator Cleats", 220.00, cleats, "Adidas",
                new String[]{"White", "Black"},
                new double[][]{{25.0, 26.0, 27.0}, {27.5, 28.0, 29.0}},
                new int[][]{{5, 8, 7}, {6, 4, 3}}, "Synthetic Leather"),
            
            new Shoes("Birkenstock Arizona", 80.00, sandals, "Birkenstock",
                new String[]{"Brown", "Black"},
                new double[][]{{24.0, 25.0, 26.0}, {27.0, 28.0, 29.0}},
                new int[][]{{7, 6, 5}, {8, 9, 4}}, "Leather & Cork"),
            
            new Shoes("UGG Classic Winter Boots", 190.00, winterBoots, "UGG",
                new String[]{"Beige"},
                new double[][]{{26.0, 27.0, 28.0}},
                new int[][]{{10, 7, 6}}, "Suede & Fur"),
            
            new Shoes("Caterpillar Steel-Toe Boots", 220.00, steelToeBoots, "Caterpillar",
                new String[]{"Brown"},
                new double[][]{{27.0, 28.0, 29.0}},
                new int[][]{{6, 4, 3}}, "Steel Toe"),
            
            new Shoes("Skechers Work Shoes", 130.00, nonSlipShoes, "Skechers",
                new String[]{"Black"},
                new double[][]{{25.0, 26.0, 27.0}},
                new int[][]{{8, 6, 5}}, "Slip Resistant"),
            
            new Shoes("Gucci Leather Sneakers", 400.00, designerShoes, "Gucci",
                new String[]{"White", "Black"},
                new double[][]{{24.5, 25.5, 26.5}, {27.0, 28.0, 29.0}},
                new int[][]{{4, 6, 5}, {5, 7, 3}}, "Italian Leather"),
            
            new Shoes("Louis Vuitton High-End Boots", 600.00, highEndBoots, "Louis Vuitton",
                new String[]{"Brown"},
                new double[][]{{26.0, 27.0, 28.0}},
                new int[][]{{3, 4, 2}}, "Luxury Leather")
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
           
            if(category.getPCategory() == null){
                System.out.printf("%-5d %s%n",i, category.getName());
                i++;
           
            }
               
              
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
    if(Product.getProductCount()>0){
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
    }else{
        System.out.println("Product not available");
    }
  

}
//#endregion disProductData
//#region disProductData overload params: Product []subCatProduct 

public void disProductData(Product [] subCatProduct){
    if(subCatProduct.length > 0){
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
    }else{
        System.out.println("Product not available");
    }
    

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
 public Product displayAllProduct(Scanner scanner) {
    if (Product.getProductCount() > 0) {
        disProductData(); // Ensure this displays all products
       
    } else {
        System.out.println("No products available. Returning to menu...");
        return null; // Fix: Ensure function always returns a Product or null
    }
    Product selectedProduct = chooseProduct( products, scanner);
    displayProductDetails(selectedProduct);
    return selectedProduct ;
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

//#region addProduct
public void addCategory(Category newCategory){
    //expand array          
    categories = Arrays.copyOf(categories,categories.length + 1 );
   
    //asign new subcat to last index
    categories[categories.length - 1] = newCategory;
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
public Product displayProductByCat(Scanner scanner) {
    displayCategories();
    
    try {
        System.out.print("Choose category: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= categories.length) {
            Product[] subCatProduct = getSubCatProduct(choice - 1, scanner);

            disProductData(subCatProduct); // Display products

            if (subCatProduct.length > 0) {  
                Product selectedProduct  =chooseProduct(subCatProduct, scanner);// Select one product
                displayProductDetails(selectedProduct);
                return  selectedProduct ;
            } else {
                System.out.println("No products found in this category.");
                return displayProductByCat(scanner);
            }
        } else {
            System.out.println("Not a valid choice!");
            return displayProductByCat(scanner);  // Recursive call
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a number.");
        scanner.next();
        return displayProductByCat(scanner);
    }
}

//#endregion
 
//#region chooseProduct param: Product[] products, Scanner scanner -> accept user input for choosing product return product object

public Product chooseProduct(Product[] products, Scanner scanner) {
    while (true) { // Keep looping until a valid choice is made
        System.out.print("Choose Product (1 - " + products.length + "): ");
        
        if (!scanner.hasNextInt()) { // Check if input is NOT an integer
            System.out.println("Invalid input! Please enter a number.");
            scanner.next(); // Clear invalid input
            continue; // Restart loop
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice > 0 && choice <= products.length) {
            Product selectedProduct = products[choice - 1];
            return (selectedProduct instanceof Shoes) ? (Shoes) selectedProduct : selectedProduct;
        } else {
            System.out.println("Invalid choice! You can only choose between 1 - " + products.length);
        }
    }
}

//#endregion
 
//Globally use* 
//#region filter params: Scanner scanner -> accept user input for choosing how the product display
//display filtered product
 //All
 //Cateogory
 public Product filter(Scanner scanner) {
    try {
        System.out.println("\n====================");
        System.out.println("1. Display all products");
        System.out.println("2. Display by category");
        System.out.println("========================");
        System.out.print("Choice (1-2): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
            
                return displayAllProduct(scanner); // Select one product
            }
            case 2 -> {
                return displayProductByCat(scanner); // Select one product by category
            }
            default -> {
                System.out.println("Invalid Choice! Choose 1-2.");
                return filter(scanner);
            }
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter a number.");
        scanner.next();
        return filter(scanner);
    }
}
//#endregion


 public static Category[] getCategories() {
     return categories;
 }

 public static Product[] getProducts() {
        return products;
 }

 public void deleteProduct(String productId,Scanner scanner,Product s) {
    int productCount = Product.getProductCount();
    int newIndex = 0;
    Shoes selectedProduct = (Shoes)s;
    boolean isValid;
    do {
            try {
                System.out.println("------------------------------------------------------");
                System.out.printf("%-25s%-15s%-4s\n", "Name", "Price(RM)","Stock");
                System.out.println("------------------------------------------------------");
                
                        System.out.printf("%-25s%-15.2f%d\n",
                 
                                selectedProduct.getName(),
                                selectedProduct.getPrice(),
                                selectedProduct.getTotalStock() // Using Shoes method
                        );
               System.out.println("------------------------------------------------------");  
                System.out.print("\nAre you sure to delete this product?(y/n): ");
                char confirm = scanner.next().toLowerCase().charAt(0);
            
                if (confirm == 'n') {
                    System.out.println("Deletion canceled.");
                    return;
                }else if(confirm == 'y'){
                    isValid = true;
                }else{
                    System.out.println("Input invalid, it must be character (y/n)");
                    isValid = false;
                }

            } catch (Exception e) {
                System.out.println("Input invalid, it must be character (y/n)");
                scanner.nextLine();
                isValid = false;
            }
        
    } while (!isValid);
   

    // Create a new array with the correct size
    Product[] newProducts = new Product[productCount - 1];

    for (int i = 0; i < productCount; i++) {
        if (products[i].getId().equals(productId)) {
            //Skip the product
            continue;
        }
        // Ensure we don't go out of bounds
        if (newIndex < newProducts.length) {
            newProducts[newIndex++] = products[i];
        }
    }


        products = newProducts;
        Product.decreaseProductCount(); // Ensure count is updated
        System.out.println("Product deleted successfully.");
        disProductData();

}

public Category selectCategory(Scanner scanner){
    boolean isValid =  true;
    do { 
        try {
              
            displayCategories();
            System.out.printf("Choose main category (1-%d)" , categories.length);
            int choice = scanner.nextInt();
            
            if(choice >= 0 && choice <= categories.length){
                Category selectedCategory = categories[choice-1];
                return selectedCategory;
            }else{
                System.out.printf("Choose between 1-%d",categories.length);
                isValid = false;
            }
       
            
        } catch (InputMismatchException e) {
            System.out.println("Input invalid.Must be number");
            scanner.nextLine();
            isValid = false;
        }
    } while (!isValid);

 
   return  selectCategory(scanner);
}

//#region color and size
//#region print out available color and size
public void chooseSize_colorInterface(Scanner scanner , Shoes selectedProduct){
    boolean isValid;
    int maxColumns = 0;
    String[] productColor =  selectedProduct.getColor();
    int[][] productStock = selectedProduct.getStock();
    double[][]productSize = selectedProduct.getSize();
    
   int column = 0;   
   int row = 0;

   System.out.println("\nAvailble Colors & Sizes:");
    
   System.out.printf("%-7s %-15s", "No.", "Color");
  
      //find max column
      for (double[] sizeRow : productSize) {
        if (sizeRow.length > maxColumns) {
            maxColumns = sizeRow.length;
        }
    }
    //display column
    for(int i = 0;  i < maxColumns ; i++ ){
      System.out.printf("c%-7d  " , i+1);
    }

  System.out.println("\n-------------------------------------------------");
  
    for(int i = 0; i < productColor.length; i ++){
    
      System.out.printf("r%-7d%-12s ",i+1, productColor[i]);
    
      for(int j = 0 ; j < productSize[i].length; j++){
        System.out.printf("  %.1f(%d)  ",productSize[i][j], productStock[i][j]);
      }
      System.out.print("\n");
    }
    System.out.println("-------------------------------------------------");

   

}
//#endregion

//#region chooseColor return row
public int chooseColor(Scanner scanner , Shoes selectedProduct){
    String[] productColor =  selectedProduct.getColor();
    int row = 0; 
    boolean isValid;

    do { 
        try {
            System.out.printf("choose row(1-%d): ",productColor.length);
            row = scanner.nextInt()-1;
            isValid = (row>=0&&row<productColor.length);
            String feedback = isValid ? "" : "choose row beetween (1-" + productColor.length +")";
            System.out.println(feedback);
        } catch (InputMismatchException e) {
            System.out.println("Input invalid,Must be number!");
            scanner.nextLine();
            isValid = false;
        }
     
      } while (!isValid);

    return row;
} 
//#endregion

//#region chooseSize return the column
public int chooseSize (Scanner scanner , Shoes selectedProduct , int row){
    int column = 0; 
    boolean isValid;
    int maxColumns = 0;
    double[][]productSize = selectedProduct.getSize();

    //find max column
    for (double[] sizeRow : productSize) {
        if (sizeRow.length > maxColumns) {
            maxColumns = sizeRow.length;
        }
    }
   
    do { 
        try {
            System.out.printf("choose column(1-%d): ",maxColumns);
            column = scanner.nextInt()-1;     
             isValid = (column>=0&&column<maxColumns);  
             String feedback = isValid ? "" : "choose column beetween (1-" + maxColumns +")";
             System.out.println(feedback);
        } catch (InputMismatchException e) {
            System.out.println("Input invalid, must be number!");
            isValid = false;
            scanner.nextLine();
        }

                               
    } while (!isValid); 
    
    return column;

}
//#endregion

public void disSelectedColor(int row , int column ,Shoes selectedProduct){
    String[] productColor =  selectedProduct.getColor();
    int[][] productStock = selectedProduct.getStock();
    double[][]productSize = selectedProduct.getSize();


    System.out.printf("%-7s %-15s c%d", "No.", "Color" , column+1);
       int maxColumns = 0;
      //display column
      for(int i = 0;  i < maxColumns ; i++ ){
        System.out.printf("c%-7d  " , i+1);
      }

    System.out.println("\n-------------------------------------------------");
    
        System.out.printf("r%-7d%-12s ",row, productColor[row]);
      
  
         System.out.printf("  %.1f(%d)  ",productSize[row][column], productStock[row][column]);
       
        System.out.print("\n");
  
    System.out.println("-------------------------------------------------");
}

//#endregion 


public void disSelectedColor(int row , Shoes selectedProduct){
    String[] productColor =  selectedProduct.getColor();
    int[][] productStock = selectedProduct.getStock();
    double[][]productSize = selectedProduct.getSize();
    

    System.out.printf("%-7s %-15s %s", "No.", "Color" , "Size");

    System.out.println("\n-------------------------------------------------");
    
      System.out.printf("r%-7d%-12s ",row, productColor[row]);
      for(int j = 0 ; j < productSize[row].length ; j++){
        System.out.printf("  %.1f(%d)  ",productSize[row][j], productStock[row][j]);
      }
        
       
        System.out.print("\n");
  
    System.out.println("-------------------------------------------------");
}


public String selectMaterial(Scanner scanner){
    boolean isValid;
   
    do { 
        try {
        
            Shoes.displayMaterials();
            System.out.printf("Select material (1-%s): ",Shoes.AVAILABLE_MATERIALS.length);
            int choice = scanner.nextInt() - 1;

            if(choice >= 0 && choice < Shoes.AVAILABLE_MATERIALS.length){
                String selectedMaterials = Shoes.AVAILABLE_MATERIALS[choice];
                return selectedMaterials;
            }else{
                System.out.printf("Choose beetween 1-%s",Shoes.AVAILABLE_MATERIALS.length);
                isValid = false;
            }
         
          
        } catch (InputMismatchException e) {
            System.out.println("Input invalid.Must be number");
            scanner.nextLine();
            isValid = false;
        }
        
    } while (!isValid);

    return selectMaterial(scanner);
  }
    
    
}

