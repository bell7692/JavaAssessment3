package user_management;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserCollectionInitializer {
    private static String filename = "/Users/bolee/Dev/Week_7/JavaAssessment3/src/main/resources/users.json";

    public UserCollectionInitializer() throws FileNotFoundException{

    }

    public static UserCollection generate() throws FileNotFoundException {
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new FileReader(filename));

        UserCollection users = gson.fromJson(reader, UserCollection.class);

        return users;
    }
}
