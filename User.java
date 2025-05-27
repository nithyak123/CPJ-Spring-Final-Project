//WIP

public class User {
    
    private String user;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private int[][] dailyCompletion;
    private int counter; //counts the daily tasks
    
    public User(String user, int dailyGoal){
        this.user = user;
        dailyCompletion = new int[dailyGoal];
        counter = 0;
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
        if (counter < dailyCompletion.length')
        dailyCompletion[counter] = 1;
        counter++;
    }
    
}
