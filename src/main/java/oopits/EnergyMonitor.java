package oopits;

public class EnergyMonitor {

    public static void main() {
        Helper.fillAdminMapnWelcome();
        do {
            Helper.mainPrompt();
            String x = Initializer.sc.nextLine().toLowerCase();
            if (x.equals("q")) {
                Initializer.appStatus = 0;
            } else if (x.equals("a")) {
                if (Methods.Auth()) {
                    Methods.AdminFunc();
                }
                ;
            } else if (x.equals("p")) {
                if (Methods.isRegistered()) {
                    LogMan.userLogin();
                    Methods.GuestFunc();
                } else {
                    LogMan.userRegistration();
                }
            } else if (x.equals("api")) {
                API.main();
            } else {
                System.out.println("\nKeyword " + x + " doesn't exist!");
            }
        } while (Initializer.appStatus == 1);
        Initializer.sc.close();
    }

}