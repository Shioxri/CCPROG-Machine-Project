package Model;



import java.util.ArrayList;

public class DisplayManager {
    public void displayAllItems(ArrayList<Slot> slots) {


        int maxItemNameLength = 0;
        for (Slot slot : slots) {
            for (Item item : slot.getItemArrayList()) {
                int itemNameLength = item.getType().length();
                if (itemNameLength > maxItemNameLength) {
                    maxItemNameLength = itemNameLength;
                }
            }
        }

        System.out.println("-----------------------------------------");
        System.out.println("|  Index  |   Item  | Stock |");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < slots.size(); i++) {
            Slot slot = slots.get(i);
            String slotType = slot.getAssignedItemType();
            int stock = slot.getItemStock();

            String itemName = slotType + " ".repeat(maxItemNameLength - slotType.length());
            String stockDisplay = stock > 0 ? String.valueOf(stock) : "[ X ]";

            System.out.printf("| %-8d| %-8s| %-6s|\n", i + 1, itemName, stockDisplay);
        }

        System.out.println("-----------------------------------------");
    }

    public void displaySpecificItem(VendingMachine vendingMachine, int slotIndex) {
        ArrayList<Slot> slots = vendingMachine.getSlotArrayList();

        if (slotIndex >= 0 && slotIndex < slots.size()) {
            Slot slot = slots.get(slotIndex);
            ArrayList<Item> items = slot.getItemArrayList();

            System.out.println("----------------------------------");
            System.out.println("|  Index  |   Item  | Price | Calories | Stock |");
            System.out.println("----------------------------------");

            Item item = items.get(0); // Assuming there is only one item per slot
            String itemName = item.getType();
            int price = item.getPrice();
            int calories = item.getCalorie();
            int stock = slot.getItemStock();

            String stockDisplay = stock > 0 ? String.valueOf(stock) : "[ X ]";
            System.out.printf("| %-8d| %-8s| %-6d| %-8d| %-6s|\n", slotIndex + 1, itemName, price, calories, stockDisplay);
            System.out.println("----------------------------------");
        } else {
            System.out.println("Invalid slot index.");
        }
    }
    public void displayAvailableItems(VendingMachine vendingMachine, boolean isSpecialSlot) {
        int totalTempUserMoney = vendingMachine.getUserBalance();
        System.out.println("[Select your Item]");
            System.out.println("Current Balance: " + totalTempUserMoney);
            System.out.println("Available Items (with respect to current balance): "); // Printing of available items

        int itemPrice;
        for (int i = 0; i < vendingMachine.getSlotArrayList().size(); i++) {
            if (vendingMachine.getSelectedSlot(i,false).getItemArrayList().isEmpty()) {
                System.out.println("[X] " + vendingMachine.getSelectedSlot(i,false).getAssignedItemType() + " [ OUT OF STOCK ]");
            } else {
                itemPrice = vendingMachine.getSelectedItem(i,isSpecialSlot).getPrice();
                if (!isSpecialSlot && itemPrice > totalTempUserMoney) {
                    System.out.println("[X] " + vendingMachine.getSelectedSlot(i,false).getAssignedItemType() + " [ INSUFFICIENT BALANCE ]");
                } else {
                    System.out.println("[" + (i + 1) + "] " + vendingMachine.getSelectedSlot(i,false).getAssignedItemType() + " ₱" + itemPrice);
                }
            }
        }
        System.out.println("[0] Exit / Cancel Transaction");
    }
}
