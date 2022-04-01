import java.util.Scanner;

public class DrawHalfArrow {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int arrowBaseHeight;
      int arrowBaseWidth;
      int arrowHeadWidth;
      String arrowBaseRow = "";
      String arrowHeadRow = "";

      System.out.println("Enter arrow base height:");
      arrowBaseHeight = scnr.nextInt();

      System.out.println("Enter arrow base width:");
      arrowBaseWidth = scnr.nextInt();
      do{
        System.out.println("Enter arrow head width:");
        arrowHeadWidth = scnr.nextInt();
      } while(arrowHeadWidth<arrowBaseWidth+1);
      System.out.println("");


      for (int i=0;i<arrowBaseWidth;i++){
        arrowBaseRow += "*";
      }
      for (int i=0;i<arrowBaseHeight;i++){
        System.out.println(arrowBaseRow);
      }

      for (int i=0;i<arrowHeadWidth;i++){
        arrowHeadRow += "*";
      }
      for (int i=arrowHeadWidth;i>0;i--){
        System.out.println(arrowHeadRow.substring(0,i));
      }



      /*
      // Draw arrow base (height = 3, width = 2)
      System.out.println("**");
      System.out.println("**");
      System.out.println("**");

      // Draw arrow head (width = 4)
      System.out.println("****");
      System.out.println("***");
      System.out.println("**");
      System.out.println("*");
      */
   }
}
