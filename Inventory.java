import java.util.Scanner;

public class Inventory {
    Category[] categories;
    Shoes[] products;

    //------------------Main Categories-------------------------------//
    Category menWear = new Category("Men Wear", null);
    Category womenWear = new Category("Women Wear", null);

    //------------------Sub Categories-------------------------------//
    Category menSportShoes = new Category("Men Sport Shoes", menWear);
    Category womenSportShoes = new Category("Women Sport Shoes", womenWear);

    public Inventory() {
        categories = new Category[]{
            menWear,
            womenWear,
            menSportShoes,
            womenSportShoes
        };

        products = new Shoes[]{
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
        for (Category category : categories) {
            if (category.getPCategory() == null) {
                System.out.println("\n");
                System.out.printf(" ID         : %s%n", category.getId());
                System.out.printf(" Name       : %s%n", category.getName());
            }
        }
    }

    public void displaySubCategories() {
        System.out.println("\n===================================");
        System.out.println("  SubCategory details");
        System.out.println("===================================");
        for (Category category : categories) {
            if (category.getPCategory() != null) {
                System.out.println("\n");
                System.out.printf(" Parent     :%s%n", category.getPCategory().getName());
                System.out.printf(" ID         : %s%n", category.getId());
                System.out.printf(" Name       : %s%n", category.getName());
            }
        }
    }

    public void displayProducts() {
        System.out.println("\n===================================");
        System.out.println("  SHOES COLLECTION");
        System.out.println("===================================");
        for (Shoes shoe : products) {
            shoe.displayProduct();
        }
    }

    public void disProductList() {
        int i = 1;
        System.out.println("------------------------------------------------------");
        System.out.printf("%-4s%-25s\t%-15s\n", "No.", "Name", "Price(RM)");
        System.out.println("------------------------------------------------------");
        for (Shoes shoe : products) {
            System.out.printf("%-4d%-25s\t%-18.2f\n", i, shoe.getName(), shoe.getPrice());
            i++;
        }
        System.out.println("------------------------------------------------------");
    }

    public void displayProductDetails(Scanner scanner) {
        disProductList();

        System.out.print("Choose an index (1 - " + products.length + "): ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= products.length) {
            Shoes shoe = products[index - 1];
            shoe.displayProduct();
        } else {
            System.out.println("Invalid index! Please choose a valid product index.");
        }
    }
}
