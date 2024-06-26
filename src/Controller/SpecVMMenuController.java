package Controller;

import Model.SpecialVendingMachine;
import View.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The SpecVMMenuController class handles the actions and navigation for the special vending machine menu.
 */
public class SpecVMMenuController implements ActionListener {
    private SpecialVMMenu specialVMMenu;

    /**
     * Constructs the SpecVMMenuController with the specified SpecialVMMenu, MainMenuController, and SpecialVendingMachine.
     *
     * @param specialVMMenu       The SpecialVMMenu to associate with the controller.
     * @param mainMenuController  The MainMenuController to handle main menu navigation.
     * @param vendingMachine      The SpecialVendingMachine representing the special vending machine.
     */
    public SpecVMMenuController(SpecialVMMenu specialVMMenu, MainMenuController mainMenuController, SpecialVendingMachine vendingMachine) {
        this.specialVMMenu = specialVMMenu;

        // ActionListener for the "Use Vending Machine" button
        specialVMMenu.getUseVMButton().addActionListener(e -> {
            playButtonClickSound();
            specialVMMenu.getFrame().setVisible(false);
            SpecialBuy specialBuyMenu = new SpecialBuy();
            SpecialBuyController specialBuyController =
                    new SpecialBuyController(specialBuyMenu, this, vendingMachine);
            specialBuyMenu.getFrame().setVisible(true);
        });

        // ActionListener for the "Maintenance" button
        specialVMMenu.getMaintenanceButton().addActionListener(e -> {
            playButtonClickSound();
            specialVMMenu.getFrame().setVisible(false);
            SpecialMaintenance specialMaintenanceMenu = new SpecialMaintenance();
            SpecMaintenanceController specMaintenanceController =
                    new SpecMaintenanceController(specialMaintenanceMenu, this, vendingMachine);
            specialMaintenanceMenu.getFrame().setVisible(true);
        });

        // ActionListener for the "Back" button
        specialVMMenu.getBackButton().addActionListener(e -> {
            playButtonClickSound();
            specialVMMenu.getFrame().setVisible(false);
            mainMenuController.getMainMenuGUI().getFrame().setVisible(true);
        });
    }

    /**
     * Returns the SpecialVMMenu associated with this controller.
     *
     * @return The SpecialVMMenu.
     */
    public SpecialVMMenu getSpecialVMMenu() {
        return specialVMMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No action required for the special vending machine menu
    }

    /**

     Plays a button click sound when the button is clicked.
     The sound is played from the "assets/sfx.wav" file.
     If an error occurs while playing the sound, the exception is printed to the standard error stream.

     */
    private void playButtonClickSound() {
        try {
            File soundFile = new File("assets/sfx.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
