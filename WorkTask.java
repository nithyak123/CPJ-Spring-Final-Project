import java.time.*;
import java.util.ArrayList;

public class WorkTask extends Task{
    
    private String teamMembers;
    
    public WorkTask(String title, String description, String deadline, int priority, String teamMembers){
        super("work", title, description, deadline, priority);
        this.teamMembers = teamMembers;
    }
    
    //getters + setters
    public String getTeamMembers(){
        return teamMembers;
    }
    public void setTeamMembers(String s){
        teamMembers = s;
    }
    
    @Override
    public String fileText(){
        return "work" + "," + super.title + "," + super.description + "," + super.deadline + "," + super.priority + "," + teamMembers;
    }
    
    @Override
    public String toString(){
        return "work task | " + super.title + " | Priority " + super.priority + " | Due " + super.deadline + "\nDescription: " + super.description + "\nTeam Members: " + teamMembers; 
    }
}
