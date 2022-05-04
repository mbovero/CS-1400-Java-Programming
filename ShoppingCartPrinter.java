import java.util.Scanner;

public class ShoppingCartPrinter {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    String newName;
    int newPrice;
    int newQuantity;

    System.out.println("Item 1\nEnter the item name:");
    newName = scnr.nextLine();
    System.out.println("Enter the item price:");
    newPrice = scnr.nextInt();
    System.out.println("Enter the item quantity:");
    newQuantity = scnr.nextInt();
    ItemToPurchase item1 = new ItemToPurchase(newName, newPrice, newQuantity);
    System.out.println();
    scnr.nextLine();

    System.out.println("Item 2\nEnter the item name:");
    newName = scnr.nextLine();
    System.out.println("Enter the item price:");
    newPrice = scnr.nextInt();
    System.out.println("Enter the item quantity:");
    newQuantity = scnr.nextInt();
    ItemToPurchase item2 = new ItemToPurchase(newName, newPrice, newQuantity);
    System.out.println();
    scnr.nextLine();

    int item1Total = item1.getQuantity() * item1.getPrice();
    int item2Total = item2.getQuantity() * item2.getPrice();
    int total = item1Total + item2Total;

    System.out.println("TOTAL COST\n" + item1.getName() + " " + item1.getQuantity() + " @ $" + item1.getPrice() + " = $" + item1Total + "\n" + item2.getName() + " " + item2.getQuantity() + " @ $" + item2.getPrice() + " = $" + item2Total + "\n\nTotal: $" + total);




  }//end main
}//end ShoppingCartPrinter class
