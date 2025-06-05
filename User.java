import java.time.*;
import java.util.ArrayList;

/**
 * objects of the class represent a user in the task management system, as well as their associated tasks and data
 * @author Nithya Karambakkam
 */

public class User {
    
    private String username;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private String[] categories = {"general/other", "work"};

    /**
     * constructs a new User with specified username
     * @param username the name specified by the user
     */
    //public User(String username, int dailyGoal){
    public User(String username){
        this.username = username;
    }

    /**
     * overloaded constructor used when the tasks and user already exist
     * @param username the name of user
     * @param tasks associated tasks
     */
    //use when loading existing users
    public User(String username, ArrayList<Task> tasks){
        this.username = username;
        this.tasks = tasks;
    }

    /**
     * username getter
     * @return username the user's name
     */
    public String getUsername(){
        return username;
    }

    /**
     * returns types of categories
     * @return categories the list of categories for tasks (general and work)
     */
    public String[] getCategories(){
        return categories;
    }

    /**
     * add a task to the account
     * @param t the Task to be added
     */
    public void addTask(Task t){
        tasks.add(t);
    }

    /**
     * returns current tasks
     * @return tasks the ArrayList which contains all of the user's tasks
     */
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    /**
     * removes a task of choice from the account
     * @param index the index of the element to be removed from tasks
     */
    public void removeTask(int index){
        tasks.remove(index);
    }

}
