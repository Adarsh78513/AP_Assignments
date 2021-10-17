import java.util.ArrayList;
import java.util.Date;

public class LectureVideos implements LectureMaterial{
    static ArrayList<LectureMaterial> allVideos = new ArrayList<>();
    String topic;
    String fileName;
    Instructor uploadedBy;
    java.util.Date date;


    LectureVideos() {
	    this.topic = "Not yet specified";
        this.fileName = "Not available";
    }

    public void fileName(String fileName){
        if ( fileName.endsWith(".mp4")){
            this.fileName = fileName;
        }
        else{
            System.out.println("The video format is not acceptable.");
        }
    }

    public void addTopic(String topic){
        this.topic = topic;
    }

    public void setFileName(String fileName){
        if ( fileName.endsWith(".mp4")){
            this.fileName = fileName;
        }
        else{
            System.out.println(fileName + " is not a valid file name.");
            System.out.println("The file should be in .mp4 format");            
        }
    }

    @Override
    public void add(String topic) {
        LectureMaterial video = new LectureVideos();
        addTopic(topic);
        allVideos.add(video);

        System.out.print("Enter filename of the video: ");
        String fileName =  Main.scanner.next();
        setFileName(fileName);
    }

    public String getTopic(){
        return this.topic;
    }

    public String getFileName(){
        return this.fileName;
    }

    
    @Override
    public Date getDateOfUpload(){
        return this.date;
    }

    private String getInstructor() {
        return this.uploadedBy.name;
    }

    @Override
    public String toString() {
        return "Title of video: " + getTopic() + "/n" + 
                "Video file: " + getFileName() + "/n" + 
                "Date of Upload: " + getDateOfUpload() + 
                "Uploaded by: " + getInstructor();
    }

}
