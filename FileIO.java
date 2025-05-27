import java.io.FileWriter;
import java.io.IOException;

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
            while (line = reader.readLine() != null){
                String[] properties = line.split(",");
                if (parts.length >= 5){
                    String type = parts[0];
                    String title = parts[1];
                    String description = parts[2];
                    String deadline = parts[3];
                    int priority = Integer.parseInt(parts[4]);
                }
                Task task;
                if (type.equals("work")){
                    task = new WorkTask(title, description, deadline, priority, parts[5]);
                }
                else if (type.equals("general")){
                    task = new Task(title, description, deadline, priority);
                }
                tasks.add(task);
            }
        }
        
        catch (IOException e){
            e.printStackTrace();
            System.out.println("There was an error while saving tasks. Try again.");
        }
        
        //try: making a buffered reader with parameters of new file reader with file name
            //while line is not null (read with readLine())
            //split into parts using delimiter
            //create empty task
            //if type is work, initialize a work task
            //if type is general, initialize a task
            //add the task to tasks
        //catch: io exception
            //same content as the other one lol
    }
}
