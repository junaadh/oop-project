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
                    Helper.noKey(choice);
            }
        }
    }
    
    private static void aboutClimateChange() {
        System.out.println("Information about Climate Change:");
        System.out.println("Climate change refers to long-term shifts in temperature and weather patterns on Earth. It is primarily caused by human activities such as burning fossil fuels, deforestation, and industrial processes. Climate change has significant impacts on ecosystems, weather events, sea levels which in turn cause more harm to the development of society especially at coastal regions and extreme climate locations.");
    }
    
    private static void aboutTheProgram() {
        System.out.println("Information about the Program:");
        System.out.println("Our program aims to raise awareness and educate people about the causes, effects, and solutions to climate change. By providing valuable insights and data, the program helps individuals understand the importance of taking action to mitigate climate change and work towards a sustainable future.");
    }
    
    private static void aboutUs() {
        System.out.println("Information about Us:");
        System.out.println("We are a team of passionate individuals dedicated to addressing climate change. Our mission is to spread awareness, promote sustainable practices, and encourage collective action. Through this program, we strive to make a positive impact on the environment and inspire others to join the fight against climate change.");
    }
}
