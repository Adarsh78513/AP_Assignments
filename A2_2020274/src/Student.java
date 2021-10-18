import java.util.ArrayList;

public class Student implements User {
    static ArrayList<Student> allStudents = new ArrayList<>();
    ArrayList<Assessments> quizzesTaken = new ArrayList<>();
    ArrayList<Assessments> assignmentsTaken = new ArrayList<>();

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
            case 3-> submitAssessment();
            case 4 -> viewGrades();
            case 5 -> viewComments();
            case 6 -> addComments();
            case 7 -> logout();
        }


    }

    private void viewGrades() {
        //TODO: complete
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
        System.out.println("Pending assessments");
        //TODO: complete this method

    }

    @Override
    public void viewComments() {
        DiscussionForum.viewComments();
    }

    @Override
    public void addComments() {
        System.out.print("Enter message to be added: ");
        String message = Main.scanner.next();
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

    @Override
    public boolean Using(){
        return this.using;
    }


    @Override
    public String toString(){
        return this.id + " - " + this.name;
    }
}
