package oopits;

import javax.swing.table.DefaultTableModel;

//import java.io.File;
//import java.io.IOException;

public class Helper {

    private static DefaultTableModel cTable = new DefaultTableModel(
        new Object[] {"ID", "Company", "Usage", "Month" }, 0
    );

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
            x.usageInfo();
        }
        tableLine();
    } 

    public static DefaultTableModel guiDisplayTableList() {
        Company companies[] = Initializer.cList;
        cTable.setRowCount(0);

        for (Company company : companies) {
            cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
        }
        return cTable;
    }
    
    public static void displaySortedByComp(boolean a) {
        System.out.println("\nCompany name: ");
            String b = Initializer.sc.nextLine();
            usageTitle(a);
            tableLine();
            for(Company x:Initializer.cList){
                if(x.getName().equals(b)){
                x.usageInfo();
                }
            }   
            tableLine();
    }

    public static DefaultTableModel guiDisplaySortedByComp( String companyName ) {
        Company companies[] = Initializer.cList;
        cTable.setRowCount(0);

        for (Company company : companies) {
            if(company.getName().equalsIgnoreCase(companyName)) {
                cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
            }
        }
        return cTable;
    }
    
    public static void displaySortedByMonth(boolean a) {
        System.out.println("\nMonth: ");
            String b = Initializer.sc.nextLine();
            usageTitle(a);
            tableLine();
            for(Company x:Initializer.cList){
                if(x.month.equals(b)){
                x.usageInfo();
                }
            }
            tableLine();
    }

    public static DefaultTableModel guiDisplaySortedByMonth( String month ) {
        Company companies[] = Initializer.cList;
        cTable.setRowCount(0);

        for (Company company : companies) {
            if(company.getMonth().equalsIgnoreCase(month)) {
                cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
            }
        }
        return cTable;
    }

    public static DefaultTableModel guiDisplayMisuse() {
        Company companies[] = Initializer.cList;
        cTable.setRowCount(0);

        for (Company company : companies) {
            double energyUsage = Double.parseDouble(company.usage.split(" ")[0]);
            String wattUsed = company.usage.split(" ")[1];
            if (energyUsage > 100 && wattUsed.equals("Gigawatt")) {
                cTable.addRow(new Object[] {company.getID(), company.getName(), company.getUsage(), company.getMonth()});
            }
        }
        return cTable;
    }
    
    public static void exceedList(Company a) {
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
    
}
