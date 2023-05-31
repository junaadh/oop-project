package oopits;

import java.util.HashMap;
import java.util.Scanner;

public class Initializer {
    public static int appStatus = 1;
    public static HashMap<String,String> adminMap = new HashMap<String,String>();
    public static Scanner sc = new Scanner(System.in);
    public static String[][] dataList = {
        {"Apple Inc.", "350 Megawatt","January"},
        {"Amazon", "750 Gigawatt","January"},
        {"Foxconn","1.5 Megawatt","January"},
        {"Amazon", "255 Megawatt","February"},
        {"Apple Inc.","775 Kilowatt","March"},
        {"Koenigsegg","0.5 Gigawatt","April"},
        {"SpaceX","255 Gigawatt","May"},
        {"Koenigsegg","550 Megawatt","June"},
        {"Amazon", "333 Megawatt","June"},
        {"SpaceX","99 Gigawatt","June"},
        {"Maybank","10 Megawatt","July"},
        {"Google","100 Gigawatt","July"},
        {"Meta Inc.","55 Megawatt","July"},
        {"Google","85 Gigawatt","August"},
        {"Sony Inc.","1 Gigawatt","October"},
        {"Tesla Inc.","5 Gigawatt","November"},
        {"Amazon", "275 Megawatt","November"},
        {"Sony Inc.","2 Gigawatt","December"},
        {"Google","150 Gigawatt","December"},
    };
}
