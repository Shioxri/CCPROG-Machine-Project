package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.Border;

/**
 * This class represents the graphical user interface (GUI) for the special vending machine buy menu.
 * It provides options for the user to select various fruits, water, milk, ice, and toppings to create a fruit shake.
 * The user can add money, make a purchase, and cancel the order.
 */
public class SpecialBuy {
    // Declare and initialize the GUI components
    // JFrame and various buttons, dropdowns, and labels
    // Also, arrays to store total price and total calories for each selected item.
    // These will be used to calculate the overall total price and total calories.
    private JFrame frame = new JFrame();
    private JButton buyButton = new JButton();
    private JButton addButton = new JButton();
    private JButton exitButton = new JButton();
    private JComboBox<String> waterType = new JComboBox<>();
    private JComboBox<String> milkType = new JComboBox<>();
    private JComboBox<String> iceType = new JComboBox<>();
    private JComboBox<String> toppingsType = new JComboBox<>();
    JLabel systemMessage = new JLabel();
    JLabel userBalanceLabel = new JLabel();
    JLabel orderLabel = new JLabel();
    JLabel infoLabel = new JLabel();
    JButton cancelButton = new JButton();

    JComboBox<String> firstFruitsDropDown;
    JComboBox<String> secondFruitsDropDown;
    JComboBox<Integer> denominations;
    private int[] totalPrice = {0,0,0,0,0,0};
    private int[] totalCals = {0,0,0,0,0,0};

    /**
     * Constructor for the SpecialBuy class.
     * Initializes the GUI by calling the init() method.
     */
    public SpecialBuy() {
        init();
    }



    /**
     * Initializes the graphical user interface (GUI) components and sets up the special vending machine buy menu view.
     * Creates various panels and adds components to them, sets their properties, and arranges them using layout managers.
     * The GUI is composed of background images, labels, dropdowns, buttons, and panels.
     */
    private void init() {
        // This method sets up the graphical user interface (GUI) components.
        // It creates various panels and adds components to them, sets their properties,
        // and arranges them using layout managers.
        // The GUI is composed of background images, labels, dropdowns, buttons, and panels.
        JLabel titleLabel = new JLabel();
        JPanel titlePanel = new JPanel();
        JPanel selectionPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        firstFruitsDropDown = new JComboBox<>();
        secondFruitsDropDown = new JComboBox<>();
        denominations = new JComboBox<>(new Integer[]{1, 5, 10, 20, 50, 100});
        denominations.setBounds(10,110,120,25);




        // Images
        ImageIcon fruitIcon = new ImageIcon("assets/pixelatedfruit.png");
        ImageIcon titleIcon = new ImageIcon("assets/SPECIALVM1.png");
        ImageIcon sampleBG = new ImageIcon("assets/VM.gif");
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



        systemMessage.setBounds(10, 8, 530, 110);
        systemMessage.setHorizontalAlignment(JLabel.CENTER);
        systemMessage.setVerticalAlignment(JLabel.CENTER);
        systemMessage.setBackground(new Color(0, 0, 0));
        systemMessage.setBorder(borderLinegrayl);
        systemMessage.setForeground(Color.WHITE);
        systemMessage.setOpaque(true);
        systemMessage.setText("<html>Welcome to our [Special] Vending Machine!<br/>" +
                "Select your favorite fruits to create a delicious fruit shake!");



        defaultBalanceText();
        userBalanceLabel.setBounds(10, 50, 180, 50);
        userBalanceLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
        userBalanceLabel.setForeground(Color.white);
        userBalanceLabel.setHorizontalAlignment(JLabel.CENTER);
        userBalanceLabel.setVerticalAlignment(JLabel.CENTER);
        userBalanceLabel.setBorder(borderLine);
        userBalanceLabel.setBackground(Color.black);
        userBalanceLabel.setOpaque(true);


        orderLabel.setBounds(10, 150, 180, 200);
        orderLabel.setForeground(Color.WHITE);
        orderLabel.setBackground(Color.BLACK);
        orderLabel.setBorder(borderLinegrayl);
        orderLabel.setOpaque(true);
        orderLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));

        infoLabel.setBounds(10, 355, 180, 200);

        infoLabel.setForeground(Color.WHITE);
        infoLabel.setBackground(Color.BLACK);
        infoLabel.setBorder(borderLinegrayl);
        infoLabel.setOpaque(true);
        infoLabel.setFont(new Font("Century Gothic", Font.BOLD, 11));
        setDefaultLabels();
        // Buttons

        buyButton.setToolTipText("Buy Item");
        buyButton.setBounds(10, 560, 180, 50);
        buyButton.setText("Buy");
        buyButton.setHorizontalAlignment(JButton.CENTER);


        addButton.setBounds(140, 110, 50, 25);
        addButton.setText("+");
        addButton.setHorizontalAlignment(JButton.CENTER);


        cancelButton.setToolTipText("Cancel Order");
        cancelButton.setBounds(10, 620, 180, 50);
        cancelButton.setText("Cancel Order");
        cancelButton.setHorizontalAlignment(JButton.CENTER);



        exitButton.setBounds(10, 700, 180, 25);
        exitButton.setHorizontalAlignment(JButton.CENTER);
        exitButton.setText("Go Back");


        // Dropdowns
        denominations.setFocusable(false);
        denominations.setToolTipText("Choose Denomination");
        denominations.setBounds(10, 110, 120, 25);

        firstFruitsDropDown.setFocusable(false);
        firstFruitsDropDown.setToolTipText("First Fruit");
        firstFruitsDropDown.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        firstFruitsDropDown.setBounds(25, 75, 240, 50);



        secondFruitsDropDown.setFocusable(false);
        secondFruitsDropDown.setToolTipText("Second Fruit");
        secondFruitsDropDown.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        secondFruitsDropDown.setBounds(285, 75, 240, 50);



        waterType.setFocusable(false);
        waterType.setToolTipText("Water type");
        waterType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        waterType.setBounds(25, 140, 500, 50);



        milkType.setFocusable(false);
        milkType.setToolTipText("Milk type");
        milkType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        milkType.setBounds(25, 205, 500, 50);




        iceType.setFocusable(false);
        iceType.setToolTipText("Ice type");
        iceType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        iceType.setBounds(25, 270, 500, 50);




        toppingsType.setFocusable(false);
        toppingsType.setToolTipText("Toppings");
        toppingsType.setAlignmentX(JComboBox.CENTER_ALIGNMENT);
        toppingsType.setBounds(25, 335, 500, 50);

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
        rightPanel.add(orderLabel);
        rightPanel.add(infoLabel);
        rightPanel.add(buyButton);
        rightPanel.add(addButton);
        rightPanel.add(cancelButton);
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



    // Updates the user balance label with the given value.
    public void updateBalanceText(int userBalance){
        userBalanceLabel.setText("Balance: Php "+userBalance);
    }

    // Resets the user balance label to its default text.
    public void defaultBalanceText()
    {
        userBalanceLabel.setText("No Balance Yet");
    }

    // Displays a system message indicating the amount of money added.
    public void showAddedMoneyText()
    {
        systemMessage.setText("You Have Added: Php " + denominations.getSelectedItem());
    }

    // Sets the default text for the infoLabel and orderLabel components.
    // These labels provide information about the selected items and the order details.
    public void setDefaultLabels() {
        String defaultInfoText = "<html>Item Details" +
                "<br/>Price | Calories | Stock<br/>" +
                "<br/>First Fruit: " +
                "<br/>Second Fruit: " +
                "<br/>Water Type: " +
                "<br/>Milk Type " +
                "<br/>Ice Type:" +
                "<br/>Toppings: </html>";
        infoLabel.setText(defaultInfoText);

        String defaultOrderText = "<html>Order Details<br/>Price: " +
                "<br/>Calories: " +
                "<br/>Selected Items:<br/>" +
                "<br/>First Fruit: " +
                "<br/>Second Fruit: " +
                "<br/>Water Type: " +
                "<br/>Milk Type " +
                "<br/>Ice Type:" +
                "<br/>Toppings: </html>";
        orderLabel.setText(defaultOrderText);
    }

    /**
     * Getter method to access the JFrame from other classes.
     *
     * @return The JFrame instance.
     */
    public JFrame getFrame() {
        return frame;
    }
    /**
     * Getter method to access the "Exit" button from other classes.
     *
     * @return The "Exit" button.
     */
    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JComboBox<String> getFirstFruitsDropDown() {
        return firstFruitsDropDown;
    }

    public JComboBox<String> getSecondFruitsDropDown() {
        return secondFruitsDropDown;
    }

    public JComboBox<String> getWaterType(){return waterType;}

    public JComboBox<String> getMilkType(){return  milkType;}

    public JComboBox<String> getIceType(){return iceType;}

    public JComboBox<String> getToppingsType(){return toppingsType;}

    public JLabel getSystemMessage(){return systemMessage;}
    /**
     * Getter method to access the denominations dropdown from other classes.
     *
     * @return The denominations dropdown.
     */
    public JComboBox<Integer> getDenominations() {
        return denominations;
    }
    /**
     * Getter method to access the orderLabel which displays order details.
     *
     * @return The orderLabel.
     */
    public JLabel getOrderLabel(){return orderLabel;}

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
        iceType.addItem("Choose the type of ice...");
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

    public JButton getCancelButton() {
        return cancelButton;
    }
    /**
     * Getter method to access the infoLabel which displays item details.
     *
     * @return The infoLabel.
     */
    public JLabel getInfoLabel(){return infoLabel;}

    // Calculates the total price by summing up the prices of individual items.
    /**
     * Calculates the total price by summing up the prices of individual items.
     *
     * @return The total price.
     */
    public int getTotalPrice() {
        int sum=0;
        for (int j : totalPrice) {
            sum += j;
        }
        return sum;
    }
    // Calculates the total calories by summing up the calories of individual items.
    /**
     * Calculates the total calories by summing up the calories of individual items.
     *
     * @return The total calories.
     */
    public int getTotalCals() {
        int sum=0;
        for (int j : totalCals) {
            sum += j;
        }
        return sum;
    }

    // Adds the given value to the total price array at the specified index.
    public void addToTotalPrice(int value, int index)
    {
        totalPrice[index] = value;
    }
    // Adds the given value to the total calories array at the specified index.
    public void addToTotalCals(int value, int index)
    {
        totalCals[index] = value;
    }
    // Resets the total price array to all zeros.
    public void resetTotalPrice()
    {
        for(int i = 0; i<6; i++)
        {
            totalPrice[i]=0;
        }
    }
    // Resets the total calories array to all zeros.
    public void resetTotalCals()
    {
        for(int i = 0; i<6; i++)
        {
            totalCals[i]=0;
        }
    }

}
