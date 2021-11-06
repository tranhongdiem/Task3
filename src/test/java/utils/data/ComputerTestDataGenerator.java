package utils.data;

import com.google.gson.Gson;
import testdata.purchasing.ComputerDataObject;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComputerTestDataGenerator {

    public static ComputerDataObject[] getTestDataFrom(String jsonDataFileLocation) {
        ComputerDataObject[] cheapComputers = new ComputerDataObject[]{};
        try {
            // create Gson instance
            Gson gson = new Gson();

            // Read file content
            String currentProjectLocation = System.getProperty("user.dir");
            Reader reader = Files.newBufferedReader(Paths.get(currentProjectLocation + jsonDataFileLocation));

            // Convert to array of Computer instances
            cheapComputers = gson.fromJson(reader, ComputerDataObject[].class);

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cheapComputers;
    }

}
