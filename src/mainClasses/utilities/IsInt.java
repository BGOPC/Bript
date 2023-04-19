package src.mainClasses.utilities;

public class IsInt {
    public static boolean isInt(String str) {
        try {
            @SuppressWarnings("unused")
          int x = Integer.parseInt(str);
            return true; //String is an Integer
      } catch (NumberFormatException e) {
          return false; //String is not an Integer
      }
  }
}
