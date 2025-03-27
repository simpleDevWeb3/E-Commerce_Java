import java.util.Scanner;
import java.lang.runtime.SwitchBootstraps;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Inventory {
    Category[] categories;
    Product[] products;

    //------------------Main Categories-------------------------------//
    Category menWear = new Category("Men Wear", null);
    Category womenWear = new Category("Women Wear", null);

    //------------------Sub Categories-------------------------------//
    Category menSportShoes = new Category("Men Sport Shoes", menWear);
    Category menSandal = new Category("Men Sandal", menWear);
    Category womenSportShoes = new Category("Women Sport Shoes", womenWear);

    public Inventory() {
        categories = new Category[]{
            menWear,
            womenWear        
        };

        products = new Product[]{
            new Shoes(
                "Adidas Running Max", 350.00, menSportShoes, "Adidas",
                new String[]{"Black", "White"},
                new String[][]{
                    {"US 7", "US 8", "US 9"}, // Black sizes
                    {"US 6", "US 7"}          // White sizes
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
                new String[][]{
                    {"US 8", "US 9", "US 10"}, // Blue sizes
                    {"US 7", "US 8"},        // Red sizes
                    {"US 7", "US 8"}         // Pink sizes    
                },
                new int[][]{
                    {4, 6, 8}, // Stock for Blue
                    {5, 9},     // Stock for Red
                    {15, 9},     // Stock for Pink
                },
                "Synthetic Leather"
            ),
            new Shoes(
                "Puma Sports", 280.00, womenSportShoes, "Puma",
                new String[]{"Pink", "Grey"},
                new String[][]{
                    {"US 6", "US 7", "US 8"}, // Pink sizes
                    {"US 5", "US 6"}          // Grey sizes
                },
                new int[][]{
                    {8, 6, 3}, // Stock for Pink
                    {4, 5}     // Stock for Grey
                },
                "Knit Fabric"
            )
        };
    }

    public void displayCategories() {
        System.out.println("\n===================================");
        System.out.println("  CATEGORY DETAILS");
        System.out.println("===================================");
    
        int i = 1;
        for (Category category : categories) {
           
            if (category.getPCategory() == null) {
            
                System.out.printf("%-5d %s%n",i, category.getName());
                i++;
            }
              
        }
        System.out.println("===================================");
    }


    public void displayProducts() {
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
    }

    public void disProductList() {
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
    }

    public void displayProductDetails(Scanner scanner) {
        disProductList();
     try{
        System.out.print("Choose an index (1 - " + products.length + "): ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= products.length) {
          Product selectedProduct = products[index-1];

           if(selectedProduct instanceof Shoes){
           ((Shoes)selectedProduct).displayProduct();
          }
          else{
            selectedProduct.displayProduct();
          }
            
        } 
        else {
            System.out.println("Invalid index! Please choose a valid product index.");
        }
     }catch(InputMismatchException e){
        System.out.println(" Invalid input! Please enter a number.");
        scanner.next(); // Clear invalid input
        displayProductDetails(scanner);
     }
       
    }


    public void addProduct(Product newProduct){
     //expand array
     products = Arrays.copyOf(products,products.length + 1 );
     
     //asign new subcat to last index
     products[products.length - 1] = newProduct;
    }

    public Product[]getSubCatProduct(int choice, Scanner scanner) {
        // Retrieve subcategories
        Category[] subcats = categories[choice].getSCategories(); // Returns array
    
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
    
    public Category chooseSubCat(int choice, Scanner scanner, Category[] subcats) {
        try {
            // Display subcategories
            System.out.println("\nSubcategories for " + categories[choice].getName() + ":");
            System.out.println("===================================");
            for (int i = 0; i < subcats.length; i++) {
                System.out.printf("%-5d%s\n", (i + 1), subcats[i].getName());
            }
            System.out.println("===================================");
    
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
    
}
