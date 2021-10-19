public class AssignmentResult implements Result{
    private final Assignments ass;
    private final int ID;
    private int marksGot;
    private String fileName;
    private boolean pending;
    private boolean graded;
    private User gradedBy;

    AssignmentResult(Assignments ass){
        this.ass = ass;
        this.fileName = "Not submitted";
        this.pending = true;
        this.marksGot = -1;
        this.ID = ass.ID();
        this.graded = false;
        this.gradedBy = null;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    @Override
    public void setMarksGot(int marksGot, User instructor){
        if ( marksGot > ass.maxMarks()){
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
        String temp = Main.scanner.nextLine();
        if ( !temp.endsWith(".zip") ){
            System.out.println("Not a valid format.");
            System.out.println("Try submitting again.\n");
            return;
        }
        fileName = temp;
        setFileName(fileName);
        this.pending = false;
        finish();
    }

    @Override
    public String toString(){
        return "ID: " + ID() + " Assignment: " + this.getFileName() + " Max Marks: " + ass.maxMarks();
    }

}
