import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingCart {
  private String customerName;
  private String currentDate;
  private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
  private boolean itemRemoveFound;
  private boolean itemModifyFound;
  private int cartQuantityTotal;
  private int cartPriceTotal;


  public ShoppingCart() {
    customerName = "none";
    currentDate = "January 1, 2016";
  }
  public ShoppingCart(String newCustomerName, String newCurrentDate) {
    this.customerName = newCustomerName;
    this.currentDate = newCurrentDate;
  }


  public String getCustomerName() {
    return customerName;
  }
  public String getDate() {
    return currentDate;
  }

  public void addItem(ItemToPurchase itemAdd) {
    cartItems.add(itemAdd);
    return;
  }
  public void removeItem(String itemRemoveName) {
    itemRemoveFound = false;
    try {
      for (int i=0; i<cartItems.size(); i++) {
        if (itemRemoveName.equals(cartItems.get(i).getName())) {
          cartItems.remove(i);
          itemRemoveFound = true;
          break; //don't know exactly how this breaks
        }
      }
      if (!itemRemoveFound) {
        throw new Exception("Item not found in cart. Nothing removed.");
      }
    } catch (Exception except){
       System.out.println(except.getMessage());
     }
    return;
  }//end removeItem
  public void modifyItem(ItemToPurchase itemModify) {
    itemModifyFound = false;
    try {
      for (int i=0; i<cartItems.size(); i++) {
        if (itemModify.getName().equals(cartItems.get(i).getName())) {
          if (!(cartItems.get(i).getDescription().equals("none")) && !(cartItems.get(i).getPrice() == 0) && !(cartItems.get(i).getQuantity() == 0)) {
            itemModify.setPrice(cartItems.get(i).getPrice());
            itemModify.setDescription(cartItems.get(i).getDescription());
            cartItems.set(i, itemModify); //probably doesn't work - use .get().set
            itemModifyFound = true;
            break; //don't know exactly how this breaks
          }
        }
      }
      if (!itemRemoveFound) {
        throw new Exception("Item not found in cart. Nothing modified.");
      }
    } catch (Exception except){
       System.out.println(except.getMessage());
     }
    return;
  }//end modifyItem

  public int getNumItemsInCart() {
    cartQuantityTotal = 0;
    for (int i=0; i<cartItems.size(); i++) {
      cartQuantityTotal += cartItems.get(i).getQuantity();
    }
    return cartQuantityTotal;
  }
  public int getCostOfCart() {
    cartPriceTotal = 0;
    for (int i=0; i<cartItems.size(); i++) {
      cartPriceTotal += (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
    }
    return cartPriceTotal;
  }

  public void printTotal() {
    System.out.println(customerName + "'s Shopping Cart - " + currentDate);
    System.out.println("Number of Items: " + getNumItemsInCart());
    if (getNumItemsInCart()> 0) {
      System.out.println();
    }
    for (int i=0; i<cartItems.size(); i++) {
      cartItems.get(i).printItemCost();
    }
    if (getNumItemsInCart()<= 0) {
      System.out.println("\nSHOPPING CART IS EMPTY");
    }
    System.out.println("\nTotal: $" + getCostOfCart());
    return;
  }
  public void printDescriptions() {
    System.out.println(customerName + "'s Shopping Cart - " + currentDate);
    System.out.println("\nItem Descriptions");
    for (int i=0; i<cartItems.size(); i++) {
      cartItems.get(i).printItemDescription();
    }
  }
  public static void main(String[] args) {
  }
}//end class
