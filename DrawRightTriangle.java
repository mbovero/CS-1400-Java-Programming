import java.util.Scanner;

public class DrawRightTriangle {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      char triangleChar;
      int triangleHeight;
      String triangleRow = "";

      System.out.println("Enter a character:");
      triangleChar = scnr.next().charAt(0);

      System.out.println("Enter triangle height:");
      triangleHeight = scnr.nextInt();
      System.out.println("");

      for (int i=0;i<triangleHeight;i++){
        triangleRow += triangleChar + " ";
        System.out.println(triangleRow);
      }
   }
}
