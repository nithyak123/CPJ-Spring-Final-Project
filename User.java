import java.time.*;
import java.util.ArrayList;

public class User {
    
    private String username;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private String[] categories = {"general/other", "work"};
    
    //public User(String username, int dailyGoal){
    public User(String username){
        this.username = username;
    }
    
    //use when loading existing users
    public User(String username, ArrayList<Task> tasks){
        this.username = username;
        this.tasks = tasks;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String[] getCategories(){
        return categories;
    }
    
    public void addTask(Task t){
        tasks.add(t);
    }
    
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    
    public void removeTask(int index){
        tasks.remove(index);
    }
    
    public void completeTask(int index){
        tasks.remove(index);
        //add completion log
    }
}
