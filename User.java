public class User {
    
    private String user;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    
    public User(String user, int dailyGoal){
        this.user = user;
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
