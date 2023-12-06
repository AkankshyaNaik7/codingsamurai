package codingsamurai;
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isComplete;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }

    public void markComplete() {
        isComplete = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
public class ToDoListApp {

	public static void main(String[] args) {
		ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    Task newTask = new Task(title, description, dueDate);
                    taskList.add(newTask);
                    System.out.println("Task added successfully.");
                    break;

                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty.");
                    } else {
                        System.out.println("Select a task to mark as complete (by index):");
                        displayTasks(taskList);
                        int index = scanner.nextInt();
                        if (index >= 0 && index < taskList.size()) {
                            taskList.get(index).markComplete();
                            System.out.println("Task marked as complete.");
                        } else {
                            System.out.println("Invalid task index.");
                        }
                    }
                    break;

                case 3:
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty.");
                    } else {
                        displayTasks(taskList);
                    }
                    break;

                case 4:
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty.");
                    } else {
                        System.out.println("Select a task to remove (by index):");
                        displayTasks(taskList);
                        int removeIndex = scanner.nextInt();
                        if (removeIndex >= 0 && removeIndex < taskList.size()) {
                            taskList.remove(removeIndex);
                            System.out.println("Task removed successfully.");
                        } else {
                            System.out.println("Invalid task index.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private static void displayTasks(ArrayList<Task> tasks) {
        int index = 0;
        for (Task task : tasks) {
            System.out.println(index + ". Title: " + task.getTitle() + ", Description: " + task.getDescription() + ", Due Date: " + task.getDueDate() + ", Complete: " + (task.isComplete() ? "Yes" : "No"));
            index++;
        }
    }
}