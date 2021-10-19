public class QuizResult implements Result{
    private final Assessments q;
    private final int ID;
    private int marksGot;
    private String answer;
    private boolean pending;
    private boolean graded;
    private User gradedBy;

    QuizResult(Assessments q){
        this.q = q;
        this.answer = "Not yet given";
        this.marksGot = -1;
        this.pending = true;
        this.ID = q.ID();
        this.graded = false;
        this.gradedBy = null;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }

    @Override
    public boolean closed() {
        return !this.q.open();
    }

    @Override
    public void setMarksGot(int marksGot, User instructor){
        if ( marksGot > q.maxMarks()){
            System.out.println("Marks received can not be more than the maximum marks. Try again");
            return;
        }
        this.marksGot=marksGot;
        this.graded = true;
        this.gradedBy = instructor;
    }

    @Override
    public boolean graded() {
        return this.graded;
    }

    @Override
    public String gradedBy() {
        if ( this.gradedBy == null){
            return "Not graded";
        }
        return this.gradedBy.getName();
    }

    @Override
    public String submittedFileName() {
        return null;
    }

    @Override
    public int getMarksGot() {
        return this.marksGot;
    }

    public boolean Pending(){
        return this.pending;
    }

    @Override
    public int ID() {
        return this.ID;
    }

    public void finish(){
        this.pending = false;
    }

    @Override
    public void complete(){
        System.out.print(this.q.question());
        String answer = Main.scanner.nextLine();
        setAnswer(answer);
        finish();
    }

    @Override
    public String toString(){
        return "ID: " + ID() + " Question: " + this.q.question() + this.answer;
    }
}
