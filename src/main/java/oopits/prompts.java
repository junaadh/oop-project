package oopits;

import javax.swing.JOptionPane;

public class prompts {
    public static boolean terms() {
        String options[] = {"Cancel", "I agree"};
        int func = JOptionPane.showOptionDialog(null, "Please read through our terms and condtions. \nDo you agree with our terms and conditions?", "terms and condtions", 0, 1, null, options, options);
        switch (func) {
            case 0:
                return false;
        
            case 1:
                return true;

        }
        return false;
    }

    public static void registrationFail(String text) {
        String title = "Registration Error";
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
    }
}
