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

/**
 *
 * @author Sheridan Sai
 */
public class Admin extends User {
    private String accessLevel; // # for superuser and $ for normal admin

    public Admin(String[] parts) {
        super(parts);
        accessLevel = parts[4];
    }

    public static int version = 1;
    public String name = "Government";
    public static String desc = "The class ADMIN represent user of the system with higher level of privilege and control over the datas.";

    public static void Func(String level) {

        if (level.equals("#")) {
            int status = 1;
            while (status == 1) {
                boolean mode = Initializer.isEnergy;
                Helper.funcPrompt(level);
                String x = Initializer.sc.nextLine().toLowerCase();
                if (x.equals("o")) {
                    status = 0;
                    Helper.clearScreen();
                    System.out.println("\nLogged Out");
                } else if (x.equals("l")) {
                    Helper.displayTableList(mode);
                } else if (x.equals("c")) {
                    Helper.displaySortedByComp(mode);
                } else if (x.equals("m")) {
                    Helper.displaySortedByMonth(mode);
                } else if (x.equals("a")) {
                    addCompany();

                } else if (x.equals("u")){
                    updateCompany();
                
                } else if (x.equals("d")){
                    deleteCompany();
                
                } else if (x.equals("!")) {
                    Helper.clearScreen();
                    System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
                    for (Company a : Initializer.cList) {
                        if (mode) {
                            double energyUsage = Double.parseDouble(a.usage.split(" ")[0]);
                            String wattUsed = a.usage.split(" ")[1];
                            if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
                            } else {
                                double waterUsage = Double.parseDouble(a.usage.split(" ")[0]);
                                String gallonUsed = a.usage.split(" ")[1];
                                if (waterUsage > 100 && gallonUsed.equals("Gallon")) {
                                    Helper.exceedList(a, mode);
                                }
                            }
                        }
                    }
                } else if (x.equals("#")) {
                    Helper.clearScreen();
                    Admin.suAdminFunc();
                } else if (x.equals("t")) {
                    Helper.toggleMode();
                } else if (x.equals("?")) {
                    About.Func();;
                } else {
                    Helper.clearScreen();
                    Helper.NoKey(x);
                }
            }
        } else if (level.equals("$")) {
            int status = 1;
            while (status == 1) {
                boolean mode = Initializer.isEnergy;
                Helper.funcPrompt(level);
                String x = Initializer.sc.nextLine().toLowerCase();
                if (x.equals("o")) {
                    status = 0;
                    Helper.clearScreen();
                    System.out.println("\nLogged Out");
                } else if (x.equals("l")) {
                    Helper.displayTableList(mode);
                } else if (x.equals("c")) {
                    Helper.displaySortedByComp(mode);
                } else if (x.equals("m")) {
                    Helper.displaySortedByMonth(mode);
                } else if (x.equals("a")) {
                addCompany();


                } else if (x.equals("u")){
                    updateCompany();
                
                } else if (x.equals("d")){
                    deleteCompany();
                
                } else if (x.equals("!")) {
                    Helper.clearScreen();
                    System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
                    for (Company a : Initializer.cList) {
                        if (mode) {
                            double energyUsage = Double.parseDouble(a.usage.split(" ")[0]);
                            String wattUsed = a.usage.split(" ")[1];
                            if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
                            } else {
                                double waterUsage = Double.parseDouble(a.usage.split(" ")[0]);
                                String gallonUsed = a.usage.split(" ")[1];
                                if (waterUsage > 100 && gallonUsed.equals("Gallon")) {
                                    Helper.exceedList(a, mode);
                                }

                            }
                        }
                    }
                } else if (x.equals("?")) {
                    About.Func();
                } else {
                    Helper.clearScreen();
                    Helper.NoKey(x);
                }
            }
        }
    }

    public static String Auth() {
        String isOK = "";
        System.out.println("\nEnter Username:");
        String userName = Initializer.sc.nextLine();
        Map<String, Admin> mod_map = FileHandler.loadAdmin();

        if (!mod_map.containsKey(userName)) {
            System.out.println("\nThat username doesn't exist!");
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
            System.out.println("\nIncorrect Password!");
            return isOK;
        }

    }

    private static void suAdminFunc() {
        System.out.println(
                "-------------------------\n| SUPER ADMIN MODE\t|\n|\t\t\t|\n| Press\t\t\t|\n| \"AA\" to add admin,\t|\n| \"D\" to delete user,\t|\n| or \"B\" to go back.\t|\n-------------------------"); // testing
                                                                                                                                                                                                            // -
                                                                                                                                                                                                            // debig
        String input = Initializer.sc.nextLine().toLowerCase();
        switch (input) {
            case "aa":
                Helper.clearScreen();
                Admin.addAdmin();
                break;
            case "d":
                Helper.clearScreen();
                Admin.delUser();
                break;
            case "b":
                Helper.clearScreen();
                break;
            default:
                Helper.NoKey(input);
        }
    }

    private static void addAdmin() {
        String firstName, lastName, userName, password, adminInfo;
        String accessLevel = "$";

        System.out.println("\nCaution! You are trying to add an admin!\n\nType in first name:");
        firstName = Initializer.sc.nextLine();

        System.out.println("\nLast name:");
        lastName = Initializer.sc.nextLine();

        System.out.println("\nAssign a username:");
        userName = Initializer.sc.nextLine();

        System.out.println("\nAssign a password for admin " + userName + ":");
        password = Initializer.sc.nextLine();

        System.out.println("\nAre you sure to add " + userName + "? (Y/N)");
        String in = Initializer.sc.nextLine().toLowerCase();
        if (in.equals("n")) {
            return;
        }
        // switch (accessLevel) {
        // case "$":
        // case "#":
        // break;
        // }

        adminInfo = firstName + "," + lastName + "," + userName + "," + password + "," + accessLevel;
        Helper.clearScreen();
        System.out.println(firstName + " " + lastName + " has successfully become admin.");

        try {
            FileWriter fileWriter = new FileWriter("src/main/java/oopits/data/adminData.txt", true);
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
            Path inputPath = Path.of("src/main/java/oopits/data/userData.txt");
            Path tempPath = Path.of("src/main/java/oopits/data/temp.txt");

            Scanner reader = new Scanner( new File("src/main/java/oopits/data/userData.txt"));
            FileWriter writer = new FileWriter("src/main/java/oopits/data/temp.txt");
            String line;

            while (reader.hasNextLine()) {
                line = reader.nextLine();
                if (!line.equals(userInfo)) {
                    writer.write(line + "\n");
                } 
            }

            reader.close();
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

    public static String guiAuth( String userName, String password) {
        String isOK = "";
        Map<String, Admin> mod_map = FileHandler.loadAdmin();

        if (!mod_map.containsKey(userName)) {
            prompts.wrongUsername();
            return isOK;
        }
        Admin mod = mod_map.get(userName);

        if ((mod.password).equals(password)) {
            isOK = mod.accessLevel;
            return isOK;
        } else {
            prompts.wrongPasssword();
            return isOK;
        }
    }

    public static void addCompany() {
                    Helper.clearScreen();
                    System.out.println("\nCompany name: ");
                    String a = Initializer.sc.nextLine();
                    System.out.println("Usage: ");
                    String b = Initializer.sc.nextLine();
                    System.out.println("Month: ");
                    String c = Initializer.sc.nextLine();
                    Initializer.cList = Arrays.copyOf(Initializer.cList, Initializer.cList.length + 1);
                    Initializer.cList[Initializer.cList.length - 1] = new Company(Initializer.cList.length, a, b, c);
    }

    public static void updateCompany(){
        System.out.println("Input ID of company for which data want to be updated:");
        int a = Initializer.sc.nextInt();
        System.out.println("\nCompany name:");
        String y = Initializer.sc.nextLine();
        y = Initializer.sc.nextLine();
        System.out.println("\nEnergy usage:");
        String c = Initializer.sc.nextLine();
        System.out.println("\nMonth:");
        String d = Initializer.sc.nextLine();
        for (Company x : Initializer.cList){
            if (a == x.getID()){
                x.name= y;
                x.usage=c;
                x.month=d;
            }
        }
    }

    public static void deleteCompany() {
        Helper.clearScreen();
        int inc = 0;
        System.out.println("Input ID to delete company:");
        int x = Initializer.sc.nextInt();
        Company[] temp = new Company[Initializer.cList.length-1];
        for (Company y : Initializer.cList){
            if(y.id<x){
                temp[inc]= y;
                inc++;
            } else if (y.id>x){
                temp[inc]= y;
                temp[inc].id = temp[inc].id-1;
                inc++;
            }
        }
        Initializer.cList=new Company[temp.length];
        for(int a =0;a<temp.length;a++){
            Initializer.cList[a]=temp[a];
        }
    }
}
