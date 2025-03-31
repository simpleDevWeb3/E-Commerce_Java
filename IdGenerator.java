public class IdGenerator{
private static int prodCount = 1;
  private static int catCount = 1;

  public static String generateProductId(String prefix) {
   String id = "Prod_" + prefix.replace(" ", "") + prodCount;
    prodCount++;
    return  id;
}

public static String generateCategoryId(String prefix) {
   String id = prefix.replace(" ", "") + "_" + (catCount);
   catCount++;
   return  id;
}


}