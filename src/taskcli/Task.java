package taskcli;

public class Task {
	private int id;
	private String description;
	private String status;
	private String createdAt;
	private String updatedAt;
	
	public Task(int id, String description, String status, String createdAt, String updatedAt) {
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = createdAt;
	}
	
	public int getID() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus() {
		return status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String toString() {
		return id + ". " + description + " (" + status + ")";
	}
 
}
