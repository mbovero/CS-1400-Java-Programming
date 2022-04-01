import java.util.Scanner;

public class PlayerRoster {
	public static int[][] players;//so I can check your 2D array
	public static void main(String[] args) {
		final int NUM_PLAYERS = 5;
        players = new int[NUM_PLAYERS][2];
				Scanner scnr = new Scanner(System.in);
				char menuOption;
				int findJersey;
				int updateRating;
				int aboveRating;
				int replaceJersey;
				int replaceRating;

				// prompt to enter initial jersey/rating numbers
				System.out.println("Enter player 1's jersey number:");
				players[0][0] = scnr.nextInt();
				System.out.println("Enter player 1's rating:");
				players[0][1] = scnr.nextInt();

				System.out.println("\nEnter player 2's jersey number:");
				players[1][0] = scnr.nextInt();
				System.out.println("Enter player 2's rating:");
				players[1][1] = scnr.nextInt();

				System.out.println("\nEnter player 3's jersey number:");
				players[2][0] = scnr.nextInt();
				System.out.println("Enter player 3's rating:");
				players[2][1] = scnr.nextInt();

				System.out.println("\nEnter player 4's jersey number:");
				players[3][0] = scnr.nextInt();
				System.out.println("Enter player 4's rating:");
				players[3][1] = scnr.nextInt();

				System.out.println("\nEnter player 5's jersey number:");
				players[4][0] = scnr.nextInt();
				System.out.println("Enter player 5's rating:");
				players[4][1] = scnr.nextInt();

				//Print Roster
				System.out.println("\nROSTER");
				for (int i=0; i<5; i++){
					System.out.println("Player " + (i +1) + " -- Jersey number: " + players[i][0] + ", Rating: " + players[i][1]);
				}

				do{
				//Print Menu
				System.out.println("\nMENU");
				System.out.println("u - Update player rating");
				System.out.println("a - Output players above a rating");
				System.out.println("r - Replace player");
				System.out.println("o - Output roster");
				System.out.println("q - Quit");
				//Prompt choose option
				System.out.println("\nChoose an option:");
				menuOption = scnr.next().charAt(0);

				//Output roster
				if (menuOption == 'o') {
					System.out.println("ROSTER");
					for (int i=0; i<5; i++){
						System.out.println("Player " + (i +1) + " -- Jersey number: " + players[i][0] + ", Rating: " + players[i][1]);
					}
				}

				//Update player rating
				if (menuOption == 'u') {
					System.out.println("Enter a jersey number:");
					findJersey = scnr.nextInt();
					System.out.println("Enter a new rating for player:");
					updateRating = scnr.nextInt();
					for (int i=0; i<5; i++){
						if (players[i][0] == findJersey)		{players[i][1] = updateRating;}
					}
				}

				//Output players above a Rating
				if (menuOption == 'a') {
					System.out.println("Enter a rating:");
					aboveRating = scnr.nextInt();
					System.out.println("\nABOVE " + aboveRating);
					for (int i=0; i<5; i++){
						if (players[i][1] > aboveRating)		{System.out.println("Player " + (i +1) + " -- Jersey number: " + players[i][0] + ", Rating: " + players[i][1]);}
					}
				}

				//Replace player
				if (menuOption == 'r') {
					System.out.println("Enter a jersey number:");
					findJersey = scnr.nextInt();
					for (int i=0; i<5; i++){
						if (players[i][0] == findJersey){
							System.out.println("Enter a new jersey number:");
							replaceJersey = scnr.nextInt();
							System.out.println("Enter a rating for the new player:");
							replaceRating = scnr.nextInt();
							players[i][0] = replaceJersey;
							players[i][1] = replaceRating;
						}
					}
				}



			} while(menuOption != 'q');
	}
}
