import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Yahtzee {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      Random randGen = new Random();
      int hold = 0;//number of dice not being rerolled
      int rounds = 2;//number of rerolls allowed
      int[] kinds = new int[6];


      //generate the initial dice roll - save it in an int[5]
      int[] dice = new int[5];
      for (int i=0; i<5; i++) {
        dice[i] = randGen.nextInt(6) + 1;
      }

      System.out.println("The dice fall:");
      System.out.println(printDice(dice));

      //determine which dice to hold holding(scnr)
      hold = holding(scnr);
      System.out.println("You chose to reroll "+(5-hold)+" dice.");
      while(hold<5&&rounds>0){
        rounds--;
			//ask and reroll some of the dice rerollDice(dice, scnr, randGen, hold)
      dice = rerollDice(dice, scnr, randGen, hold);

      if(rounds>0){//only ask if there are rerolls left
         System.out.println("The dice fall:");
		   //printDice(dice)
         System.out.println(printDice(dice));
   		//determine which dice to hold holding(scnr)
         hold = holding(scnr);
         System.out.println();//newline
         }
      }//end re-roll loop

      //final dice display
      System.out.println("The final dice are:");
      //print(printDice(dice))
      System.out.println(printDice(dice));


      //Display score
      System.out.println("Score:");
      //print(printScore(dice))
      System.out.println(printScore(dice));
      scnr.close();

   }//end main method

   public static int holding(Scanner scnr) {
     int hold;
     do {
       System.out.println("How many dice would you like to keep?");
       hold = scnr.nextInt();
     } while (hold < 0 || hold > 5);
     return hold;
   }
  /*This method asks how many of the 5 dice the palyer would like to keep (ie, not reroll)
  After getting the input, check to see if it was a valid number of dice and ask the player again if they did not put in a valid number of dice.
  Return the number of dice the player is holding.
  */

  public static int[] rerollDice(int[] dice, Scanner scnr, Random randGen, int hold) {
    int notHold = 5 - hold;
    int chosenDie;
    for (int i=0; i<notHold; i++) {
      do {
        System.out.println("Which die would you like to reroll?");
        chosenDie = scnr.nextInt();
      } while (chosenDie < 1 || chosenDie > 5);
      dice[chosenDie-1] = randGen.nextInt(6) + 1;
    }
    return dice;
  }
  /*for the number of dice the player is not holding ask which die they would like to reroll
  and validate that is is a usable die number (1-5, dice there are 5 dice).
  generate a new random number for the selected die. Return the new dice array.*/


  public static String printDice(int[] dice) {
   /*This method creates a string representation of the dice array seperated by " "
   ie. rep = "1 2 3...", full credit will be given with or without a trailing " "
   */
   String pDice = "";
   for (int i=0; i<5; i++) {
     pDice += dice[i] + " ";
   }
   return pDice;
  }


  public static int[] kinds(int[] dice) {
    int[] kinds = new int[6];
    for(int i=0; i<5; i++){
      switch(dice[i]) {
        case 1:
        kinds[0]++;
        break;
        case 2:
        kinds[1]++;
        break;
        case 3:
        kinds[2]++;
        break;
        case 4:
        kinds[3]++;
        break;
        case 5:
        kinds[4]++;
        break;
        case 6:
        kinds[5]++;
        break;
      } //end switch
    }
    return kinds;
  }
   /*this method counts the number of unique values and stores them in an int array
   ie. dice of {1, 3, 3, 4, 6} yields [1,0,2,1,0,1] which is read as (one 1, zero 2s, two 3s, one 4, zero 5s, one 6)
   */

   public static String printScore(int[] dice) {
     int[] kinds = kinds(dice);
     String scoreStr = "You did not score anything noteworthy.";

     //Full House & Three of a Kind
    boolean twoKind = false;
    boolean threeKind = false;
    for (int i=0; i<6; i++) {
      if (kinds[i] == 2) {twoKind = true;}
      else if (kinds[i] == 3) {threeKind = true;}
    }
    if (threeKind == true) {scoreStr = "Three of a Kind";}
    if (twoKind == true && threeKind == true) {scoreStr = "Full House";}
     //Four of a kind
    for (int i=0; i<6; i++) {
      if (kinds[i] == 4) {scoreStr = "Four of a Kind";}
    }
     //Small Straight
    for (int i=0; i<3; i++) {
      if (kinds[i] >= 1 && kinds[i+1] >= 1 && kinds[i+2] >= 1 && kinds[i+3] >= 1) {
        scoreStr = "Small Straight";
      }
    }
     //Large Straight
    int lStraightNum = 0;
    for (int i=0; i<6; i++) {
      if (kinds[i] == 1) {lStraightNum++;}
      else if (i != 5 && kinds[i] != 1){lStraightNum = 0;}
    }
    if (lStraightNum == 5) {scoreStr = "Large Straight";}
     // Yahtzee
    for (int i=0; i<6; i++) {
      if (kinds[i] == 5) {scoreStr = "Yahtzee";}
    }

     System.out.println(Arrays.toString(kinds));
     return scoreStr;
   }
   /*this methiod returns a string representation of the different winning values. The test for this method is worth 7 points.
   possible return values
	      rep = "Yahtzee"; all dice the same value
	      rep = "Large Straight"; all dice in sequential order
	      rep = "Small Straight"; 4 dice in sequential order
	      rep = "Four of a Kind"; 4 dice with the same value
	      rep = "Full House"; 3 dice with the same value and another 2 dice with the same value
	      rep = "Three of a Kind"; 3 dice with the same value
	      rep = "You did not score anything noteworthy."; anything else
   */

}//end class Main
