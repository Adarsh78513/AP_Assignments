public class QuizResult implements Result{
    Assessments q;
    int marksGot;
    String answer;
    boolean pending;
    int ID;
    boolean graded;

    QuizResult(Assessments q){
        this.q = q;
        this.answer = "Not yet given";
        this.marksGot = -1;
        this.pending = true;
        this.ID = q.ID();
        this.graded = false;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }

    @Override
    public void setMarksGot(int marksGot){
        this.marksGot=marksGot;
    }

    @Override
    public boolean graded() {
        return this.graded;
    }

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
        return "ID: " + ID() + " Question: " + this.q.question();
    }
}
