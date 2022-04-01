import java.util.Scanner;

public class ParseStrings {
   public static void main(String[] args) {
     String inputString = "";
     String[] words;
     Scanner scnr = new Scanner(System.in);


     do {
       try {
         //prompt user
         System.out.println("Enter input string:");
         inputString = scnr.nextLine();

         //error checking, comma in String
         if ((inputString.indexOf(",") == -1) && !inputString.equals("q")) {
           throw new Exception("Error: No comma in string.\n");
         }
         if (!inputString.equals("q")) {
           words = inputString.split(",");
           System.out.println("First word: " + words[0].trim());
           System.out.println("Second word: " + words[1].trim() + "\n");
         }
       } catch (Exception except){
          System.out.println(except.getMessage());
        }
     } while (!inputString.equals("q"));

   }  //end main()
}
