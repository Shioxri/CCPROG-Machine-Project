package Model;


public class Maintenance {
    public void restockItem(VendingMachine vendingMachine, int indexChoice)
    {
        vendingMachine.getStockManager().restockItems(vendingMachine,indexChoice);
    }

    public boolean isSameItemType(VendingMachine vendingMachine, String inputString) {
        return vendingMachine.getStockManager().isSameItemType(vendingMachine, inputString);
    }

    public void stockNewItems(VendingMachine vendingMachine, String newItem, int newPrice, int newCals) {
        vendingMachine.getStockManager().stockNewItems(vendingMachine,newItem,newPrice,newCals);
    }

    public void updateItemPrices(VendingMachine vendingMachine, int userChoice, int newPrice)
    {
        vendingMachine.getStockManager().updateItemPrice(vendingMachine, userChoice, newPrice);
    }

    public void collectMoney(VendingMachine vendingMachine)
    {
        vendingMachine.getMoneyManager().collectMoney();
    }

    public void replenishMoney(VendingMachine vendingMachine, int denomination, int quantity)
    {
        vendingMachine.getMoneyManager().addStoredMoney(denomination, quantity);
    }
}