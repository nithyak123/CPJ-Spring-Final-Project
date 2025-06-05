import java.time.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/**
 * represents a basic Task and attributes, as well as helper methods
 * @author Nithya Karambakkam
 */

public class Task
{
    protected String type;
    protected String title;
    protected String description;
    protected String deadline;
    protected int priority;

    /**
     * Constructs a new Task with specified attributes
     * @param type type of task (example: general or school)
     * @param title title of the task as given by user
     * @param description brief description of task
     * @param deadline the MM/DD/YY date the user has assigned
     * @param priority int with low numbers representing higher priority
     */
    public Task(String type, String title, String description, String deadline, int priority){
        this.type = type;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    /**
     * parses deadline provided by user and makes it a LocalDate object for ease of use
     * @return LocalDate object with parsed date in MM/DD/YY format
     */
    //date parsing
    public LocalDate getDueDateAsLocalDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(deadline, formatter);
    }

    /**
     * type getter
     * @return type the type of the Task
     */
    //getters
    public String getType(){
        return type;
    }

    /**
     * title getter
     * @return title the title of the Task
     */
    public String getTitle(){
        return title;
    }

    /**
     * description getter
     * @return description the brief description of the task
     */
    public String getDescription(){
        return description;
    }

    /**
     * deadline getter
     * @return deadline the String deadline of the Task
     */
    public String getDeadline(){
        return deadline;
    }

    /**
     * priority getter
     * @return priority the number priority assigned to the Task
     */
    public int getPriority(){
        return priority;
    }
    //setters

    /**
     * sets title
     * @param s new title of the Task
     */
    public void setTitle(String s){
        title = s;
    }

    /**
     * sets description
     * @param s new description of the Task
     */
    public void setDescription(String s){
        description = s;
    }

    /**
     * sets deadline
     * @param s new deadline of the Task
     */
    public void setDeadline(String s){
        deadline = s;
    }

    /**
     * sets priority
     * @param s new priority of the Task
     */
    public void setPriority(int s){
        priority = s;
    }

    /**
     * shorter than the toString
     * @return a formatted string with task type, title, priority, and deadline
     */
    public String getBlurb(){
        return type + " task. " + "\"" + title + "\"" + " (Priority: " + priority + ", due " + deadline + ")";
    }

    /**
     * format that it is saved to the text file with for ease of parsing
     * @return formatted string separated with all attributes, separated by comma delimiter
     */
    //format it is saved in the txt file with (comma delimiter)
    public String fileText(){
        return type + "," + title + "," + description + "," + deadline + "," + priority;
    }

    /**
     * string representation of tasks
     * @return formatted string with all attributes
     */
    public String toString(){
        return type + " task | " + title + " | Priority " + priority + " | Due " + deadline + "\nDescription: " + description; 
    }
    
}
