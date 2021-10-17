import java.util.ArrayList;

public class Instructor implements User {
    static ArrayList<Instructor> allInstructors = new ArrayList<>();
    String name;
    int id;

    Instructor(String name, int id){
        this.name = name;
        this.id = id;
    }

    public static Instructor search(int id){
        for ( Instructor k: allInstructors){
            if ( k.id == id){
                return k;
            }
        }
        System.out.println("Instructor not found");
        return null;
    }

    @Override
    public void perform(int option){
        switch (option) {
            case 1 -> {
                System.out.println("""
                        1. Add Lecture Slide +
                        2. Add Lecture Video""");
                int i = Integer.parseInt(Main.scanner.next());
                if (i == 1) {
                    System.out.print("Enter topic of slides: ");
                    String topic = Main.scanner.next();
                    System.out.print("Enter number of slides: ");
                    int numberOfSlides = Integer.parseInt(Main.scanner.next());
                    System.out.println("Enter content of slides");
                    
                    LectureMaterial slides = new LectureSlides(topic, numberOfSlides);

                    //It will add the topic and each of the slides
                    slides.add(topic);
                    
                } else if (i == 2) {
                    System.out.print("Enter topic of video: ");
                    String topic = Main.scanner.next();
                    System.out.println("Enter filename of video: ");
                    String video = Main.scanner.next();
                } else {
                    System.out.println("Please enter valid option.");
                }
            }
            case 2 -> {
                System.out.println("""
                        1. Add Assignment +
                        2. Add Quiz""");
                int i = Integer.parseInt(Main.scanner.next());
                if ( i == 1){
                    System.out.print("Enter problem statement: ");
                    String problemStatement = Main.scanner.next();
                    System.out.println("Enter max marks: ");
                    int maxMarks = Integer.parseInt(Main.scanner.next());
                    Assignments ass = new Assignments(problemStatement, maxMarks);
                }
                else if ( i == 2){
                    System.out.println("Enter quiz question: ");
                    String question = Main.scanner.next();
                    Quiz quiz = new Quiz(question);
                }
            }
            case 3 -> {
                System.out.println("lecture materials");
            }
            case 4 -> {
                System.out.println("assessments");
            }
            case 5 -> {
                System.out.println("Grade assessments");
            }
            case 6 -> {
                System.out.println("Close assessment");
            }
            case 7 -> {
                System.out.println("View comments");
            }
            case 8 -> {
                System.out.print("Enter comment: ");
                String comment = Main.scanner.next();
                //TODO: make the comment section
                //TODO: Add this comment
            }
            case 9 -> {
                //TODO: make logout
                System.out.println("logout");
            }
            default -> System.out.println("Choose a valid option");
        }
    }

    @Override
    public void viewLectureMaterial() {
        
    }

    @Override
    public void viewAssessment() {

    }

    @Override
    public void viewComments() {

    }

    @Override
    public void addComments() {

    }

    @Override
    public void logout() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void menuForUser() {
        System.out.println("Welcome " + this.name);
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
