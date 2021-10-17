import java.util.ArrayList;

public class LectureSlides implements LectureMaterial{
    String topic;
    int numberOfSlides;
    ArrayList<String> content;

    LectureSlides(String topic, int numberOfSlides){
	    this.topic = topic;
        this.numberOfSlides = numberOfSlides;
    }
    LectureSlides(String topic){
        this.topic = topic;
        this.numberOfSlides = -1;
    }
    LectureSlides(int numberOfSlides){
        this.topic = "Not yet specified";
        this.numberOfSlides = numberOfSlides;
    }
    LectureSlides(){
        this.topic = "Not yet specified";
        this.numberOfSlides = -1;
    }

    public void addSlide(String s){
        this.content.add(s);
    }

    public void addTopic(String topic){
        this.topic = topic;
	}
    
    @Override
    public void add(String topic) {
        addTopic(topic);
        if ( this.numberOfSlides != -1){
            for ( int i = 1; i <= this.numberOfSlides; ++i ){
                System.out.print("Content of slide " + i + ": ");
                String temp = Main.scanner.next();
                addSlide(temp);
            }
        }
        else{
            System.out.println("Please enter a valid number of slides");
        }
    }
}
