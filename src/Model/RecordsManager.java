package Model;

import java.util.HashMap;

public class RecordsManager {

    private HashMap<String, Integer> itemsQuantities;
    private HashMap<String, Integer> itemsPrices;

    public RecordsManager() {
        itemsQuantities = new HashMap<>();
        itemsPrices = new HashMap<>();
    }


    public void addSoldItems(String itemType) {
        if (itemsQuantities.containsKey(itemType)) {
            int quantitySold = itemsQuantities.get(itemType);
            itemsQuantities.put(itemType, quantitySold + 1);
        } else {
            itemsQuantities.put(itemType, 1);
        }
    }


    public void generateSalesReport(VendingMachine vendingMachine) {
        for (Slot slot : vendingMachine.getSlotArrayList()) {
            String itemTypeKey = slot.getAssignedItemType();

            if (itemsQuantities.containsKey(itemTypeKey)) {
                int itemPrice = itemsQuantities.get(itemTypeKey) * slot.getItemArrayList().get(0).getPrice();
                itemsPrices.put(itemTypeKey, itemPrice);

            }
        }
        System.out.println("Sales Report:");

        int totalSalesAmount = 0;

        for (String itemType : itemsQuantities.keySet()) {
            int quantitySold = itemsQuantities.getOrDefault(itemType, 0);
            int totalPrice = itemsPrices.getOrDefault(itemType, 0);
            totalSalesAmount += totalPrice;

            System.out.println(itemType + " - # of Items Sold: " + quantitySold + " - Sales: ₱" + totalPrice);
        }

        System.out.println("Total Sales: ₱" + totalSalesAmount);
    }

    public HashMap<String, Integer> getPricesList() {
        return itemsPrices;
    }

    public void clearItemsQuantities() {
        itemsQuantities.clear();
    }

    public HashMap<String, Integer> getItemsQuantities() {
        return itemsQuantities;
    }
    public void clearItemsPrices() {
        itemsPrices.clear();
    }
}
