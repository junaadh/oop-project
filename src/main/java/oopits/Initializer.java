package oopits;

//import java.util.HashMap;
import java.util.Scanner;

public class Initializer {
    public static int appStatus = 1;
    //public static HashMap<String,String> adminMap = new HashMap<String,String>();
    public static Scanner sc = new Scanner(System.in);
    public static boolean isEnergy = true;

    public static Company[] cList = {
        new Company(1, "Apple Inc.", "350 Megawatt", "January"),
        new Company(2, "Amazon", "750 Gigawatt", "January"),
        new Company(3, "Foxconn", "1.5 Megawatt", "January"),
        new Company(4, "Amazon", "255 Megawatt", "February"),
        new Company(5, "Apple Inc.", "775 Kilowatt", "March"),
        new Company(6, "Koenigsegg", "0.5 Gigawatt", "April"),
        new Company(7, "SpaceX", "255 Gigawatt", "May"),
        new Company(8, "Koenigsegg", "550 Megawatt", "June"),
        new Company(9, "Amazon", "333 Megawatt", "June"),
        new Company(10, "SpaceX", "99 Gigawatt", "June"),
        new Company(11, "Maybank", "10 Megawatt", "July"),
        new Company(12, "Google", "100 Gigawatt", "July"),
        new Company(13, "Meta Inc.", "55 Megawatt", "July"),
        new Company(14, "Google", "85 Gigawatt", "August"),
        new Company(15, "Sony Inc.", "1 Gigawatt", "October"),
        new Company(16, "Tesla Inc.", "5 Gigawatt", "November"),
        new Company(17, "Amazon", "275 Megawatt", "November"),
        new Company(18, "Sony Inc.", "2 Gigawatt", "December"),
        new Company(19, "Google", "150 Gigawatt", "December"),
        new Company(20, "Microsoft", "200 Megawatt", "February"),
        new Company(21, "Samsung", "400 Megawatt", "March"),
        new Company(22, "Apple Inc.", "600 Kilowatt", "April"),
        new Company(23, "Google", "450 Gigawatt", "May"),
        new Company(24, "Amazon", "300 Megawatt", "June"),
        new Company(25, "Tesla Inc.", "1.5 Gigawatt", "July"),
        new Company(26, "Sony Inc.", "100 Megawatt", "August"),
        new Company(27, "SpaceX", "400 Gigawatt", "September"),
        new Company(28, "Facebook", "250 Megawatt", "October"),
        new Company(29, "Oracle", "150 Gigawatt", "November"),
        new Company(30, "IBM", "300 Megawatt", "December"),
        new Company(31, "Intel", "200 Megawatt", "January"),
        new Company(32, "HP", "100 Megawatt", "February"),
        new Company(33, "Cisco", "150 Megawatt", "March"),
        new Company(34, "Adobe", "50 Megawatt", "April")


    };
}