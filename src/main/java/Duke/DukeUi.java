package Duke;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static Duke.Strings.EXIT_MESSAGE_0;
import static Duke.Strings.EXIT_MESSAGE_1;
import static Duke.Strings.EXIT_MESSAGE_DEFAULT;
import static Duke.Strings.GREETING;
import static Duke.Strings.LOADING_ERROR_MESSAGE;
import static Duke.Strings.LINE;
import static Duke.Strings.LINE_SEPARATOR;
import static Duke.Strings.LOGO;

/**
 * DukeUi is the class that deals with interactions with the user.
 */
public class DukeUi {

    private Scanner in;

    public DukeUi() {
        in = new Scanner(System.in);
    }

    /**
     * Prints the loading error message.
     */
    public void showLoadingError() {
        System.out.println(LOADING_ERROR_MESSAGE);
    }

    /**
     * Prints the welcome message and logo.
     */
    public void showWelcome() {
        // print logo and welcome message
        System.out.println(LOGO + LINE_SEPARATOR + GREETING);
    }

    /**
     * Reads the user input.
     * 
     * @return the user input
     */
    public String readCommand() {
        return in.nextLine();
    }

    /**
     * Prints the divider line.
     */
    public void showLine() {
        System.out.println(LINE);
    }

    /**
     * Prints the error message.
     * 
     * @param message the error message
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Prints the exit message.
     */
    public void showExit() {
        Random rand = new Random();
        switch (rand.nextInt() % 2) {
        case 0:
            System.out.println(EXIT_MESSAGE_0);
            break;

        case 1:
            System.out.println(EXIT_MESSAGE_1);
            break;
        
        default:
            System.out.println(EXIT_MESSAGE_DEFAULT);
            break;
        }
    }

    /**
     * Prints the list of tasks.
     * 
     * @param tasks the list of tasks
     */
    public void showList(DukeTaskList tasks) {
        if (tasks.tasksList.size() == 0) {
            System.out.println("There are no tasks in the list.");
        } else {
            System.out.println("Here are the tasks in your list:" + LINE_SEPARATOR);
            for (DukeTask dukeTask : tasks.tasksList) {
                System.out.println((tasks.tasksList.indexOf(dukeTask) + 1) + ". " + dukeTask.toString());
            }
        }
    }

    /**
     * Prints the task that has been added.
     * 
     * @param matchingTaskList a sub-list of tasks
     * @param task the task that has been added
     */
    public void showList(ArrayList<DukeTask> matchingTaskList, DukeTaskList tasks) {
        if (matchingTaskList.size() == 0) {
            System.out.println("There are no such tasks in the list.");
        } else {
            System.out.println("Here are the matching tasks in your list:" + LINE_SEPARATOR);
            for (DukeTask dukeTask : matchingTaskList) {
                System.out.println((tasks.tasksList.indexOf(dukeTask) + 1) + ". " + dukeTask.toString());
            }
        }
    }

    /**
     * Prints the task that has been removed.
     * 
     * @param task the task that has been removed
     */
    public void showDeleteTask() {
        System.out.println("Noted. I've removed this task.");
    }

}
