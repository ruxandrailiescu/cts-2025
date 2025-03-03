import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // 1. DRY - Do Not Repeat Yourself
    public static boolean validateScore(int score) {
        if (score < 0 || score > 100) {
            return false;
        }
        return true;
    }

    public static int processExamScore(int score) throws Exception {
        if (!validateScore(score)) {
            throw new Exception("Score must be between 0 and 100");
        }
        return Math.round((float) score / 10);
    }

    public static int processAssignmentScore(int score) throws Exception {
        if (!validateScore(score)) {
            throw new Exception("Score must be between 0 and 100");
        }
        return Math.round((float) score / 10);
    }

    public static int processFinalScore(int examScore, int assignmentScore) {
        try {
            return (processExamScore(examScore) + processAssignmentScore(assignmentScore)) / 2;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 2. KISS - Keep It Stupidly Simple
    public static boolean isEmailValid(String email) {
        if (email.contains("@") && email.contains(".com") && email.length() > 10) {
            return true;
        }
        return false;
    }

    // 3. YAGNI - You Aren't Gonna Need It
    public class ToDoItem {
        boolean completed;
        //List<Attachment> attachments;
        LocalDate dueDate;
        //int id;
        //Category category;
        //User assignedTo, completedBy;
        String title;
        //Priority priority;
    }

    public class Attachment {

    }

    public class Category {

    }

    public class User {

    }

    public class Priority {

    }

    public static void main(String[] args) {

    }
}