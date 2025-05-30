import java.time.*;
import java.util.ArrayList;

public class Task
{
    protected String type;
    protected String title;
    protected String description;
    protected String deadline;
    protected int priority;
    
    public Task(String type, String title, String description, String deadline, int priority){
        type = this.type;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
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
    
    public String getBlurb(){
        return type + "task. " + "\"" + title + "\"" + " (Priority: " + priority + ", due " + deadline + ")";
    }
    
    //format it is saved in the txt file with (comma delimiter)
    public String fileText(){
        return type + "," + title + "," + description + "," + deadline + "," + priority;
    }
    
    public String toString(){
        return type + " task | " + title + " | Priority " + priority + " | Due " + deadline + "\nDescription: " + description; 
    }
    
}
