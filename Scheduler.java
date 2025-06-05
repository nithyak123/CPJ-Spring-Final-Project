import java.time.*;
import java.util.ArrayList;

/**
 * this class implements schedulable and provides the logic for task selection
 * @author Nithya Karambakkam
 */

public class Scheduler implements Schedulable {
    /**
     * selects tasks based on most pertinent due dates and priorities assigned
     * @param tasks the list of Task objects to evaluate
     * @return priorityTask the Task that should be worked on
     */
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

    /**
     * selects least pertinent task based on due dates and priorities assigned
     * @param tasks the list of tasks being evaluated
     * @return lastTask the Task that is due the furthest away with lowest priority; the task that the User needs to procrastinate
     */
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
