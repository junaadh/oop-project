package oopsdg;

//@author leron
public class About {
    public static void Func() {
        Helper.clearScreen();
        boolean status = true;
        while (status) {
            System.out.println("----------------------------");
            System.out.println("| Select\t\t   |");
            System.out.println("| About Climate Change (C) |");
            System.out.println("| About the Program (P)    |");
            System.out.println("| About Us (U)\t\t   |");
            System.out.println("| Back (B)\t\t   |");
            System.out.println("----------------------------");
            
            String choice = Initializer.sc.nextLine().toLowerCase();
            
            switch (choice) {
                case "c":
                    Helper.clearScreen();
                    aboutClimateChange();
                    break;
                case "p":
                    Helper.clearScreen();
                    aboutTheProgram();
                    break;
                case "u":
                    Helper.clearScreen();
                    aboutUs();
                    break;
                case "b":
                    Helper.clearScreen();
                    status = false;
                    break;
                default:
                    Helper.clearScreen();
                    Helper.NoKey(choice);
            }
        }
    }
    
    private static void aboutClimateChange() {
        System.out.println("\nInformation about Climate Change:");
        // Add your climate change information here
    }
    
    private static void aboutTheProgram() {
        System.out.println("\nInformation about the Program:");
        // Add your program information here
    }
    
    private static void aboutUs() {
        System.out.println("\nInformation about Us:");
        // Add your about us information here
    }
}
