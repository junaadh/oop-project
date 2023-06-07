package oopits;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import oopits.guiHandlers.welcomeHandler;

//commented out version to test regitrationHandler

public class App{
    public static void main(String[] args) {
        // Helper.clearScreen();
        // EnergyMonitor.StartEngine();
        // new GUI();
        //new registrationHandler();
        //new creditsHandler();
        // new welcomeHandler();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new welcomeHandler();
            }
        });

    }
}