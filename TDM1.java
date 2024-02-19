

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

class Task {

	
	private String name;
    private Date dueDate;
    private boolean completed;
    private int priority;

    public Task(String name, Date dueDate, int priority) {
    	this.name = name;
    	this .dueDate = dueDate;
    	this.completed = false;
    	this.priority = priority;
    }
    
    public String getname() {
    	return name;
    }
    
    public Date getDueDate() {
    	return dueDate;
    }
    
    public boolean isCompleted() {
    	return completed;
    }
    
    public void markAsComplted() {
    	completed = true;
    }
    public int getPriority() {
    	return priority;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
     
}
public class TDM1	 {

    private static final int MAX_TASKS = 10;
    private static Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    searchTask();
                    break;
                case 0:
                    System.out.println("Exiting ToDo Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nToDo Manager Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Search Task");
        System.out.println("0. Exit");
    }

    private static void addTask() {
        if (taskCount < MAX_TASKS) {
            System.out.println("Enter task name:");
            String name = scanner.nextLine();

            System.out.println("Enter due date (yyyy-MM-dd):");
            String dateString = scanner.nextLine();

            System.out.println("Enter priority (1-5):");
            int priority = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            try {
                Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                tasks[taskCount++] = new Task(name, dueDate, priority);
                System.out.println("Task added successfully.");
            } catch (ParseException e) {
                System.out.println("Invalid date format. Task not added.");
            }
        } else {
            System.out.println("Task limit reached. Cannot add more tasks.");
        }
    }

    private static void updateTask() {
        System.out.println("Enter the task name to update:");
        String taskName = scanner.nextLine();

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equalsIgnoreCase(taskName)) {
                System.out.println("Enter updated due date (yyyy-MM-dd):");
                String dateString = scanner.nextLine();

                System.out.println("Enter updated priority (1-5):");
                int priority = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                try {
                    Date updatedDueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    tasks[i] = new Task(tasks[i].getName(), updatedDueDate, priority);
                    System.out.println("Task updated successfully.");
                    return;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Task not updated.");
                    return;
                }
            }
        }

        System.out.println("Task not found.");
    }

    private static void deleteTask() {
        System.out.println("Enter the task name to delete:");
        String taskName = scanner.nextLine();

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equalsIgnoreCase(taskName)) {
                // Shift tasks to remove the deleted task
                for (int j = i; j < taskCount - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                taskCount--;
                System.out.println("Task deleted successfully.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    private static void searchTask() {
        System.out.println("Enter the task name to search:");
        String taskName = scanner.nextLine();

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equalsIgnoreCase(taskName)) {
                System.out.println("Task found:");
                System.out.println("Task: " + tasks[i].getName());
                System.out.println("Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(tasks[i].getDueDate()));
                System.out.println("Priority: " + tasks[i].getPriority());
                System.out.println("Status: " + (tasks[i].isCompleted() ? "Completed" : "Not Completed"));
                return;
            }
        }

        System.out.println("Task not found.");
    }
}