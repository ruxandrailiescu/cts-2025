import java.lang.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// 1. DRY (Don't Repeat Yourself)

/*
Fix the following code (and maintain clean coding rules):
	... processExamScore(int sc)
	{
		if (score < 0 || score > 100)		(1)
			throw ...
		...
	}

	... processAssignScore(int sc)
	{
		(1)
		...
	}

	.. processFinalScore(int sc)
	{
		(1)
		...
	}
*/

class DRY { // space before bracket
    // use wrappers instead of primitive types
    private Integer examScore;
    private Integer assignmentScore;
    private Double finalScore;

    public static void validateScore(Integer score) throws IllegalArgumentException { // space before bracket
        if (score < 0 || score > 100) { // spaces before and after operators, space before bracket
            // use brackets even if your code block has one instruction
            throw new IllegalArgumentException("Score has an invalid value!"); // blocks of code are also indented
        }
    } // 1 empty line between functions

    public void processExamScore(Integer score) throws IllegalArgumentException { // space before bracket
        validateScore(score);
        this.examScore = score;
    }

    public void processAssignmentScore(Integer score) throws IllegalArgumentException { // space before bracket
        validateScore(score);
        this.assignmentScore = score;
    }

    public void processFinalScore(Integer score) throws IllegalArgumentException { // space before bracket
        validateScore(score);
        this.finalScore = 0.5 * score + 0.4 * this.examScore + 0.1 * this.assignmentScore; // space before and after operators
    }
}

// 2. KISS (Keep it Stupidly Simple)

/*
Simplify following code:

	boolean isValidEmail(String email)
	{
		Pattern p = Pattern.compile("/[a-z0-9\._%+!$&*=^|~#%'`?{}/\-]+@([a-z0-9\-]+\.){1,}([a-z]{2,16})/", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return m.matches();
	}
*/

class KISS { // space before bracket
    public static Boolean isValidEmail(String email) { // space before bracket
        // use wrapper Boolean instead of boolean
        // name Boolean variables/methods as a question that can be answered with yes or no
        if (!email.contains("@") || !email.contains(".")) { // space before bracket
            return false; // use brackets even for single instruction blocks; also indent code blocks
        }

        return email.indexOf(".") > email.indexOf("@");
    }

    // for this, do keep in mind however that this is just a simple exercise designed for understanding KISS
    // in the real-world, validating emails is a heavily complex task which requires a robust solution
    // in our case we went from a better solution to a worse one, just to exemplify the principle
    // in reality, you should think about the trade-off between simplicity and comprehensive validation
}

// 3. YAGNI (You aren't gonna need it)

/*
From this class, keep only the required attributes:
	public class TodoItem {
        private int id;
        private String title;
        private String description;
        private LocalDate dueDate;
        private boolean completed;
        private Priority priority;
        private List<String> tags;
        private List<TodoItem> subTasks;
        private List<Attachment> attachments;
        private RecurrencePattern recurrence;
        private List<Reminder> reminders;
        private GeoLocation location;
        private Category category;
        private User assignedTo;
        private LocalDateTime completedAt;
        private User completedBy;
        private List<Comment> comments;
        private List<Custom> customFields;
    }
*/

class ToDoItem { // YAGNI
    // private Integer id; // unless we do some saving to the DB, this is not required, as it doesn't help with anything
    private String title; // this or description are necessary, such that we can get some info about our ToDoItem, thus are required for its functionality
    private String description; // same as for the title, this or the title are necessary
    // private LocalDate dueDate; // this would be nice to have, thus is not required for a bare minimum, as the due date can be obtained from the description/title
    private Boolean isCompleted; // this is required, such that we know whether the task is completed or not
    // below this point, all attributes describe nice to have functionalities, but that are not really required for a bare metal ToDoItem on a Notes app
    // therefore, at a minimum, we would have title/description and isCompleted (and possibly id)
    // private Priority priority;
    // private List<String> tags;
    // private List<TodoItem> subTasks;
    // private List<Attachment> attachments;
    // private RecurrencePattern recurrence;
    // private List<Reminder> reminders;
    // private GeoLocation location;
    // private Category category;
    // private User assignedTo;
    // private LocalDateTime completedAt;
    // private User completedBy;
    // private List<Comment> comments;
    // private List<Custom> customFields;
}