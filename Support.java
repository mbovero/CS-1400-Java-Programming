import java.util.Scanner;

public class Support{
	public static String decrypt(String message, int cipher) {
		String decrypted = ""; //create an empty string for the encrypted message
		int originalCharPos;
		int newCharPos;
		char decryptedChar;
		if (cipher < 0) { //if cipher < 0
			cipher += 26; //cipher += 26
		}

		for (int i=0; i<(message.length()); i++) { //for each character in the message
			originalCharPos = message.charAt(i); //create an integer representation of the char at the current position
			if (originalCharPos>64 && originalCharPos<91){ //if the int represents a capital letter (check ascii chart)
				newCharPos = originalCharPos - cipher;//add the cipher to the int
				if (newCharPos<65){ //if the new number is out the range of capital letters, wrap it back, ie. Z+1=A, Z+2=B
					newCharPos += 26;
				}
			}
			else if (originalCharPos>96 && originalCharPos<123){ //else if the int represents a lower letter (check ascii chart)
				newCharPos = originalCharPos - cipher;//add the cipher to the int
				if (newCharPos<97){ //if the new number is out the range of lower letters, wrap it back, ie. z+1=a, z+2=b
					newCharPos += 26;
				}
			}
      else {
        newCharPos = originalCharPos;
      }
			decryptedChar = (char)newCharPos;
			decrypted += decryptedChar;
    }

		return decrypted;/*run the encryption method backwards*/
	}//end decrypt

	public static String encrypt(String message, int cipher) {
		String encrypted = ""; //create an empty string for the encrypted message
		int originalCharPos;
		int newCharPos;
		char encryptedChar;
		if (cipher < 0) { //if cipher < 0
			cipher += 26; //cipher += 26
		}

		for (int i=0; i<(message.length()); i++) { //for each character in the message
			originalCharPos = message.charAt(i); //create an integer representation of the char at the current position
			if (originalCharPos>64 && originalCharPos<91){ //if the int represents a capital letter (check ascii chart)
				newCharPos = originalCharPos + cipher;//add the cipher to the int
				if (newCharPos>90){ //if the new number is out the range of capital letters, wrap it back, ie. Z+1=A, Z+2=B
					newCharPos -= 26;
				}
			}
			else if (originalCharPos>96 && originalCharPos<123){ //else if the int represents a lower letter (check ascii chart)
				newCharPos = originalCharPos + cipher;//add the cipher to the int
				if (newCharPos>122){ //if the new number is out the range of lower letters, wrap it back, ie. z+1=a, z+2=b
					newCharPos -= 26;
				}
			}
      else {
        newCharPos = originalCharPos;
      }
			encryptedChar = (char)newCharPos;
			encrypted += encryptedChar;//add the char represented by the int to the encrypted message string
		}
		return encrypted; /*encrypted message*/
	}//end encrypt method





	public static int[] letterDistr(String message) {
		int[] distr = new int[26];//initialize an int array to hold the number of each letter
		int currentCharPos;
		for(int i=0; i<message.length(); i++) { //for each character in the message
			currentCharPos = (int)Character.toLowerCase(message.charAt(i)); //convert the current char to lowercase then to an int
			if (currentCharPos>96 && currentCharPos<123) { //if the int represents a lowercase letter (check the ascii chart)
				currentCharPos -= 97; //subtract 97 from the int
				distr[currentCharPos] += 1;//add 1 to the int array at that index
			}
		}
		return distr; //return the int array
	}//end letter distribution method

	public static void printDistr(int[] distr) {
		char currentChar;
		for (int i=0; i<distr.length; i++) { //for each element in the array
			currentChar = (char)(i+97); //create a char from the current position (ie. 0=a,1=b,...)
			System.out.printf(currentChar + ":%4s", distr[i] + "|"/*theChar:numOfChar|*/);//numOfChar should be formatted to have a width of 4.
			for (int j=0; j<distr[i]; j++) { //for the number in the array at the current position
				System.out.print("*"); //print an * on the same line
			}
			System.out.println(); //move to the next line
		}
	}//end printDistr

}//end class Caersar
