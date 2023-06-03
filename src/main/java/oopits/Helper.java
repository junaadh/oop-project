package oopits;

//import java.io.File;
//import java.io.IOException;

public class Helper {

    public static void mainPrompt() {
        System.out.println("\n--------------------------------------------------------------\n| Press \"A\" for admin, \"P\" for public guest, or \"Q\" to quit. |\n--------------------------------------------------------------");
    }
    public static void funcPrompt(int a) {
        if (a==1){
            System.out.println("\n-----------------------------\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a==2){
            System.out.println("\n-----------------------------\n| Press\t\t\t    |\n| \"L\" to see list,\t    |\n| \"C\" to search by company, |\n| \"M\" to search by month,   |\n| \"!\" to check bad use,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        }
    }
    public static void usageTitle() {
        System.out.println("\n----------------\n| Energy Usage |\n----------------");
    }
    public static void tableLine() {
        System.out.println("----------------------------------------------------------------------------------");
    }
    public static void usageList(String[] a) {
        System.out.printf("| Company: %s\tUsage: %s\tMonth: %s\t|\n", a[0],a[1],a[2]);
    }
    public static void fillAdminMapnWelcome() {
    //Initializer.adminMap.put("Admin", "Admin");
    //Initializer.adminMap.put("Arell", "IsCool");
    //Initializer.adminMap.put("Ahmad", "IsNotCool");
    // System.out.println("\n-------------------------------------------------\n|\tWelcome to Climate Change Monitor\t|\n-------------------------------------------------");
    System.out.println("\n\n\n\n#################################################\n#                                               #\n#\tWelcome to Climate Change Monitor\t#\n#                                               #\n#################################################\n\n\n");
    }
    public static void displayTableList() {
        usageTitle();
        tableLine();
        for(Company x:Initializer.cList){
            x.usageInfo();
        }
        tableLine();
    } 
    public static void displaySortedByComp() {
        System.out.println("\nCompany name: ");
            String b = Initializer.sc.nextLine();
            usageTitle();
            tableLine();
            for(Company a:Initializer.cList){
                if(a.name.equals(b)){
                a.usageInfo();
                }
            }   
            tableLine();
    }
    public static void displaySortedByMonth() {
        System.out.println("\nMonth: ");
            String b = Initializer.sc.nextLine();
            usageTitle();
            tableLine();
            for(Company a:Initializer.cList){
                if(a.month.equals(b)){
                a.usageInfo();
                }
            }
            tableLine();
    }
    public static void exceedList(Company a) {
        System.out.printf("# Company %s has exceeded green energy limit on %s!\n", a.name,a.month);
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
    
}
