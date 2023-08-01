package View;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sound.sampled.*;
import javax.swing.border.Border;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SpecialBuy {
    JFrame frame = new JFrame();
    JButton buyButton = new JButton();
    JButton addButton = new JButton();
    JButton exitButton = new JButton();
    JComboBox<String> waterType = new JComboBox<>();
    JComboBox<String> milkType = new JComboBox<>();
    JComboBox<String> iceType = new JComboBox<>();
    JComboBox<String> toppingsType = new JComboBox<>();
    JLabel systemMessage = new JLabel();
    JLabel userBalanceLabel = new JLabel();
    AtomicInteger cash = new AtomicInteger();

    JComboBox<String> firstFruitsDropDown;
    JComboBox<String> secondFruitsDropDown;
    JComboBox<Integer> denominations;

    public void setCash(AtomicInteger cash) {
        this.cash.set(cash.get());
    }

    public SpecialBuy() {
        init();
    }

    private void init() {
        // Declarations
        JLabel titleLabel = new JLabel();
        JPanel titlePanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JLabel infoLabel = new JLabel();
        JComboBox<Integer> denominations = new JComboBox<>();

        firstFruitsDropDown = new JComboBox<>();
        secondFruitsDropDown = new JComboBox<>();
        denominations = new JComboBox<>(new Integer[]{1, 5, 10, 20, 50, 100});
        denominations.setBounds(10,110,120,25);




        // Images
        ImageIcon fruitIcon = new ImageIcon("pixelatedfruit.png");
        ImageIcon titleIcon = new ImageIcon("SPECIALVM1.png");
        ImageIcon sampleBG = new ImageIcon("VM.gif");
        Border borderLine = BorderFactory.createLineBorder(Color.white, 2);
        Border borderLinegrayl = BorderFactory.createLineBorder(Color.lightGray, 2);


        // Components for Background
        JLabel backgroundLabel = new JLabel(sampleBG);
        backgroundLabel.setBounds(0, 0, 750, 750);

        // Panels
        JPanel bgpanel = new JPanel(null);
        bgpanel.setBounds(0, 0, 10000, 10000);
        bgpanel.add(backgroundLabel);

        // Label

        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setIcon(titleIcon);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));


        //TODO: need method that prints error messages or normal notifications
        systemMessage.setBounds(10, 8, 530, 110);
        systemMessage.setHorizontalAlignment(JLabel.CENTER);
        systemMessage.setVerticalAlignment(JLabel.CENTER);
        systemMessage.setBackground(new Color(0, 0, 0));
        systemMessage.setBorder(borderLinegrayl);
        systemMessage.setText("<html><p align=\"center\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Nullam ullamcorper ullamcorper risus eget elementum. Morbi ac quam in ante viverra placerat. Cras non justo purus. " +
                "In eleifend nibh lectus, a elementum purus gravida id. Praesent quis porta arcu. Integer finibus nisi id eros iaculis gravida. Cras tempor orci sit amet pharetra feugiat. " +
                "Sed at sollicitudin nisl.</p></html>"); // 368 characters max
        systemMessage.setForeground(Color.WHITE);
        systemMessage.setOpaque(true);

        userBalanceLabel.setBounds(10, 50, 180, 50);
        userBalanceLabel.setText("$" + cash);
        userBalanceLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
        userBalanceLabel.setForeground(Color.white);
        userBalanceLabel.setHorizontalAlignment(JLabel.CENTER);
        userBalanceLabel.setVerticalAlignment(JLabel.CENTER);
        userBalanceLabel.setBorder(borderLine);
        userBalanceLabel.setBackground(Color.black);
        userBalanceLabel.setOpaque(true);

        //TODO: need method to put the price and calories of the shake/item here
        infoLabel.setBounds(10, 200, 180, 200);
        infoLabel.setText("<html>Price: $999 " +
                "<br/>Calories: 999 kCal" +
                "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                "<br/> Water Type: " + waterType.getSelectedItem() +
                "<br/> Milk Type " + milkType.getSelectedItem() +
                "<br/> Ice Type:" + iceType.getSelectedItem() +
                " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>");
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setBackground(Color.BLACK);
        infoLabel.setBorder(borderLinegrayl);
        infoLabel.setOpaque(true);
        infoLabel.setFont(new Font("Century Gothic", Font.BOLD, 13));

        // Buttons

        //TODO: need method that simulates buy(reduce change reduce stocks)
        buyButton.setToolTipText("Buy Item");
        buyButton.setBounds(10, 410, 180, 50);
        buyButton.setText("Buy");
        buyButton.setHorizontalAlignment(JButton.CENTER);

        //TODO: need method to connect this to userbalance in backend or make "cash" connected to the backend
        addButton.setBounds(140, 110, 50, 25);
        addButton.setText("+");
        addButton.setHorizontalAlignment(JButton.CENTER);


        //TODO: need method to switch GUI to SpecialVMMenu
        exitButton.setBounds(10, 700, 180, 25);
        exitButton.setHorizontalAlignment(JButton.CENTER);
        exitButton.setText("Menu");
        /* How to remove action listener: exitButton.removeActionListener(exitButton.getActionListeners()[0]); */

        // Dropdowns
        denominations.setFocusable(false);
        denominations.setToolTipText("Choose Denomination");
        denominations.setBounds(10, 110, 120, 25);

        firstFruitsDropDown.setFocusable(false);
        firstFruitsDropDown.setToolTipText("First Fruit");
        firstFruitsDropDown.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        firstFruitsDropDown.setBounds(25, 75, 240, 50);
        firstFruitsDropDown.addActionListener(e ->
                infoLabel.setText("<html>Price: $999 " +
                        "<br/>Calories: 999 kCal" +
                        "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                        "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                        "<br/> Water Type: " + waterType.getSelectedItem() +
                        "<br/> Milk Type " + milkType.getSelectedItem() +
                        "<br/> Ice Type:" + iceType.getSelectedItem() +
                        " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>"));


        //TODO: need method to add calories and price to the info when clicked(use action listener)
        //TODO: need method/String[] to input items in the dropdown(for loop)
        secondFruitsDropDown.setFocusable(false);
        secondFruitsDropDown.setToolTipText("Second Fruit");
        secondFruitsDropDown.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        secondFruitsDropDown.setBounds(285, 75, 240, 50);
        secondFruitsDropDown.addActionListener(e ->
                infoLabel.setText("<html>Price: $999 " +
                        "<br/>Calories: 999 kCal" +
                        "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                        "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                        "<br/> Water Type: " + waterType.getSelectedItem() +
                        "<br/> Milk Type " + milkType.getSelectedItem() +
                        "<br/> Ice Type:" + iceType.getSelectedItem() +
                        " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>"));



        //TODO: need method to add calories and price to the info when clicked(use action listener)
        //TODO: need method/String[] to input items in the dropdown(for loop)
        waterType.setFocusable(false);
        waterType.setToolTipText("Water type");
        waterType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        waterType.setBounds(25, 140, 500, 50);
        waterType.addActionListener(e ->
                infoLabel.setText("<html>Price: $999 " +
                        "<br/>Calories: 999 kCal" +
                        "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                        "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                        "<br/> Water Type: " + waterType.getSelectedItem() +
                        "<br/> Milk Type " + milkType.getSelectedItem() +
                        "<br/> Ice Type:" + iceType.getSelectedItem() +
                        " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>"));


        //TODO: need method to add calories and price to the info when clicked(use action listener)
        //TODO: need method/String[] to input items in the dropdown(for loop)
        milkType.setFocusable(false);
        milkType.setToolTipText("Milk type");
        milkType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        milkType.setBounds(25, 205, 500, 50);
        milkType.addActionListener(e ->
                infoLabel.setText("<html>Price: $999 " +
                        "<br/>Calories: 999 kCal" +
                        "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                        "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                        "<br/> Water Type: " + waterType.getSelectedItem() +
                        "<br/> Milk Type " + milkType.getSelectedItem() +
                        "<br/> Ice Type:" + iceType.getSelectedItem() +
                        " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>"));


        //TODO: need method to add calories and price to the info when clicked(use action listener)
        //TODO: need method/String[] to input items in the dropdown(for loop)
        iceType.setFocusable(false);
        iceType.setToolTipText("Ice type");
        iceType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        iceType.setBounds(25, 270, 500, 50);

        iceType.addActionListener(e ->
                infoLabel.setText("<html>Price: $999 " +
                        "<br/>Calories: 999 kCal" +
                        "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                        "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                        "<br/> Water Type: " + waterType.getSelectedItem() +
                        "<br/> Milk Type " + milkType.getSelectedItem() +
                        "<br/> Ice Type:" + iceType.getSelectedItem() +
                        " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>"));


        //TODO: need method to add calories and price to the info when clicked(use action listener)
        //TODO: need method/String[] to input items in the dropdown(for loop)
        toppingsType.setFocusable(false);
        toppingsType.setToolTipText("Toppings");
        toppingsType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        toppingsType.setBounds(25, 335, 500, 50);
        toppingsType.addActionListener(e ->
                infoLabel.setText("<html>Price: $999 " +
                        "<br/>Calories: 999 kCal" +
                        "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                        "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                        "<br/> Water Type: " + waterType.getSelectedItem() +
                        "<br/> Milk Type " + milkType.getSelectedItem() +
                        "<br/> Ice Type:" + iceType.getSelectedItem() +
                        " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>"));

        infoLabel.setText("<html>Price: $999 " +
                "<br/>Calories: 999 kCal" +
                "<br/>First Fruit: " + firstFruitsDropDown.getSelectedItem() +
                "<br/> Second Fruit: " + secondFruitsDropDown.getSelectedItem() +
                "<br/> Water Type: " + waterType.getSelectedItem() +
                "<br/> Milk Type " + milkType.getSelectedItem() +
                "<br/> Ice Type:" + iceType.getSelectedItem() +
                " <br/> Toppings: " + toppingsType.getSelectedItem() + "</html>");

        // Panels
        titlePanel.setBackground(new Color(25, 25, 112, 123));
        titlePanel.setBounds(0, 0, 550, 150);
        titlePanel.setOpaque(true);
        titlePanel.add(titleLabel);
        titlePanel.setBorder(borderLine);

        selectionPanel.setBackground(new Color(25, 25, 112, 123));
        selectionPanel.setBounds(0, 150, 550, 480);
        selectionPanel.setLayout(null);
        selectionPanel.setOpaque(true);
        selectionPanel.setBorder(borderLine);
        selectionPanel.add(firstFruitsDropDown);
        selectionPanel.add(secondFruitsDropDown);
        selectionPanel.add(waterType);
        selectionPanel.add(milkType);
        selectionPanel.add(toppingsType);
        selectionPanel.add(iceType);

        lowerPanel.setBackground(new Color(25, 25, 112, 250));
        lowerPanel.setBounds(0, 630, 550, 130);
        lowerPanel.setLayout(null);
        lowerPanel.setOpaque(true);
        lowerPanel.setBorder(borderLine);
        lowerPanel.add(systemMessage);

        rightPanel.setBackground(new Color(25, 25, 112, 123));
        rightPanel.setBounds(550, 0, 200, 751);
        rightPanel.setLayout(null);
        rightPanel.setOpaque(true);
        rightPanel.setBorder(borderLine);
        rightPanel.add(userBalanceLabel);
        rightPanel.add(infoLabel);
        rightPanel.add(buyButton);
        rightPanel.add(addButton);
        rightPanel.add(denominations);
        rightPanel.add(exitButton);

        // Layered Pane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(750, 750));
        layeredPane.add(bgpanel, Integer.valueOf(0));
        layeredPane.add(titlePanel, Integer.valueOf(1));
        layeredPane.add(selectionPanel, Integer.valueOf(1));
        layeredPane.add(lowerPanel, Integer.valueOf(1));
        layeredPane.add(rightPanel, Integer.valueOf(1));

        // Frame
        frame.setTitle("Vending Machine");
        frame.setIconImage(fruitIcon.getImage());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setContentPane(layeredPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JComboBox<Integer> getDenominations() {
        return denominations;
    }

    public void updateBalanceText(int userBalance){
        userBalanceLabel.setText("Balance: Php "+userBalance);
    }

    public void defaultBalanceText()
    {
        userBalanceLabel.setText("No Balance Yet");
    }


    public void showAddedMoneyText()
    {
        systemMessage.setText("You Have Added: Php " + denominations.getSelectedItem());
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JComboBox<String> getWaterType(){return waterType;}

    public JComboBox<String> getMilkType(){return  milkType;}

    public JComboBox<String> getIceType(){return iceType;}

    public JComboBox<String> getToppingsType(){return toppingsType;}

    public JLabel getSystemMessage(){return systemMessage;}

    public JLabel getUserBalanceLabel(){return userBalanceLabel;}

    public void setFirstFruitsDropDown(ArrayList<String> slotTypes) {
        firstFruitsDropDown.setFocusable(false);
        firstFruitsDropDown.addItem("Choose a fruit...");
        for (String string : slotTypes) {
            firstFruitsDropDown.addItem(string);
        }
    }

    public void setSecondFruitsDropDown(ArrayList<String> slotTypes) {
        secondFruitsDropDown.setFocusable(false);
        secondFruitsDropDown.addItem("Choose a fruit...");
        for (String string : slotTypes) {
            secondFruitsDropDown.addItem(string);
        }
    }

    public void setMilkDropDown(ArrayList<String> slotTypes) {
        milkType.setFocusable(false);
        milkType.addItem("Choose a type of milk...");
        for (String string : slotTypes) {
            milkType.addItem(string);
        }
    }

    public void setWaterDropDown(ArrayList<String> slotTypes) {
        waterType.setFocusable(false);
        waterType.addItem("Choose a type of water...");
        for (String string : slotTypes) {
            waterType.addItem(string);
        }
    }

    public void setIceDropDown(ArrayList<String> slotTypes) {
        iceType.setFocusable(false);
        iceType.addItem("Choose the type of ice to be used...");
        for (String string : slotTypes) {
            iceType.addItem(string);
        }
    }

    public void setToppingsDropDown(ArrayList<String> slotTypes) {
        toppingsType.setFocusable(false);
        toppingsType.addItem("Choose a topping...");
        for (String string : slotTypes) {
            toppingsType.addItem(string);
        }
    }
}
