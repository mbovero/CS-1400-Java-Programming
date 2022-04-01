import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
   public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);
     String title;
     String headerOne;
     String headerTwo;
     String inputString = "";
     String[] splitString;
     int commaIndex;
     int stringLength;
     boolean postCommaInt = false;
     ArrayList<String> strArrayList = new ArrayList<String>();
     ArrayList<Integer> intArrayList = new ArrayList<Integer>();


     System.out.println("Enter a title for the data:");
     title = scnr.nextLine();
     System.out.println("You entered: " + title + "\n");

     System.out.println("Enter the column 1 header:");
     headerOne = scnr.nextLine();
     System.out.println("You entered: " + headerOne + "\n");

     System.out.println("Enter the column 2 header:");
     headerTwo = scnr.nextLine();
     System.out.println("You entered: " + headerTwo + "\n");

     //input data points
     do {
       try {
         //prompt user
         System.out.println("Enter a data point (-1 to stop input):");
         inputString = scnr.nextLine();


         //error checking, no comma in String
         if ((inputString.indexOf(",") == -1) && !inputString.equals("-1")) {
           throw new Exception("Error: No comma in string.\n");
         }
         //error checking, too many commas in string
         commaIndex = inputString.indexOf(",");
         if ((inputString.indexOf(",") != -1) && !inputString.equals("-1")) {
           if (inputString.indexOf(",",commaIndex+1) != -1) {
             throw new Exception("Error: Too many commas in input.\n");
           }
         }
         //error checking, entry after comma not an integer
         stringLength = inputString.length();
         if ((inputString.indexOf(",") != -1) && !inputString.equals("-1")) {
           for (int i=0; i<(stringLength-commaIndex); i++) {
             if (Character.isDigit(inputString.charAt(i+commaIndex))) {
               postCommaInt = true;
             }
           }
           if (!postCommaInt) {
             throw new Exception("Error: Comma not followed by an integer.\n");
           }
         }

         //split input, display, and store
         if (!inputString.equals("-1")) {
           splitString = inputString.split(",");
           System.out.println("Data string: " + splitString[0]);
           System.out.println("Data integer: " + splitString[1].trim() + "\n");
           strArrayList.add(splitString[0]);
           intArrayList.add(Integer.parseInt(splitString[1].trim()));
         }
       } catch (Exception except){
          System.out.println(except.getMessage());
        } finally {
          postCommaInt = false; //problems arise if not reset
        }
     } while (!inputString.equals("-1"));

     //Print table
     System.out.println();
     System.out.printf("%33s%n", title);
     System.out.printf("%-20s%s%23s%n", headerOne, "|", headerTwo);
     System.out.printf("%s%n", "--------------------------------------------");
     for (int i=0; i<strArrayList.size(); i++) {
       System.out.printf("%-20s%s%23s%n", strArrayList.get(i), "|", intArrayList.get(i));
     }

     //Print graph
     System.out.println();
     for (int i=0; i<strArrayList.size(); i++) {
       System.out.printf("%20s", strArrayList.get(i));
       System.out.print(" ");
       for (int j=0; j<intArrayList.get(i); j++) {
         System.out.print("*");
       }
       System.out.println();
     }


      return;
   }
}
