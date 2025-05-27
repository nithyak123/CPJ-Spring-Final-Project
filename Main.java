import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Task Management System\n\n");
        
        //account creation
        System.out.println("Hello! Please enter your name below to create an account.");
        System.out.print("> \u001B[33m");
        String username = input.nextLine();
        User u = new User(username);
        System.out.println("\n\u001B[30mWelcome, " + username + "!");
        System.out.println("This is your dashboard, where you will view, add, remove, and complete tasks. Right now, your task list is empty - let's add some tasks. After adding your first task, press x at any time to quit.");
        System.out.println("There are 2 common categories of tasks: ");
        for (String c : u.getCategories()){
            System.out.println(c);
        }
        System.out.println("General could include anything from gardening to bungee jumping. Our software is incredibly flexible and adaptive. Now, enter your first task:");
        System.out.print("Task type > \u001B[33m");
        String type = input.nextLine();
        System.out.print("\u001B[30mTask title > \u001B[33m");
        String title = input.nextLine();
        System.out.print("\u001B[30mTask description > \u001B[33m");
        String description = input.nextLine();
        System.out.print("\u001B[30mTask due date (MM/DD/YY) > \u001B[33m");
        String deadline = input.nextLine();
        System.out.print("\u001B[30mTask priority (1 is most important, higher numbers are least important) > \u001B[33m");
        int priority = input.nextInt();
        String teamMembers = "";
        if (type.equals("work")){
            System.out.print("\u001B[30mTeam members for this work project > \u001B[33m");
            teamMembers = input.nextLine();
        }
    }
}
