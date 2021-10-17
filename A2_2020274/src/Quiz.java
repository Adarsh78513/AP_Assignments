import java.util.ArrayList;

public class Quiz implements Assessments{
    String question;
    int maxMarks;
    int marksGot;
    static ArrayList<Assessments> allQuizzes = new ArrayList<>();
    boolean pending;
    boolean open;
    

    Quiz(String question){
        this.question = "Not given yet";
        this.maxMarks = 1;
        this.marksGot = 0;
        this.pending = true;
        this.open = true;
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
    public void complete(){
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
}
