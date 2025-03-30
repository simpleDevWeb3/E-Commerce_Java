
public class Shoes extends Product {

  private String brand;
  private double [][] size;
  private int[][] stock;
  private String[]color;
  private String material;
  public static final String[] AVAILABLE_COLORS = {"Black", "White", "Red", "Blue", "Pink", "Grey"};
  public static final String[] AVAILABLE_MATERIALS = {"Leather", "Synthetic", "Mesh", "Canvas", "Rubber", "Knit Fabric"};
  public static final double[] AVAILABLE_SIZES_CM = {22.0, 22.5, 23.5, 24.0, 25.0, 25.5, 26.0, 27.0, 28.0, 28.5, 29.0};

  public Shoes(String name, double price, Category category, String brand, String[] color, double[][] size, int[][] stock, String material) {
    super(name, price, 0, category); // Parent constructor (Product)
    this.brand  = brand;
    this.color = color;
    this.size = size;
    this.stock = stock;
    this.material = material;
    
    
}


  public String getBrand(){
    return brand;
  }

  public int getTotalStock() {
    int totalStock = 0;
    for (int i = 0; i < stock.length; i++) {
        for (int j = 0; j < stock[i].length; j++) {
            totalStock += stock[i][j]; 
        }
    }
    return totalStock;
}

  public int[][]getStock(){
    return stock;
  }
  
  public double[][] getSize(){
    return size;
  }

  public String[] getColor(){
    return color;
  }

  public String getMaterial(){
    return material;
  }

 

public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setStock(int[][] stock) {
    this.stock = stock;
  }

  public void setSize(double[][] size) {
   
    this.size = size;
  }

  public void setColor(String[] color) {
    this.color = color;

  }

  public void setMaterial(String material) {
    this.material = material;
  }

  @Override  // it overide the method display Product it prompt different prouct details
  public void displayProduct() {
    System.out.println("--------------------------------------------------");
    System.out.println("Product ID   : " + getId());  
    System.out.println("Product Name : " + getName());
    System.out.println("Brand        : " + brand);
    System.out.println("Category     : " + getCategory().getName());
    System.out.println("Material     : " + material);
    System.out.println("Price        : RM" + getPrice());
    System.out.println("\nAvailable Colors & Sizes:");

    for (int i = 0; i < color.length; i++) {
        System.out.printf("%-5s: ", color[i]); // print row (color)

        for (int j = 0; j < size[i].length; j++) {                                                   
            System.out.printf("%scm(%d)\t",size[i][j] ,stock[i][j]);//print column[length of size][stock]
        }

        System.out.println();
    }
    System.out.println("--------------------------------------------------");
}

public static void displayColor(){

    System.out.println("-------------------");
    System.out.println(" Available Colors ");
    System.out.println("--------------------");

    int index = 1;
    for (String color : AVAILABLE_COLORS) {
        System.out.printf(" %d. %-10s %n", index++, color);
    }

    System.out.println("___________________");
}


public static void displaySize(){

  System.out.println("-------------------");
  System.out.println(" Available Sizes ");
  System.out.println("--------------------");

  int index = 1;
  for (double size : AVAILABLE_SIZES_CM) {
      System.out.printf(" %d. %scm %n", index++, size);
  }

  System.out.println("___________________");
}
public static void displayMaterials(){

  System.out.println("-------------------");
  System.out.println(" Available Materials ");
  System.out.println("--------------------");

  int index = 1;
  for (String material  : AVAILABLE_MATERIALS) {
      System.out.printf(" %d. %-10s %n", index++, material);
  }

  System.out.println("___________________");
}

  

}
