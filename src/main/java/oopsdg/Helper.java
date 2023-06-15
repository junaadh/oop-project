package oopsdg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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


/*This Helper file contains a lot of methods that are used
in the same file or other files. This way, we are implementing
DRY method of programming, stands for Don't Repeat Yourself.
If we don't define the methods here and write it manually instead
in every place we called it, then the code could be much bigger in
lines and much more complicated. So we just defined them here and
called them. We also give a good, human-friendly method names.
 * 
 */


public class Helper {

    public static File tempFile;

    // private static DefaultTableModel cTable = new DefaultTableModel(
    //     new Object[] {"ID", "Company", "Usage", "Month" }, 0
    // );

    public static void mainPrompt() {
        System.out.println("\n----------------------------------------------------------------------------------------------\n| Press \"A\" for admin, \"P\" for public guest, \"?\" for about, \"C\" for credits, or \"Q\" to quit. |\n----------------------------------------------------------------------------------------------");
    }
    
    public static void funcPrompt(String a, boolean b) {
        if(b){
        if (a.equals("#")){
            System.out.println("\n-----------------------------\n| Energy Mode\t\t    |\n|\t\t\t    |\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"U\" to update data,\t    |\n| \"D\" to delete data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"T\" to toggle mode,\t    |\n| \"#\" for SUPERADMIN mode,  |\n| \"?\" for about,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a.equals("$")){
            System.out.println("\n-----------------------------\n| Energy Mode\t\t    |\n|\t\t\t    |\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"U\" to update data,\t    |\n| \"D\" to delete data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"T\" to toggle mode,\t    |\n| \"?\" for about,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a.equals("")){
            System.out.println("\n-----------------------------\n| Energy Mode\t\t    |\n|\t\t\t    |\n| Press\t\t\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"T\" to toggle mode,\t    |\n| \"?\" for about,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        }} else {
            if (a.equals("#")){
            System.out.println("\n-----------------------------\n| Water Mode\t\t    |\n|\t\t\t    |\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"U\" to update data,\t    |\n| \"D\" to delete data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"T\" to toggle mode,\t    |\n| \"#\" for SUPERADMIN mode,  |\n| \"?\" for about,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a.equals("$")){
            System.out.println("\n-----------------------------\n| Water Mode\t\t    |\n|\t\t\t    |\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"U\" to update data,\t    |\n| \"D\" to delete data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"T\" to toggle mode,\t    |\n| \"?\" for about,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a.equals("")){
            System.out.println("\n-----------------------------\n| Water Mode\t\t    |\n|\t\t\t    |\n| Press\t\t\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| \"T\" to toggle mode,\t    |\n| \"?\" for about,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        }
        }
    }
    
    public static void usageTitle(boolean a) {
        if (a) {
            System.out.println("\n----------------\n| Energy Usage |\n----------------");
        } else {
            System.out.println("\n---------------\n| Water Usage |\n---------------");
        }
    }
    
    public static void usageList(String[] a, boolean b) {
        if (b) {
            System.out.printf("| Company: %s\tUsage: %s\tMonth: %s\t|\n", a[0],a[1],a[2]);
        } else {
            System.out.printf("| Company: %s\tConsumption: %s\tMonth: %s\t|\n", a[0],a[1],a[2]);
        }
    }
    
    public static void tableLine(boolean a) {
        System.out.println("----------------------------------------------------------------------------------");
    }

    public static void toggleMode() {
        Initializer.isEnergy = !Initializer.isEnergy;
    }

    public static void BigWelcome() {
    System.out.println("\n\n\n\n#################################################\n#                                               #\n#\tWelcome to Climate Change Monitor\t#\n#                                               #\n#################################################\n\n\n");
    }
    
    public static void displayTableList(boolean a) {
        usageTitle(a);
        tableLine(a);
        for(Company x:Initializer.cList){
            x.usageInfo(a);
        }
        tableLine(a);
    } 

    public static void displaySortedByComp(boolean a) {
        System.out.println("\nCompany name: ");
            String b = Initializer.sc.nextLine();
            usageTitle(a);
            tableLine(a);
            for(Company x:Initializer.cList){
                if(x.getName().toLowerCase().equals(b.toLowerCase())){
                x.usageInfo(a);
                }
            }   
            tableLine(a);
    }

    public static void displaySortedByMonth(boolean a) {
        System.out.println("\nMonth: ");
            String b = Initializer.sc.nextLine();
            usageTitle(a);
            tableLine(a);
            for(Company x:Initializer.cList){
                if(x.month.toLowerCase().equals(b.toLowerCase())){
                x.usageInfo(a);
                }
            }
            tableLine(a);
    }
    
    public static void exceedList(Company a, boolean b) {
        if(b){
        System.out.printf("# Company %s has exceeded green energy limit on %s!\n", a.getName(),a.month);
        } else {
        System.out.printf("# Company %s has exceeded water consumption limit on %s!\n", a.getName(),a.month);
        }
    }
    
    public static void noKey(String a) {
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

    // method which creates a tmp file in system tmp files to stoer user and admin lgin sessions
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

    // method which gets users full name from adminData.txt
    public static String getFullName( String username ) {
        Map<String, User> user_map = FileHandler.loadUser();

        User u = user_map.get(username);
        String fullname = u.firstName + " " + u.lastName;
        return fullname;
    }

    // method which gets admins full name from adminData.txt
    public static String getAdminName( String username ) {
        Map<String, Admin> admin_map = FileHandler.loadAdmin();

        Admin a = admin_map.get(username);
        String fullname = a.firstName + " " + a.lastName;
        return fullname;
        
    }

    private static final int TOAST_DURATION = 3000;

    // method which creates a floating toast message
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

    // method which fades and translates object in javafx
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

    // method which translates and fades object in javafx
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

    // creates list filtered by company name 
    public static Company[] filterArrayByColumnName(Company[] array, String selectedValue) {
        List<Company> filteredList = new ArrayList<>();
        for (Company company : array) {
            String companyName = company.getName();
            if (companyName.equals(selectedValue)) {
                filteredList.add(company);
            }
        }
        return filteredList.toArray(new Company[0]);
    }

    // creates list filtered by month 
    public static Company[] filteredArrayByMonth( Company[] array, String selectedMonth ) {
        List<Company> filteredList = new ArrayList<>();
        for (Company company : array) {
            if (company.getMonth().equals(selectedMonth)) {
                filteredList.add(company);
            }
        }
        return filteredList.toArray(new Company[0]);
    }   

    // creates list filtered by usage 
    public static Company[] filteredArrayByUsage(Company[] array) {
        List<Company> filteredList = new ArrayList<>();
        for (Company company : array) {
            double usage = Double.parseDouble(company.getUsage().split(" ")[0]);
            String watt = company.getUsage().split(" ")[1];
            if (usage > 100 && watt.equals("Gigawatt")) {
                filteredList.add(company);
            }
        }
        return filteredList.toArray(new Company[0]);
    }
}
