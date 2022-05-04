import java.util.Scanner;

public class ShoppingCartManager {

  public static boolean again = true;

  public static void main(String[] args) {
    String newCustomerName;
    String newCurrentDate;
    Scanner scnr = new Scanner(System.in);  // revert

    System.out.println("Enter Customer's Name:");
    newCustomerName = scnr.nextLine();
    System.out.println("Enter Today's Date:");
    newCurrentDate = scnr.nextLine();
    System.out.println("\nCustomer Name: " + newCustomerName + "\nToday's Date: " + newCurrentDate);
    ShoppingCart cart = new ShoppingCart(newCustomerName, newCurrentDate);

    do {printMenu(cart, scnr);} while(again);

  }//end main

  public static void printMenu(ShoppingCart cart, Scanner scnr) {
    char option = 'x';
    String optionsPossible = "adcioq";
    String newName;
    String newDescription;
    int newPrice;
    int newQuantity;
    String itemRemoveName;
    again = true;


    System.out.println("\nMENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n");
    while (optionsPossible.indexOf(option) == -1) {
      System.out.println("Choose an option:");
      option = scnr.next().charAt(0);
      scnr.nextLine();
    }
    switch(option) {
      case 'a':
      System.out.println("ADD ITEM TO CART\nEnter the item name:");
      newName = scnr.nextLine();
      System.out.println("Enter the item description:");
      newDescription = scnr.nextLine();
      System.out.println("Enter the item price:");
      newPrice = scnr.nextInt();
      scnr.nextLine();
      System.out.println("Enter the item quantity:");
      newQuantity = scnr.nextInt();
      scnr.nextLine();
      cart.addItem(new ItemToPurchase(newName, newDescription, newPrice, newQuantity));
      break;


      case 'd':
      System.out.println("REMOVE ITEM FROM CART\nEnter name of item to remove:");
      itemRemoveName = scnr.nextLine();
      cart.removeItem(itemRemoveName);
      break;

      case 'c':
      System.out.println("CHANGE ITEM QUANTITY\nEnter the item name:");
      newName = scnr.nextLine();
      System.out.println("Enter the new quantity:");
      newQuantity = scnr.nextInt();
      scnr.nextLine();
      cart.modifyItem(new ItemToPurchase(newName, newQuantity));
      break;

      case 'i':
      System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
      cart.printDescriptions();
      break;

      case 'o':
      System.out.println("OUTPUT SHOPPING CART");
      cart.printTotal();
      break;

      case 'q':
      again = false;
      break;
    }
  }

}//end class
