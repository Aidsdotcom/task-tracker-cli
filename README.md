https://github.com/Aidsdotcom/task-tracker-cli
My very first solo project - a typical CLI to do list using manual JSON parsing (no external libraries used).
To run, ensure you have Java installed (Minimum JDK 11.0)
Download taskcli.jar
Open a terminal and navigate to the folder containing the JAR
Run commands using:
java -jar taskcli.jar add "(insert description of task)"
java -jar taskcli.jar delete (id of task)
java -jar taskcli.jar list 
java -jar taskcli.jar mark (id of task) (status of task)
java -jar taskcli.jar update (id of task) "(new description of task)"
