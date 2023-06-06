package oopits;

//@author leron
//lerons part part file handler//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {
    
    public static Map<String, User>  loadUser() {
        Map<String, User> user_map = new HashMap<String, User>();
        try {
            Scanner data_store = new Scanner (new File("src/main/java/oopits/data/userData.txt"));

            while (data_store.hasNextLine()) {
                String[] splitString = data_store.nextLine().split (",");
                User u = new User(splitString);
                user_map.put(u.userName, u);
            }
        } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
        }
        return user_map;
    }

    public static Map<String, Admin> loadAdmin() {
        Map<String, Admin> mod_map = new HashMap<String, Admin>();
        try {
            Scanner mod_list = new Scanner(new File("src/main/java/oopits/data/adminData.txt"));

            while (mod_list.hasNextLine()) {
                String[] modString = mod_list.nextLine().split(",");
                Admin mod = new Admin(modString);
                mod_map.put(mod.userName, mod);

            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return mod_map;
    }


}