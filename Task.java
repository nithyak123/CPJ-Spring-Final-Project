public class Task
{
    private String type;
    private String title;
    private String description;
    private String deadline;
    private int priority;
    
    public Task(String type, String title, String description, String deadline, int priority){
        type = "general";
        this.title;
        this.description;
        this.deadline;
        this.priority;
    }
    
    //date parsing
    public LocalDate getDueDateAsLocalDate(){
        return LocalDate.parse(deadline);
    }
    
    //getters
    public String getType(){
        return type;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getDeadline(){
        return deadline;
    }
    public int getPriority(){
        return priority;
    }
    //setters
    public void setTitle(String s){
        title = s;
    }
    public void setDescription(String s){
        description = s;
    }
    public void setDeadline(String s){
        deadline = s;
    }
    public void setPriority(int s){
        priority = s;
    }
    
    public String toString(){
        return title + " | Priority " + priority + " | Due " + deadline + "\nDescription: " + description; 
    }
    
}
