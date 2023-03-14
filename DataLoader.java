import java.io.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Jordan's super swaggin Data Loader class
 */
public class DataLoader {

    public static void LoadUsers() {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID uuid = (UUID) (json.get("id"));
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = (Date) json.get("DateOfBirth");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void LoadAuthors() {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID uuid = (UUID) (json.get("id"));
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = (Date) json.get("DateOfBirth");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void LoadCourses() {
        JSONParser parser = new JSONParser();

        try {     
            JSONArray arr = (JSONArray) parser.parse(new FileReader("json/users.json"));
            
            for(Object obj : arr) {
                JSONObject json =  (JSONObject) obj;

                UUID uuid = (UUID) (json.get("id"));
                String firstName = (String) json.get("firstName");
                String lastName = (String) json.get("lastName");
                String email = (String) json.get("email");
                String phone = (String) json.get("phone");
                String username = (String) json.get("userName");
                String password = (String) json.get("password");
                Date dateOfBirth = (Date) json.get("DateOfBirth");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }
}