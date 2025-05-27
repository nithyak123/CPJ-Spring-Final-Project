import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {
    
    public static void saveTasksToFile(User u){
        String fileName = u.getUsername() + "tasks.txt";
        
        try (FileWriter writer = new FileWriter(fileName)){
            for (Task t : u.getTasks()){
                writer.write(t.fileText() + "\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("There was an error while saving tasks. Try again.");
        }
    }
    
    public static ArrayList<Task> loadTasksFromFile(String username){
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
        
        catch (IOException e){
            e.printStackTrace();
            System.out.println("There was an error while saving tasks. Try again.");
        }
        return tasks;
    }
    
}
