import java.util.ArrayList;

public class Instructor implements User {
    static ArrayList<Instructor> allInstructors = new ArrayList<>();
    private final String name;
    private final int id;
    private boolean using;

    Instructor(String name, int id){
        this.name = name;
        this.id = id;
        this.using = false;
    }

    public static Instructor search(int id){
        //TODO: handle when the user is not there
        for ( Instructor k: allInstructors){
            if ( k.id == id){
                return k;
            }
        }
        System.out.println("Instructor not found");
        return null;
    }

    @Override
    public void perform(int action){
        switch  (action) {
            case 1 -> addClassMaterial();
            case 2 -> addAssessments();
            case 3 -> viewLectureMaterial();
            case 4 -> viewAssessment();
            case 5 -> gradeAssessments();
            case 6 -> closeAssessment();
            case 7 -> viewComments();
            case 8 -> addComments();
            case 9 -> {
                System.out.println("Logging out...");
                logout();
            }
            default -> System.out.println("Choose a valid action");
        }
    }

    public void addClassMaterial(){
        System.out.println("""
                        1. Add Lecture Slide
                        2. Add Lecture Video""");
        int i = Integer.parseInt(Main.scanner.nextLine());
        if (i == 1) {
            System.out.print("Enter topic of slides: ");
            String topic = Main.scanner.nextLine();
            System.out.print("Enter number of slides: ");
            int numberOfSlides = Integer.parseInt(Main.scanner.nextLine());
            System.out.println("Enter content of slides");

            LectureMaterial slides = new LectureSlides(topic, numberOfSlides, this);

            //It will add the topic and each of the slides
            slides.add(slides, topic);

        } else if (i == 2) {
            LectureMaterial temp = new LectureVideos(this);
            System.out.print("Enter topic of video: ");
            String topic = Main.scanner.nextLine();
            //TODO: clear this
            temp.add(temp , topic);

        } else {
            System.out.println("Please enter valid action.");
        }
    }

    public void addAssessments(){

        System.out.println("""
                        1. Add Assignment
                        2. Add Quiz""");
        int i = Integer.parseInt(Main.scanner.nextLine());
        if ( i == 1){
            Assignments ass = new Assignments();
            ass.add();
        }
        else if ( i == 2){
            Assessments quiz = new Quiz();
            quiz.add();
        }
    }

    public void gradeAssessments(){
        System.out.println("List of assessments");
        //Print all the assessments given with their ID
        Assignments.printAll();
        System.out.println("----------");
        Quiz.printAll();
        System.out.println("----------");

        System.out.print("Enter ID of assessment to view submissions: ");
        int assessmentID = Integer.parseInt(Main.scanner.nextLine());
        Assessments a = Assessments.searchAssessment(assessmentID);
//        System.out.println(a);
        System.out.println("Choose ID from these ungraded submissions");
        Student.ungradedSubmissionStudent(assessmentID);
        int studentID = Integer.parseInt(Main.scanner.nextLine());
        System.out.println("Submission:");

        Result r = Student.findSubmission(studentID, assessmentID);
        System.out.println("Maximum marks: " + a.maxMarks());
        System.out.print("Marks Scored: ");
        int marksScored = Integer.parseInt(Main.scanner.nextLine());
        r.setMarksGot(marksScored, this);
    }

    public void closeAssessment(){
        System.out.println("List of Open Assignments:");
        Quiz.printOpenAssessment();
        System.out.println("---------");
        Assignments.printOpenAssessment();
        System.out.println("---------");
        System.out.print("Enter id of assignment to close: ");
        int assessmentID = Integer.parseInt(Main.scanner.nextLine());
        Assessments a = Assessments.searchAssessment(assessmentID);
        a.close();
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
                1. Add class material
                2. Add assessments
                3. View lecture materials
                4. View assessments
                5. Grade assessments
                6. Close assessment
                7. View comments
                8. Add comments
                9. Logout""");
    }

    @Override
    public boolean Using() {
        return this.using;
    }

    @Override
    public void addQuiz(QuizResult q) {
        System.out.println("Not available");
    }

    @Override
    public Result searchAssessment(int id) {
        System.out.println("No such service for teacher");
        return null;
    }

    @Override
    public int ID() {
        return this.id;
    }

    @Override
    public void assAssignment(AssignmentResult a) {

    }

    public static void printAll(){
        for ( Instructor k: allInstructors){
            System.out.println(k);
        }
    }

    @Override
    public String toString(){
	    return this.id + " - " + this.name;
    }
}
