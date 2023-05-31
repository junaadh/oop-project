package oopits;

public class Helper {

    public static void mainPrompt() {
        System.out.println(
                "\n--------------------------------------------------------------\n| Press \"A\" for admin, \"P\" for public guest, or \"Q\" to quit. |\n--------------------------------------------------------------");
    }

    public static void funcPrompt(int a) {
        if (a == 1) {
            System.out.println(
                    "\n-----------------------------\n| Press\t\t\t    |\n| \"A\" to add data,\t    |\n| \"L\" to see list,\t    |\n| \"C\" to filter by company, |\n| \"M\" to filter by month,   |\n| \"!\" to check bad use,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        } else if (a == 2) {
            System.out.println(
                    "\n-----------------------------\n| Press\t\t\t    |\n| \"L\" to see list,\t    |\n| \"C\" to filter by company, |\n| \"M\" to filter by month,   |\n| \"!\" to check bad use,\t    |\n| or \"O\" to log out.\t    |\n-----------------------------");
        }
    }

    public static void usageTitle() {
        System.out.println("\n----------------\n| Energy Usage |\n----------------");
    }

    public static void tableLine() {
        System.out.println("-----------------------------------------------------------------");
    }

    public static void usageList(String[] a) {
        System.out.printf("| Company: %s\tUsage: %s\tMonth: %s\t|\n", a[0], a[1], a[2]);
    }

    public static void exceedList(String[] a) {
        System.out.printf("# Company %s has exceeded green energy limit on %s!\n", a[0], a[2]);
    }

    public static void fillAdminMapnWelcome() {
        Initializer.adminMap.put("Admin", "Admin");
        Initializer.adminMap.put("ElonMusk", "Roadster");
        Initializer.adminMap.put("Arell", "IsCool");
        // System.out.println("\n-------------------------------------------------\n|\tWelcome
        // to Climate Change
        // Monitor\t|\n-------------------------------------------------");
        System.out.println(
                "\n\n\n\n#################################################\n#                                               #\n#\tWelcome to Climate Change Monitor\t#\n#                                               #\n#################################################\n\n\n");
    }

    public static void welcome(String a) {
        if (a.equals("admin")) {
            System.out.println("\nSuccessful login.\nWelcome, admin.");
        } else if (a.equals("public")) {
            System.out.println("\nWelcome, public guest.");
        }

    }

}
