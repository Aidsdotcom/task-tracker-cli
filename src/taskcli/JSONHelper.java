package taskcli;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class JSONHelper {
	
	public void ensureFileExists() {
		
		if (!Files.exists(Paths.get("tasks.json"))) {
			try {
				Files.writeString(Paths.get("tasks.json"), "[]");
			} catch (IOException e) {
				System.out.println("Error: could not create tasks.json");
			}
		}
	
	}
	
	public void saveTasks(List<Task> tasks) {
		
		StringBuilder json = new StringBuilder();
		json.append("[");
		
		for (int i = 0; i < tasks.size(); i++) {
			
			json.append("{\n");
			json.append("\"id\":" + tasks.get(i).getID() + "\",");
			json.append("\"description\":\"" + tasks.get(i).getDescription() + "\",");
			json.append("\"status\":\"" + tasks.get(i).getStatus() + "\",");
			json.append("\"createdAt\":\"" + tasks.get(i).getCreatedAt() + "\",");
			json.append("\"updatedAt\":\"" + tasks.get(i).getUpdatedAt() + "\"");
			json.append("}");

			if (i < tasks.size() - 1) json.append(", ");
		}
		
		json.append("]\n");
		try {
		Files.writeString(Paths.get("tasks.json"), json.toString());
		} catch (IOException e) {
			System.out.println("Error: Could not find tasks.json");
		}
	}
	
	public List<Task> loadTasks()  {
		ensureFileExists();
		List <Task> tasks = new ArrayList<>();
		try {
		String json = Files.readString(Paths.get("tasks.json"));
		json = json.trim();
		json = json.substring(1, json.length() - 1);
		
		String[] blocks = json.split("\\},\\{");
		for (String block : blocks) {
			int start = block.indexOf("\"id\":") + "\"id\":".length();
			int end = block.indexOf(",", start);
			int id = Integer.parseInt(block.substring(start, end).trim());
			
			start = block.indexOf("\"description\":\"") + "\"description\":\"".length();
		    end = block.indexOf("\"", start);
			String description = block.substring(start, end).trim();
			
			start = block.indexOf("\"status\":\"") + "\"status\":\"".length();
		    end = block.indexOf("\"", start);
			String status = block.substring(start, end).trim();
			
			start = block.indexOf("\"createdAt\":\"") + "\"createdAt\":\"".length();
		    end = block.indexOf("\"", start);
			String createdAt = block.substring(start, end).trim();
	
		    start = block.indexOf("\"updatedAt\":\"") + "\"updatedAt\":\"".length();
		    end = block.indexOf("\"", start);
			String updatedAt = block.substring(start, end).trim();
			
			Task task = new Task(id, description, status, createdAt, updatedAt);
			tasks.add(task);
			
		}
			

		} catch (IOException e) {
			System.out.println("Error: could not read tasks.json");
		}
		
		
		return tasks;
	}
	}

}
