import java.util.ArrayList;

public class Quiz implements Assessments{
    String question;
    int maxMarks;
    static ArrayList<Assessments> allQuizzes = new ArrayList<>();
    boolean pending;
    

    Quiz(String question){
        this.question = "Not given yet";
        this.maxMarks = 1;
        this.pending = true;
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
}
