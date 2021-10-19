import java.util.ArrayList;

public class Assignments implements Assessments{
    private String problemStatement;
    private int maxMarks;
    static ArrayList<Assessments> allAssignments = new ArrayList<>();
    private boolean open;
    private final int ID;
    
 
    Assignments(){
    	this.problemStatement = "Not yet set";
        this.maxMarks = -1;
        this.open = true;
        this.ID = Course.getTotalQuizzes() + Course.getTotalAssignments();
        Course.totalAssignmentsIncrease();
        for ( User stud : Student.allStudents){
            AssignmentResult a = new AssignmentResult(this);
            stud.assAssignment(a);
        }
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
        String problemStatement = Main.scanner.nextLine();
        addProblem(problemStatement);
        System.out.print("Enter max marks: ");
        int maxMarks = Integer.parseInt(Main.scanner.nextLine());
        assignMaxMarks(maxMarks);
        allAssignments.add(this);
	}

    @Override
    public String toString() {
        return "ID: " + ID() + " Assignment: " + this.problemStatement +
        " Max Marks: " + this.maxMarks;
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
    public String question() {
        System.out.println("No such thing in assignments");
        return null;
    }

    public static void printAll() {
        for ( Assessments assignment: allAssignments){
            System.out.println(assignment);
        }
    }

    public int ID(){
        return this.ID;
    }

    @Override
    public int maxMarks() {
        return this.maxMarks;
    }


    @Override
    public boolean open() {
        return this.open;
    }

    public static void printOpenAssessment(){
        for ( Assessments a: allAssignments){
            if ( a.open()){
                System.out.println(a);
            }
        }
    }

}
