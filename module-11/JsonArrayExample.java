/*
 * Mark White
 * CSD420
 * Assignment11.2
 * JavaJSON example
 * The sample demonstrates how to build and print a JSON array of user objects
 using JSON-java. The code constructs two individual JSONObject instances and
  adds them to a JSONArray, which is then formatted and printed to the console. 
 */


import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArrayExample {
    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();

        JSONObject user1 = new JSONObject();
        user1.put("id", 1);
        user1.put("username", "alice");

        JSONObject user2 = new JSONObject();
        user2.put("id", 2);
        user2.put("username", "bob");

        jsonArray.put(user1);
        jsonArray.put(user2);

        System.out.println(jsonArray.toString(4));
    }
}

// Reference:(GitHub, 2024)