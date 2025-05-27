public class WorkTask extends Task{
    
    private String teamMembers;
    
    public String workTask(String title, String description, String deadline, int priority, String teamMembers){
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
}
