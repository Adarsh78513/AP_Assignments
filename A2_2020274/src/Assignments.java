import java.util.ArrayList;

public class Assignments implements Assessments{
    String problemStatement;
    int maxMarks;
    static ArrayList<Assessments> allAssignments = 
    new ArrayList<Assessments>();
    boolean pending;
    
 
    Assignments(){
    	this.problemStatement = "Not yet set";
        this.maxMarks = -1;
        this.pending = true;
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
    public void complete(){
        this.pending = false;
    }
}
