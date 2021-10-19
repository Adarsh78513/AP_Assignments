import java.util.ArrayList;

public class Quiz implements Assessments{
    private String question;
    private final int maxMarks;
    static ArrayList<Assessments> allQuizzes = new ArrayList<>();
    private boolean open;
    private final int ID;
    

    public Quiz(){
        this.question = "Not given yet";
        this.maxMarks = 1;
        this.open = true;
        this.ID = Course.getTotalQuizzes() + Course.getTotalAssignments();
        Course.totalQuizzesIncrease();
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
