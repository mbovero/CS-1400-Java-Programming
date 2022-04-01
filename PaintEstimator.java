import java.util.Scanner;
import java.lang.Math;     // Note: Needed for math functions in part (3)

public class PaintEstimator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double wallHeight;
      double wallWidth;
      double wallArea;
      double wallPaint;
      int cansNeeded;

      System.out.println("Enter wall height (feet):");
      wallHeight = scnr.nextDouble();
      System.out.println("Enter wall width (feet):");
      wallWidth = scnr.nextDouble();

      // Calculate and output wall area
      wallArea = wallHeight * wallWidth;
      System.out.println("Wall area: " + wallArea + " square feet");

      wallPaint = wallArea / 350;
      System.out.println("Paint needed: " + wallPaint + " gallons");

      cansNeeded = (int)Math.ceil(wallPaint);
      System.out.println("Cans needed: " + cansNeeded + " can(s)");
   }
}
