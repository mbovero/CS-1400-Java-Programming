import java.util.Scanner;

public class TextAnalyzer {
   // Method counts the number of characters
   public static int getNumOfCharacters(final String usrStr) {
     char tmpCh;
     int chCount = 0;
     for (int i=0; i<usrStr.length(); i++) {
       tmpCh = usrStr.charAt(i);
       if (Character.isLetter(tmpCh)) {
         chCount ++;
       }  //end if
     }  //end for
      return chCount;
   }  //end getNumOfCharacters


   public static String outputWithoutWhitespace(final String usrStr) {
     char tmpCh;
     String noWhitespaceOutput = "";
     for (int i=0; i<usrStr.length(); i++) {
       tmpCh = usrStr.charAt(i);
       if (!Character.isWhitespace(tmpCh)) {
         noWhitespaceOutput += tmpCh;
       }  //end if
     }  //end for
      return noWhitespaceOutput;
   }  //end getNumOfCharacters



   public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);

     System.out.println("Enter a sentence or phrase:");
     String usrStr = scnr.nextLine();
     System.out.println("\nYou entered: " + usrStr);
     System.out.println("\nNumber of characters: " + getNumOfCharacters(usrStr));
     System.out.println("String with no whitespace: " + outputWithoutWhitespace(usrStr));
   }
}
