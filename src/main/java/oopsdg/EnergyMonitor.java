package oopsdg;

 

public class EnergyMonitor{
    // made by zameer

 

    public static void StartEngine() {
    Helper.BigWelcome();
    do {
        Helper.mainPrompt();
        String x = Initializer.sc.nextLine().toLowerCase();
        if (x.equals("q")){
            Initializer.appStatus=0;
            System.exit(1);
        } else if (x.equals("a")){
            Helper.clearScreen();
            Admin.Func(Admin.Auth());

 

        } else if (x.equals("p")){
            Helper.clearScreen();
            // switch (User.publicPrompt()){ 
            //     case 1:
            //         if(User.login()){
                    User.Func();
                //     Helper.clearScreen();
                //     }  
                //     break;
                // case 2:
                //     User.register();
                //     break;}
        } /*else if(x.equals("api")){API.main(); } */
        else if (x.equals("?")) {
            Helper.clearScreen();
            About.Func();
        }
        else if (x.equals("c")){
            Helper.clearScreen();
            System.out.println("\n######################\n#       CREDIT       #\n#\t\t     #\n# Special Thanks To: #\n# Arell\t\t     #\n# Zameer\t     #\n# Jonathan\t     #\n# Junaadh\t     #\n# Leron\t\t     #\n# Ahmad\t\t     #\n# Evan\t\t     #\n# Naeema\t     #\n# Michael\t     #\n# Sheridan\t     #\n######################");
        }
        else {
            Helper.noKey(x);
        }
    } while (Initializer.appStatus == 1);
    Initializer.sc.close();

    }
}