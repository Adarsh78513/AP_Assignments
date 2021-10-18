import java.util.ArrayList;
import java.util.Date;


public class LectureSlides implements LectureMaterial{
    static ArrayList<LectureMaterial> allSlides = new ArrayList<>();
    String topic;
    int numberOfSlides;
    ArrayList<String> content;
    java.util.Date date;
    User uploadedBy;

    //TODO: clear these functions
    LectureSlides(String topic, int numberOfSlides, User uploasedBy){
	    this.topic = topic;
        this.numberOfSlides = numberOfSlides;
        this.content = new ArrayList<>();
        this.date = new java.util.Date();
        this.uploadedBy = uploasedBy;
    }
    LectureSlides(String topic){
        this.topic = topic;
        this.numberOfSlides = -1;
        this.content = new ArrayList<>();
        this.date = new java.util.Date();
    }
    LectureSlides(int numberOfSlides){
        this.topic = "Not yet specified";
        this.numberOfSlides = numberOfSlides;
        this.content = new ArrayList<>();
        this.date = new java.util.Date();
    }
    LectureSlides(){
        this.topic = "Not yet specified";
        this.numberOfSlides = -1;
        this.content = new ArrayList<>();
        this.date = new java.util.Date();
    }

    public void addSlide(String s){
        this.content.add(s);
    }

    public void addTopic(String topic){
        this.topic = topic;
	}
    
    @Override
    public void add(LectureMaterial slides, String topic) {
        addTopic(topic);
        allSlides.add(slides);
        if ( this.numberOfSlides != -1){
            for ( int i = 1; i <= this.numberOfSlides; ++i ){
                System.out.print("Content of slide " + i + ": ");
                String temp = Main.scanner.nextLine();
                addSlide(temp);
            }
        }
        else{
            System.out.println("First please enter a valid number of slides");
        }
    }

    @Override
    public Date getDateOfUpload(){
        return this.date;
    }

    private String getInstructor() {
        return this.uploadedBy.getName();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.topic).append("\n");
        for ( int i = 1 ; i <= this.numberOfSlides; i ++ ){
            sb.append("SLide ").append(i).append(": ").append(this.content.get(i - 1)).append("\n");
        }
        sb.append("Number of Slides ").append(this.numberOfSlides).append("\n");
        sb.append("Date of Upload").append(getDateOfUpload()).append("\n");
        sb.append("Uploaded by ").append(getInstructor());

        return sb.toString();
    }
}
