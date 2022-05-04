public class ItemToPurchase {
  private String itemName;
  private String itemDescription;
  private int itemPrice;
  private int itemQuantity;

  public ItemToPurchase() {
    itemName = "none";
    itemDescription = "none";
    itemPrice = 0;
    itemQuantity = 0;
  }
  public ItemToPurchase(String newName, int newQuantity) {
    this.itemName = newName;
    itemDescription = "none";
    itemPrice = 0;
    this.itemQuantity = newQuantity;
  }
  public ItemToPurchase(String newName, String newDescription, int newPrice, int newQuantity) {
    this.itemName = newName;
    this.itemDescription = newDescription;
    this.itemPrice = newPrice;
    this.itemQuantity = newQuantity;
  }

//name stuff
  public void setName(String newName) {
    this.itemName = newName;
  }
  public String getName() {
    return itemName;
  }

//description stuff
  public void setDescription(String newDescription) {
    this.itemDescription = newDescription;
  }
  public String getDescription() {
    return itemDescription;
  }

//price stuff
  public void setPrice(int newPrice) {
    this.itemPrice = newPrice;
  }
  public int getPrice() {
    return itemPrice;
  }

//quantity stuff
  public void setQuantity(int newQuantity) {
    this.itemQuantity = newQuantity;
  }
  public int getQuantity() {
    return itemQuantity;
  }


//print item cost
  public void printItemCost() {
    System.out.println(this.itemName + " " + this.itemQuantity + " @ $" + this.itemPrice + " = $" + (this.itemQuantity * this.itemPrice));
  }
//print item description
  public void printItemDescription() {
    System.out.println(this.itemName + ": " + this.itemDescription);
  }

}
