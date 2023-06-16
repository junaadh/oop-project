package oopsdg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

//@author LIO WEI XIANG

/*
 * This User file contains the User class. The User class
 * is an integral part of the program, since it defines
 * the attributes and functions that is accessible for the
 * public people account. There are several important methods
 * here. Func() is used for console logic of public user, 
 * which slightly differ with Admin Func(). The Admin in
 * the Func() can edit data, while public people as User 
 * cannot edit data.
 */
public class User {

    public static int version = 1;
    public String firstName, lastName, userName, password;
    public String name = "Public Civilians";
    public static String desc = "The class USER represent all kinds of public user of the system, however, specifically for general people.";

    public User(String[] parts) {
        firstName = parts[0];
        lastName = parts[1];
        userName = parts[2];
        password = parts[3];
    }

    public static boolean login() {
        Helper.clearScreen();
        Map<String, User> user_map = FileHandler.loadUser();
        String username, password;

        System.out.println("\nEnter Username:");
        username = Initializer.sc.nextLine().trim();

        if (!user_map.containsKey(username)) {
            System.out.println("\nThat username doesn't exist!");
            return false;
        }

        System.out.println("Enter password:");
        password = Initializer.sc.nextLine();

        User un = user_map.get(username);

        if ((un.password).equals(password)) {
            Helper.clearScreen();
            Welcome(un.firstName, un.lastName);
            return true;
        } else {
            System.out.println("\nIncorrect Password!");
            return false;
        }
    }

    // Login method used in GUI
    public static String guiLogin(String username, String password) {
        Map<String, User> user_map = FileHandler.loadUser();
        if (!user_map.containsKey(username)) {
            // prompts.wrongUsername();
            return "!username";
        }

        User un = user_map.get(username);

        if ((un.password).equals(password)) {
            // try catch block which create tml file containing username upon login
            try {
                Helper.tempFile = File.createTempFile("temp", "txt");
                FileWriter fileWriter = new FileWriter(Helper.tempFile);
                fileWriter.write(un.userName + ",u");
                fileWriter.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return username;
        } else {
            // prompts.wrongPasssword();
            return "!password";
        }
    }

    public static void register() {
        Helper.clearScreen();
        String firstName, lastName, userName, password, confirmation, userInfo;

        System.out.println("\nWelcome to registration. \n\nEnter first name:");
        firstName = Initializer.sc.nextLine().trim();

        System.out.println("\nEnter last name:");
        lastName = Initializer.sc.nextLine().trim();

        Map<String, User> userMap = FileHandler.loadUser();
        do {
            int count = 0;
            System.out.println("\nEnter username:");
            userName = Initializer.sc.nextLine().trim();
            count++;
            if (count > 0) {
                System.out.println("Username already taken, please choose another username");
            }
        } while (userMap.containsKey(userName));

        System.out.println("\nEnter password:");
        password = Initializer.sc.nextLine();

        System.out.println("\nRetype password:");
        confirmation = Initializer.sc.nextLine();
        while (!password.equals(confirmation)) {
            System.out.println("\nThe password you have entered in incorrect! \nEnter password again:");
            password = Initializer.sc.nextLine();

            System.out.println("\nRetype password:");
            confirmation = Initializer.sc.nextLine();

        }

        System.out.println("\nDo you agree with the Terms and Condition Agreement? (Y/N)");
        String in = Initializer.sc.nextLine().toLowerCase();
        if (in.equals("n")) {
            return;
        }

        userInfo = firstName + "," + lastName + "," + userName + "," + password;
        Helper.clearScreen();
        System.out.println("\nCongratulations! You have successfully signed-up as " + firstName + " " + lastName
                + ". \nYou may continue to login as a user now.");

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/oopsdg/data/userData.txt", true);
            fileWriter.write(userInfo + "\n");
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("An error occured while writing to this file");
            e.printStackTrace();
        }

    }

    // Method used to register user in GUI
    public static void guiRegister(String firstName, String lastName, String username, String password) {
        String userInfo = firstName + "," + lastName + "," + username + "," + password + "\n";

        //adds user info into userData.txt
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/oopsdg/data/userData.txt", true);
            fileWriter.write(userInfo);
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("An error occured while writing to this file");
            e.printStackTrace();
        }

        // creates tmp file upon registration and login
        try {
            Helper.tempFile = File.createTempFile("temp", "txt");
            FileWriter fileWriter = new FileWriter(Helper.tempFile);
            fileWriter.write(username + ",u");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int publicPrompt() {
        System.out.println(
                "\n--------------------------------------------\n| Do you want to login (L) or sign up (S)? |\n--------------------------------------------");
        String x = Initializer.sc.nextLine();
        if ((x.toLowerCase()).equals("l")) {
            return 1;
        } else if ((x.toLowerCase()).equals("s")) {
            return 2;
        }
        return 0;
    }

    public static void Func() {
        int status = 1;
        while (status == 1) {
            boolean mode = Initializer.isEnergy;
            Helper.funcPrompt("",mode);
            String x = Initializer.sc.nextLine().toLowerCase();
            switch (x) {
                case "o":
                    status = 0;
                    Helper.clearScreen();
                    System.out.println("\nLogged Out");
                    break;
                case "l":
                    Helper.clearScreen();
                    Helper.displayTableList(mode);
                    break;
                case "c":
                    Helper.clearScreen();
                    Helper.displaySortedByComp(mode);
                    break;
                case "m":
                    Helper.clearScreen();
                    Helper.displaySortedByMonth(mode);
                    break;
                case "!":
                    Helper.clearScreen();
                    System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
                    for (Company a : Initializer.cList) {
                        double energyUsage = Double.parseDouble(a.energy.split(" ")[0]);
                        String wattUsed = a.energy.split(" ")[1];
                        if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
                            Helper.exceedList(a, mode);
                        }
                    }
                    break;
                case "?":
                    Helper.clearScreen();
                    System.out.println("\nDetails about the company");
                    About.Func();
                    break;
                case "t":
                    Helper.clearScreen();
                    Helper.toggleMode();
                    break;
                default:
                    Helper.noKey(x);
            }

        }
    }

    public static void guiFunc(String option) {
        // Initializer.status = 0;
        int status = 1;
        while (status == 1) {
            boolean mode = Initializer.isEnergy;
            // String x = Initializer.sc.nextLine().toLowerCase();
            switch (option) {
                case "o":
                    status = 0;
                    System.out.println("\nLogged Out");
                    return;
                case "l":
                    Helper.displayTableList(mode);
                    return;
                case "c":
                    Helper.displaySortedByComp(mode);
                    return;
                case "m":
                    Helper.displaySortedByMonth(mode);
                    return;
                case "!":
                    for (Company a : Initializer.cList) {
                        double energyUsage = Double.parseDouble(a.energy.split(" ")[0]);
                        String wattUsed = a.energy.split(" ")[1];
                        if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
                            Helper.exceedList(a, mode);
                        }
                    }
                    return;
                case "t":
                    Helper.toggleMode();
                    break;
            }
        }
    }

    public String getDesc() {
        return desc;
    }

    public static void Welcome(String firstName, String lastName) {
        System.out.println("\nSuccessful login.\nWelcome, " + firstName + " " + lastName + ".");
    }

    public void setDesc(String a) {
        desc = a;
    }
}
