public class DukeCommands {
    public static String spacer = "__________________________________________\n";
    public static DukeTasks[] list = new DukeTasks[100];
    static Integer taskLength = 0;

    // Still requires addition of speach lines

    /**
     * Adds a task with the specified name to a list, and prints a response to the user. 
     * 
     * @param taskName Name of task added
     */
    public static void addToList(String taskName) {
        try {
            DukeSortInputTask.dukeSortInputTask(list, taskLength, taskName);
            taskLength += 1;
            System.out.println("added: " + taskName);
        } catch (DukeExceptions e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Did you forget to specify a command?");
        }
        System.out.println(spacer);
    }

    /** Prints a list of all tasks and its marked status to user. */
    public static void listTasks() {
        Integer taskIndex = 1;
        System.out.println("Here is your list of tasks: \n");
        for (DukeTasks task : list) {
            if (taskIndex > taskLength) {
                break;
            }
            System.out.println(taskIndex + ".[" + task.getTaskType() + "] " + "[" + task.getStatusIcon() + "] " + task.toString());
            taskIndex += 1;
        }
        System.out.println(spacer);
    }
    
    /**
     * Marks the specified task by index number, then prints a response to user. 
     * 
     * @param taskIndex Index number of task from list printed by Duke, to be marked
     */
    public static void markTask(Integer taskIndex) {
        list[taskIndex - 1].markDone();
        System.out.println("Some tasks have been marked off your list: \n");
        System.out.println("  [" + list[taskIndex - 1].getStatusIcon() + "] " + list[taskIndex - 1].toString());
        System.out.println(spacer);
    }
    
    /**
     * Unmarks the specified task by index number, then prints a response to user. 
     * 
     * @param taskIndex Index number of task from list printed by Duke, to be unmarked
     */
    public static void unmarkTask(Integer taskIndex) {
        list[taskIndex - 1].unmarkDone();
        System.out.println("Some tasks have been unmarked. Procrastinating much?\n");
        System.out.println("  [" + list[taskIndex - 1].getStatusIcon() + "] " + list[taskIndex - 1].toString());
        System.out.println(spacer);
    }
}
