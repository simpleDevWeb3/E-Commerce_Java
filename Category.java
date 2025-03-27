import java.util.Arrays;

public class Category {
  private String id;//id
  private String cName;// cat_name
  private Category pCategory;// refrence to main_cat
  private Category[] sCategories; // array store subcat
 
  public Category(){

  }

  public Category(String cName, Category pCategory){
      id = IdGenerator.generateCategoryId(cName);
      this.cName  = cName;
      this.pCategory = pCategory;
      sCategories = new Category[0];
  }

  public String getId(){ return id;}
  public String getName(){return cName;}
  public Category getPCategory(){return pCategory;}
  public Category[] getSCategories(){return sCategories;}

  public void addSubcategory(Category subcategory){
    //expand array
     sCategories = Arrays.copyOf(sCategories,sCategories.length + 1 );
     
     //asign new subcat to last index
     sCategories[sCategories.length - 1] = subcategory;
  }

  public void display() {
    System.out.println("\n===================================");
    System.out.println("  CATEGORY DETAILS");
    System.out.println("===================================");
    System.out.printf(" ID         : %s%n", id);
    System.out.printf(" Name       : %s%n", cName);


    if (sCategories.length > 0) {
        System.out.println("\n Subcategories:");
        for (Category sub : sCategories) {
            System.out.printf("   - %s (%s)%n", sub.getName(), sub.getId());
        }
    } else {
        System.out.println(" No Subcategories");
    }

    System.out.println("===================================\n");
}

 
}
