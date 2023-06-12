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
        System.out.println("Information about Climate Change:\n");
        System.out.println("Climate change refers to long-term shifts in temperature and weather patterns on Earth.\n\nIt is primarily caused by human activities such as burning fossil fuels, deforestation, and industrial processes.\n\nClimate change has significant impacts on ecosystems, weather events, sea levels which in turn cause more harm to the development of society especially at coastal regions and extreme climate locations.");
        System.out.println("");
    }
    
    private static void aboutTheProgram() {
        System.out.println("Information about the Program:\n");
        System.out.println("Our program aims to raise consciousness and educate people about the climate change.\n\nBy providing valuable insights and data, the program helps individuals understand the importance of taking action to mitigate climate change and work towards a sustainable future.\n\nFurthermore, the program allows for transparency of resource used by companies for the greater society.");
        System.out.println("");
    }
    
    private static void aboutUs() {
        System.out.println("Information about Us:\n");
        System.out.println("We are a team of passionate Computer Science undergraduate individuals striving for the best.\n\nOur mission is to inspire, promote hardwork and ethical practices, and encourage initiative action and habits.\n\nThrough this program, we strive to make a positive impact on society and inspire others to join the fight against falsehood.");
        System.out.println("");
    }
}
