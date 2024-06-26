package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The MoneyManager class represents the money management in the vending machine, including user paid money, machine stored money,
 * and admin money.
 */
public class MoneyManager { // by money, it means denomination (e.g. 50 pesos from 5 10 peso coins, occupies 5 spaces in the list with [10]

    private ArrayList<Integer> tempMoneyFromUser;  // List of user paid money
    private ArrayList<Integer> storedMoney;    // List of stored money in the vending machine
    private ArrayList<Integer> adminMoney;     // List of admin money

    /**
     * Constructs a MoneyManager object with empty lists for user paid money, stored money, and admin money.
     */
    public MoneyManager() {
        tempMoneyFromUser = new ArrayList<>();
        storedMoney = new ArrayList<>();
        adminMoney = new ArrayList<>();
    }

    /**
     * Adds the paid money to the user paid money list.
     *
     * @param denomination The denomination of the paid money.
     * @param quantity     The quantity of the paid money.
     */
    public void addTempPaidMoney(int denomination, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.tempMoneyFromUser.add(denomination);
        }
    }

    /**
     * Adds the stored money to the stored money list.
     *
     * @param denomination The denomination of the stored money.
     * @param quantity     The quantity of the stored money.
     */
    public void addStoredMoney(int denomination, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.storedMoney.add(denomination);
        }
    }

    /**
     * Calculates and returns the total amount of money from a given list of denominations.
     *
     * @param moneyList The list of denominations.
     * @return The total amount of money.
     */
    public int getTotalMoneyFromList(ArrayList<Integer> moneyList) {
        int totalMoney = 0;

        for (int denomination : moneyList) {
            totalMoney += denomination;
        }

        return totalMoney;
    }

    /**
     * Deposits the user paid money to the stored money list and clears the user paid money list.
     */
    public void depositMoney() {
        storedMoney.addAll(tempMoneyFromUser);
        tempMoneyFromUser.clear();
    }

    /**
     * Collects the stored money to the admin money list and clears the stored money list.
     */
    public void collectMoney() {
        adminMoney.addAll(storedMoney);
        storedMoney.clear();
    }

    /**
     * Returns the user paid money list.
     *
     * @return The list of user paid money.
     */
    public ArrayList<Integer> getTempMoneyFromUser() {
        return tempMoneyFromUser;
    }

    /**
     * Returns the stored money list.
     *
     * @return The list of stored money.
     */
    public ArrayList<Integer> getStoredMoney() {
        return storedMoney;
    }

    /**
     * Returns the admin money list.
     *
     * @return The list of admin money.
     */
    public ArrayList<Integer> getAdminMoney() {
        return adminMoney;
    }

    /**
     * Clears the user paid money list.
     */
    public void clearUserPaidMoney() {
        tempMoneyFromUser.clear();
    }

    /**
     * Checks if the machine can return change for a given amount.
     *
     * @param amount The amount for which change needs to be returned.
     * @return True if there is enough change, false otherwise.
     */
    public boolean canReturnChange(int amount) {
        ArrayList<Integer> storedMoneyCopy = new ArrayList<>(storedMoney); // Create a copy to avoid modifying the original storedMoney

        storedMoneyCopy.sort(Collections.reverseOrder());

        for (int i = 0; i < storedMoneyCopy.size(); i++) {
            int denomination = storedMoneyCopy.get(i);

            if (denomination <= amount) {
                amount -= denomination;
                storedMoneyCopy.remove(i);
                i--;
            }

            if (amount == 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the change for a given amount.
     *
     * @param amount The amount for which change needs to be returned.
     */
    public void returnChange(int amount) {
        storedMoney.sort(Collections.reverseOrder()); // Sort the stored money in descending order

        // Iterate through the stored money in descending order
        for (int i = 0; i < storedMoney.size(); i++) {
            int denomination = storedMoney.get(i);

            if (denomination <= amount) {
                amount -= denomination; // Subtract the denomination from the remaining amount
                tempMoneyFromUser.add(denomination); // Add the denomination to the tempPaidMoney list
                storedMoney.remove(i); // Remove the denomination from storedMoney
                i--; // Adjust the index after removal to avoid skipping an element
            }

            // Break the loop if the amount becomes zero
            if (amount == 0) {
                break;
            }
        }
    }

    /**
     * Returns the money to the user (called if there's not enough change in the machine or if the user cancels the transaction).
     *
     * @param moneyToReturn The list of denominations to be returned.
     */
    public void returnMoney(ArrayList<Integer> moneyToReturn) {
        storedMoney.removeAll(moneyToReturn);
    }
}
