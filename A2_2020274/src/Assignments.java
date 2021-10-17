public class Assignments implements Assessments{
    String problemStatement;
    int maxMarks;

    Assignments(){
    	this.problemStatement = "Not yet set";
        this.maxMarks = -1;
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
        System.out.println("Enter max marks: ");
        int maxMarks = Integer.parseInt(Main.scanner.next());
        assignMaxMarks(maxMarks);
	}
}
