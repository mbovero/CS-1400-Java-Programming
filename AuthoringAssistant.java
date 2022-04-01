import java.util.Scanner;

public class AuthoringAssistant {


  public static char printMenu(Scanner scnr) {
    String possible = "cwfrsq";
    char option;
    System.out.println("\nMENU\nc - Number of non-whitespace characters\nw - Number of words\nf - Find text\nr - Replace all !'s\ns - Shorten spaces\nq - Quit\n");
    do{
      System.out.println("Choose an option:");
      option = scnr.next().charAt(0);
    } while (possible.indexOf(option) == -1);
    return option;
  } //end printMenu


  public static int getNumOfNonWSCharacters(final String usrStr) {
    char tmpCh;
    int noWSChCount = 0;
    for (int i=0; i<usrStr.length(); i++) {
      tmpCh = usrStr.charAt(i);
      if (!Character.isWhitespace(tmpCh)) {
        noWSChCount ++;
      }  //end if
    }  //end for
     return noWSChCount;
  }  //end getNumOfCharacters


  public static int getNumOfWords(final String usrStr) {
    char tmpCh;
    int wordCount = 0;
    String punctuation = ".!?();,";
    String tmpString = usrStr;
    // fix error for space at beginning of phrase
    if(Character.isWhitespace(usrStr.charAt(0))) {
      tmpString = tmpString.substring(1, tmpString.length());
    }
    for (int i=0; i<tmpString.length(); i++) {
      tmpCh = tmpString.charAt(i);
      if ((Character.isWhitespace(tmpCh) || (punctuation.indexOf(tmpCh) != -1)) && Character.isLetter(tmpString.charAt(i-1))) {
        wordCount ++;
      } //end if
    } //end for
    //count end word if no punctuation
    if (Character.isLetter(tmpString.charAt(tmpString.length()-1))) {
      wordCount ++;
    } //end if
    return wordCount;
  } //end getNumOfWords


  public static int findText(final String findString, final String usrStr) {
    int findCount = 0;
    if (usrStr.indexOf(findString) != -1) {
      for (int i=0; i<(usrStr.length()-findString.length()+1); i++){
        if (usrStr.substring(i,i+findString.length()).equals(findString)) {
          findCount ++;
        } //end if
      } //end for
    } //end if
    return findCount;
  } //end findText


  public static String replaceExclamation(final String usrStr) {
    String noExclamationString = usrStr.replace('!', '.');
    return noExclamationString;
  } //end replaceExclamation


  public static String shortenSpace(final String usrStr) {
    String shortSpaceString = usrStr.replaceAll("\\s+", " ");
    if(Character.isWhitespace(usrStr.charAt(0))) {
      shortSpaceString = shortSpaceString.substring(1, shortSpaceString.length());
    }
    return shortSpaceString;
  } //end shortenSpace


   public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);
     char option;
     String findString;

     System.out.println("Enter a sample text:");
     String usrStr = scnr.nextLine();
     System.out.println("\nYou entered: " + usrStr);

     do {
       option = printMenu(scnr);
       switch (option) {
         case 'c':
         System.out.println("Number of non-whitespace characters: " + getNumOfNonWSCharacters(usrStr));
         break;
         case 'w':
         System.out.println("Number of words: " + getNumOfWords(usrStr));
         break;
         case 'f':
         System.out.println("Enter a word or phrase to be found:");
         scnr.nextLine();
         findString = scnr.nextLine();
         System.out.println("\"" + findString + "\" instances: " + findText(findString, usrStr));
         break;
         case 'r':
         System.out.println("Edited text: " + replaceExclamation(usrStr));
         usrStr = replaceExclamation(usrStr);
         break;
         case 's':
         System.out.println("Edited text: " + shortenSpace(usrStr));
         usrStr = shortenSpace(usrStr);
         break;
       }
     }  while(option != 'q');
   }
}
