public class IdGenerator{
  private static int prodCount = 1;
  private static int catCount = 1;

  public static String generateProductId(String prefix) {
    return "Prod_" + prefix.replace(" ", "") + (prodCount++);
}

public static String generateCategoryId(String prefix) {
    return prefix.replace(" ", "") + "_" + (catCount++);
}


}