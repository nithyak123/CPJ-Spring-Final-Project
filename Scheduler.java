import java.time.*;
import java.util.ArrayList;

public class Scheduler implements Schedulable {
    
    //places importance on priority and uses deadline as a tiebreaker
    @Override
    public Task suggestNextTask(ArrayList<Task> tasks){
        Task priorityTask = null;
        
        for (Task currentTask : tasks){
            if (priorityTask == null){
                priorityTask = currentTask;
            }
            else {
                if (currentTask.getPriority() < priorityTask.getPriority()){
                    priorityTask = currentTask;
                }
                else if (currentTask.getPriority() == priorityTask.getPriority()){
                    if (currentTask.getDueDateAsLocalDate().isBefore(priorityTask.getDueDateAsLocalDate())){
                        priorityTask = currentTask;
                    }
                }
            }
        }
        return priorityTask;
    }
    
    @Override
    public Task procrastinate(ArrayList<Task> tasks){
        Task lastTask = null;
        for (Task currentTask : tasks){
            if (lastTask == null){
                lastTask = currentTask;
            }
            else {
                if (currentTask.getPriority() > lastTask.getPriority()){
                    lastTask = currentTask;
                }
                else if (currentTask.getPriority() == lastTask.getPriority()){
                    if (currentTask.getDueDateAsLocalDate().isAfter(lastTask.getDueDateAsLocalDate())){
                        lastTask = currentTask;
                    }
                }
            }
        }
        return lastTask;
    }
}
