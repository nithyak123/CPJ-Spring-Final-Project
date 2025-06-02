import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Task Management System\n\n");
        
        User u = null;
        Task x = null;
        
        //account creation/login
        System.out.println("Do you already have an account? y/n");
        System.out.print("> \u001B[33m");
        String response1 = input.nextLine();
        
        if (response1.equals("n")){
            System.out.println("\u001B[30mHello! Please enter your name below to create an account.");
            System.out.print("> \u001B[33m");
            String username = input.nextLine();
            u = new User(username);
            System.out.println("\n\u001B[30mWelcome, " + username + "!");
            System.out.println("This is your dashboard, where you will view, add, remove, and complete tasks. Right now, your task list is empty - let's add some tasks.");
            System.out.println("There are 2 common categories of tasks: ");
            for (String c : u.getCategories()){
                System.out.println(c);
            }
            System.out.println("General could include anything from personal to school. Our software is incredibly flexible and adaptive. Now, enter your first task:");
            System.out.print("Task type > \u001B[33m");
            String type = input.nextLine();
            System.out.print("\u001B[30mTask title > \u001B[33m");
            String title = input.nextLine();
            System.out.print("\u001B[30mTask description > \u001B[33m");
            String description = input.nextLine();
            System.out.print("\u001B[30mTask due date (MM/DD/YYYY) > \u001B[33m");
            String deadline = input.nextLine();
            System.out.print("\u001B[30mTask priority (1 is most important, higher numbers are least important) > \u001B[33m");
            int priority = input.nextInt();
            input.nextLine();
            String teamMembers = "";
            if (type.equals("work")){
                System.out.print("\u001B[30mTeam members for this work project \n> \u001B[33m");
                teamMembers = input.nextLine();
                x = new WorkTask(title, description, deadline, priority, teamMembers);
            }
            else {
                x = new Task(type, title, description, deadline, priority);
            }
            System.out.println("\u001B[30mTask created!");
            u.addTask(x);
            FileIO.saveTasksToFile(u);
            System.out.println(); }
        
        else if (response1.equals("y")) {
            System.out.println("\u001B[30mWhat is your username?");
            System.out.print("> \u001B[33m");
            String username = input.nextLine();
            
            ArrayList<Task> tasks = new ArrayList<>(); // empty task list by default
            try {
                tasks = FileIO.loadTasksFromFile(username); // try loading tasks
            } catch (IOException e) {
                System.out.println("\u001B[30mNo saved tasks found for username \"" + username + "\". Creating a new account with an empty task list.");
            } catch (Exception e) {
                System.out.println("An error occurred while loading tasks.");
                e.printStackTrace();
            }
            
            /*tasks = FileIO.loadTasksFromFile(username);*/
            u = new User(username, tasks);
            System.out.println("Logged in successfully!");
        }
        
        else {
            System.out.println("Not a valid response. Try again.");
            System.exit(0);
        }
        
        //start the loop
        System.out.println("\npress 1 to add tasks");
        System.out.println("press 2 to remove tasks");
        System.out.println("press 3 to view the task list");
        System.out.println("press 4 to suggest which task to complete next");
        System.out.println("press 5 to procrastinate");
        System.out.println("press 6 to exit");
        System.out.print("> \u001B[33m");
        int response2 = input.nextInt();
        input.nextLine();
        Scheduler scheduler = new Scheduler();
        
        //if option chosen is not exit
        while (response2 != 6){
            //add task
            if (response2 == 1){
                //ask for info
                Task t = null;
                System.out.print("\u001B[30mTask type > \u001B[33m");
                String type = input.nextLine();
                System.out.print("\u001B[30mTask title > \u001B[33m");
                String title = input.nextLine();
                System.out.print("\u001B[30mTask description > \u001B[33m");
                String description = input.nextLine();
                System.out.print("\u001B[30mTask due date (MM/DD/YYYY) > \u001B[33m");
                String deadline = input.nextLine();
                System.out.print("\u001B[30mTask priority (1 is most important, higher numbers are least important) > \u001B[33m");
                int priority = input.nextInt();
                input.nextLine();
                String teamMembers = "";
                if (type.equals("work")){
                        System.out.print("\u001B[30mTeam members for this work project > \u001B[33m");
                        teamMembers = input.nextLine();
                        t = new WorkTask (title, description, deadline, priority, teamMembers);
                        }
                //actually add the task
                else {
                    t = new Task(type, title, description, deadline, priority);
                }
                u.addTask(t);
                System.out.println("\u001B[30mTask added!");
                FileIO.saveTasksToFile(u);
            }
            
            //remove task
            else if (response2 == 2){
                System.out.println("\u001B[30mCongratulations on having one less task! :)");
                System.out.println("What is the number of the task on the task list that you have completed or would like to remove?");
                System.out.print("> \u001B[33m");
                int index = input.nextInt();
                u.removeTask(index);
                System.out.println("\u001B[30mTask removed!");
                FileIO.saveTasksToFile(u);
            }
            
            //display task list
            else if (response2 == 3){
                ArrayList<Task> tasks = u.getTasks();
                for (int i = 0; i < tasks.size(); i++){
                    System.out.print("\u001B[30m");
                    System.out.print(i + ") ");
                    System.out.println((tasks.get(i)).getBlurb());
                }
                System.out.println("\n\u001B[30menter the number of the task for a more detailed description, or type -1 to exit");
                System.out.print("> \u001B[33m");
                int tindex = input.nextInt();
                input.nextLine();
                while (tindex != -1){
                    System.out.println("\u001B[30m" + tasks.get(tindex));
                    System.out.println("\n\u001B[30menter the number of the task for a more detailed description, or type -1 to exit");
                    System.out.print("> \u001B[33m");
                    tindex = input.nextInt();
                }
            }
            
            //suggest next task
            else if (response2 == 4){
                Task t = scheduler.suggestNextTask(u.getTasks());
                System.out.println("\u001B[30mThe most pertinent task is...");
                System.out.println(t);
            }
            
            //procrastinate
            else if (response2 == 5){
                Task t = scheduler.procrastinate(u.getTasks());
                System.out.println("\u001B[30mSo you need to procrastinate? In order to feel productive while putting off your work, complete...");
                System.out.println(t);
            }
            
            //reprompt 1-6 answer choices
            System.out.println("\n\u001B[30mpress 1 to add tasks");
            System.out.println("press 2 to remove tasks");
            System.out.println("press 3 to view the task list");
            System.out.println("press 4 to suggest which task to complete next");
            System.out.println("press 5 to procrastinate");
            System.out.println("press 6 to exit");
            System.out.print("> \u001B[33m");
            response2 = input.nextInt();
            input.nextLine();
        }
        
        FileIO.saveTasksToFile(u);
        System.out.println("\u001B[30mYour progress was saved successfully. Go forth and be productive!");
    }
}
