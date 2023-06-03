package oopits;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Admin extends User{

    private String accessLevel; // # for superuser and $ for normal admin

    public Admin(String[] parts) {
        super(parts);
        accessLevel = parts[4];
    }
    public static int version = 1;
    public String name = "Government";
    public static String desc = "The class ADMIN represent user of the system with higher level of privilege and control over the datas.";
    
    private static void Welcome( String firstName, String lastName ){
        System.out.println("\nSuccessful login.\nWelcome, " + firstName + " " + lastName + ".");
    }
    
    public static void Func(String level) {
        //Welcome(); //runs within login fuction
        // Initializer.status = 0;
        if(level.equals("#")){
        int status = 1;
        while (status==1){
        Helper.funcPrompt("#");
        String x = Initializer.sc.nextLine().toLowerCase();
        if (x.equals("o")) {
            status = 0;
            System.out.println("\nLogged Out");
        } else if (x.equals("l")) {
            Helper.displayTableList();
        } else if (x.equals("c")) {
            Helper.displaySortedByComp();
        } else if (x.equals("m")) {
            Helper.displaySortedByMonth();
        } else if (x.equals("a")) {
            System.out.println("\nCompany name: ");
            String a = Initializer.sc.nextLine();
            System.out.println("Usage: ");
            String b = Initializer.sc.nextLine();
            System.out.println("Month: ");
            String c = Initializer.sc.nextLine();
            Initializer.cList = Arrays.copyOf(Initializer.cList, Initializer.cList.length + 1);
            Initializer.cList[Initializer.cList.length - 1] = new Company(Initializer.cList.length, a, b, c);

        } else if (x.equals("!")) {
            System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
            for(Company a:Initializer.cList){
                double energyUsage = Double.parseDouble(a.usage.split(" ")[0]);
                String wattUsed = a.usage.split(" ")[1];
                if(energyUsage>100 && wattUsed.equals("Gigawatt")){
                    Helper.exceedList(a);}
            }
        } else if (x.equals("su")) {
            Helper.clearScreen();
            Admin.suAdminAccess();
        }
        }
    }
    } 
    
    public static String Auth(){
        String isOK = "";
        System.out.println("\nEnter Username:");
        String userName = Initializer.sc.nextLine();
        /*for(Entry<String, String> m : Initializer.adminMap.entrySet()){
            if (m.getKey().equals(y) && m.getValue().equals(z)){
                isOK=true;
                break;
            } 
        }
        */
        Map<String, Admin> mod_map = FileHandler.loadMod();

        if (!mod_map.containsKey(userName)) {
            System.out.println("\nUsername not found");
            return isOK;
        }

        System.out.println("Enter Password:");
        String password = Initializer.sc.nextLine();

        Admin mod = mod_map.get(userName);

        if ((mod.password).equals(password)) {
            isOK = mod.accessLevel;
            Welcome(mod.firstName, mod.lastName);
            return isOK;
        } else {
            System.out.println("\nIncorrect Password");
            return isOK;
        }
    } 

    private static void suAdminRegistration() {
        String firstName, lastName, userName, password, accessLevel, adminInfo;

        System.out.println("\nCaution! You are trying to add an admin!\n\nType in first name:");
        firstName = Initializer.sc.nextLine();

        System.out.println("\nLast name:");
        lastName = Initializer.sc.nextLine();

        System.out.println("\nAssign a username:");
        userName = Initializer.sc.nextLine();

        System.out.println("\nAssign a password for admin " + userName+":");
        password = Initializer.sc.nextLine();

        
        System.out.println("\n\"#\"SuperAdmin\n\"$\" for Admin\nEnter access level for admin " + userName + ":");
        accessLevel = Initializer.sc.nextLine();
        while (!accessLevel.equals("$") && !accessLevel.equals("#")){
            System.out.println("\n\"#\"SuperAdmin\n\"$\" for Admin\nEnter correct access level for admin " + userName + ":");
                accessLevel = Initializer.sc.nextLine();   
        }
                
        // switch (accessLevel) {
        //     case "$":
        //     case "#":
        //         break;   
        // }
            

        adminInfo = firstName + "," + lastName + "," + userName + "," + password + "," + accessLevel;
        Helper.clearScreen();
        System.out.println(firstName + " " + lastName + " has been successfully as an admin with access level " + accessLevel);

        try {
            FileWriter fileWriter = new FileWriter("src/main/java/oopits/modData.txt", true);
            fileWriter.write(adminInfo + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("An error occured while writing to file");
            e.printStackTrace();
        }

    }

    public static void delUser() {
        Map<String, User> user_map = FileHandler.loadUser();
        String firstName, lastName, userName, password, userInfo;

        System.out.println("\nWarning! You are trying to delete users. \nTHIS IS A PERMENANT OPERATION  \nEnter username of user to delete");
        userName = Initializer.sc.nextLine();

        if (!user_map.containsKey(userName)) {
            System.out.println("User not found");
            return;
            
        }
        User un = user_map.get(userName);
        firstName = un.firstName;
        lastName = un.lastName;
        password = un.password;
        userInfo = firstName + "," + lastName + "," + userName + "," + password;

        try {
            Path inputPath = Path.of("src/main/java/oopits/userData.txt");
            Path tempPath = Path.of("src/main/java/oopits/temp.txt");

            Scanner reader = new Scanner( new File("src/main/java/oopits/userData.txt"));
            StringBuffer buffer = new StringBuffer();
            while (reader.hasNextLine()) {
                buffer.append(reader.nextLine() + "\n");
            }
            String filecontents = buffer.toString();
            filecontents.replaceAll(userInfo, "");
            reader.close();

            FileWriter writer = new FileWriter("src/main/java/oopits/temp.txt");
            writer.append(filecontents);
            writer.flush();
            writer.close();

            Files.delete(inputPath);
            Files.move(tempPath, inputPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\nUser deleted successfully");
            
        } catch (IOException e) {
            System.err.println("Error:" + e.getMessage());
        }
        return;

    }

    //private static String[] Super_Admin = {"admin"};

    private static void suAdminAccess() {
        Map<String, Admin> mod_map = FileHandler.loadMod();
        String userName, password;
        String Access = "#";

        System.out.println("\nTo elevate access to SuperUser \nType your username");
        userName = Initializer.sc.nextLine();

        
        if ((mod_map.containsKey(userName))) {
            Admin mod = mod_map.get(userName);
            
            if ((mod.accessLevel).equals(Access)) {
                System.out.println("\nType your password");
                password = Initializer.sc.nextLine();
            

                try {
                    if ((mod.password).equals(password)) {
                        System.out.println("working"); //testing - debig
                       String input = Initializer.sc.nextLine();
                        switch (input) {
                            case "addAdmin":
                                Helper.clearScreen();
                                Admin.suAdminRegistration();

                            case "delUser":
                                Helper.clearScreen();
                                Admin.delUser();
                    
                            case "exit":
                                Helper.clearScreen();
                               return;

                            default:
                                System.out.println("command not found");
                        }
                    }
                }
                catch (Exception e) {
                System.out.println("Incorrect password");
                e.getMessage();
                }
            }

        } else {
        Helper.clearScreen();
        System.out.println("\nNot enough privelage. SU command will now be exiting");
        return;
        }
    
    }

    
}
