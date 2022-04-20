import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinConverter {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    System.out.println("Enter an integer:");
    int inputInt = scnr.nextInt();

    String formattedBin = convert(inputInt);
    System.out.println(formattedBin);
    write(formattedBin);
  }

  public static String convert(int inputInt) {
    String binaryNum = Integer.toBinaryString(inputInt);
    String formattedBin = "";
    int l = binaryNum.length();
    int modDif = 4-(l%4);
    if ((l%4)>0) {
      for (int i=0; i<modDif; i++){
        binaryNum = "0" + binaryNum;
      }
    }
    if (l>4) {
      for (int j=0; j<(l-4); j+=4) {
        formattedBin += binaryNum.substring(j,(j+4)) + " ";
      }
      l = binaryNum.length();
      formattedBin += binaryNum.substring((l-4),l);
    }
    else {formattedBin = binaryNum;}
    return formattedBin;
  }

  public static void write(String formattedBin) {
    try {
      File file = new File("binary.txt");
  		PrintWriter writer = new PrintWriter(file);
  		writer.println(formattedBin);
  		writer.close();
    }
    catch(FileNotFoundException e){
      System.out.println("Couldn't open the file\n"+e);
    }
  }
}
