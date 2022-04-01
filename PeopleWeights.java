import java.util.Scanner;

public class PeopleWeights {
	public static double[] userWeights;//needed so that I can check that you are useing an array!
   public static void main(String[] args) {
	   final int NUM_WEIGHTS = 5;
	   userWeights = new double[NUM_WEIGHTS];
      Scanner scnr = new Scanner(System.in);
			double maxWeight = 0.0;

			System.out.println ("Enter weight 1:");
			userWeights[0] = scnr.nextDouble();
			System.out.println ("Enter weight 2:");
			userWeights[1] = scnr.nextDouble();
			System.out.println ("Enter weight 3:");
			userWeights[2] = scnr.nextDouble();
			System.out.println ("Enter weight 4:");
			userWeights[3] = scnr.nextDouble();
			System.out.println ("Enter weight 5:");
			userWeights[4] = scnr.nextDouble();

			System.out.println("You entered: " + userWeights[0] + " " + userWeights[1] + " " + userWeights[2] + " " + userWeights[3] + " " + userWeights[4] + " \n");
			System.out.println("Total weight: " + (userWeights[0] + userWeights[1] + userWeights[2] + userWeights[3] + userWeights[4]));
			System.out.println("Average weight: " + ((userWeights[0]+userWeights[1]+userWeights[2]+userWeights[3]+userWeights[4])/5));

			for (double element: userWeights){
				if (element > maxWeight){
					maxWeight=element;}
			}
			System.out.println("Max weight: " + maxWeight);

   }
}
