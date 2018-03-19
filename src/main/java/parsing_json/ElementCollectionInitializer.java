package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ElementCollectionInitializer {

   private static String filename = "/Users/bolee/Dev/Week_7/JavaAssessment3/src/main/resources/periodic_table.json";


    public ElementCollectionInitializer() throws FileNotFoundException {

    }


    public static ElementCollection generate() throws FileNotFoundException {
         Gson gson = new Gson();

         JsonReader reader = new JsonReader(new FileReader(filename));

         ElementCollection elements = gson.fromJson(reader, ElementCollection.class);

      //  System.out.println(elements.get(0).getName().toString());
        return elements;
    }
}
