package taskcli;

import java.util.List;
import java.time.LocalDateTime;

public class TaskManager {
	private List <Task> tasks;
	private JSONHelper jsonHelper;
	
	public TaskManager() {
		this.jsonHelper = new JSONHelper();
		this.tasks = this.jsonHelper.loadTasks();
		
	}
	
	public void addTask(String description) {
		int maxId = 0;
		for (Task t : tasks) {
			if (t.getID() > maxId) maxId = t.getID();
		}
		int newId = maxId + 1;
		
		String initialStatus = "Todo";
		String now = java.time.LocalDateTime.now().toString();	
		String created = now;
		String updated = now;
		Task task = new Task(newId, description, initialStatus, created, updated);
			tasks.add(task);
		    this.jsonHelper.saveTasks(tasks);
		}
	
	public void deleteTask(int id) {
		if (tasks.isEmpty()) {
			System.out.println("No tasks to delete");
			return;
		}
	    boolean found = false;
		for (Task t : tasks) {
			if (t.getID() == id) {
				found = true;
				tasks.remove(t);
				this.jsonHelper.saveTasks(tasks);
				break;
			}
		}
		
		if (!found) {
			System.out.println("Task not found");
		}
		
	}
	
	public void updateTask(int id, String description) {
		
		boolean found = false;
		for (Task t : tasks) {
			if (t.getID() == id) {
				found = true;
				t.setDescription(description);
				t.setUpdatedAt(LocalDateTime.now().toString());
				this.jsonHelper.saveTasks(tasks);
				break;
			}
			
		}
		
		if (!found) {
			System.out.println("Task not found");
		}
		
	}
	
	public void markTask(int id, String status) {
		
	    boolean found = false;
		for (Task t : tasks) {
			if (t.getID() == id) {
				found = true;
				t.setStatus(status);
				t.setUpdatedAt(LocalDateTime.now().toString());
				this.jsonHelper.saveTasks(tasks);
				break;
			}
		}
		
		if (!found) {
			System.out.println("Task not found");
		}
		
	}
	
	public void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks to list");
			return;
		}
		
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println((i + 1) + ". " + tasks.get(i));
		}
		
	}
	

}
