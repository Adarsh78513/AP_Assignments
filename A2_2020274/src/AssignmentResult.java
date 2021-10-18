public class AssignmentResult implements Result{
    Assignments ass;
    int marksGot;
    String fileName;
    boolean pending;
    int ID;

    AssignmentResult(Assignments ass){
        this.ass = ass;
        this.fileName = "Not submitted";
        this.pending = true;
        this.marksGot = -1;
        this.ID = ass.ID();
    }

    public void setFileName(String answer){
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
    public void setMarksGot(int marksGot){
        this.marksGot=marksGot;
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
    public void complete() {
        System.out.print("Enter filename of the Assignment: ");
        this.fileName = Main.scanner.nextLine();
        this.pending = false;
        finish();
    }

}
