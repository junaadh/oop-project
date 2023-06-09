package oopsdg;

/**
 * @author Junaadh
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class guiHelper {
    // public static boolean checkNoFieldsEmpty( JTextField... values ) {

    //     JTextField[] textFields = new JTextField[5];
    //     if (values.length == 0) {
    //         return false;
    //     } else {
    //         for (JTextField value : values) {
    //             int i = 0;
    //             textFields[i] = value;
    //             i++;
    //         }
    //         for (JTextField textField : textFields) {
    //             if (textField.getText().trim().isEmpty()) {
    //                 return false;
    //             }
    //             return true;
    //         }
        
    //     }
    //     return false;
    // }  

    // public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
    //     Image originalImage = icon.getImage();
    //     Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    //     return new ImageIcon(resizedImage);
    // }

    public static boolean isFileExists(File file) {
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    public static String tempLoginCreds() {
        if (isFileExists(Helper.tempFile)) {
            try {
                FileReader fileReader = new FileReader(Helper.tempFile);
                Scanner reader = new Scanner(fileReader);
                String userInfo = reader.nextLine();
                reader.close();
                return userInfo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return "err";
    }
}
