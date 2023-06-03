package oopits;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

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
    public static void Func() {
        //Welcome(); //runs within login fuction
        // Initializer.status = 0;
        int status = 1;
        while (status==1){
        Helper.funcPrompt(1);
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
            Admin.superAdminAccess();
        }
    }
    } 
    public static boolean Auth(){
        boolean isOK = false;
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
            isOK = true;
            Welcome(mod.firstName, mod.lastName);
            return isOK;
        } else {
            System.out.println("\nIncorrect Password");
            return isOK;
        }
    } 

    private static void suAdminRegistration() {
        String firstName, lastName, userName, password, accessLevel, adminInfo;

        System.out.println("\nWarning! You are trying to add users as admins. \nType in first name of employee");
        firstName = Initializer.sc.nextLine();

        System.out.println("\nType in last name of employee");
        lastName = Initializer.sc.nextLine();

        System.out.println("\nAssign a username for user");
        userName = Initializer.sc.nextLine();

        System.out.println("\nAssign a password for user: " + userName);
        password = Initializer.sc.nextLine();

        
        System.out.println("\nSet an access level for user: " + userName + ".\n\"#\" for SuperAdmin / \"$\" for Admin");
        accessLevel = Initializer.sc.nextLine();
                
        switch (accessLevel) {
            case "$":
            case "#":
                break;
        
            default:
                System.out.println("\nEnter a correct symbol for access for " + userName + "\n\"#\" for SuperAdmin / \"$\" for Admin");
                accessLevel = Initializer.sc.nextLine();     
        }
            

        adminInfo = firstName + "," + lastName + "," + userName + "," + password + "," + accessLevel;
        Helper.clearScreen();
        System.out.println(firstName + " " + lastName + " has been successfully as an admin with access level " + accessLevel);

        try {
            FileWriter fileWriter = new FileWriter("./modData.txt", true);
            fileWriter.write(adminInfo + "\n");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("An error occured while writing to file");
            e.printStackTrace();
        }

    }
    //private static String[] Super_Admin = {"admin"};

    private static void superAdminAccess() {
        Map<String, Admin> mod_map = FileHandler.loadMod();
        String userName, password;
        String Access = "#";

        System.out.println("\nTo elevate access to SuperUser \nType your username");
        userName = Initializer.sc.nextLine();

        Admin mod = mod_map.get(userName);
        
        if (((mod.userName).equals(userName)) && ((mod.accessLevel).equals(Access))) {
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
                    
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                System.err.println("Please check if the admin has enough privilages");
                e.getMessage();
            }
        } else {
        Helper.clearScreen();
        System.out.println("\nIncorrect password. SU command will now be exiting");
        Admin.Func();
        }
    }

    
}
