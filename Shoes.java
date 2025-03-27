//unuse
public class Shoes extends Product {

  private String brand;
  private String[][] size;
  private int[][] stock;
  private String[]color;
  private String material;
 
  

  public Shoes(String name, double price, Category category, String brand, String[] color, String[][] size, int[][] stock, String material) {
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
  
  public String[][] getSize(){
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

  public void setSize(String[][] size) {
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
            System.out.printf("%s(%d)\t",size[i][j] ,stock[i][j]);//print column[length of size][stock]
        }

        System.out.println();
    }
    System.out.println("--------------------------------------------------");
}


  

}
