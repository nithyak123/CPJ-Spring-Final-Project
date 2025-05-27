import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    
    public static void saveTasksToFile(User u){
        String fileName = "tasks.txt";
        
        try (FileWriter writer = new FileWriter(fileName)){
            //write stuff in here
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
