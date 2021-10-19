public interface Assessments {
    void add();
    int assessmentID();
    static Assessments searchAssessment(int ID){
        Assessments a = Quiz.search(ID);
        if ( a == null){
            a = Assignments.search(ID);
        }
        if ( a == null){
            System.out.println("No assessment with the ID: " + ID);
        }
        return a;
    }
    void close();
    String question();
    int ID();
    int maxMarks();
    boolean open();
}
