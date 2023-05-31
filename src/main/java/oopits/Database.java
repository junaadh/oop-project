package oopits;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database {
    public static Map<String, User> load() {
        Map<String, User> user_map = new HashMap<String, User>();
        try {
            Scanner data_store = new Scanner(new File("src/main/java/oopits/assets/database.txt"));

            while (data_store.hasNextLine()) {
                String[] splitString = data_store.nextLine().split(",");
                User u = new User(splitString);
                user_map.put(u.userName, u);
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return user_map;
    }
}
