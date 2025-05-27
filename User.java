public class User {
    
    private String username;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    
    public User(String username, int dailyGoal){
        this.username = username;
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
