package oopits;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class LogMan {
    public static void userLogin() {
        Map<String, User> user_map = Database.load();

        String username, password;

        System.out.println("\nEnter Username");
        username = Initializer.sc.nextLine();

        if (!user_map.containsKey(username)) {
            System.out.println("\nThat username doesnt exist");
            System.exit(0);
        }

        System.out.println("\nEnter password");
        password = Initializer.sc.nextLine();

        User un = user_map.get(username);

        if ((un.password).equals(password)) {
            System.out.println("\nSuccessfully logged in");
            System.out.println("\nWelcome " + un.firstName + " " + un.lastName);
        } else {
            System.out.println("\nIncorrect Password");

        }
    }

    public static void userRegistration() {
        String firstName, lastName, userName, password, confirmation, userInfo;

        System.out.println("\nWelcome to registration \nEnter your first name");
        firstName = Initializer.sc.nextLine();

        System.out.println("\nEnter your last name");
        lastName = Initializer.sc.nextLine();

        System.out.println("\nEnter your username");
        userName = Initializer.sc.nextLine();

        System.out.println("\nEnter your password");
        password = Initializer.sc.nextLine();

        System.out.println("\nRetype your password");
        confirmation = Initializer.sc.nextLine();
        while (!password.equals(confirmation)) {
            System.out.println("\nThe password you have entered in incorrect! \nEnter your password again");
            password = Initializer.sc.nextLine();

            System.out.println("\nRetype your password");
            confirmation = Initializer.sc.nextLine();

        }

        userInfo = firstName + "," + lastName + "," + userName + "," + password;
        System.out.println("\nCongratulations! You have cuccessfully signed-up " + firstName + " " + lastName
                + ". \nYou may continue to login as a user now.");

        try {
            FileWriter fileWriter = new FileWriter("src/main/java/oopits/assets/database.txt", true);
            fileWriter.write(userInfo + "\n");
            fileWriter.close();

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("An error while writing to this file");
            e.printStackTrace();
        }

    }

}
