package taskcli;

public class Main {
	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		
		if (args.length == 0) {
			System.out.println("Please type a command");
			return;
		}
		
		if (args[0].equals("add")) {
			taskManager.addTask(args[1]);
		} else if (args[0].equals("delete")) {
			taskManager.deleteTask(Integer.parseInt(args[1]));
		} else if (args[0].equals("update")) {
			taskManager.updateTask(Integer.parseInt(args[1]), args[2]);
		} else if (args[0].equals("mark")) {
			taskManager.markTask(Integer.parseInt(args[1]), args[2]);
		} else if (args[0].equals("list")) {
			taskManager.listTasks();
		} else {
			System.out.println("Unrecognised command");
		}
	}

}
