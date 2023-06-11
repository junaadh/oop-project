package oopsdg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

//import java.io.File;
//import java.io.IOException;

public class Helper {

    public static File tempFile;

    // private static DefaultTableModel cTable = new DefaultTableModel(
    //     new Object[] {"ID", "Company", "Usage", "Month" }, 0
    // );

    public static void mainPrompt() {
        System.out.println("\n--------------------------------------------------------------\n| Press \"A\" for admin, \"P\" for public guest, or \"Q\" to quit. |\n--------------------------------------------------------------");
    }
    
    public static void funcPrompt(String a) {
        if (a.equals("#")){
            System.out.println("\n-----------------------------\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"#\" for SUPERADMIN mode,  |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a.equals("$")){
            System.out.println("\n-----------------------------\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a.equals("")){
            System.out.println("\n-----------------------------\n| Press\t\t\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        }
    }
    
    public static void usageTitle(boolean a) {
        if (a) {
            System.out.println("\n---------------------\n| Energy Usage |\n---------------------");
        } else {
            System.out.println("\n-----------------\n| Water Usage |\n-----------------");
        }
    }
    
    public static void usageList(String[] a, boolean b) {
        if (b) {
            System.out.printf("| Company: %s\tUsage: %s\tMonth: %s\t|\n", a[0],a[1],a[2]);
        } else {
            System.out.printf("| Company: %s\tConsumption: %s\tMonth: %s\t|\n", a[0],a[1],a[2]);
        }
    }
    
    public static void tableLine() {
        System.out.println("----------------------------------------------------------------------------------");
    }

    public static void toggleMode() {
        Initializer.isEnergy = !Initializer.isEnergy;
    }

    public static void BigWelcome() {
    //Initializer.adminMap.put("Admin", "Admin");
    //Initializer.adminMap.put("Arell", "IsCool");
    //Initializer.adminMap.put("Ahmad", "IsNotCool");
    // System.out.println("\n-------------------------------------------------\n|\tWelcome to Climate Change Monitor\t|\n-------------------------------------------------");
    System.out.println("\n\n\n\n#################################################\n#                                               #\n#\tWelcome to Climate Change Monitor\t#\n#                                               #\n#################################################\n\n\n");
    }
    
    public static void displayTableList(boolean a) {
        usageTitle(a);
        tableLine();
        for(Company x:Initializer.cList){
            x.usageInfo(a);
        }
        tableLine();
    } 
    
    public static void displaySortedByComp(boolean a) {
        System.out.println("\nCompany name: ");
            String b = Initializer.sc.nextLine();
            usageTitle(a);
            tableLine();
            for(Company x:Initializer.cList){
                if(x.getName().equals(b)){
                x.usageInfo(a);
                }
            }   
            tableLine();
    }

    // public static DefaultTableModel guiDisplaySortedByComp( String companyName ) {
    //     Company companies[] = Initializer.cList;
    //     cTable.setRowCount(0);

    //     for (Company company : companies) {
    //         if(company.getName().equalsIgnoreCase(companyName)) {
    //             cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
    //         }
    //     }
    //     return cTable;
    // }
    
    public static void displaySortedByMonth(boolean a) {
        System.out.println("\nMonth: ");
            String b = Initializer.sc.nextLine();
            usageTitle(a);
            tableLine();
            for(Company x:Initializer.cList){
                if(x.month.equals(b)){
                x.usageInfo(a);
                }
            }
            tableLine();
    }

    // public static DefaultTableModel guiDisplaySortedByMonth( String month ) {
    //     Company companies[] = Initializer.cList;
    //     cTable.setRowCount(0);

    //     for (Company company : companies) {
    //         if(company.getMonth().equalsIgnoreCase(month)) {
    //             cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
    //         }
    //     }
    //     return cTable;
    // }

    // public static DefaultTableModel guiDisplayMisuse() {
    //     Company companies[] = Initializer.cList;
    //     cTable.setRowCount(0);

    //     for (Company company : companies) {
    //         double energyUsage = Double.parseDouble(company.usage.split(" ")[0]);
    //         String wattUsed = company.usage.split(" ")[1];
    //         if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
    //             cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
    //         }
    //     }
    //     return cTable;
    // }
    
    public static void exceedList(Company a, boolean b) {
        System.out.printf("# Company %s has exceeded green energy limit on %s!\n", a.getName(),a.month);
    }
    
    public static void NoKey(String a) {
        if (a.equals("")){
            System.out.println("\nKeyword" + a + " doesn't exist!");
            return ;
        } 
        System.out.println("\nKeyword " + a + " doesn't exist!");
    }
    
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    public static String tempLoginCreds() {
            try {
                FileReader fileReader = new FileReader(Helper.tempFile);
                Scanner reader = new Scanner(fileReader);
                String userInfo = reader.nextLine();
                reader.close();
                return userInfo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return "err";
    }

    public static String getFullName( String username ) {
        Map<String, User> user_map = FileHandler.loadUser();

        User u = user_map.get(username);
        String fullname = u.firstName + " " + u.lastName;
        return fullname;
    }

    public static String getAdminName( String username ) {
        Map<String, Admin> admin_map = FileHandler.loadAdmin();

        Admin a = admin_map.get(username);
        String fullname = a.firstName + " " + a.lastName;
        return fullname;
        
    }

    // public static void storeTempLogin( String username ) {
    //     try {
    //         Helper.tempFile = File.createTempFile("temp", "txt");
    //         FileWriter fileWriter = new FileWriter(Helper.tempFile);
    //         fileWriter.write(username);
    //         fileWriter.close();
    //     } catch (IOException e) {
    //         System.err.println(e.getMessage());
    //     }
    // }

    private static final int TOAST_DURATION = 3000;

    public static void showFloatingToast(Stage ownerStage, String message, String cssStyle) {
        Stage toastStage = new Stage();
    
        Platform.setImplicitExit(false);

        toastStage.initOwner(ownerStage);
        toastStage.setResizable(false);
        toastStage.setAlwaysOnTop(true);
        toastStage.setWidth(300);

        Label toastLabel = new Label(message);
        if (cssStyle != null) {
            toastLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-padding: 10px;" + null);
            
        } else {
            toastLabel.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-padding: 10px;");
            
        }
        toastLabel.setWrapText(true);
        toastLabel.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(toastLabel);
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5); -fx-padding: 10px; -fx-background-radius: 10px;");

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        toastStage.initStyle(StageStyle.TRANSPARENT);
        toastStage.setScene(scene);

        toastStage.setOnShown(event -> {
            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), root);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);

            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), root);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setDelay(Duration.millis(TOAST_DURATION));
            fadeOut.setOnFinished(e -> toastStage.close());

            fadeIn.play();
            fadeOut.play();
        });

        toastStage.show();
    }

    public static void fadeAndTranslate(Button button, double fadeInDuration, double translateDuration,
            double translateX, double translateY, double startOpacity, double endOpacity) {
        // Fade-in animation
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(fadeInDuration), button);
        fadeTransition.setFromValue(startOpacity);
        fadeTransition.setToValue(endOpacity);

        // Translate animation
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(translateDuration), button);
        translateTransition.setByX(translateX);
        translateTransition.setByY(translateY);

        // Play animations sequentially
        fadeTransition.setOnFinished(event -> translateTransition.play());
        fadeTransition.play();
    }
    public static void translateAndFade(Button button, double fadeInDuration, double translateDuration,
            double translateX, double translateY, double startOpacity, double endOpacity) {
        // Fade-in animation
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(fadeInDuration), button);
        fadeTransition.setFromValue(startOpacity);
        fadeTransition.setToValue(endOpacity);

        // Translate animation
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(translateDuration), button);
        translateTransition.setByX(translateX);
        translateTransition.setByY(translateY);

        // Play animations sequentially
        translateTransition.setOnFinished(event -> fadeTransition.play());
        translateTransition.play();
    }
}
