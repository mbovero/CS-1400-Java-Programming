import java.io.*;
import java.util.Scanner;

public class ReadWrite{
	public static String read(Scanner file){
		String message = "";	//create a string to hold the message
		file.useDelimiter("\\Z"); //set scanner delimiter to EOF
		message += file.next(); //read the whole file
		file.close();
		return message/*message string*/;
	}//end read

	public static Scanner openFile(String	file_name, Scanner input) {
		try{//try
			File file = new File(file_name); //create a File object based on file_name
			input = new Scanner(file); //change the Scanner input to read from the File object
		}
		catch(FileNotFoundException e) { //catch if the file isn't found
			System.out.println("Can't find" + file_name + "\n" + e); //Display appropriate error message
		}
		return input;
	}//end open_file

	public static void write(String file_name, String message){
		try { //try
			File file = new File(file_name);
			PrintWriter writer = new PrintWriter(file); //create a PrintWriter object based on file_name
			writer.println(message); //print the message to the PrintWriter object
			writer.close(); //close the PrintWriter object
		}
		catch(FileNotFoundException e){ //catch if the file is not found - eventhough java is making a file, so it doesn't need to be there first --stupid java
			System.out.println("Couldn't open the file\n"+e); //display appropriate error message
		}
		catch(IOException e){
			System.out.println("Couldn't append to file\n"+e);
		}
	}//end write method
}// end class File
