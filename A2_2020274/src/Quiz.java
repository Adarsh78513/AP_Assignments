public class Quiz implements Assessments{
    String question;
    int maxMarks;

    Quiz(String question){
        this.question = "Not given yet";
        this.maxMarks = 1;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    @Override
    public void add() {
        System.out.println("Enter quiz question: ");
        String question = Main.scanner.next();
        setQuestion(question);
        
    }
}
