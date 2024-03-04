import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class PersistenceManager {
    private static final String FILE_NAME = "dictionary.json";
    private static Gson gson = new Gson();

    public static void save(HashMap<String, String> dictionary) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(dictionary, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> load() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type type = new TypeToken<HashMap<String, String>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}