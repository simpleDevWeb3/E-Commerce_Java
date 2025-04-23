import java.util.Arrays;

public class Category {
  private String id;//id
  private String cName;// cat_name
  private Category pCategory;// refrence to main_cat
  private Category[] sCategories; // array store subcat
  private int sCatProdCount = 0;
  private static int cCount = 0;
 
  public Category(){

  }

  public Category(String cName, Category pCategory){
    cCount ++;
  
      id = IdGenerator.generateCategoryId(cName);
      this.cName  = cName;
      this.pCategory = pCategory;
      sCategories = new Category[0];



   
  }

  public String getId(){ return id;}
  public String getName(){return cName;}
  public Category getPCategory(){return pCategory;}
  public Category[] getSCategories(){return sCategories;}
  public void setName(String newName){this.cName = newName;}
  public int getSCatProdCount(){
    sCatProdCount = 0; 
    for(Category sCategory : sCategories){
      for(Product product:Inventory.getProducts()){
        if(product.getCategory().getId().equals(sCategory.getId())){
          sCatProdCount+=1;
        }
      }
        
       
    }
    return sCatProdCount;
  }


  public void setSCategories(Category []sCategories){this.sCategories = sCategories;}

  public void addSubcategory(Category subcategory){
    //expand array
     sCategories = Arrays.copyOf(sCategories,sCategories.length + 1 );
     
     //asign new subcat to last index
     sCategories[sCategories.length - 1] = subcategory;
  }



 
}
