import java.time.*;
import java.util.ArrayList;

public interface Schedulable {
    Task suggestNextTask(ArrayList<Task> tasks);
    Task procrastinate(ArrayList<Task> tasks);
}
