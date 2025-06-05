import java.time.*;
import java.util.ArrayList;

/**
 * the Schedulable interface defines methods for procrastinating and optimization of task selection
 * @author Nithya Karambakkam
 */

public interface Schedulable {
    Task suggestNextTask(ArrayList<Task> tasks);
    Task procrastinate(ArrayList<Task> tasks);
}
