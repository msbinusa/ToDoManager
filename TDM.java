	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.HashSet;
	
public class TDM {

	public static void main(String[] args) {
		// User Story 1: Print name on the screen
		
		String userName = "Manisai";
		System.out.println("Hello, " + userName + "!");
		
		// User Story 2: List at least 5 Tasks of the day
		
		ArrayList<String> tasks = new ArrayList<>();
		
		tasks.add("Task 1: head to Doctor's Office");
		tasks.add("Task 2: Have a cup of Coffee");
		tasks.add("Task 3: Call Plumber for faucet leakage");
		tasks.add("Task 4: Call a friend for marketing Suggestions");
		tasks.add("Task 5: Read a Novel");
		
		System.out.println("\nToday's Tasks:");
		for (String task : tasks) {
			System.out.println(task);
		}
		
		//User Story 3: See all the tasks in increasing and decreasing order
		System.out.println("\nTasks in Increasing Order:");
		Collections.sort(tasks);
		for (String task : tasks) {
			
			System.out.println(task);
		}
		
		System.out.println("\nTasks in Decreasing Order");
		Collections.reverse(tasks);
		for (String task : tasks) {
			System.out.println(task);
		}
		
		//User Story 4: See Repeated Tasks
		
		tasks.add("Task 3: Call Plumber for faucet leakage");
		HashSet<String> uniqueTasks = new HashSet<>();
		ArrayList<String>repeatedTasks = new ArrayList<>();
		
		System.out.println("\nRepeated Tasks: ");
		for (String task : tasks);
		String task = null;
		if(!uniqueTasks.add(task)) {
			repeatedTasks.add(task);
		}
	
	
		if (repeatedTasks.isEmpty()) {
			System.out.println("No repeated tasks found.");
		}else {
			for(String repeatedTask : repeatedTasks) {
				System.out.println(repeatedTask);
			}
		}
	}
}
	
	
	

