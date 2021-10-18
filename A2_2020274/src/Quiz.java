import java.util.ArrayList;

public class Quiz implements Assessments{
    String answer;
    String question;
    int maxMarks;
    int marksGot;
    static ArrayList<Assessments> allQuizzes = new ArrayList<>();
    boolean pending;
    boolean open;
    private final int ID;
    

    Quiz(String question){
        this.question = "Not given yet";
        this.maxMarks = 1;
        this.marksGot = 0;
        this.pending = true;
        this.open = true;
        this.ID = Course.totalQuizzes + Course.totalAssignments;
        Course.totalQuizzes += 1;
        this.answer = "Not given";
    }

    public void setQuestion(String question){
        this.question = question;
    }

    @Override
    public void add() {
        System.out.print("Enter quiz question: ");
        String question = Main.scanner.next();
        setQuestion(question);
    }

    @Override
    public String toString() {
        return "ID: 1 Question: " + this.question;
    }

    @Override
    public void complete(Assessments a){
        System.out.print(this.question);
        this.answer = Main.scanner.next();
        this.pending = false;
    }

    @Override
    public int marksGot() {
        if ( !open && pending ){
            System.out.println("You missed the deadline");
        }
        else if ( pending){
            System.out.println("Quiz not taken yet");
        }
        return this.marksGot;
    }

    @Override
    public boolean Pending() {
        return this.pending;
    }

    public static Assessments search(int ID) {
        for ( Assessments quiz: allQuizzes){
            if (quiz.assessmentID() == ID){
                return quiz;
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
        for ( Assessments quiz: allQuizzes){
            System.out.println(quiz);
        }
    }
}
