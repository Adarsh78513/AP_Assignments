import java.util.ArrayList;
import java.util.Date;


public class LectureSlides implements LectureMaterial{
    static ArrayList<LectureMaterial> allSlides = new ArrayList<>();
    String topic;
    int numberOfSlides;
    ArrayList<String> content;
    java.util.Date date;


    LectureSlides(String topic, int numberOfSlides){
	    this.topic = topic;
        this.numberOfSlides = numberOfSlides;
        this.content = new ArrayList<>();
    }
    LectureSlides(String topic){
        this.topic = topic;
        this.numberOfSlides = -1;
        this.content = new ArrayList<>();
    }
    LectureSlides(int numberOfSlides){
        this.topic = "Not yet specified";
        this.numberOfSlides = numberOfSlides;
        this.content = new ArrayList<>();
    }
    LectureSlides(){
        this.topic = "Not yet specified";
        this.numberOfSlides = -1;
        this.content = new ArrayList<>();
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
                String temp = Main.scanner.next();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + this.topic + "\n");
        for ( int i = 1 ; i <= this.numberOfSlides; i ++ ){
            sb.append("SLide " + i + ": " +  this.content.get(i - 1) + "\n");
        }
        sb.append("Number of Slides " + this.numberOfSlides + "\n");
        sb.append("Date of Upload" + getDateOfUpload() + "\n");

        String str = sb.toString();
        return str;
    }
}
