package oopits;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

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
        username = Initializer.sc.nextLine();

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
            System.out.println("\nIncorrect Password");
            return false;
        }
    }

    public static void register() {
        Helper.clearScreen();
        String firstName, lastName, userName, password, confirmation, userInfo;

        System.out.println("\nWelcome to registration. \n\nEnter first name:");
        firstName = Initializer.sc.nextLine();

        System.out.println("\nEnter last name:");
        lastName = Initializer.sc.nextLine();

        System.out.println("\nEnter username:");
        userName = Initializer.sc.nextLine();

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
        if (in.equals("n")){
            return;
        }

        userInfo = firstName + "," + lastName + "," + userName + "," + password;
        Helper.clearScreen();
        System.out.println("\nCongratulations! You have successfully signed-up as " + firstName + " " + lastName
                + ". \nYou may continue to login as a user now.");

        try {
            FileWriter fileWriter = new FileWriter("src/main/java/oopits/userData.txt", true);
            fileWriter.write(userInfo + "\n");
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("An error occured while writing to this file");
            e.printStackTrace();
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

    /*
     * private static void Welcome() {
     * System.out.println("\nWelcome, public guest.");
     * }
     */
    public static void Func() {
        // Initializer.status = 0;
        int status = 1;
        while (status == 1) {
            Helper.funcPrompt("");
            String x = Initializer.sc.nextLine().toLowerCase();
            switch (x) {
                case "o":
                    status = 0;
                    Helper.clearScreen();
                    System.out.println("\nLogged Out");
                    break;
                case "l":
                    Helper.clearScreen();
                    Helper.displayTableList();
                    break;
                case "c":
                    Helper.clearScreen();
                    Helper.displaySortedByComp();
                    break;
                case "m":
                    Helper.clearScreen();
                    Helper.displaySortedByMonth();
                    break;
                case "!":
                    System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
                    for (Company a : Initializer.cList) {
                        double energyUsage = Double.parseDouble(a.usage.split(" ")[0]);
                        String wattUsed = a.usage.split(" ")[1];
                        if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
                            Helper.clearScreen();
                            Helper.exceedList(a);
                        }
                    }
            }

        }
    }

    public String getDesc() {
        return desc;
    }

    private static void Welcome( String firstName, String lastName ){
        System.out.println("\nSuccessful login.\nWelcome, " + firstName + " " + lastName + ".");
    }

    public void setDesc(String a) {
        desc = a;
    }
}
