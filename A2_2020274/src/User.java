interface User {
    public String getName();
    public void menuForUser();
    public void perform(int option);
    public void viewLectureMaterial();
    public void viewAssessment();
    public void viewComments();
    public void addComments();
    public void logout();
    public void login();
    public boolean Using();

    public abstract void addQuiz(QuizResult q);

    Result searchAssessment(int id);
    public int ID();

    void assAssignment(AssignmentResult a);
}
