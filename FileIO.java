import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    
    public static void saveTasksToFile(User u){
        String fileName = u.getUsername() + "tasks.txt";
        
        try (FileWriter writer = new FileWriter(fileName)){
            for (Task t : u.getTasks()){
                writer.write(t.toString() + "\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("There was an error while saving tasks. Try again.");
        }
    }
}
