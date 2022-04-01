import java.util.Scanner;

public class BasicInput {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int userInt;
      double userDouble;
      char userChar;
      String userString;

      System.out.println("Enter integer:");
      userInt = scnr.nextInt();

      System.out.println("Enter double:");
      userDouble = scnr.nextDouble();

      System.out.println("Enter character:");
      userChar = scnr.next().charAt(0);

      System.out.println("Enter string:");
      userString = scnr.next();


      String all = "" + userInt + " " + userDouble + " " + userChar + " " + userString;
      System.out.println(all);

      String allReverse = "" + userString + " " + userChar + " " + userDouble + " " + userInt;
      System.out.println(allReverse);

      int castDouble = (int)userDouble;
      System.out.println("" + userDouble + " cast to an integer is " + castDouble);

      // FIXME (1): Finish reading other items into variables, then output the four values on a single line separated by a space

      // FIXME (2): Output the four values in reverse

      // FIXME (3): Cast the double to an integer, and output that integer
   }
}
