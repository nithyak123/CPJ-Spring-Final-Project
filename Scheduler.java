public class Scheduler implements Schedulable {
    
    @Override
    public Task suggestNextTask(ArrayList<Task> tasks){
        Task priorityTask = null;
        
        for (Task tasks : currentTask){
            if (priorityTask == null){
                priorityTask = currentTask;
            }
            else {
                if (currentTask.getPriority() > priorityTask.getPriority()){
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
}
