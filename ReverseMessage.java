import java.util.Scanner;
public class ReverseMessage {
    public static void main(String[] args){
      Scanner scnr = new Scanner(System.in);
      String message = scnr.nextLine();
      System.out.println(reverse(message));
    }

    public static String reverse(String message){
      String reverseMessage = "";
      char ch;
      for (int i=0; i<message.length(); i++) {
        ch = message.charAt(i);
        reverseMessage = ch + reverseMessage;
      }
      return reverseMessage;
    }
}
