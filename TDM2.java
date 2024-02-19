import java.util.Scanner;

class Task {
    private static int taskIdCounter = 1;

    private int taskId;
    private String taskTitle;
    private String taskText;
    private String assignedTo;

    public Task(String taskTitle, String taskText, String assignedTo) {
        this.taskId = taskIdCounter++;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.assignedTo = assignedTo;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskText() {
        return taskText;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}

class ToDoManagerDAO {
    private static final int MAX_TASKS = 10;
    private Task[] tasks;
    private int taskCount;

    public ToDoManagerDAO() {
        tasks = new Task[MAX_TASKS];
        taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < MAX_TASKS) {
            tasks[taskCount++] = task;
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Task limit reached. Cannot add more tasks.");
        }
    }

    public void updateTask(int taskId, String taskTitle, String taskText, String assignedTo) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
                tasks[i].setTaskTitle(taskTitle);
                tasks[i].setTaskText(taskText);
                tasks[i].setAssignedTo(assignedTo);
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int taskId) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getTaskId() == taskId) {
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

    public Task[] getAllTasks() {
        return tasks;
    }

    public Task searchTask(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }
}

public class TDM2 {

    public static void main(String[] args) {
        ToDoManagerDAO dao = new ToDoManagerDAO();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(dao, scanner);
                    break;
                case 2:
                    updateTask(dao, scanner);
                    break;
                case 3:
                    deleteTask(dao, scanner);
                    break;
                case 4:
                    searchTask(dao, scanner);
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

    private static void addTask(ToDoManagerDAO dao, Scanner scanner) {
        System.out.println("Enter task title:");
        String taskTitle = scanner.nextLine();

        System.out.println("Enter task text:");
        String taskText = scanner.nextLine();

        System.out.println("Enter assigned to:");
        String assignedTo = scanner.nextLine();

        Task task = new Task(taskTitle, taskText, assignedTo);
        dao.addTask(task);
    }

    private static void updateTask(ToDoManagerDAO dao, Scanner scanner) {
        System.out.println("Enter task ID to update:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter updated task title:");
        String taskTitle = scanner.nextLine();

        System.out.println("Enter updated task text:");
        String taskText = scanner.nextLine();

        System.out.println("Enter updated assigned to:");
        String assignedTo = scanner.nextLine();

        dao.updateTask(taskId, taskTitle, taskText, assignedTo);
    }

    private static void deleteTask(ToDoManagerDAO dao, Scanner scanner) {
        System.out.println("Enter task ID to delete:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        dao.deleteTask(taskId);
    }

    private static void searchTask(ToDoManagerDAO dao, Scanner scanner) {
        System.out.println("Enter task ID to search:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Task task = dao.searchTask(taskId);
        if (task != null) {
            System.out.println("Task found:");
            System.out.println("Task ID: " + task.getTaskId());
            System.out.println("Task Title: " + task.getTaskTitle());
            System.out.println("Task Text: " + task.getTaskText());
            System.out.println("Assigned To: " + task.getAssignedTo());
        } else {
            System.out.println("Task not found.");
        }
    }
}
