import java.util.Scanner;

public class TextMsgDecoder {
   public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);

     System.out.println("Enter text:");
     String input = scnr.nextLine();
     System.out.println("You entered: " + input);

     boolean bff = (input.indexOf("BFF") == -1) ? false : true;
     boolean idk = (input.indexOf("IDK") == -1) ? false : true;
     boolean jk = (input.indexOf("JK") == -1) ? false : true;
     boolean tmi = (input.indexOf("TMI") == -1) ? false : true;
     boolean ttyl = (input.indexOf("TTYL") == -1) ? false : true;

     if (bff == true) {System.out.println("BFF: best friend forever");}
     if (idk == true) {System.out.println("IDK: I don't know");}
     if (jk == true) {System.out.println("JK: just kidding");}
     if (tmi == true) {System.out.println("TMI: too much information");}
     if (ttyl == true) {System.out.println("TTYL: talk to you later");}
   }
}
