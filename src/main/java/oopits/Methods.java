package oopits;

import java.util.Arrays;
import java.util.Map;

public class Methods {
    public static boolean Auth(){
        boolean isOK = false;
        System.out.println("\nEnter Username:");
        String y = Initializer.sc.nextLine();
        System.out.println("Enter Password:");
        String z = Initializer.sc.nextLine();
        for(Map.Entry m : Initializer.adminMap.entrySet()){
            if (m.getKey().equals(y) && m.getValue().equals(z)){
                isOK=true;
                break;
            } 
        }
        if (isOK==false){
            System.out.println("\nWrong Username or Password!");
        }
        return isOK;
    }
    public static void GuestFunc() {
        Helper.welcome("public");
        // Initializer.status = 0;
        int status = 1;
        while (status==1){
        Helper.funcPrompt(2);
        String x = Initializer.sc.nextLine().toLowerCase();
        if (x.equals("o")){
            status=0;
            System.out.println("\nLogged Out");
        } else if (x.equals("l")){
            Helper.usageTitle();
            Helper.tableLine();
            for(String[] a:Initializer.dataList){
                Helper.usageList(a);
            }
            Helper.tableLine();
        } else if (x.equals("c")){
            System.out.println("\nCompany name: ");
            String b = Initializer.sc.nextLine();
            Helper.usageTitle();
            Helper.tableLine();
            for(String[] a:Initializer.dataList){
                if(a[0].equals(b)){
                Helper.usageList(a);}
            }
            Helper.tableLine();

        } else if (x.equals("m")){
            System.out.println("\nMonth: ");
            String b = Initializer.sc.nextLine();
            Helper.usageTitle();
            Helper.tableLine();
            for(String[] a:Initializer.dataList){
                if(a[2].equals(b)){
                Helper.usageList(a);}
            }
            Helper.tableLine();

        } else if (x.equals("!")){
            System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
            for(String[] a:Initializer.dataList){
                double energyUsage = Double.parseDouble(a[1].split(" ")[0]);
                String monthUsed = a[1].split(" ")[1];
                if(energyUsage>100 && monthUsed.equals("Gigawatt")){
                    Helper.exceedList(a);
                }
            }
        }
    }
   } 
    public static void AdminFunc() {
    Helper.welcome("admin");
    // Initializer.status = 0;
    int status = 1;
    while (status==1){
    Helper.funcPrompt(1);
    String x = Initializer.sc.nextLine().toLowerCase();
    if (x.equals("o")){
        status=0;
        System.out.println("\nLogged Out");
    } else if (x.equals("l")){
        Helper.usageTitle();
        Helper.tableLine();
        for(String[] a:Initializer.dataList){
            Helper.usageList(a);
        }
        Helper.tableLine();
    } else if (x.equals("c")){
        System.out.println("\nCompany name: ");
        String b = Initializer.sc.nextLine();
        Helper.usageTitle();
        Helper.tableLine();
        for(String[] a:Initializer.dataList){
            if(a[0].equals(b)){
                Helper.usageList(a);;}
        }
        Helper.tableLine();

    } else if (x.equals("m")){
        System.out.println("\nMonth: ");
        String b = Initializer.sc.nextLine();
        Helper.usageTitle();
        Helper.tableLine();
        for(String[] a:Initializer.dataList){
            if(a[2].equals(b)){
                Helper.usageList(a);}
        }
        Helper.tableLine();

    } else if (x.equals("a")){
        System.out.println("\nCompany name: ");
        String a = Initializer.sc.nextLine(); 
        System.out.println("Usage: ");
        String b = Initializer.sc.nextLine(); 
        System.out.println("Month: ");
        String c = Initializer.sc.nextLine();
        Initializer.dataList = Arrays.copyOf(Initializer.dataList, Initializer.dataList.length+1);
        Initializer.dataList[Initializer.dataList.length-1] = new String[3];
        Initializer.dataList[Initializer.dataList.length-1][0]=a; 
        Initializer.dataList[Initializer.dataList.length-1][1]=b;  
        Initializer.dataList[Initializer.dataList.length-1][2]=c; 
    } else if (x.equals("!")){
        System.out.println("\n-------------------\n<  !!!WARNING!!!  >\n-------------------");
        for(String[] a:Initializer.dataList){
            double energyUsage = Double.parseDouble(a[1].split(" ")[0]);
            String monthUsed = a[1].split(" ")[1];
            if(energyUsage>100 && monthUsed.equals("Gigawatt")){
                Helper.exceedList(a);}
        }
    }
}
} 
}
