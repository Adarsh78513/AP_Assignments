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
    

    public Quiz(){
        this.question = "Not given yet";
        this.maxMarks = 1;
        this.marksGot = 0;
        this.pending = true;
        this.open = true;
        this.ID = Course.totalQuizzes + Course.totalAssignments;
        Course.totalQuizzes += 1;
        this.answer = "Not given";
        for ( User stud : Student.allStudents){
            QuizResult q = new QuizResult(this);
            stud.addQuiz(q);
        }
    }

    public void setQuestion(String question){
        this.question = question;
    }

    @Override
    public void add() {
        System.out.print("Enter quiz question: ");
        String question = Main.scanner.nextLine();
        setQuestion(question);
        allQuizzes.add(this);
    }

    @Override
    public String toString() {
        return "ID: "+ ID() + " Question: " + this.question;
    }

    @Override
    public void complete(Assessments a){
        System.out.print(this.question);
        this.answer = Main.scanner.nextLine();
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

    public String question(){
        return this.question;
    }

    @Override
    public int ID() {
        return this.ID;
    }

    @Override
    public int maxMarks() {
        return this.maxMarks;
    }

    @Override
    public String getProblemStatement() {
        return this.question;
    }


    @Override
    public boolean open() {
        return this.open;
    }

    public static void printOpenAssessment(){
        for ( Assessments quiz: allQuizzes){
            if ( quiz.open()){
                System.out.println(quiz);
            }
        }
    }
}
