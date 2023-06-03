package oopits;

public class EnergyMonitor{

    public static void StartEngine() {
    Helper.fillAdminMapnWelcome();
    do {
        Helper.mainPrompt();
        String x = Initializer.sc.nextLine().toLowerCase();
        if (x.equals("q")){
            Initializer.appStatus=0;
        } else if (x.equals("a")){
            if(Admin.Auth()){
                Admin.Func();
            };
        } else if (x.equals("p")){
            Helper.clearScreen();
            switch (User.publicPrompt()){ 
                case 1:
                    if(User.login()){
                    User.Func();
                    Helper.clearScreen();
                    }  
                    break;
                case 2:
                    User.register();
                    break;}
        } /*else if(x.equals("api")){
            API.main();
        } */else {
            System.out.println("\nKeyword " + x + " doesn't exist!");
        }
    } while (Initializer.appStatus == 1);
    Initializer.sc.close();
    }
}