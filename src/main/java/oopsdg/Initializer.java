package oopsdg;

//import java.util.HashMap;
/* This is the Initializer file, which help initialize several
key variables that will be used alot in the program, so that
we don't need to do extra work or repeat codes. It also fill
the cList array with company datas. This cList is an integral 
part of the program, since all the company data is derived from
this cList if it wants to be displayed in table console or GUI.
 * 
 */
import java.util.Scanner;

public class Initializer {
    public static int appStatus = 1;
    public static Scanner sc = new Scanner(System.in);
    public static boolean isEnergy = true;

    public static Company[] cList = {
        new Company(1, "Apple Inc.", "350 Megawatt", "January", "150 Kiloton"),
        new Company(2, "Amazon", "750 Gigawatt", "January", "380 Kiloton"),
        new Company(3, "Foxconn", "1.5 Megawatt", "January", "220 Kiloton"),
        new Company(4, "Amazon", "255 Megawatt", "February", "180 Kiloton"),
        new Company(5, "Apple Inc.", "775 Kilowatt", "March", "250 Kiloton"),
        new Company(6, "Koenigsegg", "0.5 Gigawatt", "April", "120 Kiloton"),
        new Company(7, "SpaceX", "255 Gigawatt", "May", "420 Kiloton"),
        new Company(8, "Koenigsegg", "550 Megawatt", "June", "390 Kiloton"),
        new Company(9, "Amazon", "333 Megawatt", "June", "290 Kiloton"),
        new Company(10, "SpaceX", "99 Gigawatt", "June", "160 Kiloton"),
        new Company(11, "Maybank", "10 Megawatt", "July", "70 Kiloton"),
        new Company(12, "Google", "100 Gigawatt", "July", "200 Kiloton"),
        new Company(13, "Meta Inc.", "55 Megawatt", "July", "120 Kiloton"),
        new Company(14, "Google", "85 Gigawatt", "August", "160 Kiloton"),
        new Company(15, "Tesla Inc.", "5 Gigawatt", "November", "110 Kiloton"),
        new Company(16, "Amazon", "275 Megawatt", "November", "200 Kiloton"),
        new Company(17, "Sony Inc.", "2 Gigawatt", "December", "70 Kiloton"),
        new Company(18, "Google", "150 Gigawatt", "December", "270 Kiloton"),
        new Company(19, "Microsoft", "200 Megawatt", "February", "300 Kiloton"),
        new Company(20, "Samsung", "400 Megawatt", "March", "400 Kiloton"),
        new Company(21, "Apple Inc.", "600 Kilowatt", "April", "160 Kiloton"),
        new Company(22, "Google", "450 Gigawatt", "May", "480 Kiloton"),
        new Company(23, "Tesla Inc.", "1.5 Gigawatt", "July", "200 Kiloton"),
        new Company(24, "Sony Inc.", "100 Megawatt", "August", "180 Kiloton"),
        new Company(25, "SpaceX", "400 Gigawatt", "September", "440 Kiloton"),
        new Company(26, "Facebook", "250 Megawatt", "October", "300 Kiloton"),
        new Company(27, "Oracle", "150 Gigawatt", "November", "260 Kiloton"),
        new Company(28, "IBM", "300 Megawatt", "December", "320 Kiloton"),
        new Company(29, "Intel", "200 Megawatt", "January", "240 Kiloton"),
        new Company(30, "HP", "100 Megawatt", "February", "170 Kiloton"),
        new Company(31, "Cisco", "150 Megawatt", "March", "210 Kiloton"),
        new Company(32, "Adobe", "50 Megawatt", "April", "120 Kiloton"),
        new Company(33, "Microsoft", "400 Megawatt", "May", "380 Kiloton"),
        new Company(34, "Apple Inc.", "550 Kilowatt", "June", "180 Kiloton"),
        new Company(35, "Facebook", "300 Megawatt", "August", "290 Kiloton"),
        new Company(36, "Tesla Inc.", "2.5 Gigawatt", "September", "150 Kiloton"),
        new Company(37, "Amazon", "400 Megawatt", "October", "370 Kiloton"),
        new Company(38, "Sony Inc.", "120 Megawatt", "November", "200 Kiloton"),
        new Company(39, "Samsung", "800 Megawatt", "December", "450 Kiloton"),
        new Company(40, "Koenigsegg", "700 Megawatt", "January", "230 Kiloton"),
        new Company(41, "Oracle", "450 Gigawatt", "February", "410 Kiloton"),
        new Company(42, "Intel", "600 Megawatt", "March", "320 Kiloton"),
        new Company(43, "HP", "350 Megawatt", "April", "290 Kiloton"),
        new Company(44, "Meta Inc.", "450 Gigawatt", "June", "480 Kiloton"),
        new Company(45, "Adobe", "200 Megawatt", "August", "250 Kiloton"),
        new Company(46, "Cisco", "350 Gigawatt", "September", "430 Kiloton"),
        new Company(47, "Apple Inc.", "600 Kilowatt", "February", "220 Kiloton"),
        new Company(48, "Amazon", "700 Megawatt", "March", "370 Kiloton"),
        new Company(49, "Foxconn", "1.2 Megawatt", "April", "250 Kiloton"),
        new Company(50, "Apple Inc.", "500 Kilowatt", "August", "150 Kiloton"),
        new Company(51, "Google", "600 Gigawatt", "September", "380 Kiloton"),
        new Company(52, "Microsoft", "800 Megawatt", "December", "250 Kiloton"),
        new Company(53, "Samsung", "600 Megawatt", "February", "280 Kiloton"),
        new Company(54, "Google", "700 Gigawatt", "March", "410 Kiloton"),
        new Company(55, "Tesla Inc.", "2 Gigawatt", "April", "270 Kiloton"),
        new Company(56, "Sony Inc.", "300 Megawatt", "May", "320 Kiloton"),
        new Company(57, "Amazon", "600 Megawatt", "July", "330 Kiloton"),
        new Company(58, "Oracle", "200 Gigawatt", "August", "290 Kiloton"),
        new Company(59, "IBM", "400 Megawatt", "September", "150 Kiloton"),
        new Company(60, "Intel", "250 Megawatt", "October", "210 Kiloton"),
        new Company(61, "HP", "150 Megawatt", "November", "120 Kiloton"),
        new Company(62, "Cisco", "100 Megawatt", "December", "180 Kiloton"),
        new Company(63, "Adobe", "50 Megawatt", "January", "220 Kiloton"),
        new Company(64, "Google", "800 Gigawatt", "April", "390 Kiloton"),
        new Company(65, "Facebook", "400 Megawatt", "May", "330 Kiloton"),
        new Company(66, "Oracle", "350 Gigawatt", "October", "250 Kiloton"),
        new Company(67, "Intel", "300 Megawatt", "November", "290 Kiloton"),
        new Company(68, "HP", "200 Megawatt", "December", "170 Kiloton"),
        new Company(69, "Meta Inc.", "450 Gigawatt", "January", "410 Kiloton"),
        new Company(70, "Maybank", "300 Megawatt", "February", "320 Kiloton"),
        new Company(71, "Adobe", "100 Megawatt", "March", "230 Kiloton"),
        new Company(72, "Cisco", "200 Megawatt", "April", "270 Kiloton"),
        new Company(73, "Apple Inc.", "500 Kilowatt", "May", "360 Kiloton"),
        new Company(74, "Google", "750 Gigawatt", "June", "390 Kiloton"),
        new Company(75, "Facebook", "450 Megawatt", "July", "310 Kiloton"),
        new Company(76, "Tesla Inc.", "2 Gigawatt", "August", "240 Kiloton"),
        new Company(77, "Amazon", "600 Megawatt", "September", "330 Kiloton"),
        new Company(78, "Sony Inc.", "250 Megawatt", "October", "280 Kiloton"),
        new Company(79, "Samsung", "700 Megawatt", "November", "370 Kiloton"),
        new Company(80, "Oracle", "300 Gigawatt", "December", "400 Kiloton"),
        new Company(81, "IBM", "350 Megawatt", "January", "290 Kiloton"),
        new Company(82, "Intel", "400 Megawatt", "February", "350 Kiloton"),
        new Company(83, "HP", "250 Megawatt", "March", "230 Kiloton"),
        new Company(84, "Adobe", "150 Megawatt", "May", "180 Kiloton"),
        new Company(85, "Microsoft", "700 Megawatt", "June", "410 Kiloton"),
        new Company(86, "Apple Inc.", "550 Kilowatt", "July", "320 Kiloton"),
        new Company(87, "SpaceX", "600 Gigawatt", "January", "410 Kiloton"),
        new Company(88, "Facebook", "400 Megawatt", "September", "280 Kiloton"),
        new Company(89, "SpaceX", "600 Gigawatt", "January", "410 Kiloton")

    };
}