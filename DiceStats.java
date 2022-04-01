import java.util.Scanner;
import java.util.Random;

public class DiceStats {
   public static void main(String[] args) {
	   //Leave this code or your tests won't work
	   Random randGen = (args.length>0) ? new Random(Integer.parseInt(args[0])) : new Random();
	   //Don't delete ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

      Scanner scnr = new Scanner(System.in);
      int numRolls;   // User defined number of rolls

      System.out.println("Enter number of rolls:");
      numRolls = scnr.nextInt();

      if (numRolls >= 1) {
        System.out.println(histogram(dice(numRolls,randGen)));
         }

      else {
         System.out.println("Invalid rolls. Try again.");
      }
   }

   public static int[] dice(int numRolls,Random randGen) {
     int die1;       // Dice values
     int die2;       // Dice values
     int rollTotal;  // Sum of dice values
     int[] totalNums = new int[11];  //Keep track of roll totals


     // Roll dice numRoll times
     for (int i = 0; i < numRolls; ++i) {
        die1 = randGen.nextInt(6) + 1;
        die2 = randGen.nextInt(6) + 1;
        rollTotal = die1 + die2;

        // Count number dice totals (2-12)
        if (rollTotal == 2) {
           totalNums[0] ++;
        }
        else if (rollTotal == 3) {
           totalNums[1] ++;
        }
        else if (rollTotal == 4) {
           totalNums[2] ++;
        }
        else if (rollTotal == 5) {
           totalNums[3] ++;
        }
        else if (rollTotal == 6) {
           totalNums[4] ++;
        }
        else if (rollTotal == 7) {
           totalNums[5] ++;
        }
        else if (rollTotal == 8) {
           totalNums[6] ++;
        }
        else if (rollTotal == 9) {
           totalNums[7] ++;
        }
        else if (rollTotal == 10) {
           totalNums[8] ++;
        }
        else if (rollTotal == 11) {
           totalNums[9] ++;
        }
        else if (rollTotal == 12) {
           totalNums[10] ++;
        }
    } //end for loop
    return totalNums;
  } //end dice


  public static String histogram (int[] totalNums) {
    String hgramString = "Dice roll histogram:\n\n";
    String hgramRow = "";
    for (int i = 0; i < totalNums.length; ++i){
      hgramRow = (i+2) + ":\t";
      for (int j = 0; j < totalNums[i]; ++j) {
        hgramRow += "*";
      }
      hgramRow += "(" + totalNums[i] + ")";
      hgramString += hgramRow + "\n";
    }
    return hgramString;
  } //end histogram
}
