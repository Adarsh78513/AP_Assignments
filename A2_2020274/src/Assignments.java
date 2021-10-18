import java.util.ArrayList;

public class Assignments implements Assessments{
    String fileName;
    String problemStatement;
    int maxMarks;
    int marksGot;
    static ArrayList<Assessments> allAssignments = new ArrayList<>();
    boolean pending;
    boolean open;
    private final int ID;
    
 
    Assignments(){
        this.fileName = "Not given";
    	this.problemStatement = "Not yet set";
        this.maxMarks = -1;
        this.marksGot = 0;
        this.pending = true;
        this.open = true;
        this.ID = Course.totalQuizzes + Course.totalAssignments;
        Course.totalAssignments += 1;
    }


    public void addProblem(String problemStatement){
        this.problemStatement = problemStatement;
    }

    public void assignMaxMarks(int maxMarks){
        this.maxMarks = maxMarks;
    }
    

	@Override
	public void add() {
		System.out.print("Enter problem statement: ");
        String problemStatement = Main.scanner.next();
        addProblem(problemStatement);
        System.out.print("Enter max marks: ");
        int maxMarks = Integer.parseInt(Main.scanner.next());
        assignMaxMarks(maxMarks);
	}

    @Override
    public String toString() {
        return "ID: Assignment: " + this.problemStatement + 
        " Max Marks: " + this.maxMarks;
    }

    @Override
    public void complete(Assessments a){
        System.out.print("Enter filename of the Assignment: ");
        this.fileName = Main.scanner.next();
        this.pending = false;
    }

    @Override
    public int marksGot() {
        if ( !open && pending ){
            System.out.println("You missed the deadline");
        }
        else if ( pending){
            System.out.println("Assignment not taken yet");
        }
        return this.marksGot;
    }

    @Override
    public boolean Pending() {
        return this.pending;
    }

    public static Assessments search(int ID) {
        for ( Assessments assignment: allAssignments){
            if (assignment.assessmentID() == ID){
                return assignment;
            }
        }
        System.out.println("Quiz not found.");
        return null;
    }

    @Override
    public int assessmentID() {
        return this.ID;
    }

    @Override
    public void close() {
        this.open = false;
    }

    @Override
    public void gradeAssessments(int marks) {
        this.marksGot = marks;
    }

    public static void printAll() {
        for ( Assessments assignment: allAssignments){
            System.out.println(assignment);
        }
    }

}
