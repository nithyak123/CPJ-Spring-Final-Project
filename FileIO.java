import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The class provides static methods for saving and loading tasks for a specific user to and from a text file
 * @author Nithya Karambakkam
 */

public class FileIO {

    /**
     * saves tasks for param u to a text file
     * @param u the User whose tasks will be saved
     */
    public static void saveTasksToFile(User u){
        String fileName = u.getUsername() + "tasks.txt";
        
        try (FileWriter writer = new FileWriter(fileName)){
            for (Task t : u.getTasks()){
                writer.write(t.fileText() + "\n");
            }
        }
        catch (IOException e){
            System.out.println("There was an error while saving tasks. Try again.");
            System.exit(0);
        }
    }

    /**
     * loads tasks from a text file associated with the user
     * @param username name of the user whose tasks are being loaded
     * @return tasks an ArrayList with the tasks of the user listed in the text file
     * @throws IOException if text file is not found
     */
    public static ArrayList<Task> loadTasksFromFile(String username) throws IOException{
        ArrayList<Task> tasks = new ArrayList<Task>();
        String fileName = username + "tasks.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            
            String line;
            
            String type = "";
            String title = "";
            String description = "";
            String deadline = "";
            int priority = 0;
            
            while ((line = reader.readLine()) != null){
                String[] properties = line.split(",");
                if (properties.length >= 5){
                    type = properties[0];
                    title = properties[1];
                    description = properties[2];
                    deadline = properties[3];
                    priority = Integer.parseInt(properties[4]);
                }
                Task task;
                if (type.equals("work")){
                    task = new WorkTask(title, description, deadline, priority, properties[5]);
                }
                else {
                    task = new Task(type, title, description, deadline, priority);
                }
                tasks.add(task);
            }
        }
        
        /*catch (IOException e){
            System.out.println("\u001B[30mThere was an error while finding your account. Try again.");
            System.exit(0);
        }*/
        return tasks;
    }
    
}
