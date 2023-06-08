package oopits;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

// import oopits.guiHandlers.listHandler;
import oopits.guiHandlers.welcomeHandler;

public class App{
    public static void main(String[] args) {
        //Helper.clearScreen();
        //EnergyMonitor.StartEngine();
        // new GUI();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new welcomeHandler();
                // new listHandler();
            }
        });

    }
}