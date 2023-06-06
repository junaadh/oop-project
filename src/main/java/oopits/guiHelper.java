package oopits;

import java.awt.Image;

import javax.swing.ImageIcon;

// created by @junaadh at 20230606 05:33.

import javax.swing.JTextField;

public class guiHelper {
    public static boolean checkNoFieldsEmpty( JTextField... values ) {

        JTextField[] textFields = new JTextField[5];
        if (values.length == 0) {
            return false;
        } else {
            for (JTextField value : values) {
                int i = 0;
                textFields[i] = value;
                i++;
            }
            for (JTextField textField : textFields) {
                if (textField.getText().trim().isEmpty()) {
                    return false;
                }
                return true;
            }
        
        }
        return false;
    }  

    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

}
