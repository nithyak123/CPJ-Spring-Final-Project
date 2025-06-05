import java.time.*;
import java.util.ArrayList;

/**
 * a type of Task intended specifically for work tasks with team members
 * subclass of Task
 * @author Nithya Karambakkam
 */

public class WorkTask extends Task{
    
    private String teamMembers;

    /**
     * constructs a WorkTask object with necessary attributes and sends the first 4 to the superclass
     * @param title title of the task
     * @param description short description of the task
     * @param deadline deadline provided by the user
     * @param priority priority int number provided by the user
     * @param teamMembers attribute specific to WorkTask - team members who are in the task
     */
    public WorkTask(String title, String description, String deadline, int priority, String teamMembers){
        super("work", title, description, deadline, priority);
        this.teamMembers = teamMembers;
    }

    /**
     * team members getter
     * @return teamMembers string with names of team members
     */
    //getters + setters
    public String getTeamMembers(){
        return teamMembers;
    }

    /**
     * team member setter
     * @param s new team members
     */
    public void setTeamMembers(String s){
        teamMembers = s;
    }

    /**
     * formats info to be loaded into a file
     * @return formatted string with title, description, deadline, priority, team members formatted with comma delimiter
     */
    @Override
    public String fileText(){
        return "work" + "," + super.title + "," + super.description + "," + super.deadline + "," + super.priority + "," + teamMembers;
    }

    /**
     * returns all attributes of the WorkTask
     * @return formatted string with title, priority, deadline, description, and team members
     */
    @Override
    public String toString(){
        return "work task | " + super.title + " | Priority " + super.priority + " | Due " + super.deadline + "\nDescription: " + super.description + "\nTeam Members: " + teamMembers; 
    }
}
