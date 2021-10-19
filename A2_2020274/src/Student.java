import java.util.ArrayList;

public class Student implements User {
    static ArrayList<Student> allStudents = new ArrayList<>();
    ArrayList<Result> quizzesTaken = new ArrayList<>();
    ArrayList<Result> assignmentsTaken = new ArrayList<>();

    String name;
    int id;
    boolean using;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.using = false;
    }

    public static Student search(int id){
        for ( Student s: allStudents){
            if (s.id == id){
                return s;
            }
        }
        System.out.println("Student not found");
        return null;
    }

    @Override
    public void perform(int action){
        
        switch (action) {
            case 1 -> viewLectureMaterial();
            case 2 -> viewAssessment();
            case 3 -> submitAssessment();
            case 4 -> viewGrades();
            case 5 -> viewComments();
            case 6 -> addComments();
            case 7 -> logout();
            default -> System.out.println("Enter a valid number");
        }


    }

    private void viewGrades() {
        //TODO: print in correct format(not most imp)
        System.out.println("Graded Submission");
        gradedSubmission();
        System.out.println("-----------");
        System.out.println("Ungraded Submission");
        ungradedSubmission();
    }

    private void ungradedSubmission(){
        //TODO: make properly
        for ( Result quiz: this.quizzesTaken){
            if (!quiz.Pending() && !quiz.graded()){
                System.out.println(quiz);
            }
        }
        for ( Result ass : this.assignmentsTaken){
            if (!ass.Pending() && !ass.graded()){
                System.out.println(ass);
            }
        }
        System.out.println("----------");
    }

    private void gradedSubmission(){
        for ( Result quiz: this.quizzesTaken){
            if (quiz.graded()){
                System.out.println("Answer: " + quiz.getAnswer());
                System.out.println("Marks Scored: " + quiz.getMarksGot());
                System.out.println("Graded by: " + quiz.gradedBy());
//                System.out.println(quiz);
            }
        }
        for ( Result ass : this.assignmentsTaken){
            if ( ass.graded()){
                System.out.println("Submission: " + ass.submittedFileName());
                System.out.println("Marks Scored: " + ass.getMarksGot());
                System.out.println("Graded by: " + ass.gradedBy());
//                System.out.println(ass);
            }
        }
    }

    @Override
    public void viewLectureMaterial() {
        for ( LectureMaterial lectureMaterial: LectureSlides.allSlides){
            System.out.println(lectureMaterial);
            System.out.println();
        }
        for ( LectureMaterial lectureMaterial: LectureVideos.allVideos){
            System.out.println(lectureMaterial);
            System.out.println();
        }
    }

    @Override
    public void viewAssessment() {
        for ( Assessments quiz: Quiz.allQuizzes){
            System.out.println(quiz);
            System.out.println();
        }

        for ( Assessments ass : Assignments.allAssignments){
            System.out.println(ass);
            System.out.println();
        }

    }

    public void submitAssessment() {
        //Printing all the pending assessment
        boolean pending = pendingAssessment();
        if ( !pending ){
            return;
        }
        System.out.print("Enter ID of assignment: ");
        int ID = Integer.parseInt(Main.scanner.nextLine());
        Result r = searchAssessment(ID);
//        Assessments a = Assessments.searchAssessment(ID);
        r.complete();
    }

//    public void pendingAssessment() {
//        System.out.println("Pending assessments");
//        for ( Assessments quiz: Quiz.allQuizzes){
//            if (quiz.Pending()){
//                System.out.println(quiz);
//            }
//        }
//        for ( Assessments assignment: Assignments.allAssignments){
//            if(assignment.Pending()){
//                System.out.println(assignment);
//            }
//        }
//    }

    public Result searchAssessment(int ID){
        for ( Result quiz: this.quizzesTaken){
            if ( quiz.ID() == ID){
                return quiz;
            }
        }
        for ( Result ass : this.assignmentsTaken){
            if ( ass.ID() == ID){
                return ass;
            }
        }
        System.out.println("No such file found");
        return null;
    }

    @Override
    public int ID() {
        return this.id;
    }

    @Override
    public void assAssignment(AssignmentResult a) {
        this.assignmentsTaken.add(a);
    }

    public boolean pendingAssessment() {
        System.out.print("Pending assessments");
        int count = 0;
        for ( Result quiz: this.quizzesTaken){
            if (!quiz.closed() && quiz.Pending()){
                System.out.println();
                System.out.println(quiz);
                count += 1;
            }
        }

        for ( Result assignment: this.assignmentsTaken){
            if(!assignment.closed() && assignment.Pending()){
                System.out.println();
                System.out.println(assignment);
                count += 1;
            }
        }
        if ( count == 0){
            System.out.println(" are zero");
            return false;
        }
        return true;
    }

    @Override
    public void viewComments() {
        DiscussionForum.viewComments();
    }

    @Override
    public void addComments() {
        System.out.print("Enter message to be added: ");
        String message = Main.scanner.nextLine();
        DiscussionForum.addComments(this, message);
    }

    @Override
    public void logout() {
        this.using = false;
    }

    @Override
    public void login(){
        this.using = true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void menuForUser() {
        System.out.println("Welcome " + this.name);
        System.out.println("===============");
        System.out.println("""
                1. View lecture materials
                2. View assessments
                3. Submit assessment
                4. View grades
                5. View comments
                6. Add comments
                7. Logout""");
    }

    public static void printAll(){
        for ( Student k: allStudents){
            System.out.println(k);
        }
    }

    public void addQuiz(QuizResult q){
        this.quizzesTaken.add(q);
    }

    public void addAssignment(AssignmentResult a){
        this.assignmentsTaken.add(a);
    }

    @Override
    public boolean Using(){
        return this.using;
    }


    @Override
    public String toString(){
        return this.id + " - " + this.name;
    }

    public static void ungradedSubmissionStudent(int ID){
        for ( User user : allStudents){
            Result r = user.searchAssessment(ID);
            if ( !r.Pending() && !r.graded()){
                System.out.println(user.ID() + ". " + user.getName());
            }
        }
    }

    public static Result findSubmission(int studentID, int assessmentID){
        User stu = search(studentID);
        //TODO: Look into assert
        assert stu != null;
        return stu.searchAssessment(assessmentID);

    }
}
