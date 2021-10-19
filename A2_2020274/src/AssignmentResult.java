public class AssignmentResult implements Result{
    Assignments ass;
    int marksGot;
    String fileName;
    boolean pending;
    int ID;
    boolean graded;
    User gradedBy;

    AssignmentResult(Assignments ass){
        this.ass = ass;
        this.fileName = "Not submitted";
        this.pending = true;
        this.marksGot = -1;
        this.ID = ass.ID();
        this.graded = false;
        this.gradedBy = null;
    }

    public void setFileName(String answer){
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    @Override
    public void setMarksGot(int marksGot, User instructor){
        this.marksGot=marksGot;
        this.graded = true;
        this.gradedBy = instructor;
    }

    @Override
    public boolean graded() {
        return this.graded;
    }

    @Override
    public String submittedFileName() {
        return this.fileName;
    }

    @Override
    public String gradedBy() {
        if ( this.gradedBy == null){
            return "Not graded";
        }
        return this.gradedBy.getName();
    }

    @Override
    public String getAnswer() {
        return null;
    }

    @Override
    public boolean closed() {
        return !this.ass.open();
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
    public void complete() {
        System.out.print("Enter filename of the Assignment: ");
        fileName = Main.scanner.nextLine();
        setFileName(fileName);
        this.pending = false;
        finish();
    }

    @Override
    public String toString(){
        return "ID: " + ID() + " Assignment: " + this.getFileName() + " Max Marks: " + ass.maxMarks();
    }

}
