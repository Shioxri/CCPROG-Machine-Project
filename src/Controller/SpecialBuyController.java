package Controller;

import Model.*;
import View.SpecialBuy;

import javax.swing.*;
import java.util.ArrayList;

public class SpecialBuyController {
    private SpecialBuy specialBuyMenu;

    SpecialBuyController(SpecialBuy specialBuyMenu, SpecVMMenuController specVMMenuController, SpecialVendingMachine vendingMachine){
        this.specialBuyMenu = specialBuyMenu;

        ArrayList<Slot> originalSlots = Maintenance.deepCopySlotArrayList(vendingMachine.getSlotArrayList());
        ArrayList<Slot> originalSpecialSlots = Maintenance.deepCopySlotArrayList(vendingMachine.getSpecialSlots());


        setDropdownContents(vendingMachine);




        specialBuyMenu.getFirstFruitsDropDown().addActionListener(e ->{
            int firstFruitSelectedIndex = specialBuyMenu.getFirstFruitsDropDown().getSelectedIndex();
            if(firstFruitSelectedIndex==0)
            {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0,0);
                specialBuyMenu.addToTotalCals(0,0);
            }
            else
            {
                Item selectedItem = vendingMachine.getSelectedItem(firstFruitSelectedIndex-1, false);


                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(),0);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(),0);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });

        specialBuyMenu.getFirstFruitsDropDown().addActionListener(e -> {
            int firstFruitSelectedIndex = specialBuyMenu.getFirstFruitsDropDown().getSelectedIndex();
            if (firstFruitSelectedIndex == 0) {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0, 0);
                specialBuyMenu.addToTotalCals(0, 0);
            } else {
                Item selectedItem = vendingMachine.getSelectedItem(firstFruitSelectedIndex - 1, false);
                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(), 0);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(), 0);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });

        specialBuyMenu.getSecondFruitsDropDown().addActionListener(e -> {
            int secondFruitSelectedIndex = specialBuyMenu.getSecondFruitsDropDown().getSelectedIndex();
            if (secondFruitSelectedIndex == 0) {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0, 1);
                specialBuyMenu.addToTotalCals(0, 1);
            } else {
                Item selectedItem = vendingMachine.getSelectedItem(secondFruitSelectedIndex - 1, false);
                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(), 1);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(), 1);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });

        specialBuyMenu.getWaterType().addActionListener(e -> {
            int waterTypeSelectedIndex = specialBuyMenu.getWaterType().getSelectedIndex();
            if (waterTypeSelectedIndex == 0) {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0, 2);
                specialBuyMenu.addToTotalCals(0, 2);
            } else {
                Item selectedItem = vendingMachine.getSelectedItem(waterTypeSelectedIndex - 1, true);
                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(), 2);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(), 2);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });

        specialBuyMenu.getMilkType().addActionListener(e -> {
            int milkTypeSelectedIndex = specialBuyMenu.getMilkType().getSelectedIndex() + 2;
            if (milkTypeSelectedIndex == 2) {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0, 3);
                specialBuyMenu.addToTotalCals(0, 3);
            } else {
                Item selectedItem = vendingMachine.getSelectedItem(milkTypeSelectedIndex - 1, true);
                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(), 3);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(), 3);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });

        specialBuyMenu.getIceType().addActionListener(e -> {
            int iceTypeSelectedIndex = specialBuyMenu.getIceType().getSelectedIndex() + 7;
            if (iceTypeSelectedIndex == 7) {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0, 4);
                specialBuyMenu.addToTotalCals(0, 4);
            } else {
                Item selectedItem = vendingMachine.getSelectedItem(iceTypeSelectedIndex - 1, true);
                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(), 4);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(), 4);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });

        specialBuyMenu.getToppingsType().addActionListener(e -> {
            int toppingsSelectedIndex = specialBuyMenu.getToppingsType().getSelectedIndex() + 9;
            if (toppingsSelectedIndex == 9) {
                updateSideLabels(specialBuyMenu, vendingMachine);
                specialBuyMenu.addToTotalPrice(0, 5);
                specialBuyMenu.addToTotalCals(0, 5);
            } else {
                Item selectedItem = vendingMachine.getSelectedItem(toppingsSelectedIndex - 1, true);
                specialBuyMenu.addToTotalPrice(selectedItem.getPrice(), 5);
                specialBuyMenu.addToTotalCals(selectedItem.getCalorie(), 5);
                updateSideLabels(specialBuyMenu, vendingMachine);
            }
        });



        specialBuyMenu.getAddButton().addActionListener(e -> {
            vendingMachine.addTempPaidMoney((Integer) specialBuyMenu.getDenominations().getSelectedItem(), 1);
            specialBuyMenu.updateBalanceText(vendingMachine.getUserBalance());
            specialBuyMenu.showAddedMoneyText();

        });


        specialBuyMenu.getBuyButton().addActionListener(e ->{
            int firstFruitIndex = specialBuyMenu.getFirstFruitsDropDown().getSelectedIndex();
            int secondFruitIndex = specialBuyMenu.getSecondFruitsDropDown().getSelectedIndex();
            int waterTypeIndex = specialBuyMenu.getWaterType().getSelectedIndex();
            int milkTypeIndex = specialBuyMenu.getMilkType().getSelectedIndex();
            int iceTypeIndex = specialBuyMenu.getIceType().getSelectedIndex();
            int toppingsTypeIndex = specialBuyMenu.getToppingsType().getSelectedIndex();
            boolean isInvalidOrder = false;

            ArrayList<Item> selectedItems = new ArrayList<>();
            ArrayList<Item> selectedFruits = new ArrayList<>();
            ArrayList<Item> selectedLiquids = new ArrayList<>();
            Item iceType = null;
            Item toppingsType = null;
            if(vendingMachine.getUserBalance()>=specialBuyMenu.getTotalPrice())
            {
                if(vendingMachine.getMoneyManager().canReturnChange(specialBuyMenu.getTotalPrice())) {

                    if ((firstFruitIndex != 0 || secondFruitIndex != 0) && (waterTypeIndex != 0 || milkTypeIndex != 0)) {

                        StringBuilder systemLabelMessage = new StringBuilder();
                        systemLabelMessage.append("<html>List of out of stock items:<br/>");

                        if(firstFruitIndex!=secondFruitIndex)
                        {
                            if (firstFruitIndex != 0) {
                                if (!vendingMachine.getSelectedSlot(firstFruitIndex - 1, false).getItemArrayList().isEmpty()) {
                                    Item firstFruit = vendingMachine.dispenseSelectedItem(firstFruitIndex - 1, false);
                                    selectedItems.add(firstFruit);
                                    selectedFruits.add(firstFruit);
                                } else {
                                    isInvalidOrder = true;
                                    systemLabelMessage.append("First Fruit is out of stock or not available<br/>");
                                }
                            }

                            if (secondFruitIndex != 0) {
                                if (!vendingMachine.getSelectedSlot(secondFruitIndex - 1, false).getItemArrayList().isEmpty()) {
                                    Item secondFruit = vendingMachine.dispenseSelectedItem(secondFruitIndex - 1, false);
                                    selectedItems.add(secondFruit);
                                    selectedFruits.add(secondFruit);
                                } else {
                                    isInvalidOrder = true;
                                    systemLabelMessage.append("Second Fruit is out of stock or not available<br/>");
                                }
                            }
                        }
                        else {
                            isInvalidOrder = true;
                            systemLabelMessage.append("Please select different fruits to combine!<br/>");
                        }


                        if (waterTypeIndex != 0) {
                            if (!vendingMachine.getSelectedSlot(waterTypeIndex - 1, true).getItemArrayList().isEmpty()) {
                                Item waterType = vendingMachine.dispenseSelectedItem(waterTypeIndex - 1, true);
                                selectedItems.add(waterType);
                                selectedLiquids.add(waterType);
                            } else {
                                isInvalidOrder = true;
                                systemLabelMessage.append("Water Type is out of stock or not available<br/>");
                            }
                        }

                        if (milkTypeIndex != 0) {
                            if (!vendingMachine.getSelectedSlot(milkTypeIndex + 1, true).getItemArrayList().isEmpty()) {
                                Item milkType = vendingMachine.dispenseSelectedItem(milkTypeIndex + 1, true);
                                selectedItems.add(milkType);
                                selectedLiquids.add(milkType);
                            } else {
                                isInvalidOrder = true;
                                systemLabelMessage.append("Milk Type is out of stock or not available<br/>");
                            }
                        }

                        if (iceTypeIndex != 0) {
                            if (!vendingMachine.getSelectedSlot(iceTypeIndex + 6, true).getItemArrayList().isEmpty()) {
                                iceType = vendingMachine.dispenseSelectedItem(iceTypeIndex + 6, true);
                                selectedItems.add(iceType);
                            } else {
                                isInvalidOrder = true;
                                systemLabelMessage.append("Ice Type is out of stock or not available<br/>");
                            }
                        }

                        if (toppingsTypeIndex != 0) {
                            if (!vendingMachine.getSelectedSlot(toppingsTypeIndex + 8, true).getItemArrayList().isEmpty()) {
                                toppingsType = vendingMachine.dispenseSelectedItem(toppingsTypeIndex + 8, true);
                                selectedItems.add(toppingsType);
                            } else {
                                isInvalidOrder = true;
                                systemLabelMessage.append("Toppings Type is out of stock or not available<br/>");
                            }
                        }

                        if(!isInvalidOrder)
                        {
                            updateSideLabels(specialBuyMenu, vendingMachine);

                            int totalUserMoney = vendingMachine.getUserBalance();
                            int change = totalUserMoney - specialBuyMenu.getTotalPrice();
                            for(Item item : selectedItems)
                            {
                                Maintenance.addSoldItems(vendingMachine, item.getType());
                            }

                            vendingMachine.getMoneyManager().depositMoney();
                            vendingMachine.getMoneyManager().returnChange(change);
                            specialBuyMenu.updateBalanceText(vendingMachine.getUserBalance());
                            specialBuyMenu.resetTotalPrice();
                            specialBuyMenu.resetTotalCals();
                            resetDropdowns();

                            StringBuilder successMessage = new StringBuilder("<html>Preparing your custom fruit shake...<br/>");
                            successMessage.append("Blended Fruits: ");
                            for (Item item : selectedFruits) {
                                successMessage.append(item.getType()).append(" ");
                            }
                            successMessage.append("<br/>Poured Liquids: ");
                            for (Item liquid : selectedLiquids) {
                                successMessage.append(liquid.getType()).append(" ");
                            }
                            successMessage.append("<br/>");
                            if (iceType != null) {
                                successMessage.append("Used ice: ").append(iceType.getType()).append("<br/>");
                            }
                            if (toppingsType != null) {
                                successMessage.append("Topped with: ").append(toppingsType.getType()).append("<br/>");
                            }
                            successMessage.append("[Transaction Complete]<br/>");
                            successMessage.append("Order Complete! Enjoy your customized fruit shake!<br/>");
                            successMessage.append("Change Returned: Php ").append(change).append("</html>");

                            specialBuyMenu.getSystemMessage().setText("<html>Order Complete!<br/>Transaction Successful!<html>");

                            JOptionPane.showMessageDialog(null, new JLabel(successMessage.toString()));

                        }
                        else
                        {
                            specialBuyMenu.getSystemMessage().setText(systemLabelMessage.toString());
                        }

                    }
                    else
                    {
                        resetDropdowns();
                        specialBuyMenu.getSystemMessage().setText("<html>Invalid Order!" +
                                "<br/>Must have at least: 1 Fruit and 1 Liquid Type (Milk/Water)" +
                                "<br/>too complete an order, please try again!<html>");

                    }
                }
                else
                {
                    resetDropdowns();
                    specialBuyMenu.getSystemMessage().setText("<html>Machine does not have enough change<br/>" +
                            "Order cancelled and money returned<html>");

                }
            }
            else
            {
                resetDropdowns();
                specialBuyMenu.getSystemMessage().setText("<html>Invalid Order!<br/>" +
                        "Not enough balance inserted!<html>");
            }

        });

        specialBuyMenu.getCancelButton().addActionListener(e -> {
            vendingMachine.getMoneyManager().clearUserPaidMoney();
            specialBuyMenu.defaultBalanceText();
            vendingMachine.restoreOriginalContents(originalSlots, originalSpecialSlots);
            resetDropdowns();

            specialBuyMenu.getSystemMessage().setText("<html>Cleared user balance<br/>"+
                    "Returned User Money<br/>"+
                    "Cleared Order<br/>"+
                    "Returned Selected Items<br/>"+
                    "Successfully cancelled the transaction </html>");
        });

        specialBuyMenu.getExitButton().addActionListener(e -> {

            vendingMachine.getMoneyManager().clearUserPaidMoney();
            specialBuyMenu.getFrame().setVisible(false);
            specVMMenuController.getSpecialVMMenu().getFrame().setVisible(true);
        });
    }
    private void setDropdownContents(SpecialVendingMachine vendingMachine)
    {
        specialBuyMenu.setFirstFruitsDropDown(getSlotTypes(vendingMachine.getSlotArrayList()));
        specialBuyMenu.setSecondFruitsDropDown(getSlotTypes(vendingMachine.getSlotArrayList()));
        specialBuyMenu.setWaterDropDown(getSpecialSlotTypes(vendingMachine.getSpecialSlots(),0,1));
        specialBuyMenu.setMilkDropDown(getSpecialSlotTypes(vendingMachine.getSpecialSlots(),2,6));
        specialBuyMenu.setIceDropDown(getSpecialSlotTypes(vendingMachine.getSpecialSlots(),7,8));
        specialBuyMenu.setToppingsDropDown(getSpecialSlotTypes(vendingMachine.getSpecialSlots(),9,10));
    }

    private void resetDropdowns()
    {
        specialBuyMenu.getFirstFruitsDropDown().setSelectedIndex(0);
        specialBuyMenu.getSecondFruitsDropDown().setSelectedIndex(0);
        specialBuyMenu.getWaterType().setSelectedIndex(0);
        specialBuyMenu.getMilkType().setSelectedIndex(0);
        specialBuyMenu.getIceType().setSelectedIndex(0);
        specialBuyMenu.getToppingsType().setSelectedIndex(0);
    }


    private ArrayList<String> getSlotTypes(ArrayList<Slot> slotTypes) {
        ArrayList<String> stringSlotTypes = new ArrayList<>();
        for (Slot slot : slotTypes) {
            stringSlotTypes.add(slot.getAssignedItemType());
        }
        return stringSlotTypes;
    }

    private ArrayList<String> getSpecialSlotTypes(ArrayList<Slot> slotTypes, int lowerBound, int upperBound) {
        ArrayList<String> stringSlotTypes = new ArrayList<>();
        for (int i=lowerBound; i<upperBound+1;i++) {
            stringSlotTypes.add(slotTypes.get(i).getAssignedItemType());
        }
        return stringSlotTypes;
    }

    public void updateSideLabels(SpecialBuy specialBuyMenu, SpecialVendingMachine vendingMachine) {
        int firstFruitIndex = specialBuyMenu.getFirstFruitsDropDown().getSelectedIndex();
        int secondFruitIndex = specialBuyMenu.getSecondFruitsDropDown().getSelectedIndex();
        int waterTypeIndex = specialBuyMenu.getWaterType().getSelectedIndex();
        int milkTypeIndex = specialBuyMenu.getMilkType().getSelectedIndex();
        int iceTypeIndex = specialBuyMenu.getIceType().getSelectedIndex();
        int toppingsTypeIndex = specialBuyMenu.getToppingsType().getSelectedIndex();

        StringBuilder infoText = new StringBuilder("<html>Item Details:<br/>Price | Calories | Stock<br/>");
        StringBuilder orderText = new StringBuilder();
        orderText.append("<html>Order Details<br/>Price: Php ").append(specialBuyMenu.getTotalPrice());
        orderText.append("<br/>Calories: ").append(specialBuyMenu.getTotalCals()).append(" kCal");
        orderText.append("<br/>Selected Items:<br/>");

        if (firstFruitIndex != 0) {
            String firstFruit = (String) specialBuyMenu.getFirstFruitsDropDown().getSelectedItem();
            int price = vendingMachine.getSelectedItem(firstFruitIndex-1, false).getPrice();
            int calories = vendingMachine.getSelectedItem(firstFruitIndex-1, false).getCalorie();
            int stock = vendingMachine.getSelectedSlot(firstFruitIndex-1, false).getItemStock();

            orderText.append("<br/>First Fruit: ").append(firstFruit);
            infoText.append("<br/>First Fruit: ").append(price).append(" | ").append(calories).append(" | ").append(stock);
        } else {
            infoText.append("<br/>First Fruit: ");
            orderText.append("<br/>First Fruit: ");
        }

        if (secondFruitIndex != 0) {
            String secondFruit = (String) specialBuyMenu.getSecondFruitsDropDown().getSelectedItem();
            int price = vendingMachine.getSelectedItem(secondFruitIndex-1, false).getPrice();
            int calories = vendingMachine.getSelectedItem(secondFruitIndex-1, false).getCalorie();
            int stock = vendingMachine.getSelectedSlot(secondFruitIndex-1, false).getItemStock();

            orderText.append("<br/>Second Fruit: ").append(secondFruit);
            infoText.append("<br/>Second Fruit: ").append(price).append(" | ").append(calories).append(" | ").append(stock);
        } else {
            infoText.append("<br/> Second Fruit: ");
            orderText.append("<br/>Second Fruit: ");
        }
        if (waterTypeIndex != 0) {
            String waterType = (String) specialBuyMenu.getWaterType().getSelectedItem();
            int price = vendingMachine.getSelectedItem(waterTypeIndex-1, true).getPrice();
            int calories = vendingMachine.getSelectedItem(waterTypeIndex-1, true).getCalorie();
            int stock = vendingMachine.getSelectedSlot(waterTypeIndex-1, true).getItemStock();

            orderText.append("<br/>Water Type: ").append(waterType);
            infoText.append("<br/>Water Type: ").append(price).append(" | ").append(calories).append(" | ").append(stock);
        } else {
            infoText.append("<br/> Water Type: ");
            orderText.append("<br/>Water Type: ");
        }
        if (milkTypeIndex != 0) {
            String milkType = (String) specialBuyMenu.getMilkType().getSelectedItem();
            int price = vendingMachine.getSelectedItem(milkTypeIndex+1, true).getPrice();
            int calories = vendingMachine.getSelectedItem(milkTypeIndex+1, true).getCalorie();
            int stock = vendingMachine.getSelectedSlot(milkTypeIndex+1, true).getItemStock();

            orderText.append("<br/>Milk Type: ").append(milkType);
            infoText.append("<br/>Milk Type: ").append(price).append(" | ").append(calories).append(" | ").append(stock);
        } else {
            infoText.append("<br/> Milk Type: ");
            orderText.append("<br/>Milk Type: ");
        }
        if (iceTypeIndex != 0) {
            String iceType = (String) specialBuyMenu.getIceType().getSelectedItem();
            int price = vendingMachine.getSelectedItem(iceTypeIndex+6, true).getPrice();
            int calories = vendingMachine.getSelectedItem(iceTypeIndex+6, true).getCalorie();
            int stock = vendingMachine.getSelectedSlot(iceTypeIndex+6, true).getItemStock();

            orderText.append("<br/>Ice Type: ").append(iceType);
            infoText.append("<br/>Ice Type: ").append(price).append(" | ").append(calories).append(" | ").append(stock);
        } else {
            infoText.append("<br/> Ice Type: ");
            orderText.append("<br/>Ice Type: ");
        }
        if (toppingsTypeIndex != 0) {
            String toppingsType = (String) specialBuyMenu.getToppingsType().getSelectedItem();
            int price = vendingMachine.getSelectedItem(toppingsTypeIndex+8, true).getPrice();
            int calories = vendingMachine.getSelectedItem(toppingsTypeIndex+8, true).getCalorie();
            int stock = vendingMachine.getSelectedSlot(toppingsTypeIndex+8, true).getItemStock();

            orderText.append("<br/>Toppings: ").append(toppingsType);
            infoText.append("<br/>Toppings: ").append(price).append(" | ").append(calories).append(" | ").append(stock);
        } else {
            infoText.append("<br/> Toppings: ");
            orderText.append("<br/>Toppings: ");
        }

        infoText.append("</html>");
        specialBuyMenu.getInfoLabel().setText(infoText.toString());
        orderText.append("</html>");
        specialBuyMenu.getOrderLabel().setText(orderText.toString());
        specialBuyMenu.getSystemMessage().setText("");
    }


}
