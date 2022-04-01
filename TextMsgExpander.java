import java.util.Scanner;

public class TextMsgExpander {
   public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);

     System.out.println("Enter text:");
     String input = scnr.nextLine();
     System.out.println("You entered: " + input + "\n");

     boolean bff = (input.indexOf("BFF") == -1) ? false : true;
     boolean idk = (input.indexOf("IDK") == -1) ? false : true;
     boolean jk = (input.indexOf("JK") == -1) ? false : true;
     boolean tmi = (input.indexOf("TMI") == -1) ? false : true;
     boolean ttyl = (input.indexOf("TTYL") == -1) ? false : true;

     if (bff == true) {System.out.println("Replaced \"BFF\" with \"best friend forever\".");}
     if (idk == true) {System.out.println("Replaced \"IDK\" with \"I don't know\".");}
     if (jk == true) {System.out.println("Replaced \"JK\" with \"just kidding\".");}
     if (tmi == true) {System.out.println("Replaced \"TMI\" with \"too much information\".");}
     if (ttyl == true) {System.out.println("Replaced \"TTYL\" with \"talk to you later\".");}

     input = input.replace("BFF","best friend forever");
     input = input.replace("IDK","I don't know");
     input = input.replace("JK","just kidding");
     input = input.replace("TMI","too much information");
     input = input.replace("TTYL","talk to you later");

     System.out.println("\nExpanded: " + input);
   }
}
