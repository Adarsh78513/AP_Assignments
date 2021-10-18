public interface Assessments {
    public void add();
    public void complete(Assessments a);
    public int marksGot();
    public boolean Pending();
    public int assessmentID();
    public static Assessments searchAssessment(int ID){
        Assessments a = Quiz.search(ID);
        if ( a == null){
            a = Assignments.search(ID);
        }
        if ( a == null){
            System.out.println("No assessment with the ID: " + ID);
        }
        return a;
    }
    public void close();
    public void gradeAssessments(int marks);

}
